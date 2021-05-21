package com.fatec.ed10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
    public void ct02_quando_cadastrar_livro_com_isbn_ja_cadastrado() {
        Biblioteca biblioteca = new Biblioteca();
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        biblioteca.save(umLivro);
        List<Livro> lista = biblioteca.getLivros();
        //outro livro com o mesmo isbn é cadastrado
        Livro outroLivro = new Livro();
        outroLivro.setAutor("Pressman");;
        outroLivro.setIsbn("1111");
        outroLivro.setTitulo("Engenharia de Software"); 
        biblioteca.save(outroLivro);
//        Verifica se o livro é realmente igual ao ja cadastrado
        assertTrue(outroLivro.equals(lista.get(0)));
        //entao o total de livros cadastrados deve ser igual a 1
        assertEquals(1, biblioteca.size());
    }
	
	@Test
    public void ct03_quando_cadastrar_livro_com_isbn_em_branco() {        
        Biblioteca biblioteca = new Biblioteca();
        //um livro é cadastrado com isbn em branco
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        String mensagem = umLivro.setIsbn("");
        umLivro.setTitulo("Engenharia de Software");
        //Verifica se foi enviado  a mensagem de dados invalidos
        assertTrue(!mensagem.equals(null));
        //O livro não deve ser cadastrado
        biblioteca.save(umLivro);
        //entao o total de livros cadastrados deve ser igual 0
        assertEquals(0, biblioteca.size());
    }
	
	@Test
    public void ct04_quando_cadastrar_livro_com_titulo_em_branco() {
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro é cadastrado com titulo em branco
        Livro umLivro = new Livro();
        umLivro.setAutor("Pressman");;
        umLivro.setIsbn("1111");
        String mens = umLivro.setTitulo("");
        //Verifica se foi enviado  a mensagem de dados invalidos
        assertTrue(!mens.equals(null));
        //O livro não deve ser cadastrado
        biblioteca.save(umLivro);
        //entao o total de livros cadastrados deve ser igual 0
        assertEquals(0, biblioteca.size());
    }
	
	@Test
    public void ct05_quando_cadastrar_livro_com_autor_em_branco() {
        //dado que nao existem livros cadastrados
        Biblioteca biblioteca = new Biblioteca();
        //quando um livro é cadastrado com autor em branco
        Livro umLivro = new Livro();
        //Verifica se foi enviado  a mensagem de dados invalidos
        String mens = umLivro.setAutor("");;
        umLivro.setIsbn("1111");
        umLivro.setTitulo("Engenharia de Software");
        assertTrue(!mens.equals(null));
        //O livro não deve ser cadastrado
        biblioteca.save(umLivro);
        //entao o total de livros cadastrados deve ser igual 0
        assertEquals(0, biblioteca.size());
    }

}
