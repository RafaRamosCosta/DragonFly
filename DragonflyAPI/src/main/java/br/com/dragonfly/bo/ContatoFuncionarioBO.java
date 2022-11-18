package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.ContatoFuncionarioDAO;
import br.com.dragonfly.to.ContatoFuncionarioTO;

public class ContatoFuncionarioBO {
private ContatoFuncionarioDAO cDAO;
	
	public String cadastraContato(ContatoFuncionarioTO contato) {
		cDAO = new ContatoFuncionarioDAO();
		return cDAO.inserir(contato);
	}
	
	public String alteraContato(ContatoFuncionarioTO contato) {
		cDAO = new ContatoFuncionarioDAO();
		return cDAO.alterar(contato);
	}
	
	public String excluiContato(int id) {
		cDAO = new ContatoFuncionarioDAO();
		ContatoFuncionarioTO contato = new ContatoFuncionarioTO();
		contato.setIdContFunc(id);
		return cDAO.excluir(contato);
	}
	
	public ArrayList<ContatoFuncionarioTO> listaContatos() {
		ArrayList<ContatoFuncionarioTO> contatos;
		cDAO = new ContatoFuncionarioDAO();
		contatos = cDAO.listaContatos();
		return contatos;
	}
	
	public ContatoFuncionarioTO listaContato(int id) {
		cDAO = new ContatoFuncionarioDAO();
		return cDAO.listaContato(id);
	}
}
