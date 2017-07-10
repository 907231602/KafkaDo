package com.bf.common;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestProducer {
	public static void main(String[] args) {
		Properties props=new Properties();
		props.put("bootstrap.servers", "yanjijun1:9092,yanjijun2:9092,yanjijun3:9092");
		props.put("acks", "all");// ֻҪ��leaderȷ���յ����ǳɹ�
		props.put("retries", 0);// ʧ�ܲ����·��ͣ�����0���·���

		props.put("batch.size", 16384);// ��������С������Ƿ���ͬһ���������Ժϲ���һ������
		props.put("linger.ms", 0);// �����ӳٶ��ٺ��뷢��Ϣ
//1048576
		 props.put("buffer.memory", 1024*1024);// ��������ʹ�û����С
		props.put("key.serializer", ""
				+ "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		KafkaProducer<String, String> producer=new KafkaProducer<>(props);
		ProducerRecord<String, String> record=new ProducerRecord<String, String>("mytopic", "���");
		producer.send(record);
		producer.close();
		
	}
}