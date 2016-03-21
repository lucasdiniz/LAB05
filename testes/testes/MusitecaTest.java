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
			fail("Nao deveria chegar aqui.");
			
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Album inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(null, "album inexistente");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(something, null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaMusicaNoAlbum(something, "  ");
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Album inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(null, "album inexistente");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(something, null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbum(something, "  ");
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Album inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome(null, "abbey road");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome("something", null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da musica e nome do album nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaNoAlbumPeloNome("something", "  ");
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da musica nao pode ser nulo ou vazio.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaPeloNome(" ");
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
			
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
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.getDuracaoPlaylist(" ");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.getDuracaoPlaylist(null);
			fail("Nao deveria chegar aqui.");
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
			theBeatles.adicionaPlaylist("coletanea", "Revolver", 1);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Album nao pertence ao Perfil especificado", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey Road", 100);
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylist(" ", something);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylist(null, something);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da playlist e a musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey Road", 1);
			theBeatles.removeMusicaDaPlaylist("coletanea", null);
			fail("Nao deveria chegar aqui.");
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
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylistPeloNome(" ", "something");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.removeMusicaDaPlaylistPeloNome(null, "something");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey Road", 1);
			theBeatles.removeMusicaDaPlaylistPeloNome("coletanea", null);
			fail("Nao deveria chegar aqui.");
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
			theBeatles.pesquisaMusicaNaPlaylist("inexistente", comeTogether);
			fail("Nao deveria chegar aqui.");
			
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylist(" ", comeTogether);
			fail("Nao deveria chegar aqui.");
			
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylist(null, comeTogether);
			fail("Nao deveria chegar aqui.");
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e a musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			theBeatles.pesquisaMusicaNaPlaylist("coletanea", null);
			fail("Nao deveria chegar aqui.");
			
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
			theBeatles.pesquisaMusicaNaPlaylistPeloNome("inexistente", "come together");
			fail("Nao deveria chegar aqui.");
			
		}catch(Exception ex){
			assertEquals("Playlist inexistente.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylistPeloNome(" ", "come together");
			fail("Nao deveria chegar aqui.");
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.pesquisaMusicaNaPlaylistPeloNome(null, "come together");
			fail("Nao deveria chegar aqui.");
			
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao devem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			theBeatles.adicionaPlaylist("coletanea", "Abbey road", 1);
			theBeatles.pesquisaMusicaNaPlaylistPeloNome("coletanea", null);
			fail("Nao deveria chegar aqui.");
			
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
	
	@Test
	public void testSortedAlbuns(){
		try{
			Album primeiro = new Album("a", "a", 2000);
			Album segundo = new Album("b", "b", 2001);
			Album terceiro = new Album("c", "c", 2002);
			Musiteca musitecaTeste = new Musiteca();
			
			musitecaTeste.adicionaAlbum(primeiro);
			musitecaTeste.adicionaAlbum(segundo);
			musitecaTeste.adicionaAlbum(terceiro);
			
			ArrayList<Album> ordenadoPeloAno = musitecaTeste.sortedAlbuns();
			assertEquals(ordenadoPeloAno.get(0),primeiro);
			assertEquals(ordenadoPeloAno.get(1),segundo);
			assertEquals(ordenadoPeloAno.get(2),terceiro);
					
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
	@Test
	public void testSortedAlbunsPorArtista(){
		try{
			Album primeiro = new Album("a", "a", 2000);
			Album segundo = new Album("b", "b", 2001);
			Album terceiro = new Album("c", "c", 2002);
			Musiteca musitecaTeste = new Musiteca();
			
			musitecaTeste.adicionaAlbum(primeiro);
			musitecaTeste.adicionaAlbum(segundo);
			musitecaTeste.adicionaAlbum(terceiro);
			
			ArrayList<Album> ordenadoPorArtista = musitecaTeste.sortedAlbunsPorArtista();
			assertEquals(ordenadoPorArtista.get(0),primeiro);
			assertEquals(ordenadoPorArtista.get(1),segundo);
			assertEquals(ordenadoPorArtista.get(2),terceiro);
					
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
	@Test
	public void testSortedAlbunsPorDuracao(){
		try{
			Album primeiro = new Album("a", "a", 2000);
			primeiro.adicionaMusica(new Musica("A", 5, "rock"));
			
			Album segundo = new Album("b", "b", 2001);
			segundo.adicionaMusica(new Musica("B", 10, "rock"));
			
			Album terceiro = new Album("c", "c", 2002);
			terceiro.adicionaMusica(new Musica("A", 15, "rock"));
			
			Musiteca musitecaTeste = new Musiteca();
			
			musitecaTeste.adicionaAlbum(primeiro);
			musitecaTeste.adicionaAlbum(segundo);
			musitecaTeste.adicionaAlbum(terceiro);
			
			ArrayList<Album> ordenadoPorDuracao = musitecaTeste.sortedAlbunsPorDuracao();
			assertEquals(ordenadoPorDuracao.get(0),primeiro);
			assertEquals(ordenadoPorDuracao.get(1),segundo);
			assertEquals(ordenadoPorDuracao.get(2),terceiro);
					
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
	@Test
	public void testSortedAlbunsPorQuantidadeDeMusicas(){
		try{
			Album primeiro = new Album("a", "a", 2000);
			primeiro.adicionaMusica(new Musica("A", 5, "rock"));
			
			Album segundo = new Album("b", "b", 2001);
			segundo.adicionaMusica(new Musica("A", 5, "rock"));
			segundo.adicionaMusica(new Musica("B", 5, "rock"));
			
			Album terceiro = new Album("c", "c", 2002);
			terceiro.adicionaMusica(new Musica("A", 5, "rock"));
			terceiro.adicionaMusica(new Musica("B", 5, "rock"));
			terceiro.adicionaMusica(new Musica("C", 5, "rock"));
			
			Musiteca musitecaTeste = new Musiteca();
			
			musitecaTeste.adicionaAlbum(primeiro);
			musitecaTeste.adicionaAlbum(segundo);
			musitecaTeste.adicionaAlbum(terceiro);
			
			ArrayList<Album> ordenadoPeloAno = musitecaTeste.sortedAlbunsPorQuantidadeDeMusicas();
			assertEquals(ordenadoPeloAno.get(0),primeiro);
			assertEquals(ordenadoPeloAno.get(1),segundo);
			assertEquals(ordenadoPeloAno.get(2),terceiro);
					
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
	}
	
}
