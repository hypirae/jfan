package io.github.hypirae.jfan;

/**
 * Represents a user with a username and password.
 */
public class User {

  private final Pair<String, String> credentials;

  /**
   * Constructs a new User instance with the specified username and password.
   *
   * @param username the username of the user
   * @param password the password of the user
   */
  public User(String username, String password) {
    credentials = new Pair<>(username, password);
  }

  /**
   * Returns the username of the user.
   *
   * @return the username
   */
  public String username() {
    return credentials.x();
  }

  /**
   * Returns the password of the user.
   *
   * @return the password
   */
  public String password() {
    return credentials.y();
  }

}