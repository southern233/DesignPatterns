/// 返现类
public class CashReturn extends CashSuper{
    private double moneyReturn = 0.0d;
    private double moneyCondition = 0.0d;

    /// 传入折扣情况(满多少开始返现)和折扣价格(返现多少)
    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyReturn = moneyReturn;
        this.moneyCondition = moneyCondition;
    }
    @Override
    double acceptCash(double money) {
        double result = money;
        if(money >= moneyCondition)
            // 超出moneyCondition的部分按比例返还(超出以后开始打折)
            //money*（1-moneyReturn/moneyCondition）
            result = money - Math.floor(money/moneyCondition)*moneyReturn;
        return result;
    }
}
