package br.com.ebix.monitoramento.controllers;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ebix.monitoramento.model.Evento;
import br.com.ebix.monitoramento.model.Usuario;
import br.com.ebix.monitoramento.repository.EventoRepository;
import br.com.ebix.monitoramento.service.EventoService;

@Named
@ViewScoped
public class UsuarioController {
	
	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private EventoService eventoService;

	private Usuario usuario = new Usuario();

	private List<Usuario> usuarios;
	
	
	

}
