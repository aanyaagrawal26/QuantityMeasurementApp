package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC9QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testKgToGramEquality() {
        var a = new UC9QuantityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new UC9QuantityMeasurementApp.QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(a.equals(b));
    }

    @Test
    void testKgToPoundEquality() {
        var a = new UC9QuantityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new UC9QuantityMeasurementApp.QuantityWeight(2.20462, WeightUnit.POUND);

        assertEquals(a.toBaseUnit(), b.toBaseUnit(), 1e-3);
    }

    @Test
    void testConversion() {
        var a = new UC9QuantityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);

        var result = a.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.value, EPSILON);
    }

    @Test
    void testAddition() {
        var a = new UC9QuantityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new UC9QuantityMeasurementApp.QuantityWeight(1000.0, WeightUnit.GRAM);

        var result = a.add(b);

        assertEquals(2.0, result.value, EPSILON);
    }

    @Test
    void testAdditionWithTargetUnit() {
        var a = new UC9QuantityMeasurementApp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        var b = new UC9QuantityMeasurementApp.QuantityWeight(1000.0, WeightUnit.GRAM);

        var result = a.add(b, WeightUnit.GRAM);

        assertEquals(2000.0, result.value, EPSILON);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new UC9QuantityMeasurementApp.QuantityWeight(1.0, null));
    }

    @Test
    void testZeroValue() {
        var a = new UC9QuantityMeasurementApp.QuantityWeight(0.0, WeightUnit.KILOGRAM);
        var b = new UC9QuantityMeasurementApp.QuantityWeight(0.0, WeightUnit.GRAM);

        assertTrue(a.equals(b));
    }
}