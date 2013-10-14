
public class MyLength {
    private final double value;
    private final MyUnit unit;

    public MyLength(double value, MyUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        MyLength myLength = (MyLength) o;
        return baseValue() == myLength.baseValue();
    }

    private double baseValue() {
        return value * unit.getRate();
    }

    public MyLength minus(MyLength length) {
        return new MyLength(baseValue() - length.baseValue(), MyUnit.CM);
    }

    public MyLength add(MyLength length) {
        return new MyLength(baseValue() + length.baseValue(), MyUnit.CM);
    }
}
