package fun.crejo.controller;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Nullable;
import javax.validation.Valid;

import fun.crejo.dto.UserSaveRequest;
import fun.crejo.dto.UserUpdateRequest;
import fun.crejo.entity.Role;
import fun.crejo.entity.User;
import fun.crejo.service.RoleService;
import fun.crejo.service.UserService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@Controller("/users")
@ExecuteOn(TaskExecutors.IO)
public class UserController {

  private final UserService userService;
  private final RoleService roleService;

  public UserController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

  @Get(produces = MediaType.APPLICATION_JSON)
  public Page<User> findAll(Pageable pageable) {
    return userService.findAll(pageable);
  }

  @Get(produces = MediaType.APPLICATION_JSON, value = "/{id}")
  public User findById(Long id) {
    return userService.findById(id).orElse(null);
  }

  @Put(produces = MediaType.APPLICATION_JSON)
  public HttpResponse<?> update(@Body @Valid UserUpdateRequest userUpdateRequest) {
    final Long id = userUpdateRequest.getId();

    User savedUser = userService.findById(id).orElse(null);

    if (savedUser == null)
      return null;

    if (userUpdateRequest.getName() != null) {
      savedUser.setName(userUpdateRequest.getName());
    }

    if (userUpdateRequest.getAge() != null) {
      savedUser.setAge(userUpdateRequest.getAge());
    }

    if (userUpdateRequest.getRoles() != null) {
      List<String> roleNames = userUpdateRequest.getRoles();
      List<Role> roles = roleService.findByNameInList(roleNames);
      savedUser.setRoles(new HashSet<Role>(roles));
    }

    userService.update(id, savedUser);
    return HttpResponse.status(HttpStatus.ACCEPTED).body("Successfully updated");
  }

  @Post(produces = MediaType.APPLICATION_JSON)
  public HttpResponse<User> save(@Body @Valid UserSaveRequest userSaveRequest) {
    List<String> roleNames = userSaveRequest.getRoles();
    List<Role> roles = roleService.findByNameInList(roleNames);
    User newUser = new User(userSaveRequest.getName(), userSaveRequest.getAge(), new HashSet<Role>(roles));
    User savedUser = userService.save(newUser);
    return HttpResponse.created(savedUser);
  }

  @Delete(produces = MediaType.APPLICATION_JSON, value = "{/id}")
  public HttpResponse<?> delete(@Nullable Long id) {
    if (id == null)
      return null;
    userService.deleteById(id);
    return HttpResponse.noContent();
  }
}
