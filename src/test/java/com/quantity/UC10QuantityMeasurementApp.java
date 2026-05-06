package com.quantity;

public class UC10QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<LengthUnit> length1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("Length equality: " + length1.equals(length2));
        System.out.println("Length conversion: " + length1.convertTo(LengthUnit.INCHES));
        System.out.println("Length addition: " + length1.add(length2, LengthUnit.FEET));

        Quantity<WeightUnit> weight1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weight2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Weight equality: " + weight1.equals(weight2));
        System.out.println("Weight conversion: " + weight1.convertTo(WeightUnit.POUND));
        System.out.println("Weight addition: " + weight1.add(weight2, WeightUnit.GRAM));

        System.out.println("Length vs Weight equality: " + length1.equals(weight1));
    }
}