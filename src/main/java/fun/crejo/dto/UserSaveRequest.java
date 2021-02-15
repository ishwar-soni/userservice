package fun.crejo.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UserSaveRequest {
  @NotBlank
  private String name;

  @NotBlank
  private Long age;

  @NotNull
  private List<String> roles;

  public UserSaveRequest() {
  }

  public UserSaveRequest(String name, Long age, List<String> roles) {
    this.name = name;
    this.age = age;
    this.roles = roles;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getAge() {
    return this.age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

  public List<String> getRoles() {
    return this.roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "{" + " name='" + getName() + "'" + ", age='" + getAge() + "'" + ", roles='" + getRoles() + "'" + "}";
  }

}
