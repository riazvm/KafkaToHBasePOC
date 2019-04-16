package com.bhp.digital.wfm.hbase.poc.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.event.ContextRe;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
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
