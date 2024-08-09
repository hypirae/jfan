package io.github.hypirae.jfan;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Vector;

public class Query {
  private final Vector<Pair<String, String>> query;

  private Query(Vector<Pair<String, String>> q) {
    query = q;
  }

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

  private String encode(String slug) {
    return URLEncoder.encode(slug, StandardCharsets.UTF_8);
  }

  public static String encodeUsername(String slug) {
    return slug.replaceAll(" ", "_");
  }

  public static class Builder {
    private final Vector<Pair<String, String>> query = new Vector<>();

    public Builder property(String key, String value) {
      query.add(new Pair<>(key, value));

      return this;
    }

    public Query build() {
      return new Query(query);
    }
  }
}
