import java.util.Random;

public class MissingElement {

    public static void main(String[] args) {
        int[] array = createArray(5);
        showArray(array);
        flipArray(array);
        showArray(array);
        if (array.length == 0){
            System.out.println("Array don't exist.");
        }
        else {
            System.out.println("Average value in array is: " + averageValueInArray(array));
        }
        missedElement(array);

    }

    static int[] createArray(int arraySize){
        int[] array = new int[arraySize];
        for (int count = 0; count < arraySize; count++){
            array[count] = count + 1;
        }
        return array;
    }

    static void showArray(int[] array){
        for (int count = 0; count < array.length; count++){
            System.out.print(array[count] + " ");
        }
        System.out.println();
    }

    static void flipArray(int[] array){
        for (int count = 0; count < array.length/2; count++){
            int temp;
            temp = array[count];
            array[count] = array[array.length - count - 1];
            array[array.length - count - 1] = temp;
        }
    }

    static int averageValueInArray(int[] array){
        if (array.length != 0) {
            int sum = 0;
            for (int count = 0; count <array.length; count++){
                sum += array[count];
            }
            return sum / array.length;
        }
        else {
            return 0;
        }
    }

    static void missedElement(int[] array){
        Random witchMissed = new Random();
        int count = 0;
        int shift = 1;
        int nrOfMissingElement = witchMissed.nextInt(array.length-1);
        while (count < array.length) {
            if (count == nrOfMissingElement) {
                shift = 2;
            }
            array[count] = count + shift;
            System.out.print(array[count] + " ");
            count++;
        }
        System.out.println();
        count = 0;
        while (count < array.length){
            if (array[count] != count + 1){
                System.out.println("Missing element is: " + (count + 1));
                break;
            }
            count++;
        }
    }
}
