package br.com.wso.monitoramento.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wso.monitoramento.model.Usuario;
import br.com.wso.monitoramento.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	//Metodo Consultar
//	public boolean consultar(String login, String senha) {
//	        boolean autenticado = false;
//	        String sql;
//	        try {
//	          
//	        	alan.lopes@b3.com.br
//
//	            sql = "SELECT idUser, username, senha, acesso FROM usuarios WHERE username=? and senha=?";
//	            PreparedStatement ps;
//	            ps = conn.prepareStatement(sql);
//	            ps.setString(1, login);
//	            ps.setString(2, senha);
//
//	            ResultSet rs;
//	            rs = ps.executeQuery();
//
//	            if (rs.next()) {
//	                Acesso = rs.getString("acesso");
//	                id = rs.getInt("idUser");
//	                autenticado = true;
//	            } else {
//	                ps.close();
//	                return autenticado;
//	            }
//	        } catch (SQLException ex) {
//	            JOptionPane.showMessageDialog(this, ex);
//	        }
//	        return autenticado;
//	    }


}
