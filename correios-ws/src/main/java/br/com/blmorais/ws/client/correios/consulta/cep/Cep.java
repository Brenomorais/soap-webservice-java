package br.com.blmorais.ws.client.correios.consulta.cep;

import java.util.List;

import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.UnidadePostagemERP;

public class Cep {

	String bairro;
	String cep;
	String cidade;
	String complemento;
	String endereco;
	String uf;
	List<UnidadePostagemERP> unidadesPostagem;

	public Cep() {
	}


	public Cep(EnderecoERP endErp) {
		super();
		this.bairro = endErp.getBairro();
		this.cep =endErp.getCep();;
		this.cidade =endErp.getCidade();
		this.complemento =endErp.getComplemento2();;
		this.endereco = endErp.getEnd();;
		this.uf =endErp.getUf();			;
	}

	@Override
	public String toString() {
		return "Cep [bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", complemento=" + complemento
				+ ", end=" + endereco + ", uf=" + uf + "]";
	}
}
