package br.com.blmorais.clientws;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXML {

	@SuppressWarnings("unchecked")
	public List<Negociacao> carregaDadosRecebidos(InputStream inputStream) {
		XStream stream = new XStream(new DomDriver());		
		stream.alias("negociacao", Negociacao.class);
			
		return (List<Negociacao>) stream.fromXML(inputStream);		
	}
}
