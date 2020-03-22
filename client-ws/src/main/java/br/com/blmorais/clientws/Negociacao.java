package br.com.blmorais.clientws;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Negociacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Double preco;
	private final Integer quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {		
		return  data;
	}

	@Override
	public String toString() {
		return "Negociacao [preco=" + preco + ", quantidade=" + quantidade + ", data=" +  convertCalendarToDate(data) + "]";
	}
	
	private String convertCalendarToDate(Calendar date) {
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		return dateformat.format(date.getTime());
	}
}
