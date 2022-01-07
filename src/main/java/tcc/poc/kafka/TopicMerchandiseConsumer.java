package tcc.poc.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tcc.poc.models.vo.MerchandiseVO;
import tcc.poc.service.EisService;

@Slf4j
@Service
public class TopicMerchandiseConsumer {

    @Autowired
    private EisService eisService;

    @Value("${topic.merchandise.register}")
    private String topicName;

    @KafkaListener(topics = "${topic.merchandise.register}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());

        MerchandiseVO merchandiseVO = getJson(payload.value());

        if(merchandiseVO != null) {

            if(merchandiseVO.getDelivered() != null && merchandiseVO.getDelivered()) {

                eisService.registerMerchandiseAsDelivered(merchandiseVO.getIdMerchandise());

            } else {

                eisService.registerMerchandise(merchandiseVO.getMerchandiseRequest(), merchandiseVO.getCnpj());
            }

        }

    }

    private MerchandiseVO getJson(String jsonString) {
        try {
            return new ObjectMapper().readValue(jsonString, MerchandiseVO.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}