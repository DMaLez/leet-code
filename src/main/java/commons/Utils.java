package commons;

public class Utils {

    public static int[] toArray(int... args) {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            array[i] = args[i];
        }
        return array;
    }

}
