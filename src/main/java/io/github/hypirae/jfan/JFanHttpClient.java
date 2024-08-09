package io.github.hypirae.jfan;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public interface JFanHttpClient {
  HttpResponse<String> get(URI uri, Query query) throws URISyntaxException, IOException, InterruptedException;
  HttpResponse<String> post(URI uri, Query query) throws IOException, InterruptedException;
}
