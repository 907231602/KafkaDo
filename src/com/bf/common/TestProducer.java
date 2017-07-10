package com.bf.common;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestProducer {
	public static void main(String[] args) {
		Properties props=new Properties();
		props.put("bootstrap.servers", "yanjijun1:9092,yanjijun2:9092,yanjijun3:9092");
		props.put("acks", "all");// 只要有leader确认收到就是成功
		props.put("retries", 0);// 失败不重新发送，大于0重新发送

		props.put("batch.size", 16384);// 批处理大小，如果是发到同一分区，可以合并成一个请求
		props.put("linger.ms", 0);// 可以延迟多少毫秒发消息
//1048576
		 props.put("buffer.memory", 1024*1024);// 生产者能使用缓存大小
		props.put("key.serializer", ""
				+ "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer=new KafkaProducer<>(props);
		ProducerRecord<String, String> record=new ProducerRecord<String, String>("mytopic", "你好");
		producer.send(record);
		producer.close();
		
	}
}
