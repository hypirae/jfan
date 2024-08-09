package io.github.hypirae.jfan;

public class User {

  private final Pair<String, String> credentials;

  public User(String username, String password) {
    credentials = new Pair<>(username, password);
  }

  public String username() {
    return credentials.x();
  }

  public String password() {
    return credentials.y();
  }

}
