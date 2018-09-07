package br.com.brenomorais.noticia.jaxws.client.utils;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import br.com.brenomorais.noticia.jaxws.services.SEINoticia;
 
public class Conexao {
 
    private static final SEINoticia sei = construirConexao();
 
    private static SEINoticia construirConexao() {
        try {            
            URL url = new URL("http://localhost:8089/noticias?wsdl");
              
            QName qname = new QName("http://services.jaxws.noticia.brenomorais.com.br/", "SIBNoticiaService");
      
            Service service = Service.create(url, qname);
             
            return service.getPort(SEINoticia.class);
 
        } catch (Exception ex) {
            System.err.println("Problemas ao conectar no serviço: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
 
    public static SEINoticia getConnection() {
        return sei;
    }
}