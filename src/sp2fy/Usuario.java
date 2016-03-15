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
	
	public boolean existeAlbum(Album album) throws Exception{
		return biblioteca.existeAlbum(album);
	}
	
	public ArrayList<Album> getAlbunsFavoritos(){
		return biblioteca.getAlbunsFavoritos();
	}
	
	public ArrayList<Album> getAlbuns(){
		return biblioteca.getAlbuns();
	}
	
	public ArrayList<Album> getFavoritos(Album album){
		return biblioteca.getAlbunsFavoritos();
	}
	
	public int duracaoPlaylist(String nomePlaylist) throws Exception{
		return biblioteca.getDuracaoPlaylist(nomePlaylist);
	}
	
	public boolean adicionaPlaylist(String nomePlaylist,String nomeAlbum,int faixa) throws Exception{
		return biblioteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);
	}
	
	public boolean removeDaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		return biblioteca.removeMusicaDaPlaylist(nomePlaylist, musica);
	}
	
	public boolean removeDaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		return biblioteca.removeMusicaDaPlaylistPeloNome(nomePlaylist, nomeMusica);
	}
	
	public boolean pesquisaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		return biblioteca.pesquisaMusicaNaPlaylist(nomePlaylist, musica);
	}
	
	public boolean pesquisaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		return biblioteca.pesquisaMusicaNaPlaylistPeloNome(nomePlaylist, nomeMusica);
	}
	
	public Musiteca getMusiteca(){
		return this.biblioteca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((biblioteca == null) ? 0 : biblioteca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Usuario){
			Usuario outroUsuario = (Usuario) obj;
			return this.biblioteca.equals(outroUsuario.getMusiteca());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Usuario [biblioteca=" + biblioteca + "]";
	}
	
}
