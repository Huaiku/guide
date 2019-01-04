package com.huaiku.guide.jms;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
	private final KafkaTemplate<Object, Object> kafka;

	@Autowired
	public KafkaProducer(KafkaTemplate<Object, Object> kafkaTemplate) {
		this.kafka = kafkaTemplate;
	}

	/**
	 * i. 发送消息到指定得 TOPIC
	 * 
	 * @param topic
	 * @param message
	 */
	public void send(@NotNull String topic, @NotNull String message) {
		logger.info("发送消息到Topic:{},Message:{}", new Object[] { topic, message });
		kafka.send(topic, message);
		logger.info("消息返送完毕...");
	}
}
