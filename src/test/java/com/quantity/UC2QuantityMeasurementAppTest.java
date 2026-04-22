package com.quantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UC2QuantityMeasurementAppTest {

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(UC2QuantityMeasurementApp.areFeetEqual(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(UC2QuantityMeasurementApp.areFeetEqual(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        UC2QuantityMeasurementApp.Feet feet = new UC2QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        UC2QuantityMeasurementApp.Feet feet = new UC2QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet.equals(feet));
    }

    @Test
    void testFeetEquality_DifferentType() {
        UC2QuantityMeasurementApp.Feet feet = new UC2QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals("1.0"));
    }

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(UC2QuantityMeasurementApp.areInchesEqual(1.0, 1.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(UC2QuantityMeasurementApp.areInchesEqual(1.0, 2.0));
    }

    @Test
    void testInchesEquality_NullComparison() {
        UC2QuantityMeasurementApp.Inches inches = new UC2QuantityMeasurementApp.Inches(1.0);
        assertFalse(inches.equals(null));
    }

    @Test
    void testInchesEquality_SameReference() {
        UC2QuantityMeasurementApp.Inches inches = new UC2QuantityMeasurementApp.Inches(1.0);
        assertTrue(inches.equals(inches));
    }

    @Test
    void testInchesEquality_DifferentType() {
        UC2QuantityMeasurementApp.Inches inches = new UC2QuantityMeasurementApp.Inches(1.0);
        assertFalse(inches.equals("1.0"));
    }
}