package tcc.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchandiseModel {
  private BigDecimal value;
  private String description;
  private String customerCpf;
}

