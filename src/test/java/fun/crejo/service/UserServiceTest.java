package fun.crejo.service;

// import static org.junit.jupiter.api.Assertions.assertIterableEquals;

// import java.util.Arrays;
// import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class UserServiceTest {
  @Inject
  UserService userService;

  @Test
  void testGetAllUsers() {
    // List<String> expectedList = Arrays.asList("Ishwar", "Sutirtha");
    // assertIterableEquals(expectedList, userService.getAllUsers());
  }
}
