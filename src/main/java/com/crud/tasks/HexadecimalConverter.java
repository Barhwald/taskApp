package com.crud.tasks;

public class HexadecimalConverter {

    public static void main(String[] args) {
        System.out.println(convertToHexadecimal(350));
        System.out.println(convertToHexadecimal(65));
        System.out.println(convertToHexadecimal(1660));
    }

    public static String convertToHexadecimal(int number) {
        String converted = "";
        String remainder;
        while (number > 0) {
            remainder = switch (number%16) {
                case 10: yield "A";
                case 11: yield "B";
                case 12: yield "C";
                case 13: yield "D";
                case 14: yield "E";
                case 15: yield "F";
                default: yield String.valueOf(number%16);
            };
            converted = remainder + converted;
            number/=16;
        }
        return converted;
    }

}
