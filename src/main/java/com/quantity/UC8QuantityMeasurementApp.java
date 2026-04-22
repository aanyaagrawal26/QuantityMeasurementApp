package com.quantity;

public class UC8QuantityMeasurementApp {

    static class QuantityLength {
        final double value;
        final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
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

        public QuantityLength convertTo(LengthUnit targetUnit) {
            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double base = this.toBaseUnit();
            double converted = targetUnit.convertFromBaseUnit(base);

            return new QuantityLength(converted, targetUnit);
        }

        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
            if (other == null)
                throw new IllegalArgumentException("Second operand null");

            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit null");

            double sum = this.toBaseUnit() + other.toBaseUnit();

            double result = targetUnit.convertFromBaseUnit(sum);

            return new QuantityLength(result, targetUnit);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;

            return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
        }

        @Override
        public String toString() {
            return value + " " + unit;
        }
    }

    public static void main(String[] args) {

        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        System.out.println("Convert: " + a.convertTo(LengthUnit.INCHES));
        System.out.println("Add (feet): " + a.add(b, LengthUnit.FEET));
        System.out.println("Add (yards): " + a.add(b, LengthUnit.YARDS));
        System.out.println("Equality: " + a.equals(b));
    }
}