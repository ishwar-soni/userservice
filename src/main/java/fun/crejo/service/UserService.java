package fun.crejo.service;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import fun.crejo.entity.User;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

public interface UserService {
  Page<User> findAll(@NotNull Pageable pageable);

  Optional<User> findById(@NotNull Long id);

  User save(@NotNull User user);

  void deleteById(@NotNull Long id);

  User update(@NotNull Long id, @NotNull User user);
}
