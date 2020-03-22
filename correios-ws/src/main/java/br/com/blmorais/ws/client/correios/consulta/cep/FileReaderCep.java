package br.com.blmorais.ws.client.correios.consulta.cep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileReaderCep {
	
	private static final String PATH_FILE_CEP = "../correios-ws/src/main/resources/list-cep.txt";
	
	public static List<String> getListCep(){

		System.out.println("Iniciando leitura do arquivo: " + PATH_FILE_CEP + "\n");

		Path path = Paths.get(PATH_FILE_CEP);

		List<String> linesFile = new ArrayList<String>();
		
		try {
			linesFile = Files.readAllLines(path);
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo! "+e.getStackTrace());
		}
		LinkedList<String> listCep = new LinkedList<String>();

		if (linesFile.isEmpty()) {
			System.out.println("O arquivo está vazio ou não está válido.");
		} else {

			for (String line : linesFile) {
				if (!line.isEmpty()) {
					String cep = line.substring(0, 8);
					listCep.add(cep);
					System.out.println("+ " + linesFile.indexOf(line) + " CEP: " + cep + " foi adicionada a lista.");
				} else {
					System.out.println(">> Linha de nº: " + linesFile.indexOf(line) + "f oi ignorada.");
				}
			}
			System.out.println("\nFim da leitura do arquivo, total de CEP processados: " + linesFile.size()+"\n");
		}
		return listCep;
	}

}
