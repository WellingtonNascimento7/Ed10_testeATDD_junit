package com.fatec.ed10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class REQ01_Cadastro_Livro_Teste {

	@Test	
	void ct01_quando_dados_validos_cadastra_com_sucesso() {
	 Biblioteca biblioteca = new Biblioteca();
	 Livro umLivro = new Livro();
	 umLivro.setAutor("Pressman");
	 umLivro.setIsbn("1111");
	 umLivro.setTitulo("Engenharia de Software");
	 biblioteca.save(umLivro);
	 assertEquals (1, biblioteca.size());
	} 

}
