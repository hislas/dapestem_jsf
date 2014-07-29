/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.dapestem.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author K43U
 */
public class FacesContextUtil {
    
   
    public static final String HIBERNATE_SESSION = "hibernate_session";

     public static void setRequestSession(Session session){
        
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION,session);
        
    }
     
    public static Session getRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }
    
    
    
}
