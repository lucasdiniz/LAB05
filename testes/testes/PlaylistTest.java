package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sp2fy.Musica;
import sp2fy.Playlist;


public class PlaylistTest {
	
	private Playlist playlistUm;
	private Musica isThisIt,kids,electricFeel,timeToPretend;

	@Before
	public void criaPlaylist(){
		try{
			playlistUm = new Playlist();
			isThisIt = new Musica("Is this it", 4, "indie rock");
			kids = new Musica("Kids", 4, "psychedelic rock");
			electricFeel = new Musica("Electric Feel", 4, "psychedelic rock");
			timeToPretend = new Musica("Time to pretend", 4, "psychedelic rock");
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
	}
	
	@Test
	public void testContemMusica(){
		try{
			assertNotEquals(true, playlistUm.contemMusica(kids));
			assertNotEquals(true, playlistUm.contemMusica(isThisIt));
			assertEquals(true, playlistUm.adicionaMusica(kids));
			assertEquals(true, playlistUm.adicionaMusica(isThisIt));
			assertEquals(true, playlistUm.contemMusica(kids));
			assertEquals(true, playlistUm.contemMusica(isThisIt));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.contemMusica(null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica a ser buscada nao pode ser null.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testContemMusicaṔeloNome(){
		try{
			assertNotEquals(true, playlistUm.contemMusicaPeloNome("kids"));
			assertNotEquals(true, playlistUm.contemMusicaPeloNome("isThisIt"));
			assertEquals(true, playlistUm.adicionaMusica(kids));
			assertEquals(true, playlistUm.adicionaMusica(isThisIt));
			assertEquals(true, playlistUm.contemMusicaPeloNome("kids"));
			assertEquals(true, playlistUm.contemMusicaPeloNome("is this it"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.contemMusicaPeloNome(null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da musica a ser buscada nao pode ser vaziou ou null.", ex.getMessage());
		}
		
	}
	
	
	@Test
	public void testAdicionaMusica(){
		try{
			assertEquals(true, playlistUm.adicionaMusica(isThisIt));
			assertEquals(true, playlistUm.adicionaMusica(kids));
			assertEquals(true, playlistUm.adicionaMusica(electricFeel));
			assertEquals(true, playlistUm.adicionaMusica(timeToPretend));
			assertNotEquals(true, playlistUm.adicionaMusica(timeToPretend));
			assertNotEquals(true, playlistUm.adicionaMusica(electricFeel));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.adicionaMusica(null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica a ser adicionada nao pode ser null.", ex.getMessage());
		}
		
		try{
			playlistUm.adicionaMusica(new Musica(null, 4, "funk"));
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Titulo da musica nao pode ser nulo ou vazio.", ex.getMessage());
		}
		

		try{
			playlistUm.adicionaMusica(new Musica("meu carro virou motel", 4, ""));
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Genero da musica nao pode ser nulo ou vazio.", ex.getMessage());
		}
		
	}

	@Test
	public void testRemoveMusica(){
		try{
			assertNotEquals(true, playlistUm.contemMusica(kids));
			assertNotEquals(true, playlistUm.removeMusica(kids));
			playlistUm.adicionaMusica(kids);
			assertEquals(true, playlistUm.contemMusica(kids));
			assertEquals(true, playlistUm.removeMusica(kids));
			assertNotEquals(true, playlistUm.removeMusica(isThisIt));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.removeMusica(null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica a ser removida nao pode ser null.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testRemoveMusicaPeloNome(){
		try{
			assertNotEquals(true, playlistUm.contemMusicaPeloNome("kids"));
			assertNotEquals(true, playlistUm.removeMusicaPeloNome("kids"));
			playlistUm.adicionaMusica(kids);
			assertEquals(true, playlistUm.contemMusicaPeloNome("kids"));
			assertEquals(true, playlistUm.removeMusicaPeloNome("kids"));
			assertNotEquals(true, playlistUm.removeMusicaPeloNome("kids"));
			assertNotEquals(true, playlistUm.removeMusicaPeloNome("musica que nao existe"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.removeMusicaPeloNome("");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da musica a ser removida nao pode ser vazio ou nulo.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testGetDuracao(){
		try{
			assertEquals(0, playlistUm.getDuracao());
			playlistUm.adicionaMusica(isThisIt);
			assertEquals(4, playlistUm.getDuracao());
			playlistUm.adicionaMusica(kids);
			assertEquals(8, playlistUm.getDuracao());
			playlistUm.adicionaMusica(timeToPretend);
			assertEquals(12, playlistUm.getDuracao());
			playlistUm.removeMusica(timeToPretend);
			assertEquals(8, playlistUm.getDuracao());
			playlistUm.removeMusica(isThisIt);
			assertEquals(4, playlistUm.getDuracao());
			playlistUm.removeMusica(kids);
			assertEquals(0, playlistUm.getDuracao());
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
	@Test
	public void testEquals(){
		try{
			Playlist playlistDois,playlistTres;
			playlistDois = new Playlist();
			playlistTres = new Playlist();
			assertEquals(playlistDois, playlistTres);
			playlistDois.adicionaMusica(kids);
			playlistTres.adicionaMusica(isThisIt);
			assertNotEquals(playlistDois, playlistTres);
			playlistDois.adicionaMusica(isThisIt);
			playlistTres.adicionaMusica(kids);
			assertNotEquals(playlistDois, playlistTres); //Musicas iguais porem em ordem diferente
			playlistTres.removeMusica(isThisIt);
			playlistTres.adicionaMusica(isThisIt); 
			assertEquals(playlistDois, playlistTres); //Musicas iguais na mesma ordem
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
}