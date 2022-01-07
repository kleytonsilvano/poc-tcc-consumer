package tcc.poc.service;

import org.springframework.stereotype.Service;
import tcc.poc.models.*;
import tcc.poc.models.enums.StatusMerchandise;
import tcc.poc.models.vo.SupplierVO;

/**
 *  Esta classe seria responsável por realizar todas integrações com o EIS
 */
@Service
public class EisService {

    public void registerDepositInWarehouse(Integer idMerchandise, Integer idWarehouse) {
        //Cadastra o depósito da mercadoria no armazem
    }

    public StatusMerchandise getStatusMerchandise(Integer idMerchandise) {
        return StatusMerchandise.IN_TRANSIT;
    }

    public void registerCustomer(CustomerModel customerModel) {
        //Cadastra um novo cliente
    }

    public void registerMerchandiseAsDelivered(String idMerchandise) {
        //Registra mercadoria como entregue
    }

    public void registerMerchandise(MerchandiseModel merchandiseRequest, String cnpj) {
        //Cadastra uma nova mercadoria cujo cnpj do fornecedor
    }

    public void registerSupplier(SupplierVO supplierVO) {
        //Cadastra um novo fornecedor
    }

    public void registerWarehouse(WarehouseModel warehouseModel) {
        //Cadastra um novo armazém
    }
}
