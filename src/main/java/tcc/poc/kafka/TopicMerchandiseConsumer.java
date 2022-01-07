package tcc.poc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TopicMerchandiseConsumer {

    @Value("${topic.merchandise.register}")
    private String topicName;

    @KafkaListener(topics = "${topic.merchandise.register}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());
    }

}