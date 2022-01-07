package tcc.poc.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tcc.poc.models.WarehouseModel;
import tcc.poc.service.EisService;

@Slf4j
@Service
public class TopicWarehouseConsumer {

    @Autowired
    private EisService eisService;

    @Value("${topic.warehouse.register}")
    private String topicName;

    @KafkaListener(topics = "${topic.warehouse.register}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());

        WarehouseModel warehouseModel = getJson(payload.value());

        if(warehouseModel != null) {

            eisService.registerWarehouse(warehouseModel);

        }

    }

    private WarehouseModel getJson(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, WarehouseModel.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}