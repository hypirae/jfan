package io.github.hypirae.jfantest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.hypirae.jfan.Query;
import org.junit.jupiter.api.Test;

class QueryTest {

  @Test
  void buildSingle() {
    var res = new Query.Builder()
        .property("foo", "bar")
        .build();

    assertEquals("foo=bar", res.toString());
  }

  @Test
  void buildMany() {
    var res = new Query.Builder()
        .property("foo", "bar")
        .property("foo", "baz")
        .build();

    assertEquals("foo=bar&foo=baz", res.toString());
  }

  @Test
  void encode() {
    var res = new Query.Builder()
        .property("foo", "bar baz")
        .build();

    assertEquals("foo=bar+baz", res.toString());
  }

}