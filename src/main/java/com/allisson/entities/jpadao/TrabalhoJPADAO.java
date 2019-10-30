package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.TrabalhoDAO;
import com.allisson.entities.Trabalho;

public class TrabalhoJPADAO extends GenericJPADAO<Trabalho> implements TrabalhoDAO{

	public TrabalhoJPADAO() {
		super(Trabalho.class);
		
	}

	
	
}
