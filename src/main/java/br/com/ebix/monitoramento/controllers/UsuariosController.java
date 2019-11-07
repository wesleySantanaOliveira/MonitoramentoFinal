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
import br.com.ebix.monitoramento.model.Usuario;
import br.com.ebix.monitoramento.repository.EventoRepository;
import br.com.ebix.monitoramento.repository.UsuarioRepository;

@RestController
public class UsuariosController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//POST
	@RequestMapping(method = RequestMethod.POST,value = "/usuario",
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Usuario> cadastraEvento(@RequestBody Usuario usuario) {
		Usuario usuarioCadastro = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioCadastro, HttpStatus.OK);
	}
	
	//GET
	@RequestMapping(method = RequestMethod.GET, value = "/usuario", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Usuario>> buscarUsuario() {
		Collection<Usuario> usuarioBuscar = usuarioRepository.findAll();
		return new ResponseEntity<>(usuarioBuscar, HttpStatus.OK);
	}
	
	//GET{id}
	@RequestMapping(method = RequestMethod.GET, value = "/usuario/{id}", 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuarioId(Usuario usuario) {
		Usuario usuarioBuscar = usuarioRepository.findOne(usuario.getIdUser());
		return new ResponseEntity<>(usuarioBuscar, HttpStatus.OK);
	}
	
	//DELETE
	@RequestMapping(method = RequestMethod.DELETE, value = "/usuario/{id}")
	public ResponseEntity<Usuario> deletarUsuario(Usuario usuario) {
		Usuario usuarioDeletado = usuarioRepository.findOne(usuario.getIdUser());
		if(usuarioDeletado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usuarioRepository.delete(usuarioDeletado);
		return new ResponseEntity<>(HttpStatus.OK);		
		
	}
	
	//ALTERAR
	@RequestMapping(method = RequestMethod.PUT, value = "/usuario",
			consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE , 
			produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> alterarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioAlterado = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioAlterado, HttpStatus.OK);
	}
	

}
