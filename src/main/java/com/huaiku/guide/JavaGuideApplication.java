package com.huaiku.guide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.huaiku.guide.jms.KafkaProducer;

@SpringBootApplication
public class JavaGuideApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(JavaGuideApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavaGuideApplication.class, args);
	}
	
//	@Bean public NewTopic huaikuTopic() {
//		logger.info("创建Topic：huaikuFirstTopic");
//		return new NewTopic("huaikuFirstTopic",1,(short)1);
//	}
//
//	@Bean public CommandLineRunner applicationMonitor(final BeanMonitor contextMonitor) {
//		return args -> {
//			logger.info("程序启动....");
//			contextMonitor.listAllBeans();
//		};
//	}
	
	@Bean public CommandLineRunner jmsSender(final KafkaProducer producer) {
		return args -> {
			logger.info("程序启动....");
			producer.send("huaikuFirstTopic","你好Kafka..");
		};
	}
}
