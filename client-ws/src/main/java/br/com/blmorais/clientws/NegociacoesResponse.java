package br.com.blmorais.clientws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class NegociacoesResponse {
	
	private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";
	
	public static void main(String[] args) {
		List<Negociacao> negociacoes = getListNegociacoes();
		
		for (Negociacao negociacao : negociacoes) {
			System.out.println(negociacao.toString());
		}
	}

	public static List<Negociacao> getListNegociacoes() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			InputStream content = connection.getInputStream();			
			return new LeitorXML().carregaDadosRecebidos(content);
		} catch (IOException e) {
			throw new IllegalArgumentException("Erro na leitura do xml: "+ e.getMessage());
		} finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
	}
}
