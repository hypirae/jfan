package io.github.hypirae.jfantest;

import io.github.hypirae.jfan.Query;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryTest {

    @Test
    void encodeUsername() {
        String encoded = Query.encodeUsername("test user");
        assertEquals("test_user", encoded);
    }

    @Test
    void toStringTest() {
        Query query = new Query.Builder()
                .property("key1", "value1")
                .property("key2", "value 2")
                .build();
        assertEquals("key1=value1&key2=value+2", query.toString());
    }

    @Test
    void builderTest() {
        Query query = new Query.Builder()
                .property("key1", "value1")
                .property("key2", "value2")
                .build();
        assertEquals("key1=value1&key2=value2", query.toString());
    }
}