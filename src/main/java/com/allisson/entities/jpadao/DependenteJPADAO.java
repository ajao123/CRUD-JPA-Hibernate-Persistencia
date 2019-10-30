package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.DependenteDAO;
import com.allisson.entities.Dependente;

public class DependenteJPADAO extends GenericJPADAO<Dependente> implements DependenteDAO{

	public DependenteJPADAO() {
		super(Dependente.class);
		
	}

	
	
}
