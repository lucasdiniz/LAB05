package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import sp2fy.*;

public class MusitecaTest {
	
	private Musiteca theBeatles;
	private Album abbeyRoad;
	private Musica something,octopusGarden,comeTogether;

	@Before
	public void testConstrutor() {
		try{
			theBeatles = new Musiteca();
			abbeyRoad = new Album("Abbey Road", "The Beatles", 1969);
			comeTogether = new Musica("Come together", 4, "rock");
			something = new Musica("Something", 4, "rock");
			octopusGarden = new Musica("Octopus garden", 4, "rock");
			abbeyRoad.adicionaMusica(comeTogether);
			abbeyRoad.adicionaMusica(something);
			abbeyRoad.adicionaMusica(octopusGarden);
			theBeatles.adicionaAlbum(abbeyRoad);
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
	@Test
	public void testAdicionaAlbum() {
		
		try{
			assertEquals(true,theBeatles.adicionaAlbum(new Album("Revolver","The Beatles",1969)));
			
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			assertNotEquals(true,theBeatles.adicionaAlbum(new Album("Revolver","The Beatles",1966)));
			assertNotEquals(true,theBeatles.adicionaAlbum(new Album("Revolver","The Beatles",1998)));
			
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.adicionaAlbum(null);
			
		} catch(Exception ex){
			assertEquals("Album a ser adicionado nao pode ser nulo.", ex.getMessage());
		}
		
	}

	@Test
	public void testAdicionaMusicaNoAlbum(){
		
		try{
			Musica sunKing = new Musica("Sun king", 4, "rock");
			assertEquals(false,theBeatles.adicionaMusicaNoAlbum(something, "abbey road"));//Musica ja esta no album
			assertEquals(false,theBeatles.adicionaMusicaNoAlbum(comeTogether, "abbey road"));//Musica ja esta no album
			assertEquals(true,theBeatles.adicionaMusicaNoAlbum(sunKing, "abbey road"));//Musica nao esta no album
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(something, "album inexistente");
		}catch(Exception ex){
			assertEquals("Album inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(null, "album inexistente");
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(something, null);
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(something, "  ");
		}catch(Exception ex){
			assertEquals("Nome do album nao podem ser vazio.", ex.getMessage());
		}
	}

	@Test
	public void testRemoveMusicaNoAlbum(){
		try{
			Musica sunKing = new Musica("Sun king", 4, "rock");
			assertEquals(true, theBeatles.removeMusicaNoAlbum(something, "abbey road"));
			assertEquals(true, theBeatles.removeMusicaNoAlbum(comeTogether, "abbey road"));
			assertEquals(false, theBeatles.removeMusicaNoAlbum(sunKing, "abbey road")); //Musica nao esta no album
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(something, "album inexistente");
		}catch(Exception ex){
			assertEquals("Album inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(null, "album inexistente");
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(something, null);
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(something, "  ");
		}catch(Exception ex){
			assertEquals("Nome do album nao podem ser vazio.", ex.getMessage());
		}
	}

	@Test
	public void testPesquisaMusica(){
		
		try{
			Musica musicaInexistente = new Musica("nao existe", 4, "nao existe");
			assertEquals(true, theBeatles.pesquisaMusica(something));
			assertEquals(true, theBeatles.pesquisaMusica(comeTogether));
			assertEquals(false, theBeatles.pesquisaMusica(musicaInexistente));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.pesquisaMusica(null);
		}catch(Exception ex){
			assertEquals("Musica nao pode ser nula.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testRemoveMusicaNoAlbumPeloNome(){
		try{
			assertEquals(true, theBeatles.removeMusicaNoAlbumPeloNome("something", "abbey road"));
			assertEquals(true, theBeatles.removeMusicaNoAlbumPeloNome("come together", "abbey road"));
			assertEquals(false, theBeatles.removeMusicaNoAlbumPeloNome("sun king", "abbey road")); //Musica nao esta no album
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome("something", "album inexistente");
		}catch(Exception ex){
			assertEquals("Album inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome(null, "abbey road");
		}catch(Exception ex){
			assertEquals("Nome da musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome("something", null);
		}catch(Exception ex){
			assertEquals("Nome da musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome("something", "  ");
		}catch(Exception ex){
			assertEquals("Nome da musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testPesquisaMusicaPeloNome(){
		try{
			assertEquals(true, theBeatles.pesquisaMusicaPeloNome("something"));
			assertEquals(true, theBeatles.pesquisaMusicaPeloNome("come Together"));
			assertEquals(false, theBeatles.pesquisaMusicaPeloNome("musica Inexistente"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.pesquisaMusicaPeloNome(null);
		}catch(Exception ex){
			assertEquals("Nome da musica nao pode ser nulo ou vazio.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaPeloNome(" ");
		}catch(Exception ex){
			assertEquals("Nome da musica nao pode ser nulo ou vazio.", ex.getMessage());
		}
	}
	
	@Test
	public void testRemoveAlbum(){
		try{
			assertNotEquals(true,theBeatles.removeAlbum(new Album("album inexistente","nao existe",2016)));
			assertEquals(true,theBeatles.removeAlbum(new Album("Abbey Road","The Beatles",1969)));
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.removeAlbum(null);
			
		}catch(Exception ex){
			assertEquals("Album a ser removido nao pode ser nulo.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testExisteAlbum(){
		
		try{
			assertEquals(true, theBeatles.existeAlbum(new Album("Abbey Road", "The Beatles", 1969)));
			assertNotEquals(true, theBeatles.existeAlbum(new Album("nao existe", "inexistente", 2016)));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.existeAlbum(null);
		}catch(Exception ex){
			assertEquals("Album a ser pesquisado nao pode ser nulo.", ex.getMessage());
		}
		
		
	}
	
	@Test
	public void testGetAlbunsFavoritos(){
		try{
			Musiteca musiteca = new Musiteca();
			Album um = new Album("um", "um", 2016);
			Album dois = new Album("dois", "dois", 2016);
			Album tres = new Album("tres", "tres", 2016);
			Album quatro = new Album("quatro", "quatro", 2016);
			um.mudaStatusDeFavorito(); //Por default favorito = false. O metodo muda para true
			tres.mudaStatusDeFavorito();
			musiteca.adicionaAlbum(um);
			musiteca.adicionaAlbum(dois);
			musiteca.adicionaAlbum(tres);
			musiteca.adicionaAlbum(quatro);
			ArrayList<Album> favoritos = musiteca.getAlbunsFavoritos();
			assertEquals(2,favoritos.size());
			assertEquals(true, favoritos.contains(um));
			assertEquals(true, favoritos.contains(tres));
			assertNotEquals(true, favoritos.contains(dois));
			assertNotEquals(true, favoritos.contains(quatro));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
	@Test
	public void testGetDuracaoPlaylist(){
		try{
			theBeatles.getDuracaoPlaylist("nao existe");
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.getDuracaoPlaylist(" ");
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.getDuracaoPlaylist(null);
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			assertEquals(4,theBeatles.getDuracaoPlaylist("coletanea"));
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 2);
			assertEquals(8,theBeatles.getDuracaoPlaylist("coletanea"));
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 3);
			assertEquals(12,theBeatles.getDuracaoPlaylist("coletanea"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
	@Test
	public void testAdicionaPlaylist(){
		try{
			assertEquals(true,theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1));
			assertEquals(true,theBeatles.adicionaPlaylist("coletanea", "Abbey road", 2));
			assertEquals(true,theBeatles.adicionaPlaylist("coletanea", "Abbey road", 3));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "Something"));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "come together"));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "octopus garden"));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "musica inexistente"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			assertEquals(true,theBeatles.adicionaPlaylist("coletanea", "Revolver", 1));
		}catch(Exception ex){
			assertEquals("Album nao pertence ao Perfil especificado", ex.getMessage());
		}
		
		try{
			assertEquals(true,theBeatles.adicionaPlaylist("coletanea", "Abbey Road", 100));
		}catch(Exception ex){
			assertEquals("Numero da faixa maior que o total de musicas no album.", ex.getMessage());
			/*Excecao relancada da classe Album*/
		}
		
	}
	
	@Test
	public void testRemoveMusicaDaPlaylist(){
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 2);
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 3);
			
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", something));
			assertEquals(true, theBeatles.removeMusicaDaPlaylist("coletanea", something));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", something));
			
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", comeTogether));
			assertEquals(true, theBeatles.removeMusicaDaPlaylist("coletanea", comeTogether));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", comeTogether));
			
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", octopusGarden));
			assertEquals(true, theBeatles.removeMusicaDaPlaylist("coletanea", octopusGarden));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", octopusGarden));
			
			assertNotEquals(true, octopusGarden); //ja foi removido
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.removeMusicaDaPlaylist("inexistente", something);
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylist(" ", something);
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylist(null, something);
		}catch(Exception ex){
			assertEquals("Nome da playlist e a musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey Road", 1);
			theBeatles.removeMusicaDaPlaylist("coletanea", null);
		}catch(Exception ex){
			assertEquals("Nome da playlist e a musica nao podem ser null.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testRemoveMusicaDaPlaylistPeloNome(){
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 2);
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 3);
			
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", something));
			assertEquals(true, theBeatles.removeMusicaDaPlaylistPeloNome("coletanea", "something"));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", something));
			
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", comeTogether));
			assertEquals(true, theBeatles.removeMusicaDaPlaylistPeloNome("coletanea", "come together"));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", comeTogether));
			
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", octopusGarden));
			assertEquals(true, theBeatles.removeMusicaDaPlaylistPeloNome("coletanea", "octopus garden"));
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", octopusGarden));
			
			assertNotEquals(true, octopusGarden); //ja foi removido
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.removeMusicaDaPlaylistPeloNome("inexistente", "something");
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylistPeloNome(" ", "something");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylistPeloNome(null, "something");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey Road", 1);
			theBeatles.removeMusicaDaPlaylistPeloNome("coletanea", null);
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
	}

	@Test
	public void testPesquisaMusicaNaPlaylist(){
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", something));
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 2);
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 3);
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", something));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", octopusGarden));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylist("coletanea", comeTogether));
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylist("coletanea", comeTogether);
			
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylist(" ", comeTogether);
			
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylist(null, comeTogether);
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e a musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			theBeatles.pesquisaMusicaNaPlaylist("coletanea", null);
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e a musica nao podem ser null.", ex.getMessage());
		}
		
	}

	@Test
	public void testPesquisaMusicaNaPlaylistPeloNome(){
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			assertNotEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "something"));
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 2);
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 3);
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "something"));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "octopus garden"));
			assertEquals(true, theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "come together"));
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", "come together");
			
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylistPeloNome(" ", "come together");
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylistPeloNome(null, "come together");
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", null);
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
	}

	@Test
	public void testExistePlaylist(){
		try{
			assertNotEquals(true, theBeatles.existePlaylist("coletanea"));
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			assertEquals(true, theBeatles.existePlaylist("coletanea"));
			assertNotEquals(true, theBeatles.existePlaylist("playlist inexistente"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
	@Test
	public void testEquals(){
		try{
			Album albumUm = new Album("um", "um", 2016);
			albumUm.adicionaMusica(comeTogether);
			
			Musiteca musitecaUm = new Musiteca();
			Musiteca musitecaDois = new Musiteca();
			assertEquals(musitecaUm, musitecaDois);
			
			musitecaUm.adicionaAlbum(albumUm);
			assertNotEquals(musitecaUm, musitecaDois);
			
			musitecaDois.adicionaAlbum(albumUm);
			assertEquals(musitecaUm, musitecaDois);
			
			musitecaUm.adicionaPlaylist("playlist um", "um", 1);
			assertNotEquals(musitecaUm, musitecaDois);
			musitecaDois.adicionaPlaylist("playlist um", "um", 1);
			assertEquals(musitecaUm, musitecaDois);
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
}
