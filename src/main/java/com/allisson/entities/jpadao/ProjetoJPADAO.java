package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.ProjetoDAO;
import com.allisson.entities.Projeto;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> implements ProjetoDAO{

	public ProjetoJPADAO() {
		super(Projeto.class);
		
	}	
	
}
