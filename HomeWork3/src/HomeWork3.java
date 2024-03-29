import java.lang.reflect.Array;
import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
        zeroToOne();// 1
        System.out.println();

        fromOneToHundred(); // 2
        System.out.println();

        lessThenSix(); // 3
        System.out.println();

        drawDiagonals();// 4
        System.out.println();

        createArray(15, 9); // 5
        System.out.println();

        minAndMax();// 6
        System.out.println();

        int[] arr = {3, 2, 1};
        System.out.println(checkBalance(arr));


    }


    public static void shiftOptimal(int[] arr, int n) {
        if (arr == null || arr.length < 2) return;
        int shift = (arr.length + n % arr.length) % arr.length;
        int count = 0;
        for (int i = 0; count < arr.length; i++) {
            int currentIndex = i;
            int prevElement = arr[i];
            do {
                int nextElement = (currentIndex + shift) % arr.length;
                int temp = arr[nextElement];
                arr[nextElement] = prevElement;
                prevElement = temp;
                currentIndex = nextElement;
                count++;
            } while (i != currentIndex);
        }
    }

    static void shiftLong(int[] arr, int n) {
        int shift = (arr.length + n % arr.length) % arr.length;
        for (int i = 0; i < shift; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    static boolean checkBalance(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) return false;

        int half = sum / 2;
        int left = 0;

        for (int i : arr) {
            left += i;
            if (left == half) return true;
        }
        return false;
    }

    private static void minAndMax() {
        int[] arr = {45, -23, 43, 68, -530, 5343, 34, 3455, 1345, 985};

        int max, min;
        max = min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("Минимальное " + min);
        System.out.println("Максимальное " + max);
    }

    public static void createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));

    }

    private static void drawDiagonals() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length ; i++) {
            arr[i][i] = 1;
        }

        int i = 0;
        int j = arr.length - 1;

        for (; i < arr.length && j >= 0; i++, j--) {
            arr[i][j] = 1;
        }

        System.out.println(Arrays.deepToString(arr));
    }

    private static void lessThenSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void fromOneToHundred() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void zeroToOne() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                arr[i] = 0;
            } else if(arr[i] == 0) {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
