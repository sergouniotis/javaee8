package com.tns.webapp.services;

import java.io.Serializable;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(name = "KatalystEventQueueMessageListener", activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/OEDesignQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class KatalystEventQueueMessageListener implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(KatalystEventQueueSender.class);

	@Override
	public void onMessage(Message message) {

		try {
			ObjectMessage jmsMessage = ObjectMessage.class.cast(message);
			Serializable content = jmsMessage.getObject();
			LOGGER.info(String.valueOf(content));
		} catch (Exception e) {
			LOGGER.error("Error during reading the message", e);
		}

	}

}
