package tcc.poc.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tcc.poc.models.DepositWarehouseModel;
import tcc.poc.models.enums.StatusMerchandise;
import tcc.poc.service.EisService;

@Slf4j
@Service
public class TopicDepositWarehouseConsumer {

    @Autowired
    private EisService eisService;

    @Value("${topic.warehouse.deposit}")
    private String topicName;

    @KafkaListener(topics = "${topic.warehouse.deposit}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());

        DepositWarehouseModel depositWarehouseModel = getJson(payload.value());

        if(depositWarehouseModel != null) {

            StatusMerchandise status = eisService.getStatusMerchandise(depositWarehouseModel.getIdMerchandise());

            if(status != null && !StatusMerchandise.RECEIVED.equals(status)) {

                eisService.registerDepositInWarehouse(depositWarehouseModel.getIdMerchandise(), depositWarehouseModel.getIdWarehouse());

            }

        }

    }

    private DepositWarehouseModel getJson(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, DepositWarehouseModel.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}