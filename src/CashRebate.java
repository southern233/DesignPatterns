/// 折扣类
public class CashRebate extends CashSuper{
    //折扣
    private double rebate = 1d;
    /// 获取折扣率
    public CashRebate(double rebate) {
        this.rebate = rebate;
    }
    @Override
    double acceptCash(double money) {
        return money * rebate;
    }
}
