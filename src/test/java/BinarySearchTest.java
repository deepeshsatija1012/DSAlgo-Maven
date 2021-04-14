import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import symboltable.BinarySearch;

import java.util.Random;

public class BinarySearchTest {

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
    public void testBinarySearchInteger() {
        Integer[] integerList = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch<Integer, Integer> search = new BinarySearch<>(integerList, integerList);

        Assert.assertTrue(search.rank(2) == 2);
        Assert.assertTrue(search.rank(-2) == 0);

        Assert.assertTrue(search.rank(10) == 10);
        Assert.assertTrue(search.rank(11) == 10);
    }


}
