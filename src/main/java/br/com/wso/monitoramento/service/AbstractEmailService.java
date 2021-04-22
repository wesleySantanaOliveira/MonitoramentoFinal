package br.com.wso.monitoramento.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.wso.monitoramento.model.Evento;
import br.com.wso.monitoramento.repository.EmailService;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Evento obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Evento obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getNmStatus());
		sm.setFrom(sender);
		sm.setSubject("Esta fora! Código: " + obj.getNmEvento());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

}
