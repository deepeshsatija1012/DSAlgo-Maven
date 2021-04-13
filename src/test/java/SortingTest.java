import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;
import sorting.SortingUtils;

import java.util.Arrays;
import java.util.Random;

public class SortingTest {

    private Integer[] getIntegerData() {
        Integer[] integerList = new Integer[10];
        Random random = new Random();
        for (int i = 0 ; i < 10 ; i++) {
            integerList[i] = random.nextInt();
        }
        return integerList;
    }

    private Double[] getDoubleData() {
        Double[] doubleList = new Double[10];
        Random random = new Random();
        for (int i = 0 ; i < 10 ; i++) {
            doubleList[i] = random.nextDouble();
        }
        return doubleList;
    }

    private String[] getStringData() {
        String[] stringList = new String[10];
        for (int i = 0 ; i < 10 ; i++) {
            String generatedString = RandomStringUtils.randomAlphabetic(10);
            stringList[i] = generatedString;
        }
        return stringList;
    }

    @Test
    public void bubbleSortTest() {
        Integer[] integerList = getIntegerData();
        Double[] doubleList = getDoubleData();
        String[] stringList = getStringData();

        Integer[] integerListC = SerializationUtils.clone(integerList);
        Double[] doubleListC = SerializationUtils.clone(doubleList);
        String[] stringListC = SerializationUtils.clone(stringList);

        SortingUtils.bubbleSort(integerListC);
        SortingUtils.bubbleSort(doubleListC);
        SortingUtils.bubbleSort(stringListC);

        Arrays.sort(integerList);
        Arrays.sort(doubleList);
        Arrays.sort(stringList);

        Assert.assertArrayEquals(integerListC, integerList);
        Assert.assertArrayEquals(doubleListC, doubleList);
        Assert.assertArrayEquals(stringListC, stringList);

    }

    @Test
    public void selectionSortTest() {
        Integer[] integerList = getIntegerData();
        Double[] doubleList = getDoubleData();
        String[] stringList = getStringData();

        Integer[] integerListC = SerializationUtils.clone(integerList);
        Double[] doubleListC = SerializationUtils.clone(doubleList);
        String[] stringListC = SerializationUtils.clone(stringList);

        SortingUtils.selectionSort(integerListC);
        SortingUtils.selectionSort(doubleListC);
        SortingUtils.selectionSort(stringListC);

        Arrays.sort(integerList);
        Arrays.sort(doubleList);
        Arrays.sort(stringList);

        Assert.assertArrayEquals(integerListC, integerList);
        Assert.assertArrayEquals(doubleListC, doubleList);
        Assert.assertArrayEquals(stringListC, stringList);

    }

    @Test
    public void insertionSortTest() {
        Integer[] integerList = getIntegerData();
        Double[] doubleList = getDoubleData();
        String[] stringList = getStringData();

        Integer[] integerListC = SerializationUtils.clone(integerList);
        Double[] doubleListC = SerializationUtils.clone(doubleList);
        String[] stringListC = SerializationUtils.clone(stringList);

        SortingUtils.insertionSort(integerListC);
        SortingUtils.insertionSort(doubleListC);
        SortingUtils.insertionSort(stringListC);

        Arrays.sort(integerList);
        Arrays.sort(doubleList);
        Arrays.sort(stringList);

        Assert.assertArrayEquals(integerListC, integerList);
        Assert.assertArrayEquals(doubleListC, doubleList);
        Assert.assertArrayEquals(stringListC, stringList);

    }

    @Test
    public void shellSortTest() {
        Integer[] integerList = getIntegerData();
        Double[] doubleList = getDoubleData();
        String[] stringList = getStringData();

        Integer[] integerListC = SerializationUtils.clone(integerList);
        Double[] doubleListC = SerializationUtils.clone(doubleList);
        String[] stringListC = SerializationUtils.clone(stringList);

        SortingUtils.shellSort(integerListC);
        SortingUtils.shellSort(doubleListC);
        SortingUtils.shellSort(stringListC);

        Arrays.sort(integerList);
        Arrays.sort(doubleList);
        Arrays.sort(stringList);

        Assert.assertArrayEquals(integerListC, integerList);
        Assert.assertArrayEquals(doubleListC, doubleList);
        Assert.assertArrayEquals(stringListC, stringList);

    }

}
