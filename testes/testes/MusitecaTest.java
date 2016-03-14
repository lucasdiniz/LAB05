package testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class MusitecaTest {

	@Test
	public void testConstrutor() {
		
		try{
			Musiteca correto = new Musiteca();
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
	public void testAdicionaAlbum() {
		
		try{
			Musiteca musiteca = new Musiteca();
			musiteca.adcionaAlbum(new Album("Revolver","The Beatles",1966));
			
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			Musiteca musiteca = new Musiteca();
			musiteca.adcionaAlbum(null);
			
		} catch(Exception ex){
			assertEquals("Album nao pode ser null.", ex.getMessage());
		}
	}

}
