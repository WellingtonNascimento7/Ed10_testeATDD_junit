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
	
	@Test
    public void ct02_quando_cadastrar_livro_com_isbn_ja_cadastrado_nao_deve_cadastrar() {
        Biblioteca biblioteca = new Biblioteca();
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        biblioteca.save(umLivro);
        //outro livro com o mesmo isbn é cadastrado
        Livro outroLivro = new Livro();
        outroLivro.setAutor("Pressman 2");;
        outroLivro.setIsbn("1111");
        outroLivro.setTitulo("Engenharia de Software 2");
        biblioteca.save(outroLivro);
        //entao o total de livros cadastrados deve ser igual a 1
        assertEquals(1, biblioteca.size());
    }

}
