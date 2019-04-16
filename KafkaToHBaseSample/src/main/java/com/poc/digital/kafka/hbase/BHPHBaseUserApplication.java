package com.poc.digital.kafka.hbase;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.poc.digital.kafka.hbase.util.Consumer;
/**
 * Main class for Inventory micro service.
 */
@SpringBootApplication
//@EnableDiscoveryClient
@ComponentScan({"com.bhp.digital"})
public class BHPHBaseUserApplication {

	private static Consumer consumer;

	@Autowired
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}


	@SuppressWarnings({"squid:S2095"})
	public static void main(String... args) {
		SpringApplication.run(BHPHBaseUserApplication.class, args);
		consumer.startConsumer();
		

	}
}
