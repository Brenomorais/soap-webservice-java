
package br.com.brenomorais.noticia.jaxws.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SEINoticia", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SEINoticia {


    /**
     * 
     * @param arg0
     * @return
     *     returns br.com.brenomorais.noticia.jaxws.services.Noticia
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ler", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.Ler")
    @ResponseWrapper(localName = "lerResponse", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.LerResponse")
    @Action(input = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/lerRequest", output = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/lerResponse")
    public Noticia ler(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletar", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.Deletar")
    @ResponseWrapper(localName = "deletarResponse", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.DeletarResponse")
    @Action(input = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/deletarRequest", output = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/deletarResponse")
    public boolean deletar(
        @WebParam(name = "arg0", targetNamespace = "")
        Noticia arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "criar", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.Criar")
    @ResponseWrapper(localName = "criarResponse", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.CriarResponse")
    @Action(input = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/criarRequest", output = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/criarResponse")
    public boolean criar(
        @WebParam(name = "arg0", targetNamespace = "")
        Noticia arg0);

    /**
     * 
     * @return
     *     returns java.util.List<br.com.brenomorais.noticia.jaxws.services.Noticia>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listar", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.Listar")
    @ResponseWrapper(localName = "listarResponse", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.ListarResponse")
    @Action(input = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/listarRequest", output = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/listarResponse")
    public List<Noticia> listar();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alterar", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.Alterar")
    @ResponseWrapper(localName = "alterarResponse", targetNamespace = "http://services.jaxws.noticia.brenomorais.com.br/", className = "br.com.brenomorais.noticia.jaxws.services.AlterarResponse")
    @Action(input = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/alterarRequest", output = "http://services.jaxws.noticia.brenomorais.com.br/SEINoticia/alterarResponse")
    public boolean alterar(
        @WebParam(name = "arg0", targetNamespace = "")
        Noticia arg0);

}
