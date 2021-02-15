package fun.crejo.controller;

import javax.annotation.Nullable;
import javax.validation.Valid;

import fun.crejo.dto.RoleSaveRequest;
import fun.crejo.dto.RoleUpdateRequest;
import fun.crejo.entity.Role;
import fun.crejo.service.RoleService;
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

@Controller("/roles")
@ExecuteOn(TaskExecutors.IO)
public class RoleController {
  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @Get(produces = MediaType.APPLICATION_JSON)
  public Page<Role> findAll(Pageable pageable) {
    return roleService.findAll(pageable);
  }

  @Get(produces = MediaType.APPLICATION_JSON, value = "/{id}")
  public Role findById(Long id) {
    return roleService.findById(id).orElse(null);
  }

  @Put(produces = MediaType.APPLICATION_JSON)
  public HttpResponse<?> update(@Body @Valid RoleUpdateRequest roleUpdateRequest) {
    final Long id = roleUpdateRequest.getId();
    final String name = roleUpdateRequest.getName();
    final Role updateRole = new Role(name);
    roleService.update(id, updateRole);
    return HttpResponse.status(HttpStatus.ACCEPTED).body("Successfully updated");
  }

  @Post(produces = MediaType.APPLICATION_JSON)
  public HttpResponse<Role> save(@Body @Valid RoleSaveRequest roleSaveRequest) {
    Role newRole = new Role(roleSaveRequest.getName());
    Role savedRole = roleService.save(newRole);
    return HttpResponse.created(savedRole);
  }

  @Delete(produces = MediaType.APPLICATION_JSON, value = "{/id}")
  public HttpResponse<?> delete(@Nullable Long id) {
    if (id == null)
      return null;
    roleService.deleteById(id);
    return HttpResponse.noContent();
  }

}
