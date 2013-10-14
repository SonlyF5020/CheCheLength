
public class MyLength {
    private final double value;
    private final String unit;

    public MyLength(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        MyLength myLength = (MyLength) o;
        return baseValue() == myLength.baseValue();
    }

    private double baseValue() {
        if (unit.equals("M")) {
            return value * 100;
        } else {
            return value;
        }
    }

    public MyLength minus(MyLength length) {
        if (unit.equals(length.unit)) {
            return new MyLength(value - length.value, unit);
        } else return new MyLength(baseValue() - length.baseValue(), "CM");
    }

    public MyLength add(MyLength length) {
        if (unit.equals(length.unit)) {
            return new MyLength(value + length.value, unit);
        } else return new MyLength(baseValue() + length.baseValue(), "CM");
    }
}
