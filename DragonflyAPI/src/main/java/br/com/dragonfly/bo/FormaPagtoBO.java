package br.com.dragonfly.bo;

import java.util.ArrayList;

import br.com.dragonfly.dao.FormaPagtoDAO;
import br.com.dragonfly.to.FormaPagtoTO;

public class FormaPagtoBO {
	private FormaPagtoDAO fPDAO;
	
	public String cadastraFormaPagto(FormaPagtoTO formaPagto) {
		fPDAO = new FormaPagtoDAO();
		return fPDAO.inserir(formaPagto);
	}
	
	public String alteraFormaPagto(FormaPagtoTO formaPagto) {
		fPDAO = new FormaPagtoDAO();
		return fPDAO.alterar(formaPagto);
	}
	
	public String excluiFormaPagto(FormaPagtoTO formaPagto) {
		fPDAO = new FormaPagtoDAO();
		return fPDAO.excluir(formaPagto);
	}
	
	public ArrayList<FormaPagtoTO> listaFormasPagto() {
		ArrayList<FormaPagtoTO> formasPagto;
		fPDAO = new FormaPagtoDAO();
		formasPagto = fPDAO.listaFormas();
		return formasPagto;
	}
	
	public FormaPagtoTO listaFormaPagto(int id) {
		FormaPagtoTO formaPagto;
		fPDAO = new FormaPagtoDAO();
		formaPagto = fPDAO.listaForma(id);
		return formaPagto;
	}
}
