package br.com.ebix.monitoramento.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ebix.monitoramento.model.Evento;
import br.com.ebix.monitoramento.repository.EventoRepository;

@RestController
public class EventosController {
	
	@Autowired
	EventoRepository eventoRepository;
	
	//POST
	@RequestMapping(method = RequestMethod.POST,value = "/evento",
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Evento> cadastraEvento(@RequestBody Evento evento) {
		Evento eventoCadastro = eventoRepository.save(evento);
		return new ResponseEntity<Evento>(eventoCadastro, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method = RequestMethod.GET, value = "/evento", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Evento>> buscarEventos() {
		Collection<Evento> eventoBuscar = eventoRepository.findAll();
		return new ResponseEntity<>(eventoBuscar, HttpStatus.OK);
	}
	
	//GET{id}
	@RequestMapping(method = RequestMethod.GET, value = "/evento/{id}", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Evento> buscarEventosId(Evento evento) {
		Evento eventoBuscar = eventoRepository.findOne(evento.getId());
		return new ResponseEntity<>(eventoBuscar, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/evento/{id}")
	public ResponseEntity<Evento> deletarEvento(Evento evento) {
		Evento eventoDeletado = eventoRepository.findOne(evento.getId());
		if(eventoDeletado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		eventoRepository.delete(eventoDeletado);
		return new ResponseEntity<>(HttpStatus.OK);		
		
	}
	
	//ALTERAR
	@RequestMapping(method = RequestMethod.PUT, value = "/evento",
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE , 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Evento> alterarEvento(@RequestBody Evento evento) {
		Evento eventoAlterado = eventoRepository.save(evento);
		return new ResponseEntity<Evento>(eventoAlterado, HttpStatus.OK);
	}
	

}
