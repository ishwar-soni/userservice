package fun.crejo.service;

import java.util.Optional;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;

import fun.crejo.config.ApplicationConfiguration;
import fun.crejo.entity.User;
import fun.crejo.repository.UserRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final ApplicationConfiguration applicationConfiguration;

  public UserServiceImpl(UserRepository userRepository, ApplicationConfiguration applicationConfiguration) {
    this.userRepository = userRepository;
    this.applicationConfiguration = applicationConfiguration;
  }

  @Override
  public Page<User> findAll(@NotNull Pageable pageable) {
    if (pageable.getSize() > applicationConfiguration.getMax()) {
      System.out.println("The requested page size is greater than the max application size.");
    }

    return userRepository.findAll(pageable);
  }

  @Override
  public Optional<User> findById(@NotNull Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User save(@NotNull User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteById(@NotNull Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public User update(@NotNull Long id, @NotNull User user) {
    user.setId(id);
    return userRepository.update(user);
  }

}
