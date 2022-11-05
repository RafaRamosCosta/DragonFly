package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.FuncionarioDAO;
import br.com.dragonfly.to.FuncionarioTO;

public class FuncionarioBO {
	private FuncionarioDAO fDAO = new FuncionarioDAO();
	
	public String cadastraFuncionario(FuncionarioTO func) {
		return fDAO.inserir(func);
	}
	
	public String alteraFuncionario(FuncionarioTO func) {
		return fDAO.alterar(func);
	}
	
	public String excluirFuncionario(int id) {
		FuncionarioTO func = new FuncionarioTO();
		func.setIdFunc(id);
		return fDAO.excluir(func);
	}
	
	public ArrayList<FuncionarioTO> listaFuncionarios() {
		return fDAO.listaFuncs();
	}
	
	public FuncionarioTO listaFuncionario(int id) {
		return fDAO.listaFuncs(id);
	}
}
