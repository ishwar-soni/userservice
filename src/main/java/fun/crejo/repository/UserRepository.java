package fun.crejo.repository;

import java.util.Optional;

import fun.crejo.entity.User;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  @Executable
  Optional<User> findByName(String name);
}
