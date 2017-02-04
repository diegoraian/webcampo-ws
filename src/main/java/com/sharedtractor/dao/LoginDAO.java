package com.sharedtractor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sharedtractor.models.DadosLogin;
import com.sharedtractor.models.Usuario;

public class LoginDAO {
	private Connection conn = null;
	
	public LoginDAO() {
		conn = DAO.getConnection();
	}
	
	public Usuario efetuarLogin(DadosLogin dadosLogin) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		Usuario usuario = null;
		
		try {
			int i = 0;
			StringBuilder build =  new StringBuilder();
			build.append("SELECT `login`.`username`,`login`.`password`,`login`.`token` FROM `webcampo`.`login`");
			build.append("WHERE `login`.`username` = ? AND `login`.`password` = ? ");
			ps = conn.prepareStatement(build.toString());
			ps.setString(++i, dadosLogin.getUsername());
			ps.setString(++i, dadosLogin.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				i = 0;
				DadosLogin dados = new DadosLogin();
				dados.setUsername(rs.getString(++i));
				dados.setPassword(rs.getString(++i));
				dados.setToken(rs.getString(++i));
				usuario = new UsuarioDAO().buscarUsuario(dados);
			};
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DAO.closeConnection(conn, rs, ps);
		}
		return usuario;
	}

	
	public Boolean criarConta(Usuario usuario){
		String query = "";
		return null;
	}
	
	
}
