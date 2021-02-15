package fun.crejo.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import fun.crejo.entity.Role;
import fun.crejo.repository.RoleRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Page<Role> findAll(@NotNull Pageable pageable) {
    return roleRepository.findAll(pageable);
  }

  @Override
  public Optional<Role> findById(@NotNull Long id) {
    return roleRepository.findById(id);
  }

  @Override
  public List<Role> findByNameInList(List<String> roleNames) {
    return roleRepository.findByNameInList(roleNames);
  }

  @Override
  public Role save(@NotNull Role role) {
    return roleRepository.save(role);
  }

  @Override
  public void deleteById(@NotNull Long id) {
    roleRepository.deleteById(id);
  }

  @Override
  public Role update(@NotNull Long id, @NotNull Role role) {
    role.setId(id);
    return roleRepository.update(role);
  }

}
