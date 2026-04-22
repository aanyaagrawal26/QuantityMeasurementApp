package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UC3QuantityMeasurementAppTest {

    @Test
    void testFeetToFeet_SameValue() {
        var q1 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testInchToInch_SameValue() {
        var q1 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.INCH);
        var q2 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToInch_Equivalent() {
        var q1 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new UC3QuantityMeasurementApp.QuantityLength(12.0,
                UC3QuantityMeasurementApp.LengthUnit.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testDifferentValues() {
        var q1 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);
        var q2 = new UC3QuantityMeasurementApp.QuantityLength(2.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    void testNullComparison() {
        var q1 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    void testSameReference() {
        var q1 = new UC3QuantityMeasurementApp.QuantityLength(1.0,
                UC3QuantityMeasurementApp.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UC3QuantityMeasurementApp.QuantityLength(1.0, null);
        });
    }
}