import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import unionfind.QuickFindEager;
import unionfind.QuickUnionLazy;
import unionfind.UF;
import unionfind.WeightedQuickUnion;

import java.util.ArrayList;
import java.util.List;

public class UnionFindTest {

    private static class DataUFTest {
        private final int p, q;
        private final boolean connected;

        public DataUFTest(int p, int q, boolean connected) {
            this.p = p;
            this.q = q;
            this.connected = connected;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }

        public boolean isConnected() {
            return connected;
        }
    }

    private List<DataUFTest> dataToTest = new ArrayList<>();


    @Before
    public void init() {
        dataToTest.clear();
        dataToTest.add(new DataUFTest(4, 3, false));
        dataToTest.add(new DataUFTest(3, 8, false));
        dataToTest.add(new DataUFTest(6, 5, false));
        dataToTest.add(new DataUFTest(9, 4, false));
        dataToTest.add(new DataUFTest(2, 1, false));
        dataToTest.add(new DataUFTest(8, 9, true));
        dataToTest.add(new DataUFTest(5, 0, false));
        dataToTest.add(new DataUFTest(7, 2, false));
        dataToTest.add(new DataUFTest(6, 1, false));
        dataToTest.add(new DataUFTest(1, 0, true));
        dataToTest.add(new DataUFTest(6, 7, true));
    }

    private void testData(UF uf) {
        for (DataUFTest data : dataToTest) {
            Assert.assertTrue(data.p + "-" + data.q, uf.connected(data.p, data.q) == data.isConnected());
            if (!uf.connected(data.p, data.q)) {
                uf.union(data.p, data.q);
                System.out.println("Connecting " + data.p + "-" + data.q);
            } else {
                System.out.println("Connected " + data.p + "-" + data.q);
            }
        }
    }

    @Test
    public void testQuickFindEager() {
        QuickFindEager qfe = new QuickFindEager(dataToTest.size());
        testData(qfe);
    }

    @Test
    public void testQuickUnionLazy() {
        QuickUnionLazy qfe = new QuickUnionLazy(dataToTest.size());
        testData(qfe);
    }

    @Test
    public void testWeightedQuickUnion() {
        WeightedQuickUnion qfe = new WeightedQuickUnion(dataToTest.size());
        testData(qfe);
    }
}
