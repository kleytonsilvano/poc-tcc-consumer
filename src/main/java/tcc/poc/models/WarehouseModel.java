package tcc.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseModel {
  private Integer id;
  private String name;
  private AdressModel address;
  private Boolean isActive;
}

