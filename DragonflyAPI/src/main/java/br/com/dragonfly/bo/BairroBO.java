package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.BairroDAO;
import br.com.dragonfly.to.BairroTO;

public class BairroBO {
	private BairroDAO bDAO = new BairroDAO();
	
	public ArrayList<BairroTO> listaBairros() {
		return bDAO.listaBairros();
	}
	
	public BairroTO listaBairro(int id) {
		return bDAO.listaBairro(id);
	}
}
