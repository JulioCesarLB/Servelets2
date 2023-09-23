package br.com.fiap.negocio;

import br.com.fiap.dao.DaoPessoa;
import br.com.fiap.modelo.Pessoa;

public class BusinessObject {

	
	public void cadastraPessoa(Pessoa p) throws Exception {
		//Aplico regras de negocio, caso alguma regra seja invalida retorno uma excecao
		DaoPessoa dao = new DaoPessoa();
		dao.inclui(p);
	}
	
	public void alteraPessoa(Pessoa p) throws Exception {
		
	}
	
	public Pessoa recuperaPessoa(long id) throws Exception {
		return null;
	}
	
}
