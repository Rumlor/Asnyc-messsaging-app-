package com.sixtyone.server.services.impl;

import java.util.List;



import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import com.sixtyone.server.services.UserEventProducer;

import dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserEventProducerImpl implements UserEventProducer{

	private KafkaTemplate<String,UserDTO> producer;
	private static final String TOPIC = "usertopic";
	private final SuccessCallBackForEvent successCallBack;
	private final FailureCallBackForEvent failureCallBack;
	
	
	public UserEventProducerImpl(KafkaTemplate<String, UserDTO> producer) {
		this.producer = producer;
		this.successCallBack = new SuccessCallBackForEvent();
		this.failureCallBack = new FailureCallBackForEvent();
	}



	@Override
	public void sendEventDetail(UserDTO dto) {
		log.info("Sending message to broker for User with id {} and followers {}",dto.getId(),dto.getFollowerList());
		ListenableFuture<SendResult<String, UserDTO>> toBeCompleted =  producer.send(TOPIC,dto);
		//thread won't block for the completion of sent message.
		toBeCompleted.addCallback(successCallBack,failureCallBack);
	}

	
	
   private final class SuccessCallBackForEvent implements SuccessCallback<SendResult<String,UserDTO>> {

		
		@Override
		public void onSuccess(SendResult<String, UserDTO> result) {
			log.info("Message was sent succesfully! last message offset is {}",result.getRecordMetadata().offset());
		}
		
	}


	private  final class FailureCallBackForEvent implements   FailureCallback{

		@Override
		public void onFailure(Throwable ex) {
			log.info("Error was encountered while sending message with error message {}",ex.getMessage());
		}

	
		
	}

}
