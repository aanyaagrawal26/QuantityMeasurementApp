package com.quantity;

public class UC5QuantityMeasurementApp {

    enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(1.0 / 30.48);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toFeet(double value) {
            return value * toFeet;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeet;
        }
    }

    static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null)
                throw new IllegalArgumentException("Unit cannot be null");

            if (!Double.isFinite(value))
                throw new IllegalArgumentException("Invalid numeric value");

            this.value = value;
            this.unit = unit;
        }

        private double toBaseUnit() {
            return unit.toFeet(value);
        }

        public double convertTo(LengthUnit targetUnit) {
            if (targetUnit == null)
                throw new IllegalArgumentException("Target unit cannot be null");

            double base = toBaseUnit();
            return targetUnit.fromFeet(base);
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

    // 🔥 STATIC API METHOD (as asked in UC5)
    public static double convert(double value, LengthUnit source, LengthUnit target) {
        if (source == null || target == null)
            throw new IllegalArgumentException("Units cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        double base = source.toFeet(value);
        return target.fromFeet(base);
    }

    public static void main(String[] args) {

        System.out.println("1 ft → inches: " + convert(1.0, LengthUnit.FEET, LengthUnit.INCHES));
        System.out.println("3 yards → feet: " + convert(3.0, LengthUnit.YARDS, LengthUnit.FEET));
        System.out.println("36 inches → yards: " + convert(36.0, LengthUnit.INCHES, LengthUnit.YARDS));
        System.out.println("2.54 cm → inches: " + convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES));
    }
}