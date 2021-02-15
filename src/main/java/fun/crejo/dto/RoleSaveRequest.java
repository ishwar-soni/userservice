package fun.crejo.dto;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class RoleSaveRequest {
  @NotBlank
  private String name;

  public RoleSaveRequest() {
  }

  public RoleSaveRequest(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{" + " name='" + getName() + "'" + "}";
  }

}
