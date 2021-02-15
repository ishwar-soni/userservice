package fun.crejo.controller;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

// import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class UserControllerTest {
  @Inject
  EmbeddedServer embeddedServer;

  @Inject
  @Client("/")
  HttpClient httpClient;

  @Test
  void testGetUsersResponse() {
    // String response =
    // httpClient.toBlocking().retrieve(HttpRequest.GET("/users"));
    // assertEquals("[\"Ishwar\",\"Sutirtha\"]", response);
  }
}
