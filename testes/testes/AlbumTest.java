package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sp2fy.Album;
import sp2fy.Musica;

public class AlbumTest {
	
	private Album theStrokes,metallica;
	
	@Before
	public void criaAlbuns(){
		try{
			metallica = new Album("Death Magnetic", "Metallica" , 2008);
			metallica.adicionaMusica(new Musica("That Was Just Your Life" , 7, "Heavy Metal"));
			metallica.adicionaMusica(new Musica("The End of the Line" , 8, "Heavy Metal"));
			metallica.adicionaMusica(new Musica("Broken, Beat and Scarred" , 7, "Heavy Metal"));
			metallica.adicionaMusica(new Musica("The Day That Never Comes" , 8, "Heavy Metal"));
			
			theStrokes = new Album("Room on fire", "The Strokes", 2003);
			theStrokes.adicionaMusica(new Musica("What ever happened?", 3, "Indie Rock"));
			theStrokes.adicionaMusica(new Musica("Reptilia", 4, "Indie Rock"));
			theStrokes.adicionaMusica(new Musica("Automatic Stop", 3, "Indie Rock"));
			theStrokes.adicionaMusica(new Musica("12:51", 3, "Indie Rock"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}


	@Test
	public void testEquals() {
		
		Album safadao,vingadora,losHermanos,pedrinho;
		
		try{
			safadao = new Album("Safadao 10 anos","Safadao",2003);
			pedrinho = new Album("Funk ostentacao","MC Pedrinho",2015);
			vingadora = new Album("Paredao metralhadora","Vingadora",2016);
			losHermanos = new Album("Los Hermanos","Ventura", 2003);
			assertNotEquals(safadao,vingadora);
			assertNotEquals(pedrinho,vingadora);
			assertNotEquals(vingadora,losHermanos);
			assertNotEquals(safadao, losHermanos);
			assertNotEquals(new int[5], vingadora);
			assertNotEquals(new Album("Paredao metralhadora","Vingador",2016), vingadora);
			assertEquals(safadao,new Album("Safadao 10 anos","Safadao",2002));
			assertEquals(new Album("Los Hermanos","Ventura", 2010), losHermanos); // ano nao eh considerado na comparacao
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
	@Test
	public void testConstrutorErrado() {
		
		try{
			Album tituloErrado = new Album(null, "Metallica", 2008);
		}catch(Exception ex){
			assertEquals("Titulo do album nao pode ser vazio ou nulo.",ex.getMessage());
		}
		
		
		try{
			Album tituloErrado = new Album("", "Metallica", 2008);
		}catch(Exception ex){
			assertEquals(ex.getMessage(),"Titulo do album nao pode ser vazio ou nulo.");
		}
		
		
		try{
			Album artistaErrado = new Album("Death Magnetic", null , 2008);
		}catch(Exception ex){
			assertEquals(ex.getMessage(),"Nome do artista nao pode ser vazio ou nulo.");
		}
		
		
		try{
			Album artistaErrado = new Album("Death Magnetic", "" , 2008);
		}catch(Exception ex){
			assertEquals(ex.getMessage(),"Nome do artista nao pode ser vazio ou nulo.");
		}
		
		
		try{
			Album anoErrado = new Album("Death Magnetic", "Metallica" , -1);
		}catch(Exception ex){
			assertEquals(ex.getMessage(),"Ano do album deve ser maior que 1900.");
		}
		
		
		try{
			Album anoErrado = new Album("Death Magnetic", "Metallica" , 1900);
		}catch(Exception ex){
			assertEquals(ex.getMessage(),"Ano do album deve ser maior que 1900.");
		}
		
	}
	
	@Test
	public void testGetMusicaNaFaixa(){
		
		try{
			assertEquals(theStrokes.getMusicaNaFaixa(1), new Musica("What ever happened?", 3, "Indie Rock"));
			assertEquals(theStrokes.getMusicaNaFaixa(2), new Musica("Reptilia", 4, "Indie Rock"));
			assertNotEquals(new Musica("Meu carro virou motel", 3, "Forro"), theStrokes.getMusicaNaFaixa(1));
			theStrokes.getMusicaNaFaixa(1);
			theStrokes.getMusicaNaFaixa(4);
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		
		try{
			theStrokes.getMusicaNaFaixa(10);
		}catch(Exception ex){
			assertEquals("Numero da faixa maior que o total de musicas no album.",ex.getMessage());
		}
		
		try{
			theStrokes.getMusicaNaFaixa(-1);
		}catch(Exception ex){
			assertEquals("O numero da faixa deve ser positivo.",ex.getMessage());
		}
		
	}
	
	
	
	@Test
	public void testExisteMusica(){
		try{
			assertEquals(true, theStrokes.existeMusica("12:51"));
			assertEquals(true, theStrokes.existeMusica("What ever happened?"));
			assertEquals(true, theStrokes.existeMusica("Reptilia"));
			assertEquals(true, theStrokes.existeMusica("Automatic Stop"));
			assertEquals(false, theStrokes.existeMusica("Garota de ipanema"));
		}
		catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theStrokes.existeMusica(" ");
		}
		catch(Exception ex){
			assertEquals("Musica a ser buscada nao pode ser nula ou vazia.", ex.getMessage());
		}
		
		try{
			theStrokes.existeMusica(null);
		}
		catch(Exception ex){
			assertEquals("Musica a ser buscada nao pode ser nula ou vazia.", ex.getMessage());
		}
		
		
	}
	
	
	@Test
	public void testAdcionaMusica(){
		
		try{
			metallica.adicionaMusica(null);
		}catch(Exception ex){
			assertEquals("Musica a ser adicionada nao pode ser nula.", ex.getMessage());
		}
		
		try{
			metallica.adicionaMusica(new Musica("All nightmare long", 8, "Heavy metal"));
			assertEquals(metallica.getMusicaNaFaixa(5), new Musica("All nightmare long", 8, "Heavy metal"));
			assertEquals(true,metallica.existeMusica("All nightmare long"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			assertNotEquals(true,metallica.adicionaMusica(new Musica("All nightmare long", 8, "Heavy metal")));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}

	@Test
	public void testRemoveMusica(){
		try{
			
			assertEquals(true, metallica.existeMusica("That Was Just Your Life"));
			assertEquals(true,metallica.removeMusica("That Was Just Your Life"));
			assertEquals(false, metallica.existeMusica("That Was Just Your Life"));
			
			assertEquals(true, metallica.existeMusica("The End of the Line"));
			assertEquals(true,metallica.removeMusica("The End of the Line"));
			assertEquals(false, metallica.existeMusica("The End of the Line"));
			
			assertEquals(false, metallica.removeMusica("Musica inexistente"));

			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			metallica.removeMusica(" ");
		}catch(Exception ex){
			assertEquals("Musica a ser removida nao pode ser nula ou vazia.", ex.getMessage());
		}
		
		try{
			metallica.removeMusica(null);
		}catch(Exception ex){
			assertEquals("Musica a ser removida nao pode ser nula ou vazia.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testGetDuracao(){
		try{
			assertEquals(13, theStrokes.getDuracao());
			
			theStrokes.removeMusica("12:51");
			assertEquals(10, theStrokes.getDuracao());
			
			theStrokes.removeMusica("Reptilia");
			assertEquals(6, theStrokes.getDuracao());
			
			theStrokes.removeMusica("Automatic Stop");
			assertEquals(3, theStrokes.getDuracao());
			
			theStrokes.removeMusica("What ever happened?");
			assertEquals(0, theStrokes.getDuracao());
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}


}
