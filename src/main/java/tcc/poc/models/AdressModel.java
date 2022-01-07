package tcc.poc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdressModel {
  private Integer id;
  private String zipCode;
  private String street;
  private String number;
  private String district;
  private String city;
  private String state;
}

