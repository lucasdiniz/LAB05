package sp2fy;

import java.util.ArrayList;

public class Usuario {

	private Musiteca biblioteca;
	
	
	public Usuario(){
		biblioteca = new Musiteca();
	}
	
	public boolean adicionaAlbum(Album album) throws Exception{
		return biblioteca.adicionaAlbum(album);
	}
	
	public boolean removeAlbum(Album album) throws Exception{
		return biblioteca.removeAlbum(album);
	}
	
	public boolean adicionaPlaylist(String nomePlaylist,String nomeAlbum,int faixa) throws Exception{
		return biblioteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);
	}
	
	public ArrayList<Album> getFavoritos(Album album){
		return biblioteca.getAlbunsFavoritos();
	}
	
	public boolean pesquisaAlbum(Album album) throws Exception{
		return biblioteca.existeAlbum(album);
	}
	
	public boolean pesquisaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		return biblioteca.pesquisaMusicaNaPlaylist(nomePlaylist, musica);
	}
	
	public boolean pesquisaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		return biblioteca.pesquisaMusicaNaPlaylistPeloNome(nomePlaylist, nomeMusica);
	}
	
	public boolean removeMusicaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		return biblioteca.removeMusicaDaPlaylist(nomePlaylist, musica);
	}
	
	public boolean removeMusicaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		return biblioteca.removeMusicaDaPlaylistPeloNome(nomePlaylist, nomeMusica);
	}
	
}
