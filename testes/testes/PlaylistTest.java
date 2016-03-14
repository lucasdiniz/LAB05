package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import sp2fy.Musica;
import sp2fy.Playlist;


public class PlaylistTest {
	
	private Playlist playlistUm;

	@Before
	public void criaPlaylists(){
		playlistUm = new Playlist();
		try{
			playlistUm.adiciona("rock", new Musica("hangar 18", 4, "rock"));
			playlistUm.adiciona("rock", new Musica("Last Night", 4, "rock"));
			playlistUm.adiciona("forro", new Musica("meu carro virou motel", 4, "forro"));
			playlistUm.adiciona("axe", new Musica("berimbau metalizado", 4, "axe"));
		}catch (Exception ex) {
			fail("Nao deveria lancar excecao");
		}
		
	}
	
	@Test
	public void testExistePlaylist(){
		
		try{
			assertEquals(true,playlistUm.existePlaylist("forro"));
			assertEquals(true,playlistUm.existePlaylist("rock"));
			assertEquals(false,playlistUm.existePlaylist("swingueira"));
			assertEquals(false,playlistUm.existePlaylist("metal"));
			assertEquals(false,playlistUm.existePlaylist("musica classica"));
			assertEquals(true,playlistUm.existePlaylist("axe"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.existePlaylist(" ");
		} catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio ou null.", ex.getMessage());
		}
		
		try{
			playlistUm.existePlaylist(null);
		} catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio ou null.", ex.getMessage());
		}
		
	}

