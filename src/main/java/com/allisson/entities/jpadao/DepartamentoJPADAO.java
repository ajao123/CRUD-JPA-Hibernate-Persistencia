package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.DepartamentoDAO;
import com.allisson.entities.Departamento;

public class DepartamentoJPADAO extends GenericJPADAO<Departamento> implements DepartamentoDAO{

	public DepartamentoJPADAO() {
		super(Departamento.class);
		
	}

	
	
}
