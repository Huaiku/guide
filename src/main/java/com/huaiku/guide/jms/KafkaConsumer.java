package com.huaiku.guide.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	@KafkaListener(id="huaiku",topics="huaikuFirstTopic") public void firstConsumer(String message) {
		logger.info("****************接受到一下信息***********************");
		logger.info(message);
		logger.info("********************结束******************************");
	}
}
