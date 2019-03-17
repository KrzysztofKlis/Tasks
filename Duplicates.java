import java.util.Arrays;
import java.util.Random;

public class Duplicates {

    public static void main(String[] args) {
        int arraySize = 10;
        int[] array1, array2;
        array1 = createArray(arraySize);
        array2 = createArray(arraySize);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));

        sortingArray(array1, 0, array1.length - 1);
        sortingArray(array2, 0, array2.length - 1);

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        
        int[][] arrayOfDuplicates = {checkDuplicates(array1), checkDuplicates(array2)};
        System.out.println(Arrays.toString(checkDuplicates(array1)));
        System.out.println(Arrays.toString(checkDuplicates(array2)));
    }

    static int[] checkDuplicates(int[] array) {
        int nrOfDuplicates = 0;
        int[] tempArray = new int[array.length / 2];
        tempArray[0] = -1;

        for (int count = 0; count < array.length - 1; count++) {
            if ((array[count] == array[count + 1]) && (array[count] != tempArray[nrOfDuplicates])) {
                tempArray[nrOfDuplicates] = array[count];
                tempArray[nrOfDuplicates + 1] = array[count];
                nrOfDuplicates++;
                count++;
            }
        }

        int[] arrayOfDuplicates = new int[nrOfDuplicates];
        for (int count = 0; count < nrOfDuplicates; count++) {
            arrayOfDuplicates[count] = tempArray[count];
        }
        return arrayOfDuplicates;

    }

    static int[] createArray(int arraySize) {
        Random randomNumbers = new Random();
        int[] array;
        array = new int[arraySize];
        int count = 0;
        while (count < array.length) {
            array[count] = randomNumbers.nextInt(10);
            count++;
        }
        return array;
    }

    static void sortingArray(int[] array, int begining, int end) {
        if (begining < end) {

            int middle = (begining + end) / 2;
            sortingArray(array, begining, middle);
            sortingArray(array, middle + 1, end);
            merge(array, begining, middle, end);
        }
    }

    static void merge(int[] array, int begining, int middle, int end) {
        int counter1, counter2, counter3;
        int firstArrayLength = middle - begining + 1;
        int secondArrayLength = end - middle;

        int[] firstTempArray = new int[firstArrayLength];
        int[] secondTempArray = new int[secondArrayLength];

        for (counter1 = 0; counter1 < firstArrayLength; counter1++)
            firstTempArray[counter1] = array[begining + counter1];
        for (counter2 = 0; counter2 < secondArrayLength; counter2++)
            secondTempArray[counter2] = array[middle + 1 + counter2];

        counter1 = 0;
        counter2 = 0;
        counter3 = begining;

        while (counter1 < firstArrayLength && counter2 < secondArrayLength) {
            if (firstTempArray[counter1] <= secondTempArray[counter2]) {
                array[counter3] = firstTempArray[counter1];
                counter1++;
            } else {
                array[counter3] = secondTempArray[counter2];
                counter2++;
            }
            counter3++;
        }

        while (counter1 < firstArrayLength) {
            array[counter3] = firstTempArray[counter1];
            counter1++;
            counter3++;
        }

        while (counter2 < secondArrayLength) {
            array[counter3] = secondTempArray[counter2];
            counter2++;
            counter3++;
        }
    }

}
