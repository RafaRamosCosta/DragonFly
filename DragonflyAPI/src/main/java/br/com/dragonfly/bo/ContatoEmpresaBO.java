package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.ContatoEmpresaDAO;
import br.com.dragonfly.to.ContatoEmpresaTO;

public class ContatoEmpresaBO {
	private ContatoEmpresaDAO cDAO;
	
	public String cadastraContato(ContatoEmpresaTO contato) {
		cDAO = new ContatoEmpresaDAO();
		return cDAO.inserir(contato);
	}
	
	public String alteraContato(ContatoEmpresaTO contato) {
		cDAO = new ContatoEmpresaDAO();
		return cDAO.alterar(contato);
	}
	
	public String excluiContato(ContatoEmpresaTO contato) {
		cDAO = new ContatoEmpresaDAO();
		return cDAO.excluir(contato);
	}
	
	public ArrayList<ContatoEmpresaTO> listaContaos() {
		ArrayList<ContatoEmpresaTO> contatos;
		cDAO = new ContatoEmpresaDAO();
		contatos = cDAO.listaContatos();
		return contatos;
	}
	
	public ContatoEmpresaTO listaContato(int id) {
		cDAO = new ContatoEmpresaDAO();
		return cDAO.listaContato(id);
	}
}
