package br.com.wso.monitoramento.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.wso.monitoramento.model.Usuario;
import br.com.wso.monitoramento.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	private Usuario usuario = new Usuario();

	private List<Usuario> usuarios;	
	
	private boolean modoEdicao = false;

	private boolean modoValidar = false;

	// METODO PARA CONTRUIR APOS TODOS OBJETOS ACONTECER
	@PostConstruct
	public void init() {
		usuarios = usuarioRepository.buscarTodos();
	}
	

	// METODO DE SALVAR UM OBJETO NA TABELA
	public void salvar() throws Exception {					
		usuarioRepository.save(usuario); // COLOCAMOS NO BANCO
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro inserido"));		
		if (!modoEdicao)
			usuarios.add(usuario); // COLOCAMOS NA LISTA
		usuario = new Usuario();
		modoEdicao = false;
	}
	
	// METODO DE EXCLUIR
		public void excluir(Usuario usuario) {
			usuarioRepository.delete(usuario);// REMOVI DO BANCO
			usuarios.remove(usuario);// REMOVI DA LISTA
		}

		// METODO EDITAR
		public void editar(Usuario usuarios) {
			setUsuario(usuarios);
		    modoEdicao = true; 
		}

		// METODO CANCELAR
		public void cancelar() {
			usuario = new Usuario();
		    modoEdicao = false; 
		}
	
		//METODO PARA RESTAURA INFORMACAO NA TELA
		public void refresh() {  
	        FacesContext context = FacesContext.getCurrentInstance();  
	        Application application = context.getApplication();  
	        ViewHandler viewHandler = application.getViewHandler();  
	        UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());  
	        context.setViewRoot(viewRoot);  
	        context.renderResponse();  
	    } 
		
		// METODO LISTAR TUDO
		public void listar() throws Exception {
			usuarios = usuarioRepository.buscarTodos();
			
			for (int i = 0; i < usuarios.size(); i++) {
				Usuario us = usuarios.get(i);
				
				usuario.setIdUser(us.getIdUser());
				usuario.setEmail(us.getEmail());
				usuario.setTipoUser(us.getTipoUser());
				usuarioRepository.save(usuario);		
				
			}
			this.refresh();
		}

		//GET E SET
		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public List<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(List<Usuario> usuarios) {
			this.usuarios = usuarios;
		}

		public boolean isModoEdicao() {
			return modoEdicao;
		}

		public void setModoEdicao(boolean modoEdicao) {
			this.modoEdicao = modoEdicao;
		}

		public boolean isModoValidar() {
			return modoValidar;
		}

		public void setModoValidar(boolean modoValidar) {
			this.modoValidar = modoValidar;
		}
		
		
		
}
