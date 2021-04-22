package br.com.wso.monitoramento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.wso.monitoramento.model.Evento;
import br.com.wso.monitoramento.model.Usuario;

public interface LoginRepository extends JpaRepository<Usuario, Long>{
	
	@Query("select u from Usuario u where u.email=:email")
	public Evento buscarPorEmail(@Param("email") String email);
	
	@Query("select u from Usuario u where u.pass=:pass")
	public Evento buscarPorPass(@Param("pass") String pass);

}
