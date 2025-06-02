import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFrame
{
    // 声明全局变量
    private String[] discount = new String[]{"正常收费","九折", "三折", "满300返100"};
    private double price = 0.0d;
    private int quantity = 0;
    private double cost = 0.0d;
    private double total = 0.0d;

    // 声明控件
    // 主Frame
    private JFrame mFrmMain = new JFrame("Design Patterns");
    // 单价条
    private JLabel mLblPrice = new JLabel("单价：");
    private JTextField mTxtPrice = new JTextField(14);
    private JButton mBtnConfirm = new JButton("确定");
    private JPanel mPnlPrice = new JPanel();
    // 数量条
    private JLabel mLblNumber = new JLabel("数量：");
    private JTextField mTxtNumber = new JTextField(14);
    private JButton mBtnReset = new JButton("重置");
    private JPanel mPnlNumber = new JPanel();
    // 打折
    private JComboBox<String> mCmbDiscount = new JComboBox<>(discount);
    // 详情List
    private DefaultListModel mLstmodelDetail = new DefaultListModel();
    private JList mLstDetail = new JList(mLstmodelDetail);
    private JPanel mPnlList = new JPanel();
    // 总计条
    private JLabel mLblTotal = new JLabel("总计:");
    private JPanel mPnlTotal = new JPanel();
    //全局
    private Box mBoxAll = Box.createVerticalBox();
    //空边框
    private Border mPadding = BorderFactory.createEmptyBorder(10, 30, 10, 30);

    // 构造MyFrame
    public MyFrame(){
        init();
        assembleControls();
    }

    /// 组装控件
    private void assembleControls() {
        // 组装单价条
        mPnlPrice.add(mLblPrice);
        mPnlPrice.add(mTxtPrice);
        mPnlPrice.add(mBtnConfirm);

        // 组装数量条
        mPnlNumber.add(mLblNumber);
        mPnlNumber.add(mTxtNumber);
        mPnlNumber.add(mBtnReset);

        // 组装详情List
        mPnlList.add(mLstDetail);

        // 组装总计条
        mPnlTotal.setLayout(new FlowLayout(FlowLayout.LEFT));
        mPnlTotal.add(mLblTotal);
        mPnlTotal.add(Box.createVerticalGlue());

        // 全局组装
        mBoxAll.add(mPnlPrice);
        mBoxAll.add(mPnlNumber);
        mBoxAll.add(mCmbDiscount);
        mBoxAll.add(mPnlList);
        mBoxAll.add(mPnlTotal);
        mBoxAll.setBorder(mPadding);

        mFrmMain.add(mBoxAll);
    }

    /// 初始化
    private void init() {
        mLstDetail.setPreferredSize(new Dimension(270, 150));

        mFrmMain.setPreferredSize(new Dimension(350, 300));
        mFrmMain.setMinimumSize(new Dimension(350, 300));
        mFrmMain.pack();
        mFrmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //按钮事件
        mBtnConfirm.addActionListener(e -> {
            price = Double.parseDouble(mTxtPrice.getText());
            quantity = Integer.parseInt(mTxtNumber.getText());
            String discountSelected = mCmbDiscount.getSelectedItem().toString();

            //简单工厂
//            CashSuper cashSuper = CashFactory.createCashAdapter(discountSelected) ;
//            cost = cashSuper.acceptCash(price*quantity);

            //策略模式
            cost = new CashContext(discountSelected).getResult(price*quantity);

            total += cost;
            mLstmodelDetail.addElement("售价:"+price + " 数量:" + quantity +" 折扣:"+discountSelected+" 花费:"+cost);
            mLblTotal.setText("总计:" + total);
        });
        mBtnReset.addActionListener(e -> {
            mTxtNumber.setText("");
            mTxtPrice.setText("");
        });
    }

    public void show(){
        mFrmMain.setVisible(true);
    }
}