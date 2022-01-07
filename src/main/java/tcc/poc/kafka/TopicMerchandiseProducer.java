package tcc.poc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Qualifier("topicMerchandiseProducer")
public class TopicMerchandiseProducer extends TopicProducer {

    @Value("${topic.merchandise.register.producer}")
    private String topicName;

    public TopicMerchandiseProducer(KafkaTemplate<String, String> kafkaTemplate) {
        super(kafkaTemplate);
    }

    @Override
    public String getTopicName() {
        return topicName;
    }

}