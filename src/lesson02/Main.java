package lesson02;

public class Main {
    public static void main(String[] args) {
        int res;

        String[][] arr1 = {
                {"0", "1", "2", "3"},
                {"-1", "-2", "-3", "-4"},
                {"1", "1", "1", "1"},
                {"10", "9", "8", "7"}
        };

        // Все ОК
        try {
            res = arraySum(arr1);
            System.out.println(res);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        String[][] arr2 = {
                {"0", "1", "2", "3"},
                {"-1", "-2", "-3", "-4"},
                {"1", "1", "1", "1"}
        };

        // Не хватает 1 элемента в массиве
        try {
            res = arraySum(arr2);
            System.out.println(res);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        String[][] arr3 = {
                {"0", "1", "2", "3"},
                {"-1", "-2", "-3", "-4", "тест"},
                {"1", "1", "1", "1"},
                {"10", "9", "8", "7"}
        };

        // Лишний элемент в подмассиве
        try {
            res = arraySum(arr3);
            System.out.println(res);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }

        String[][] arr4 = {
                {"0", "1", "2", "3"},
                {"-1", "-2", "-4", "тест"},
                {"1", "1", "1", "1"},
                {"10", "9", "8", "7"}
        };

        // Лишний элемент в подмассиве
        try {
            res = arraySum(arr4);
            System.out.println(res);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    private static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;

        if (arr.length != 4) {
            throw new MyArraySizeException(arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException(i, arr[i].length);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }

        return sum;
    }
}
