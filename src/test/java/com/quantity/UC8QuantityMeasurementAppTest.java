package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC8QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testConvertToBaseUnit() {
        assertEquals(1.0,
                LengthUnit.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit() {
        assertEquals(12.0,
                LengthUnit.INCHES.convertFromBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testEquality() {
        var a = new UC8QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new UC8QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(a.equals(b));
    }

    @Test
    void testConversion() {
        var a = new UC8QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);

        var result = a.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.value, EPSILON);
    }

    @Test
    void testAddition() {
        var a = new UC8QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new UC8QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCHES);

        var result = a.add(b, LengthUnit.FEET);

        assertEquals(2.0, result.value, EPSILON);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new UC8QuantityMeasurementApp.QuantityLength(1.0, null));
    }
}