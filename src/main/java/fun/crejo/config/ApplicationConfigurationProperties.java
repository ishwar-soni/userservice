package fun.crejo.config;

import javax.validation.constraints.NotNull;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("application")
public class ApplicationConfigurationProperties implements ApplicationConfiguration {

  protected final Integer DEFAULT_MAX = 10;

  @NotNull
  private Integer max = DEFAULT_MAX;

  @Override
  @NotNull
  public Integer getMax() {
    return max;
  }

  public void setMax(@NotNull Integer max) {
    this.max = max;
  }
}
