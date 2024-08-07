package com.github.hypirae.jfantest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.hypirae.jfan.Application;
import com.github.hypirae.jfan.Session;

class ApplicationTest {

  public final String sessionName = "test";
  public final Session session = new Session.Builder()
      .setSessionName(sessionName)
      .build();
  public final Application app = new Application.Builder()
      .setSession(session)
      .build();

  @Test
  void getSession() {
    assertNotNull(app.getSession());
    assertEquals(session, app.getSession());
  }
}
