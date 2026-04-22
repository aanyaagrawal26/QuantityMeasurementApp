package com.quantity;

public class UC9QuantityMeasurementApp {

    static class QuantityWeight {
        final double value;
        final WeightUnit unit;

        public QuantityWeight(double value, WeightUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return unit.convertToBaseUnit(value);
        }

        public QuantityWeight convertTo(WeightUnit targetUnit) {
            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit null");

            double base = this.toBaseUnit();
            double converted = targetUnit.convertFromBaseUnit(base);

            return new QuantityWeight(converted, targetUnit);
        }

        public QuantityWeight add(QuantityWeight other) {
            return add(other, this.unit);
        }

        public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
            if (other == null)
                throw new IllegalArgumentException("Second operand null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit null");

            double sum = this.toBaseUnit() + other.toBaseUnit();

            double result = targetUnit.convertFromBaseUnit(sum);

            return new QuantityWeight(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityWeight other = (QuantityWeight) obj;

            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        QuantityWeight a = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight b = new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Equality: " + a.equals(b));
        System.out.println("Convert to pounds: " + a.convertTo(WeightUnit.POUND));
        System.out.println("Addition: " + a.add(b));
        System.out.println("Addition (grams): " + a.add(b, WeightUnit.GRAM));
    }
}