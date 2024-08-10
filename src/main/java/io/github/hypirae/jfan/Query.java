package io.github.hypirae.jfan;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

/**
 * Represents a query with key-value pairs.
 */
public class Query {

  private final Vector<Pair<String, String>> query;

  private Query(Vector<Pair<String, String>> q) {
    query = q;
  }

  /**
   * Encodes the username by replacing spaces with underscores.
   *
   * @param slug the username to encode
   * @return the encoded username
   */
  public static String encodeUsername(String slug) {
    return slug.replaceAll(" ", "_");
  }

  /**
   * Converts the query to a URL-encoded string.
   *
   * @return the URL-encoded query string
   */
  public String toString() {
    var queryString = new StringBuilder();

    query.iterator().forEachRemaining(p -> {
      queryString.append(p.x());
      queryString.append("=");
      queryString.append(encode(p.y()));
      queryString.append("&");
    });

    queryString.deleteCharAt(queryString.length() - 1);

    return queryString.toString();
  }

  /**
   * URL-encodes the given string.
   *
   * @param slug the string to encode
   * @return the URL-encoded string
   */
  private String encode(String slug) {
    return URLEncoder.encode(slug, StandardCharsets.UTF_8);
  }

  /**
   * Builder class for constructing Query instances.
   */
  public static class Builder {

    private final Vector<Pair<String, String>> query = new Vector<>();

    /**
     * Adds a key-value pair to the query.
     *
     * @param key   the key
     * @param value the value
     * @return the Builder instance
     */
    public Builder property(String key, String value) {
      query.add(new Pair<>(key, value));

      return this;
    }

    /**
     * Builds and returns a Query instance.
     *
     * @return the constructed Query instance
     */
    public Query build() {
      return new Query(query);
    }
  }
}