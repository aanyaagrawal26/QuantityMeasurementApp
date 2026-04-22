package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC5QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                UC5QuantityMeasurementApp.convert(1.0,
                        UC5QuantityMeasurementApp.LengthUnit.FEET,
                        UC5QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                UC5QuantityMeasurementApp.convert(24.0,
                        UC5QuantityMeasurementApp.LengthUnit.INCHES,
                        UC5QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testYardsToFeet() {
        assertEquals(9.0,
                UC5QuantityMeasurementApp.convert(3.0,
                        UC5QuantityMeasurementApp.LengthUnit.YARDS,
                        UC5QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testCentimeterToInch() {
        assertEquals(1.0,
                UC5QuantityMeasurementApp.convert(2.54,
                        UC5QuantityMeasurementApp.LengthUnit.CENTIMETERS,
                        UC5QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testZeroValue() {
        assertEquals(0.0,
                UC5QuantityMeasurementApp.convert(0.0,
                        UC5QuantityMeasurementApp.LengthUnit.FEET,
                        UC5QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testNegativeValue() {
        assertEquals(-12.0,
                UC5QuantityMeasurementApp.convert(-1.0,
                        UC5QuantityMeasurementApp.LengthUnit.FEET,
                        UC5QuantityMeasurementApp.LengthUnit.INCHES),
                EPSILON);
    }

    @Test
    void testSameUnit() {
        assertEquals(5.0,
                UC5QuantityMeasurementApp.convert(5.0,
                        UC5QuantityMeasurementApp.LengthUnit.FEET,
                        UC5QuantityMeasurementApp.LengthUnit.FEET),
                EPSILON);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            UC5QuantityMeasurementApp.convert(1.0, null,
                    UC5QuantityMeasurementApp.LengthUnit.FEET);
        });
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            UC5QuantityMeasurementApp.convert(Double.NaN,
                    UC5QuantityMeasurementApp.LengthUnit.FEET,
                    UC5QuantityMeasurementApp.LengthUnit.INCHES);
        });
    }
}