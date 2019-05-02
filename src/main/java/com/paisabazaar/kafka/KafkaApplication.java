package com.paisabazaar.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class KafkaApplication {
//    static final Logger logger = Logger.getLogger(KafkaApplication.class);
//
//    @Value("${kafka.bootstrap.servers}")
//    private static String kafkaBootstrapServers;
//
//    @Value("${kafka.topic}")
//    private static String topic;
//
//    private static void sendKafkaMessage(String payload,
//                                         KafkaProducer<String, String> producer,
//                                         String topic) {
//        logger.info("Sending Kafka message: " + payload);
//        producer.send(new ProducerRecord<>(topic, payload));
//    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
//        Properties producerProperties = new Properties();
//        producerProperties.put("bootstrap.servers", "10.120.0.6:9092");
//        producerProperties.put("acks", "all");
//        producerProperties.put("retries", 0);
//        producerProperties.put("batch.size", 16384);
//        producerProperties.put("linger.ms", 1);
//        producerProperties.put("buffer.memory", 33554432);
//        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);
//
//        JSONObject jsonObject = new JSONObject();
//        JSONObject nestedJsonObject = new JSONObject();
//
//        for (int index = 0; index < 10; index++) {
//            try {
//                jsonObject.put("index", index);
//                jsonObject.put("message", "The index is now: " + index);
//                nestedJsonObject.put("nestedObjectMessage", "This is a nested JSON object with index: " + index);
//                jsonObject.put("nestedJsonObject", nestedJsonObject);
//            } catch (JSONException e) {
//                logger.error(e.getMessage());
//            } finally {
//                sendKafkaMessage(jsonObject.toString(), producer, "com.paisabazaar.test.tushar");
//            }
//        }
    }

}
