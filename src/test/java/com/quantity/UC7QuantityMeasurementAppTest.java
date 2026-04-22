package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC7QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testTargetUnit_Feet() {
        var a = new UC7QuantityMeasurementApp.QuantityLength(1.0,
                UC7QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC7QuantityMeasurementApp.QuantityLength(12.0,
                UC7QuantityMeasurementApp.LengthUnit.INCHES);

        var result = a.add(b, UC7QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, result.value, EPSILON);
    }

    @Test
    void testTargetUnit_Inches() {
        var a = new UC7QuantityMeasurementApp.QuantityLength(1.0,
                UC7QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC7QuantityMeasurementApp.QuantityLength(12.0,
                UC7QuantityMeasurementApp.LengthUnit.INCHES);

        var result = a.add(b, UC7QuantityMeasurementApp.LengthUnit.INCHES);

        assertEquals(24.0, result.value, EPSILON);
    }

    @Test
    void testTargetUnit_Yards() {
        var a = new UC7QuantityMeasurementApp.QuantityLength(1.0,
                UC7QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC7QuantityMeasurementApp.QuantityLength(12.0,
                UC7QuantityMeasurementApp.LengthUnit.INCHES);

        var result = a.add(b, UC7QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(0.666666, result.value, 1e-3);
    }

    @Test
    void testCommutativity() {
        var a = new UC7QuantityMeasurementApp.QuantityLength(1.0,
                UC7QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC7QuantityMeasurementApp.QuantityLength(12.0,
                UC7QuantityMeasurementApp.LengthUnit.INCHES);

        var r1 = a.add(b, UC7QuantityMeasurementApp.LengthUnit.FEET);
        var r2 = b.add(a, UC7QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(r1.value, r2.value, EPSILON);
    }

    @Test
    void testNullTargetUnit() {
        var a = new UC7QuantityMeasurementApp.QuantityLength(1.0,
                UC7QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> a.add(a, null));
    }

    @Test
    void testZeroAddition() {
        var a = new UC7QuantityMeasurementApp.QuantityLength(5.0,
                UC7QuantityMeasurementApp.LengthUnit.FEET);
        var b = new UC7QuantityMeasurementApp.QuantityLength(0.0,
                UC7QuantityMeasurementApp.LengthUnit.INCHES);

        var result = a.add(b, UC7QuantityMeasurementApp.LengthUnit.YARDS);

        assertEquals(1.6666, result.value, 1e-3);
    }
}