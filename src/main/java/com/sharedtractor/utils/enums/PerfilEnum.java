package com.sharedtractor.utils.enums;

public enum PerfilEnum {

	ADMINISTRADOR(0,"Administrador"),
	FAZENDEIRO(1,"Fazendeiro"),
	CLIENTE(2,"Cliente");
	
	
	private Integer codigo;
	
	private String perfil;

	private PerfilEnum(Integer codigo, String perfil) {
		this.codigo = codigo;
		this.perfil = perfil;
		
	}

	public static String getDescricaoByCodigo(Integer codigo){
		for (PerfilEnum item : values()) {
			if(item.getCodigo() == codigo){
				return item.getPerfil();
			}
		}
		return null;
		
	}
	
	public static Integer getCodigoByDescricao(String perfil){
		for (PerfilEnum item : values()) {
			if(item.getPerfil() == perfil){
				return item.getCodigo();
			}
		}
		return null;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
}


