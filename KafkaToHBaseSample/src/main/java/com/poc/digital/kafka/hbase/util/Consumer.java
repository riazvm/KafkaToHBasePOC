package com.poc.digital.kafka.hbase.util;

import com.poc.digital.kafka.hbase.model.Company;
import com.poc.digital.kafka.hbase.model.User;
import com.poc.digital.kafka.hbase.service.HbaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

@Component
public class Consumer 
{
	@Value("${consumer.propfile}")
	private String propFile;

	//@Value("${consumer.topic}")
	//private String kafkaTopic="COM.BHP.DIGITAL.WFM.POC.CREATEUSER";
	
	 @Value("#{'${consumer.topic}'.split(',')}") 
	 private List<String> kafkaTopic;
	 
	private KafkaConsumer<String,String> consumer;	
	private boolean runConsumer = true;
	private boolean isRunning = false;
	
	@Autowired
	private HbaseService hBaseService;
	 
	
	
		
	public void stopConsumer()
	{
		setRunConsumer(false);
		isRunning=false;

	}
	public void startConsumer()
	{
		if (!isRunConsumer())
		{
			initialize();		
			setRunConsumer(true);


			consumeMessage();
		}
		else
		{
			if (!isRunning)
				consumeMessage();
		}
	}
	public void consumeMessage()
	{
		try
		{


			System.out.println("The topic is...."+kafkaTopic);
			// KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<>(consumerConfig);
		    TestConsumerRebalanceListener rebalanceListener = new TestConsumerRebalanceListener();
		    consumer.subscribe(kafkaTopic, rebalanceListener);
	       while (true) {
		           ConsumerRecords<String,String> records = consumer.poll(1000);
		           for (ConsumerRecord<String,String> record : records) {
		        	   
		        	   ObjectMapper mapper = new ObjectMapper();
						if(record.topic().equals("COM.BHP.DIGITAL.WFM.POC.CREATEUSER") && record.value() != null)
						{
							User userObj = mapper.readValue(record.value(), User.class);
							hBaseService.createUser(userObj);
							
						}
						else if(record.topic().equals("COM.BHP.DIGITAL.WFM.POC.UPDATEUSER") && record.value() != null)
						{
							User userObj = mapper.readValue(record.value(), User.class);
							hBaseService.updateUser(userObj);

						}
						else if(record.topic().equals("COM.BHP.DIGITAL.WFM.POC.CREATECOMPANY") && record.value() != null)
						{
							Company companyObj = mapper.readValue(record.value(), Company.class);
							hBaseService.createCompany(companyObj);
							
						}
						else
						{
							Company companyObj = mapper.readValue(record.value(), Company.class);
							hBaseService.updateCompany(companyObj);
							
						}

		               System.out.printf("Received Message topic =%s, partition =%s, offset = %d, key = %s, value = %s\n", record.topic(),
		                       record.partition(), record.offset(), record.key(), record.value());
		           }

		           consumer.commitSync();
		       }
		}
		       catch (Exception ex)
				{
					ex.printStackTrace();
				}
			
			/*int timeouts = 0;
			int recCounter = 0;
			while (isRunConsumer()) 
			{
				// read records with a short timeout. If we time out, we don't really care.
				System.out.println("Looking up for messages ......");
				ConsumerRecords<String, String> records = consumer.poll(200);
				System.out.println(records.count()+" messages received");
				Thread.sleep(6000);
				if (records.count() == 0) {
					timeouts++;

				} else {
					timeouts = 0;
				}

				for (ConsumerRecord<String, String> record : records)
				{
					System.out.println("-------------TOPIC--------------"+record.topic());
					System.out.println("record::"+recCounter++ +"::Message is::"+record.value());
					ObjectMapper mapper = new ObjectMapper();
					if(record.topic().equals("COM.BHP.DIGITAL.WFM.POC.CREATEUSER") && record.value() != null)
					{
						User userObj = mapper.readValue(record.value(), User.class);
						if(userObj.getPersonUniqueID() != null)
							cirysApi.createUser(userObj);
						
					}
					else if(record.topic().equals("COM.BHP.DIGITAL.WFM.POC.UPDATEUSER") && record.value() != null)
					{
						User userObj = mapper.readValue(record.value(), User.class);
						if(userObj.getPersonUniqueID() != null)
							cirysApi.updateUser(userObj);

					}
					else if(record.topic().equals("COM.BHP.DIGITAL.WFM.POC.CREATECOMPANY") && record.value() != null)
					{
						Company companyObj = mapper.readValue(record.value(), Company.class);
						if(companyObj.getCompanyID() != null)
							cirysApi.createCompany(companyObj);
						
					}
					else
					{
						Company companyObj = mapper.readValue(record.value(), Company.class);
						if(companyObj.getCompanyID() != null)
							cirysApi.updateCompany(companyObj);
						
					}
                   
				
				}
			}
			isRunning=false;
			consumer.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}*/
	}
	/**
	 * @return the runConsumer
	 */
	private boolean isRunConsumer() {
		return runConsumer;
	}
	/**
	 * @param runConsumer the runConsumer to set
	 */
	private void setRunConsumer(boolean runConsumer) {
		this.runConsumer = runConsumer;
	}

	@EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
	public void ContextRefreshedEvent() 
	{
		initialize();
		System.out.println("Kafka consumer initialized---::"+propFile);
	}

	private void initialize()
	{
		try (InputStream props = new FileInputStream(propFile)) 
		{
			setRunConsumer(true);
			Properties properties = new Properties();
			properties.load(props);

			consumer = new KafkaConsumer<>(properties);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void main(String args[]){
		Consumer consumer = new Consumer();
		consumer.initialize();
		consumer.consumeMessage();

	}
	
	private static class  TestConsumerRebalanceListener implements ConsumerRebalanceListener {
	       @Override
	       public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
	           System.out.println("Called onPartitionsRevoked with partitions:" + partitions);
	       }

	       @Override
	       public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
	           System.out.println("Called onPartitionsAssigned with partitions:" + partitions);
	       }
	   }
}
