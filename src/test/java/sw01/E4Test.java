package sw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class E4Test {

    @Test
    void fiboRec1Zero() {
        E4 e4  = new E4();
        assertEquals(0, e4.fiboRec1(0));

    }

    @Test
    void fiboRec1One() {
        E4 e4  = new E4();
        assertEquals(1, e4.fiboRec1(1));

    }

    @Test
    void fiboRec1Two() {
        E4 e4  = new E4();
        assertEquals(1, e4.fiboRec1(2));

    }

    @Test
    void fiboRec1Twenty() {
        E4 e4  = new E4();
        assertEquals(6765, e4.fiboRec1(20));

    }
}