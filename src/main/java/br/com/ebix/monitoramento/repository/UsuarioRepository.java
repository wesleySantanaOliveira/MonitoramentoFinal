package br.com.ebix.monitoramento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ebix.monitoramento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	  @Query("select u from Usuario u where u.email=:email") public Usuario
	  buscarPorEmail(@Param("email") String email);
	  
	  @Query("select u from Usuario u ORDER BY u.idUser DESC") public List<Usuario>
	  buscarTodos();
	  
	  @Query("select u from Usuario u where u.idUser=:idUser") public Usuario
	  buscarPorUsuario(@Param("idUser") Usuario idUser);
	  
	  @Query("select u from Usuario u") public List<Usuario> listAll();
	 

}
