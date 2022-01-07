package tcc.poc.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.poc.models.CustomerModel;
import tcc.poc.models.DepositWarehouseModel;
import tcc.poc.models.enums.StatusMerchandise;
import tcc.poc.service.EisService;

@Slf4j
@Service
public class TopicCustomerConsumer {

    @Autowired
    private EisService eisService;

    @Value("${topic.customer.register}")
    private String topicName;

    @KafkaListener(topics = "${topic.customer.register}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());

        CustomerModel customerModel = getJson(payload.value());

        if(customerModel != null) {

            eisService.registerCustomer(customerModel);

        }

    }

    private CustomerModel getJson(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, CustomerModel.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}