package com.quantity;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double toFeet;

    LengthUnit(double toFeet) {
        this.toFeet = toFeet;
    }

    // Convert this unit → base unit (feet)
    public double convertToBaseUnit(double value) {
        return value * toFeet;
    }

    // Convert base unit (feet) → this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toFeet;
    }

    public double getConversionFactor() {
        return toFeet;
    }
}