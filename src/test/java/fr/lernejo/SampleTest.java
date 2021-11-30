package fr.lernejo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    @Test
    void op() {
        assertEquals(15, new Sample().op(Sample.Operation.ADD, 10, 5));
        assertEquals(15, new Sample().op(Sample.Operation.MULT, 3, 5));
    }

    @Test
    void fact() {
        assertEquals(6,new Sample().fact(3));
        assertTrue(assertThrows(IllegalArgumentException.class, () -> new Sample().fact(-1)).getMessage().contains("N should be positive"));

    }
}