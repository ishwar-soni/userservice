package fun.crejo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import fun.crejo.entity.Role;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

public interface RoleService {
  Page<Role> findAll(@NotNull Pageable pageable);

  Optional<Role> findById(@NotNull Long id);

  List<Role> findByNameInList(List<String> roleNames);

  Role save(@NotNull Role role);

  void deleteById(@NotNull Long id);

  Role update(@NotNull Long id, @NotNull Role role);
}
