package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.LogradouroDAO;
import br.com.dragonfly.to.LogradouroTO;

public class LogradouroBO {
private LogradouroDAO lDAO = new LogradouroDAO();
	
	public ArrayList<LogradouroTO> listaLogradouros() {
		return lDAO.listaLogradouros();
	}
	
	public LogradouroTO listaLogradouro(int id) {
		return lDAO.listaLogradouro(id);
	}
}
