package com.github.hypirae.jfan;

public class Application {

  private final Session session;

  public static class Builder {
    private Session session;

    public Builder() {}

    public Builder setSession(Session sess) {
      session = sess;

      return this;
    }

    public Application build() {
      return new Application(session);
    }
  }

  private Application(Session sess) {
    session = sess;
  }

  public Session getSession() {
    return session;
  }

}
