package br.com.ejbapp.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	public static  FacesContext context = FacesContext.getCurrentInstance();
	
	public static void addMsg(String msg) {
		context.addMessage(null, new FacesMessage(msg));
	}

}
