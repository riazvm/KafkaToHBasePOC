package com.poc.digital.kafka.hbase.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

//public class kInitializer  implements ApplicationListener<ApplicationStartedEvent> {
public class kInitializer  {
	@Value("${consumer.propfile}")
	private String propFile;
	@Autowired
	private Consumer consumer;
	public kInitializer()
	{
		//consumer = new Consumer();
	}

	
    public void startConsumer()
    {
    	consumer.startConsumer();
    }
    public void stopCosumer()
    {
    	consumer.stopConsumer();
    }


}
