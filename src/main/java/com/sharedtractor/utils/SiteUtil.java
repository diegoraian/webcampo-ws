package com.sharedtractor.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SiteUtil {
	
	public static Boolean isNotEmptyOrNull(Object obj){
		return isNotNull(obj) || isNotEmpty(obj);
	}
	
	public static Boolean isNotEmpty(Object obj){
		return isNot(isEmpty(obj));
	}
	
	public static Boolean isEmpty(Object obj){
		return obj == Constantes.VAZIO ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public static Boolean isNotNull(Object obj){
		return isNot(isNull(obj));
	}
	
	public static Boolean isNull(Object obj){
		if(obj ==  null){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public static Boolean isNot (Boolean test){
		return test ? Boolean.FALSE: Boolean.TRUE;
	}
	
	public static Date converterStringToDate(String dataString){
		Date data = null;
		SimpleDateFormat df = new SimpleDateFormat(Constantes.DATE_FORMAT);
		if(dataString != null){
			try {
				data = df.parse(dataString);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		}
		return data;
		
	}
	
	public static String converterDateToString(Date data) {
		String retorno = Constantes.VAZIO;
		try{
			SimpleDateFormat df = new SimpleDateFormat(Constantes.DATE_FORMAT);
		
			if(data != null){
				retorno = df.format(data);
			}
			return retorno;
				
		} catch(Exception pe){
			System.out.println(pe.getMessage());
		}
		return retorno;
		
	}
}
