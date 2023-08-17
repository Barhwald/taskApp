import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraAssignments {

    public static void main(String[] args) {

//        int[] grades = {3, 1, 1, 5, 6, 4};
//        int[] weights = {4, 6, 8, 4, 4, 10};
//        System.out.printf("%.2f", countWeightedAvg(grades, weights));
//        System.out.println(isNumberPrime(2));
//        System.out.println(isNumberPrime(4));
//        System.out.println(isNumberPrime(7));
//        System.out.println(isNumberPrime(19));

//        int[] myArr = {3, 1, 1, 5, 6, 4};
//        sortArray(myArr);
//        System.out.println(Arrays.toString(myArr));
//
//        List<Integer> myList = new ArrayList<>(List.of(3,1,1,5,6,4,0,-9,23));
//        sortList(myList);
        System.out.println(switchToInt("2a3"));
    }

    //ZADANIE DODATKOWE 22.4 Zmieniamy znak w cyfrę

    public static int switchToInt(String str) {
        int a = -1;
        try {
            a = Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    //ZADANIE DODATKOWE 20.1 Wartościowa segregacja

    public static int findMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public static void sortList(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>();
        while (!list.isEmpty()) {
            int a = findMin(list);
            if (a > 0) {
                sortedList.add(a);
                list.remove(Integer.valueOf(a));
            } else {
                list.remove(Integer.valueOf(a));
            }
        }
        System.out.println(sortedList);
    }

//    public static void sortArray(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//    }

    //ZADANIE DODATKOWE 19.3 Liczby pierwsze

    public static boolean isNumberPrime(int a) {
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    //ZADANIE DODATKOWE 18.3 Średnia ważona
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
