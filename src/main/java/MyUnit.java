
public enum MyUnit {
    M(100),CM(1);
    private int rate;

    private MyUnit(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
