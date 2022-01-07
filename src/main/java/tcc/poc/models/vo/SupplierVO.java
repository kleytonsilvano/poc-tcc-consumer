package tcc.poc.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tcc.poc.models.AdressModel;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierVO implements Serializable {
  private Integer id;
  private String name;
  private String cnpj;
  private AdressModel address;
  private String telephone;
  private String email;
}

