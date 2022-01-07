package tcc.poc.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tcc.poc.models.vo.SupplierVO;
import tcc.poc.service.EisService;

@Slf4j
@Component
@Qualifier("topicSupplierProducer")
public class TopicSupplierConsumer {

    @Autowired
    private EisService eisService;

    @Value("${topic.supplier.register}")
    private String topicName;

    @KafkaListener(topics = "${topic.supplier.register}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());

        SupplierVO supplierVO = getJson(payload.value());

        if(supplierVO != null) {

            eisService.registerSupplier(supplierVO);

        }

    }

    private SupplierVO getJson(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, SupplierVO.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}