package com.allisson.entities.jpadao;

import com.allisson.dao.GenericJPADAO;
import com.allisson.dao.services.FuncionarioLimpezaDAO;
import com.allisson.entities.FuncionarioLimpeza;

public class FuncionarioLimpezaJPADAO extends GenericJPADAO<FuncionarioLimpeza> implements FuncionarioLimpezaDAO{

	public FuncionarioLimpezaJPADAO() {
		super(FuncionarioLimpeza.class);
		
	}
	
}
