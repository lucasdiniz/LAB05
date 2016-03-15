package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sp2fy.*;

public class MusitecaTest {
	
	private Musiteca musiteca;

	@Before
	public void testConstrutor() {
		try{
			musiteca = new Musiteca();
			musiteca.adicionaAlbum(new Album("Abbey Road", "The Beatles", 1969));
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
	@Test
	public void testAdicionaAlbum() {
		
		try{
			assertEquals(true,musiteca.adicionaAlbum(new Album("Revolver","The Beatles",1969)));
			
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			assertNotEquals(true,musiteca.adicionaAlbum(new Album("Revolver","The Beatles",1966)));
			assertNotEquals(true,musiteca.adicionaAlbum(new Album("Revolver","The Beatles",1998)));
			
		} catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		
		try{
			musiteca.adicionaAlbum(null);
			
		} catch(Exception ex){
			assertEquals("Album a ser adicionado nao pode ser nulo.", ex.getMessage());
		}
		
	}

	@Test
	public void testRemoveAlbum(){
		try{
			assertNotEquals(true,musiteca.removeAlbum(new Album("Revolver","The Beatles",1966)));
			assertEquals(true,musiteca.removeAlbum(new Album("Abbey Road","The Beatles",1969)));
			assertNotEquals(true,musiteca.removeAlbum(new Album("album inexistente","nao existe",2016)));
			
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
	}
	
}
