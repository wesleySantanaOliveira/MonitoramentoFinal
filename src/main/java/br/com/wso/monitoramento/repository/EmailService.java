package br.com.wso.monitoramento.repository;

import org.springframework.mail.SimpleMailMessage;

import br.com.wso.monitoramento.model.Evento;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationEmail(Evento obj);
	
	
}
