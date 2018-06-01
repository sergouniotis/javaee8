package com.tns.webapp.services;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class KatalystEventQueueSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KatalystEventQueueSender.class);

	@Resource(name = "jms/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(name = "java:/jms/queue/OEDesignQueue")
	private Queue queue;

	private static Boolean TRANSACTED = Boolean.TRUE;

	public void send(Serializable o) {
		try (Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession(TRANSACTED, Session.AUTO_ACKNOWLEDGE);
				MessageProducer messageProducer = session.createProducer(queue)) {

			ObjectMessage jmsMessage = session.createObjectMessage(o);

			messageProducer.send(jmsMessage);

		} catch (Exception e) {
			LOGGER.error("Error during sending the message!", e);
		}
	}

}
