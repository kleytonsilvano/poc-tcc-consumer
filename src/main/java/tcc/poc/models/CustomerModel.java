package tcc.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerModel {
  private Integer id;
  private String name;
  private String cpf;
  private String birthDate;
  private AdressModel address;
  private String telephone;
  private String email;
}

