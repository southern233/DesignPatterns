public class CashFactory {
    public static CashSuper createCashAdapter(String type) {
        switch (type) {
            case "正常收费":
                return new CashNormal();
            case"九折":
                return new CashRebate(0.9);
            case"三折":
                return new CashRebate(0.3);
            case"满300返100":
                return new CashReturn(300,100);
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
