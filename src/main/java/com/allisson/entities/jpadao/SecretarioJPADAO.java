package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.SecretarioDAO;
import com.allisson.entities.Secretario;

public class SecretarioJPADAO extends GenericJPADAO<Secretario> implements SecretarioDAO{
	
	public SecretarioJPADAO() {
		super(Secretario.class);
		
	}

}
