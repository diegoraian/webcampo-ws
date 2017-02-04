package com.sharedtractor.business;

import com.sharedtractor.dao.LoginDAO;
import com.sharedtractor.models.DadosLogin;
import com.sharedtractor.models.Usuario;
import com.sharedtractor.utils.SiteUtil;

public class LoginBusiness {

	
	public Usuario efetuarLogin(DadosLogin dados){
		if(SiteUtil.isNotEmptyOrNull(dados.getUsername()) && SiteUtil.isNotEmptyOrNull(dados.getPassword())){
			
			return new LoginDAO().efetuarLogin(dados);
		}
		return null;
	}
}
