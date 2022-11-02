package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.EnderecoEmpresaDAO;
import br.com.dragonfly.to.EnderecoEmpresaTO;

public class EnderecoEmpresaBO {
private EnderecoEmpresaDAO eDAO;
	
	public String cadastraEndereco(EnderecoEmpresaTO endereco) {
		eDAO = new EnderecoEmpresaDAO();
		return eDAO.inserir(endereco);
	}
	
	public String alteraEndereco(EnderecoEmpresaTO endereco) {
		eDAO = new EnderecoEmpresaDAO();
		return eDAO.alterar(endereco);
	}
	
	public String excluiEndereco(int id) {
		eDAO = new EnderecoEmpresaDAO();
		EnderecoEmpresaTO endereco = new EnderecoEmpresaTO();
		endereco.setIdEndEmp(id);
		return eDAO.excluir(endereco);
	}
	
	public ArrayList<EnderecoEmpresaTO> listaEnderecos() {
		ArrayList<EnderecoEmpresaTO> enderecos;
		eDAO = new EnderecoEmpresaDAO();
		enderecos = eDAO.listaEnderecos();
		return enderecos;
	}
	
	public EnderecoEmpresaTO listaEndereco(int id) {
		eDAO = new EnderecoEmpresaDAO();
		return eDAO.listaEndereco(id);
	}
}
