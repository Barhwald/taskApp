package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApplication {
    public static void main(String[] args) {
//        int[] grades = {3, 1, 1, 5, 6, 4};
//        int[] weights = {4, 6, 8, 4, 4, 10};
//        System.out.printf("%.2f", countWeightedAvg(grades, weights));
//        System.out.println(isNumberPrime(2));
//        System.out.println(isNumberPrime(4));
//        System.out.println(isNumberPrime(7));
//        System.out.println(isNumberPrime(19));
		SpringApplication.run(TasksApplication.class, args);
    }

    //ZADANIE DODATKOWE 19.3 Liczby pierwsze

    public static boolean isNumberPrime(int a) {
        for (int i = 2; i <= a/2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static double countWeightedAvg(int[] grades, int[] weights) {
        double total = 0;
        if (!areGradesInBounds(grades)) {
            return -1;
        }
        if (!areWeightsInBounds(weights)) {
            return -1;
        }
        if (!isLengthEqual(grades, weights)) {
            System.out.println("Lengths are not equal!");
            return -1;
        }
        if (isLengthZero(grades) || isLengthZero(weights)) {
            System.out.println("One of the arrays' length is 0!");
            return -1;
        }
        for (int i = 0; i < grades.length; i++) {
            total += grades[i] * weights[i];
        }
        return total / grades.length;
    }


    // check if grade is in range
    public static boolean areGradesInBounds(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 1 || grades[i] > 6) {
                System.out.println("Error: Grade out of 1-6 bounds!");
                System.out.println("Index " + i + ", value " + grades[i]);
                return false;
            }
        }
        return true;
    }

    // check if weight is in range
    public static boolean areWeightsInBounds(int[] weights) {
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] < 1 || weights[i] > 10) {
                System.out.println("Error: Weight out of 1-10 bounds!");
                System.out.println("Index " + i + ", value " + weights[i]);
                return false;
            }
        }
        return true;
    }

    //check if lengths are equal
    public static boolean isLengthEqual(int[] grades, int[] weights) {
        return grades.length == weights.length;
    }

    //check if length is not 0
    public static boolean isLengthZero(int[] myInt) {
        return myInt.length == 0;
    }
}


