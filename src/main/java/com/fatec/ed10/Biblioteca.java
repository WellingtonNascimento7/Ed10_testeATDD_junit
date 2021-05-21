package com.fatec.ed10;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private List<Livro> livros = new ArrayList<Livro>();

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void save(Livro livro) {
//		livros.add(livro);
//		validação de livro com isbn ja cadastrado usando funções lambda 
		if(livros.stream().noneMatch(l -> l.getIsbn().equals(livro.getIsbn())) 
				//Verifica se Isbn não esta em branco 
				&& livro.getIsbn().length() != 0){
			livros.add(livro);
		}
	}
	
	
	
	

	public int size() {
		return livros.size();
	}

}
