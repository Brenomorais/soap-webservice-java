package br.com.brenomorais.noticia.jaxws.services;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.brenomorais.noticia.jaxws.model.Noticia;
  
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface SEINoticia {
     
    @WebMethod
    boolean criar(Noticia noticia);
     
    @WebMethod
    boolean alterar(Noticia noticia);
     
    @WebMethod
    boolean deletar(Noticia noticia);
     
    @WebMethod
    Noticia ler(int id);
     
    @WebMethod
    ArrayList<Noticia> listar();
 
}