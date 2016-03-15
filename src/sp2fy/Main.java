package sp2fy;

public class Main {

	public static void main(String[] args) {
		Usuario usuarioUm = new Usuario();
		
		try{
			Album abbey = new Album("abbey road", "beatles", 1969);
			abbey.adicionaMusica(new Musica("come together", 4, "rock"));
			abbey.adicionaMusica(new Musica("octopus garden", 4, "rock"));
			abbey.adicionaMusica(new Musica("maxwells silver hammer", 4, "rock"));
			abbey.adicionaMusica(new Musica("something", 4, "rock"));
			
			System.out.println(usuarioUm.adicionaAlbum(abbey));
			System.out.println(usuarioUm.adicionaPlaylist("beatles", "abbey road", 1));
			System.out.println(usuarioUm.adicionaPlaylist("beatles", "abbey road", 2));
			System.out.println(usuarioUm.adicionaPlaylist("beatles", "abbey road", 3));
			System.out.println(usuarioUm.adicionaPlaylist("beatles", "abbey road", 4));

			System.out.println(usuarioUm.duracaoPlaylist("beatles"));
			System.out.println(usuarioUm.existeAlbum(abbey));

			System.out.println(usuarioUm.removeDaPlaylistPeloNome("beatles", "something"));
			System.out.println(usuarioUm.removeDaPlaylistPeloNome("beatles", "something"));
			
		}catch(Exception ex){
			System.out.println("Nao deveria lancar excecao.");
		}
		
	}

}