	@Test
	public void testAdicionaMusica(){
		try{
			assertEquals(false,playlistUm.existeMusicaPeloNome("rock", "Wouldnt it be nice"));
			playlistUm.adiciona("rock", new Musica("Wouldnt it be nice", 4, "rock"));
			assertEquals(true,playlistUm.existeMusicaPeloNome("rock", "Wouldnt it be nice"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.adiciona("rock", new Musica("hangar 18", 4, "rock"));
		}catch(Exception ex){
			assertEquals("Musica ja esta na playlist.", ex.getMessage());
		}
		
		try{
			playlistUm.adiciona("", new Musica("Wouldnt it be nice", 4, "rock"));
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			playlistUm.adiciona(null, new Musica("Wouldnt it be nice", 4, "rock"));
		}catch(Exception ex){
			assertEquals("Nome da playlist e musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			playlistUm.adiciona("rock",null);
		}catch(Exception ex){
			assertEquals("Nome da playlist e musica nao podem ser null.", ex.getMessage());
		}
		
	}

	@Test
	public void testRemovePeloNome(){
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome("rock", "hangar 18"));
			assertEquals(true,playlistUm.existeMusicaPeloNome("rock", "Last Night"));
			assertEquals(true,playlistUm.existeMusicaPeloNome("forro", "meu carro virou motel"));
			assertEquals(true,playlistUm.existeMusicaPeloNome("axe", "berimbau metalizado"));
			playlistUm.removePeloNome("rock", "hangar 18");
			playlistUm.removePeloNome("rock", "Last Night");
			playlistUm.removePeloNome("forro", "meu carro virou motel");
			playlistUm.removePeloNome("axe", "berimbau metalizado");
			assertEquals(false,playlistUm.existeMusicaPeloNome("rock", "hangar 18"));
			assertEquals(false,playlistUm.existeMusicaPeloNome("rock", "Last Night"));
			assertEquals(false,playlistUm.existeMusicaPeloNome("forro", "meu carro virou motel"));
			assertEquals(false,playlistUm.existeMusicaPeloNome("axe", "berimbau metalizado"));
		}catch(Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.removePeloNome("rock", "Beat it");
		}catch(Exception ex){
			assertEquals("Impossivel remover musica nao contida na playlist.", ex.getMessage());
		}
		
		try{
			playlistUm.removePeloNome("musica sul-africana", "tambores da africa");
		}catch(Exception ex){
			assertEquals("Impossivel remover, playlist inexistente.", ex.getMessage());
		}
		
		try{
			playlistUm.removePeloNome("", "tambores da africa");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			playlistUm.removePeloNome("rock", "");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			playlistUm.removePeloNome("rock", null);
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazios ou null.", ex.getMessage());
		}
		
		try{
			playlistUm.removePeloNome(null, "tambores");
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazios ou null.", ex.getMessage());
		}
		
	}
	
	@Test
	public void testRemove(){
		try{
			assertEquals(true,playlistUm.existeMusica("rock", new Musica("hangar 18", 4, "rock")));
			assertEquals(true,playlistUm.existeMusica("rock", new Musica("Last Night", 4, "rock")));
			assertEquals(true,playlistUm.existeMusica("forro", new Musica("meu carro virou motel", 4, "forro")));
			assertEquals(true,playlistUm.existeMusica("axe", new Musica("berimbau metalizado", 4, "axe")));
			playlistUm.remove("rock", new Musica("hangar 18", 4, "rock"));
			playlistUm.remove("rock", new Musica("Last Night", 4, "rock"));
			playlistUm.remove("forro", new Musica("meu carro virou motel", 4, "forro"));
			playlistUm.remove("axe", new Musica("berimbau metalizado", 4, "axe"));
			assertEquals(false,playlistUm.existeMusica("rock", new Musica("hangar 18", 4, "rock")));
			assertEquals(false,playlistUm.existeMusica("rock", new Musica("Last Night", 4, "rock")));
			assertEquals(false,playlistUm.existeMusica("forro", new Musica("meu carro virou motel", 4, "forro")));
			assertEquals(false,playlistUm.existeMusica("axe", new Musica("berimbau metalizado", 4, "axe")));
		}catch(Exception e){
			fail("Nao deveria lancar excecao");
		}
		
		try{
			playlistUm.remove("rock", new Musica("beat it", 4, "Pop"));
		}catch(Exception ex){
			assertEquals("Impossivel remover musica nao contida na playlist.", ex.getMessage());
		}
		
		try{
			playlistUm.remove("musica sul-africana",new Musica("tambores da africa",4,"outro"));
		}catch(Exception ex){
			assertEquals("Impossivel remover, playlist inexistente.", ex.getMessage());
		}
		
		try{
			playlistUm.remove("", new Musica("tambores da africa",4,"outro"));
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			playlistUm.remove("rock", null);
		}catch(Exception ex){
			assertEquals("Nome da playlist e musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			playlistUm.remove(null, new Musica("tambores da africa",4,"outro"));
		}catch(Exception ex){
			assertEquals("Nome da playlist e musica nao podem ser null.", ex.getMessage());
		}
		
		
	}

	@Test
	public void testExisteMusica(){
		
		try{
			assertEquals(true,playlistUm.existeMusica("axe", new Musica("berimbau metalizado", 4, "axe")));
			assertEquals(true,playlistUm.existeMusica("rock", new Musica("hangar 18", 4, "rock")));
			assertEquals(true,playlistUm.existeMusica("rock", new Musica("Last Night", 4, "rock")));
			assertNotEquals(true, playlistUm.existeMusica("rock", new Musica("Hit the lights", 4, "heavy metal")));
			assertNotEquals(true, playlistUm.existeMusica("forro", new Musica("hangar 18", 4, "rock")));
			assertNotEquals(true,playlistUm.existeMusica("forro", new Musica("berimbau metalizado", 4, "axe")));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			assertEquals(true,playlistUm.existeMusica("jazz", new Musica("Highway Blues", 4, "jazz")));
		}catch(Exception ex){
			assertEquals("Impossivel pesquisar em playlist inexistente.", ex.getMessage());
		}
		
		
		try{
			assertEquals(true,playlistUm.existeMusica("", new Musica("Highway Blues", 4, "jazz")));
		}catch(Exception ex){
			assertEquals("Nome da playlist nao pode ser vazio.", ex.getMessage());
		}
		
		try{
			assertEquals(true,playlistUm.existeMusica(null, new Musica("Highway Blues", 4, "jazz")));
		}catch(Exception ex){
			assertEquals("Nome da playlist e musica nao podem ser null.", ex.getMessage());
		}
		
		try{
			assertEquals(true,playlistUm.existeMusica("jazz",null));
		}catch(Exception ex){
			assertEquals("Nome da playlist e musica nao podem ser null.", ex.getMessage());
		}
		
	}

	@Test
	public void testExisteMusicaPeloNome(){
		
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome("axe", "berimbau metalizado"));
			assertEquals(true,playlistUm.existeMusicaPeloNome("rock","hangar 18"));
			assertEquals(true,playlistUm.existeMusicaPeloNome("rock", "Last Night"));
			assertNotEquals(true, playlistUm.existeMusicaPeloNome("rock","Hit the lights"));
			assertNotEquals(true, playlistUm.existeMusicaPeloNome("forro","hangar 18"));
			assertNotEquals(true,playlistUm.existeMusicaPeloNome("forro", "berimbau metalizado"));
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome("jazz","Highway Blues"));
		}catch(Exception ex){
			assertEquals("Impossivel pesquisar em playlist inexistente.", ex.getMessage());
		}
		
		
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome("", "Highway Blues"));
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazious ou null.", ex.getMessage());
		}
		
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome(null, "Highway Blues"));
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazious ou null.", ex.getMessage());
		}
		
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome("jazz",null));
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazious ou null.", ex.getMessage());
		}
		
		try{
			assertEquals(true,playlistUm.existeMusicaPeloNome("jazz",""));
		}catch(Exception ex){
			assertEquals("Nome da playlist e nome da musica nao podem ser vazious ou null.", ex.getMessage());
		}
		
		
	}

}

