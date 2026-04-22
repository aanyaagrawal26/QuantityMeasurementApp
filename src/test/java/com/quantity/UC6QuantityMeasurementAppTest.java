package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC6QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit() {
        var a = new UC6QuantityMeasurementApp.QuantityLength(1.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC6QuantityMeasurementApp.QuantityLength(2.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);

        var result = a.add(b);

        assertEquals(3.0, result.value, EPSILON);
    }

    @Test
    void testAddition_FeetPlusInches() {
        var a = new UC6QuantityMeasurementApp.QuantityLength(1.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC6QuantityMeasurementApp.QuantityLength(12.0,
                UC6QuantityMeasurementApp.LengthUnit.INCHES);

        var result = a.add(b);

        assertEquals(2.0, result.value, EPSILON);
    }

    @Test
    void testAddition_InchesPlusFeet() {
        var a = new UC6QuantityMeasurementApp.QuantityLength(12.0,
                UC6QuantityMeasurementApp.LengthUnit.INCHES);
        var b = new UC6QuantityMeasurementApp.QuantityLength(1.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);

        var result = a.add(b);

        assertEquals(24.0, result.value, EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        var a = new UC6QuantityMeasurementApp.QuantityLength(5.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC6QuantityMeasurementApp.QuantityLength(0.0,
                UC6QuantityMeasurementApp.LengthUnit.INCHES);

        var result = a.add(b);

        assertEquals(5.0, result.value, EPSILON);
    }

    @Test
    void testAddition_NegativeValues() {
        var a = new UC6QuantityMeasurementApp.QuantityLength(5.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC6QuantityMeasurementApp.QuantityLength(-2.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);

        var result = a.add(b);

        assertEquals(3.0, result.value, EPSILON);
    }

    @Test
    void testAddition_NullOperand() {
        var a = new UC6QuantityMeasurementApp.QuantityLength(1.0,
                UC6QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }
}