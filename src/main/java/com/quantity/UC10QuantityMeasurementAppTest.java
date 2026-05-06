package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UC10QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testLengthEquality_FeetToInches() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    void testWeightEquality_KgToGram() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(gram));
    }

    @Test
    void testLengthConversion() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result = feet.convertTo(LengthUnit.INCHES);

        assertEquals(12.0, result.value, EPSILON);
    }

    @Test
    void testWeightConversion() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result = kg.convertTo(WeightUnit.GRAM);

        assertEquals(1000.0, result.value, EPSILON);
    }

    @Test
    void testLengthAddition() {
        Quantity<LengthUnit> feet = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> inches = new Quantity<>(12.0, LengthUnit.INCHES);

        Quantity<LengthUnit> result = feet.add(inches, LengthUnit.FEET);

        assertEquals(2.0, result.value, EPSILON);
    }

    @Test
    void testWeightAddition() {
        Quantity<WeightUnit> kg = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> gram = new Quantity<>(1000.0, WeightUnit.GRAM);

        Quantity<WeightUnit> result = kg.add(gram, WeightUnit.KILOGRAM);

        assertEquals(2.0, result.value, EPSILON);
    }

    @Test
    void testLengthVsWeightNotEqual() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<WeightUnit> weight = new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    void testNullUnitThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<LengthUnit>(1.0, null));
    }

    @Test
    void testInvalidValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Quantity<>(Double.NaN, LengthUnit.FEET));
    }

    @Test
    void testSameReference() {
        Quantity<LengthUnit> length = new Quantity<>(1.0, LengthUnit.FEET);

        assertTrue(length.equals(length));
    }
}