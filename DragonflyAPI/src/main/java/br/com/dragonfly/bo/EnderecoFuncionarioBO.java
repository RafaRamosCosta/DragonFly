package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.EnderecoFuncionarioDAO;
import br.com.dragonfly.to.EnderecoFuncionarioTO;

public class EnderecoFuncionarioBO {
private EnderecoFuncionarioDAO eDAO;
	
	public String cadastraEndereco(EnderecoFuncionarioTO endereco) {
		eDAO = new EnderecoFuncionarioDAO();
		return eDAO.inserir(endereco);
	}
	
	public String alteraEndereco(EnderecoFuncionarioTO endereco) {
		eDAO = new EnderecoFuncionarioDAO();
		return eDAO.alterar(endereco);
	}
	
	public String excluiEndereco(int id) {
		eDAO = new EnderecoFuncionarioDAO();
		EnderecoFuncionarioTO endereco = new EnderecoFuncionarioTO();
		endereco.setIdEndFunc(id);
		return eDAO.excluir(endereco);
	}
	
	public ArrayList<EnderecoFuncionarioTO> listaEnderecos() {
		ArrayList<EnderecoFuncionarioTO> enderecos;
		eDAO = new EnderecoFuncionarioDAO();
		enderecos = eDAO.listaEnderecos();
		return enderecos;
	}
	
	public EnderecoFuncionarioTO listaEndereco(int id) {
		eDAO = new EnderecoFuncionarioDAO();
		return eDAO.listaEndereco(id);
	}
}
