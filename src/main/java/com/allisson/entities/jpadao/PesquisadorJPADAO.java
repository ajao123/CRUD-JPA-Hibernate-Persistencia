package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.PesquisadorDAO;
import com.allisson.entities.Pesquisador;

public class PesquisadorJPADAO extends GenericJPADAO<Pesquisador> implements PesquisadorDAO{

	public PesquisadorJPADAO() {
		super(Pesquisador.class);
		
	}

	
	
}
