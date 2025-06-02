public class CashContext {
    private CashSuper cs;

    public CashContext(String discountSelected) {
            switch(discountSelected){
            case "正常收费":
                this.cs = new  CashNormal();
                break;
            case "九折":
                this.cs = new CashRebate(0.9);
                break;
            case "三折":
                this.cs = new CashRebate(0.3);
                break;
            case "满300返100":
                this.cs = new CashReturn(300,100);
                break;
            default:throw new IllegalStateException("Unexpected value: " + discountSelected);
        }
    }

    public double getResult(double money){
        return cs.acceptCash(money);
    }
}
