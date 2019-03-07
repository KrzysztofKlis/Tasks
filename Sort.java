import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        int[] array = createArray(15);
        sortArray(array);
        showArray(array);
        Person[] array1 = createPersonArray(5);
        sortArray(array1);
        showArray(array1);

    }

    public static int[] createArray(int arraySize) {
        int[] array = new int[arraySize];
        Random fillArray = new Random();
        for (int index = 0; index < array.length; index++) {
            array[index] = fillArray.nextInt(100);
            System.out.print(array[index] + " ");
        }
        System.out.println();
        return array;
    }

    public static Person[] createPersonArray(int arraySize) {
        Person[] array = new Person[arraySize];
        Random fillArray = new Random();
        for (int index = 0; index < array.length; index++) {
            array[index] = new Person(fillArray.nextInt(100), Integer.toString(index));
            System.out.println("Person nr: " + array[index].getName() + " has: " + array[index].getAge() + " years.");
        }
        System.out.println();
        return array;
    }

    public static void sortArray(int[] array) {
        int temp, count1, count2;
        for (count1 = 1; count1 < array.length; count1++) {
            for (count2 = count1; count2 > 0; count2--) {
                if (array[count2] < array[count2 - 1]) {
                    temp = array[count2];
                    array[count2] = array[count2 - 1];
                    array[count2 - 1] = temp;
                } else break;
            }
        }
    }

    public static void sortArray(Person[] array) {
        int count1, count2;
        Person temp = new Person();
        for (count1 = 1; count1 < array.length; count1++) {
            for (count2 = count1; count2 > 0; count2--) {
                if (array[count2].getAge() < array[count2 - 1].getAge()) {
                    temp = array[count2];
                    array[count2] = array[count2 - 1];
                    array[count2 - 1] = temp;
                } else break;
            }
        }
    }

    public static void showArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    public static void showArray(Person[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.println("Person nr: " + array[index].getName() + " has: " + array[index].getAge() + " years.");
        }
        System.out.println();
    }

}
