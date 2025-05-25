/// 不打折类
public class CashNormal extends CashSuper{
    @Override
    double acceptCash(double money) {
        return money;
    }
}
