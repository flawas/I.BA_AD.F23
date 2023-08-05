package sw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E7Test {

    @Test
    public void testSymmetricTrue() {
        E7 e7 = new E7();
        assertEquals(true, e7.checkSymmetric(1234321));
    }

    @Test
    public void testSymmetricFalse() {
        E7 e7 = new E7();
        assertEquals(false, e7.checkSymmetric(12345));
    }

    @Test
    void getMaxNumber() {
        E7 e7 = new E7();
        assertEquals(999, e7.getMaxNumber(3));

    }

    @Test
    void getSymmetricCountOne() {
        E7 e7 = new E7();
        assertEquals(10, e7.getSymmetricCount(1));
    }

    @Test
    void getSymmetricCountTwo() {
        E7 e7 = new E7();
        assertEquals(9, e7.getSymmetricCount(2));
    }

    @Test
    void getSymmetricCountThree() {
        E7 e7 = new E7();
        assertEquals(90, e7.getSymmetricCount(3));
    }

    @Test
    void getSymmetricCountFour() {
        E7 e7 = new E7();
        assertEquals(90, e7.getSymmetricCount(4));
    }

    @Test
    void getMinNumberOne() {
        E7 e7 = new E7();
        assertEquals(0, e7.getMinNumber(1));
    }

    @Test
    void getMinNumberTwo() {
        E7 e7 = new E7();
        assertEquals(10, e7.getMinNumber(2));
    }
}