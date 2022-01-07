package tcc.poc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class DepositWarehouseModel implements Serializable {
    private Integer idMerchandise;
    private Integer idWarehouse;
}
