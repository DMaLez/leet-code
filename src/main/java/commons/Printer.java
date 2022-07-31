package commons;

import java.util.Map;

public class Printer {

    public static void toBinary(int x) {
        System.out.println(x + " -> " + Integer.toBinaryString(x));
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1) {
                System.out.println(array[i]);
            } else {
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void printMap(Map<?,?> map) {
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
