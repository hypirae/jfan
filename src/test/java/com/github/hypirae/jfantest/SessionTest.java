package com.github.hypirae.jfantest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.hypirae.jfan.Session;

class SessionTest {
  public final String sessionName = "test";
  public final Session session = new Session.Builder()
      .setSessionName(sessionName)
      .build();


  @Test
  void getSessionName() {
    assertEquals(session.getSessionName(), sessionName);
  }
}
