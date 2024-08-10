package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairTest {

    @Test
    void x() {
        Pair<String, Integer> pair = new Pair<>("Hello", 123);
        assertEquals("Hello", pair.x());
    }

    @Test
    void y() {
        Pair<String, Integer> pair = new Pair<>("Hello", 123);
        assertEquals(123, pair.y());
    }
}