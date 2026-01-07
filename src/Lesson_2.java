import java.util.Arrays;
public class Lesson_2 {

    // Задание_1: Создайте метод printThreeWords()
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // Задание_2: Создайте метод checkSumSign()
    public static void checkSumSign() {
        int a = 5;
        int b = 4;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // Задание_3: Создайте метод printColor()
    public static void printColor () {
        int value = 60;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Задание_4: Создайте метод compareNumbers()
    public static void compareNumbers() {
        int a = 77;
        int b = 88;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // Задание_5: Напишите метод, принимающий на вход два целых числа
    public static boolean checkSumRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Задание_6: Напишите метод, которому в качестве параметра передается целое число
    public static void printNumberSign(int number){
        if (number >= 0) {
            System.out.println(number + " - положительное число");
        } else {
            System.out.println(number + " - отрицателное число");
        }
    }// Задание_7 Напишите метод, которому в качестве параметра передается целое число
    public static boolean isNegative(int number){
        return number < 0;
    }

    // Задание_8: Напишите метод, которому в качестве аргументов передается строка и число
    public static void printStringMultipleTimes(String str, int count) {
        for (int i = 0; i < count; i++){
            System.out.println(str);
        }
    }

    // Задание_9: Напишите метод, который определяет, является ли год високосным
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Задание_10: Задать целочисленный массив, состоящий из элементов 0 и 1
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    // Задание_11: Задать пустой целочисленный массив длиной 100
    public static int[] fillArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    //Задание_12: Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом
    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void main(String[] args) {
        // 1. Вызов метода printThreeWords()
        System.out.println("Задача 1:");
        printThreeWords();

        // 2. Вызов метода checkSumSign()
        System.out.println("\nЗадача 2:");
        checkSumSign();

        // 3. Вызов метода printColor()
        System.out.println("\nЗадача 3:");
        printColor();

        // 4. Вызов метода compareNumbers()
        System.out.println("\nЗадача 4:");
        compareNumbers();

        // 5. Вызов метода checkSumRange()
        System.out.println("\nЗадача 5:");
        System.out.println("Сумма 5 и 7 в диапазоне 10-20: " + checkSumRange(5, 7));
        System.out.println("Сумма 10 и 5 в диапазоне 10-20: " + checkSumRange(10, 5));

        // 6. Вызов метода printNumberSign()
        System.out.println("\nЗадача 6:");
        printNumberSign(10);
        printNumberSign(-5);
        printNumberSign(0);

        // 7. Вызов метода isNegative()
        System.out.println("\nЗадача 7:");
        System.out.println("Число -5 отрицательное: " + isNegative(-5));
        System.out.println("Число 10 отрицательное: " + isNegative(10));
        System.out.println("Число 0 отрицательное: " + isNegative(0));

        // 8. Вызов метода printStringMultipleTimes()
        System.out.println("\nЗадача 8:");
        printStringMultipleTimes("Hello", 3);

        // 9. Вызов метода isLeapYear()
        System.out.println("\nЗадача 9:");
        System.out.println("2024 год високосный: " + isLeapYear(2024));
        System.out.println("2023 год високосный: " + isLeapYear(2023));
        System.out.println("1900 год високосный: " + isLeapYear(1900));
        System.out.println("2000 год високосный: " + isLeapYear(2000));

        // 10. Вызов метода invertArray()
        System.out.println("\nЗадача 10:");
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив: " + Arrays.toString(array10));
        invertArray(array10);
        System.out.println("Инвертированный массив: " + Arrays.toString(array10));

        // 11. Вызов метода fillArray()
        System.out.println("\nЗадача 11:");
        int[] array11 = fillArray(100);
        System.out.println("Первые 10 элементов массива: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array11[i] + " ");
        }
        System.out.println("...");

        // 12. Вызов метода multiplyLessThanSix()
        System.out.println("\nЗадача 12:");
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив: " + Arrays.toString(array12));
        multiplyLessThanSix(array12);
        System.out.println("Измененный массив: " + Arrays.toString(array12));
    }
}
