package fun.crejo.repository;

import java.util.List;

import fun.crejo.entity.Role;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  @Executable
  List<Role> findByNameInList(List<String> roleNames);
}
