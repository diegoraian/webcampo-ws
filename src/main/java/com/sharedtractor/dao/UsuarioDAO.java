package com.sharedtractor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sharedtractor.models.DadosLogin;
import com.sharedtractor.models.Usuario;
import com.sharedtractor.utils.SiteUtil;
import com.sharedtractor.utils.enums.PerfilEnum;

public class UsuarioDAO {

	Connection conn = null;
	public UsuarioDAO() {
		conn = DAO.getConnection();
	}
	
	public Usuario buscarUsuario(DadosLogin login){
		ResultSet rs = null;
		PreparedStatement ps = null;
		Usuario usuario = null;

		try {
			int i = 0;
			StringBuilder build =  new StringBuilder();
			build.append("SELECT user.nome, ")
			.append("user.telefone, user.perfil, ")
			.append("user.`data-de-nascimento`, ")
			.append("pfl.Descricao FROM webcampo.usuario as user ")
			.append("INNER JOIN webcampo.login  as lgn " )
			.append("ON lgn.idlogin  = user.idusuario ")
			.append("LEFT OUTER JOIN webcampo.perfis as pfl ")
			.append("on pfl.Valor = user.perfil ")
			.append("WHERE lgn.username = ? AND lgn.password = ?");
			
			ps = conn.prepareStatement(build.toString());
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			rs = ps.executeQuery();
			if(rs.next()){
				usuario = new  Usuario();
				usuario.setNome(rs.getString(++i));
				usuario.setTelefone(rs.getString(++i));
				usuario.setPerfil(PerfilEnum.getCodigoByDescricao(rs.getString(++i)));
				usuario.setDataDeNascimento(SiteUtil.converterStringToDate(rs.getString(++i)));
				return usuario;
			};
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DAO.closeConnection(conn, rs, ps);
		}
		return null;
	}
	
	public Boolean cadastrarUsuario(Usuario usuario){
		ResultSet rs = null;
		PreparedStatement ps = null;
		int i = 0;
		StringBuilder build =  new StringBuilder();
		build.append("INSERT INTO `webcampo`.`usuario` ")
			 .append("(`idusuario`,`nome`,`idade`,`telefone`, ")
			 .append("`perfil`,`data-de-nascimento`) ")
			 .append("VALUES (?,")
			 .append("?,?,?,?)");
		try {
			ps = conn.prepareStatement(build.toString());
			ps.setString(++i, usuario.getNome());
			ps.setInt(++i, usuario.getIdade());
			ps.setString(++i, usuario.getTelefone());
			ps.setString(++i, SiteUtil.converterDateToString(usuario.getDataDeNascimento()));
			rs = ps.executeQuery();
			return rs.rowInserted();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally{
			DAO.closeConnection(conn, rs, ps);
		}
		return null;
	}
}

