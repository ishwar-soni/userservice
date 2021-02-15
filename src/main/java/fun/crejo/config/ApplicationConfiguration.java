package fun.crejo.config;

import javax.validation.constraints.NotNull;

public interface ApplicationConfiguration {
  @NotNull
  public Integer getMax();
}
