package com.bf.common;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class TestConsumer {
	public static void main(String[] args) {
		 Properties props=new Properties();
		 props.put("bootstrap.servers", "yanjijun1:9092,yanjijun2:9092,yanjijun3:9092");
	     props.put("group.id", "test");
	     props.put("enable.auto.commit", "true");
	     props.put("auto.offset.reset", "latest");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		 KafkaConsumer<String, String> consumer=new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("mytopic"));
		while (true) {
		 ConsumerRecords<String, String> records=consumer.poll(2000);
			for (ConsumerRecord<String, String> consumerRecord : records) {
				System.out.println(consumerRecord.value());
			}
		}
		
		
	}
}
