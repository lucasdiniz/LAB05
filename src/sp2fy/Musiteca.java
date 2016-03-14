package sp2fy;

import java.util.ArrayList;

public class Musiteca {
	
	private ArrayList<Album> albuns;
	private Playlist playlists;
	
	public Musiteca(){
		albuns = new ArrayList<Album>();
		playlists = new Playlist();
	}
	
	public boolean adicionaAlbum(Album albumParaAdicionar) throws Exception{
		
		if(albumParaAdicionar == null){
			throw new Exception("Album a ser adicionado nao pode ser nulo.");
		}
		
		if(albuns.contains(albumParaAdicionar)){
			throw new Exception("Album ja contido na colecao.");
		}
		
		return albuns.add(albumParaAdicionar);
	
	}
	
	public boolean removeAlbum(Album albumParaRemover) throws Exception{
		
		if(albumParaRemover == null){
			throw new Exception("Album a ser removido nao pode ser nulo.");
		}
		
		if(!albuns.contains(albumParaRemover)){
			throw new Exception("Impossivel remover album nao contido na colecao.");
		}

		return albuns.remove(albumParaRemover);
	}
	
	public boolean existeAlbum(Album albumParaPesquisar) throws Exception{
		if(albumParaPesquisar == null){
			throw new Exception("Album a ser pesquisado nao pode ser nulo.");
		}
		return albuns.contains(albumParaPesquisar);
	}
	
	private int getIndiceAlbum(String nomeAlbum){
		for(int i = 0 ; i < albuns.size() ; i++){
			if(albuns.get(i).getTitulo().equals(nomeAlbum)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception{
		
		if(nomePlaylist == null || nomeAlbum == null || nomePlaylist.trim().equals("") || nomeAlbum.trim().equals("")){
			throw new Exception("Nome da playlist e nome do album nao podem ser vazios ou null.");
		}
		
		if(faixa <= 0){
			throw new Exception("Numero da faixa deve ser positivo");
		}
		
		int indice = getIndiceAlbum(nomeAlbum);
		
		if(indice == -1){
			throw new Exception("Album nao pertence ao Perfil especificado");
		}
		
		Musica musica = albuns.get(indice).getMusicaNaFaixa(faixa);
		return playlists.adiciona(nomePlaylist, musica);
	}
	
	public boolean removeMusicaDaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		if(nomePlaylist == null || musica == null){
			throw new Exception("Nome da playlist e a musica nao podem ser null.");
		}
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pdoe ser vazio.");
		}

		return playlists.remove(nomePlaylist, musica);
	}
	
	public boolean removeMusicaDaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		
		if(nomePlaylist == null || nomeMusica == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao devem ser vazios ou null.");
		}
		
		playlists.removePeloNome(nomePlaylist, nomeMusica);
		
		return true;
	}
	
	public boolean pesquisaMusicaNaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		
		if(nomePlaylist == null || musica == null){
			throw new Exception("Nome da playlist e a musica nao podem ser null.");
		}
		
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pdoe ser vazio.");
		}
		
		return playlists.existeMusica(nomePlaylist, musica);
	}
	
	public boolean pesquisaMusicaNaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		
		if(nomePlaylist == null || nomeMusica == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao devem ser vazios ou null.");
		}
		return playlists.existeMusicaPeloNome(nomePlaylist, nomeMusica);
	}
	
	public ArrayList<Album> getAlbunsFavoritos(){
		
		ArrayList<Album> favoritos = new ArrayList<Album>();
		
		for(Album alb : albuns){
			if(alb.isFavorito()){
				favoritos.add(alb);
			}
		}
		
		return favoritos;
	}

	
}
