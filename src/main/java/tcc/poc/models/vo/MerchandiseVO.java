package tcc.poc.models.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tcc.poc.models.MerchandiseModel;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchandiseVO implements Serializable {
    private MerchandiseModel merchandiseRequest;
    private String cnpj;
    private String idMerchandise;
    private Boolean delivered;
}