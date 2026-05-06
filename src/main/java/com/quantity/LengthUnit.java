package com.quantity;

public enum LengthUnit implements IMeasurable {

    FEET(1.0, "Feet"),
    INCHES(1.0 / 12.0, "Inches"),
    YARDS(3.0, "Yards"),
    CENTIMETERS(1.0 / 30.48, "Centimeters");

    private final double conversionFactor;
    private final String unitName;

    LengthUnit(double conversionFactor, String unitName) {
        this.conversionFactor = conversionFactor;
        this.unitName = unitName;
    }

    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    @Override
    public String getUnitName() {
        return unitName;
    }
}