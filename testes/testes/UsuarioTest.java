package testes;

import static org.junit.Assert.*;
import org.junit.Test;
import sp2fy.*;

public class UsuarioTest {

	@Test
	public void testConstrutor(){
		
		try{
			Usuario usuarioUm = new Usuario("Joao");
			Usuario usuarioDois = new Usuario("Pedro");
			Usuario usuarioTres = new Usuario("Xico");
		}catch(Exception ex){
			fail("Nao deveria lancar excecao.");
		}
		

		try{
			Usuario usuarioUm = new Usuario("  ");
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		}
		
		try{
			Usuario usuarioUm = new Usuario(null);
			fail("Nao deveria chegar aqui.");
		}catch(Exception ex){
			assertEquals("Nome do usuario nao pode ser vazio ou nulo.", ex.getMessage());
		}
		
	}

}
