package br.com.blmorais.ws.client.correios.consulta.cep;

import java.net.URL;
import java.util.List;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;

public class ProviderConsultaCep {
	
	/*Codigo fonte gerado via wsimport:
	 * wsimport -keep -verbose https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl
	 */
	private static final String WSDL_URL = "https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl";
		
	public static void main(String[] args) {					
		try {
			String cep = "70150-903";
			
			//Dois tipo de consulta informando o codigo do CEP ou uma lista de CEP 			
			processingCep(cep, null);
			processingCep(null, FileReaderCep.getListCep());
			
			//Casos de erro
			processingCep(null, null);
			processingCep(cep, FileReaderCep.getListCep());
			
		} catch (Exception e) {
			System.out.println("Erro na operação: " +e.getMessage());
		}
	}
	
	private static void processingCep(String cep, List<String> listCep) {
		
		boolean isCep = (cep != null) ? true : false;
		boolean isListCep = (listCep != null) ? true : false;
		
		if(isCep && isListCep) {
			throw new IllegalArgumentException("Parametro de entrada para consulta duplicidade.");
		}else if(!isCep && !isListCep){
			throw new IllegalArgumentException("Nehum parametro informado.");
		}
		
		if(isCep) {
			System.out.println("Consulta por CEP: " +cep);
			consultaCep(cep);
		}else if(isListCep) {	
			for (String strCep : listCep) {
				consultaCep(strCep);
			}	
			System.out.println("\n--------------------------------------------------------\n");
			System.out.println(" Consulta de CEP em massa total a ser processados: " +listCep.size());
			System.out.println("\n--------------------------------------------------------\n");
		}		
	}
	
	private static void consultaCep(String cep) {
		if (validateCep(cep)) {
			Cep cepRsponse = returnCepResponse(cep);
			imprimir(cepRsponse);
		}
	}

	private static Cep returnCepResponse(String cepRequest) {
		EnderecoERP enderecoERP = getConsultaCepWs(cepRequest);
		return new Cep(enderecoERP);	
	}
	
	private static EnderecoERP getConsultaCepWs(String cep) {
		EnderecoERP consultaCEP = new EnderecoERP();
		try {
			System.out.println("Iniciando conexão com o WS.");
			
			URL url = new URL(WSDL_URL);
			AtendeClienteService atendeClienteService = new AtendeClienteService(url);
			consultaCEP = atendeClienteService.getAtendeClientePort().consultaCEP(cep);			
		} catch (SigepClienteException e) {
			if(e.getMessage().equals("CEP INVÁLIDO")) {
				System.out.println(e.getMessage()+" : " +cep);
			}			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro na operação: "+ e.getMessage());
		}		
		return consultaCEP;
	}	

	private static Boolean validateCep(String cep) {
		
		boolean toSeparador = true;
		if(!cep.contains("-")) {
			toSeparador = false;	
		}
		
		if(cep.isEmpty()) {
			System.out.println("CEP NÃO CONSULTADO VALOR VAZIO.");
			return false;
		}else if (toSeparador && cep.length() > 9 ) {
			System.out.println("CEP INVÁLID: "+ cep);
			return false;
		}
		return true;
	}	
	
	private static void imprimir(Cep cep) {
		if(cep.cep != null) {
			System.out.println("Cep [bairro=" + cep.bairro + ", cep=" + cep + ", cidade=" + cep.cidade + ", complemento=" + cep.complemento
			+ ", end=" + cep.endereco + ", uf=" + cep.uf + "]");
		}
	}
}
