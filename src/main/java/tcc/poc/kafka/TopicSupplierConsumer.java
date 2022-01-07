package tcc.poc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Qualifier("topicSupplierProducer")
public class TopicSupplierConsumer {

    @Value("${topic.supplier.register}")
    private String topicName;

    @KafkaListener(topics = "${topic.supplier.register}")
    public void consume(ConsumerRecord<String, String> payload){
        log.info("Tópico: {}", topicName);
        log.info(payload.value());
    }

}