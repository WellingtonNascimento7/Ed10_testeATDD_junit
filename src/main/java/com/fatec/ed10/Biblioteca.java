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
		livros.add(livro);
	}

	public int size() {
		return livros.size();
	}

}
