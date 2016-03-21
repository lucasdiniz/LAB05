package sp2fy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Musiteca {
	
	private ArrayList<Album> albuns;
	private HashMap<String, Playlist> playlists;

	
	public Musiteca(){
		albuns = new ArrayList<Album>();
		playlists = new HashMap<String, Playlist>();
	}
	
	public boolean adicionaAlbum(Album albumParaAdicionar) throws Exception{
		
		if(albumParaAdicionar == null){
			throw new Exception("Album a ser adicionado nao pode ser nulo.");
		}
		
		if(albuns.contains(albumParaAdicionar)){
			return false;
		}
		
		return albuns.add(albumParaAdicionar);
	
	}
	
	public boolean adicionaMusicaNoAlbum(Musica musicaParaAdicionar , String nomeAlbum) throws Exception{
		
		if(musicaParaAdicionar == null || nomeAlbum == null){
			throw new Exception("Musica e nome do album nao podem ser null.");
		}
		
		if(nomeAlbum.trim().equals("")){
			throw new Exception("Nome do album nao podem ser vazio.");
		}
		
		int indiceDoAlbum = getIndiceAlbum(nomeAlbum);
		
		if(indiceDoAlbum == -1){
			throw new Exception("Album inexistente.");
		}
		
		Album albumDoUsuario = albuns.get(indiceDoAlbum);
		boolean foiAdicionado = albumDoUsuario.adicionaMusica(musicaParaAdicionar);
		albuns.add(indiceDoAlbum, albumDoUsuario);
		
		return foiAdicionado;
	}
	
	public boolean removeMusicaNoAlbum(Musica musicaParaRemover , String nomeAlbum) throws Exception{
		
		if(musicaParaRemover == null || nomeAlbum == null){
			throw new Exception("Musica e nome do album nao podem ser null.");
		}
		
		if(nomeAlbum.trim().equals("")){
			throw new Exception("Nome do album nao podem ser vazio.");
		}
		
		int indiceDoAlbum = getIndiceAlbum(nomeAlbum);
		
		if(indiceDoAlbum == -1){
			throw new Exception("Album inexistente.");
		}
		
		Album albumDoUsuario = albuns.get(indiceDoAlbum);
		boolean foiRemovido = albumDoUsuario.removeMusica(musicaParaRemover.getTitulo());
		albuns.add(indiceDoAlbum, albumDoUsuario);
		
		return foiRemovido;
	}
	
	
	public boolean pesquisaMusica(Musica musicaParaPesquisar) throws Exception{
		
		if(musicaParaPesquisar == null){
			throw new Exception("Musica nao pode ser nula.");
		}
		
		for(Album album : albuns){
			if(album.existeMusica(musicaParaPesquisar.getTitulo())){
				return true;
			}
		}
		return false;
	}
	
	public boolean removeMusicaNoAlbumPeloNome(String nomeMusica , String nomeAlbum) throws Exception{
		
		if(nomeMusica == null || nomeAlbum == null || nomeAlbum.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da musica e nome do album nao podem ser null.");
		}
		
		
		int indiceDoAlbum = getIndiceAlbum(nomeAlbum);
		
		if(indiceDoAlbum == -1){
			throw new Exception("Album inexistente.");
		}
		
		Album albumDoUsuario = albuns.get(indiceDoAlbum);
		boolean foiRemovido = albumDoUsuario.removeMusica(nomeMusica);
		albuns.add(indiceDoAlbum, albumDoUsuario);
		
		return foiRemovido;
	}
	
	public boolean pesquisaMusicaPeloNome(String nomeMusica) throws Exception{
		
		if(nomeMusica == null || nomeMusica.trim().equals("")){
			throw new Exception("Nome da musica nao pode ser nulo ou vazio.");
		}
		
		for(Album album : albuns){
			if(album.existeMusica(nomeMusica)){
				return true;
			}
		}
		return false;
	}
	
	public boolean removeAlbum(Album albumParaRemover) throws Exception{
		
		if(albumParaRemover == null){
			throw new Exception("Album a ser removido nao pode ser nulo.");
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
			if(albuns.get(i).getTitulo().equalsIgnoreCase(nomeAlbum)){
				return i;
			}
		}
		return -1;
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
	
	public ArrayList<Album> getAlbuns(){
		return this.albuns;
	}
	
	public int getDuracaoPlaylist(String nomePlaylist) throws Exception{
		if(nomePlaylist == null || nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio ou null.");
		}
		if(!playlists.containsKey(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		return playlists.get(nomePlaylist).getDuracao();
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
		
		if(!existePlaylist(nomePlaylist)){
			playlists.put(nomePlaylist , new Playlist());
		}
		
		Playlist playlistDoUsuario = playlists.get(nomePlaylist);
		/*Lanca excecao quando o numero da faixa eh maior que o tamanho do album*/
		Musica musicaParaAdicionar = albuns.get(indice).getMusicaNaFaixa(faixa);
		/*---------------------------------------------------------------------*/
		boolean foiAdicionado = playlistDoUsuario.adicionaMusica(musicaParaAdicionar);
		playlists.put(nomePlaylist, playlistDoUsuario);
		
		return foiAdicionado;
	}
	
	public boolean removeMusicaDaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		if(nomePlaylist == null || musica == null){
			throw new Exception("Nome da playlist e a musica nao podem ser null.");
		}
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio.");
		}
		
		if(!playlists.containsKey(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}

		Playlist playlistDoUsuario = playlists.get(nomePlaylist);
		boolean foiRemovido = playlistDoUsuario.removeMusica(musica);
		playlists.put(nomePlaylist, playlistDoUsuario);
		return foiRemovido;
	}
	
	public boolean removeMusicaDaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		
		if(nomePlaylist == null || nomeMusica == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao devem ser vazios ou null.");
		}
		
		if(!playlists.containsKey(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		
		Playlist playlistDoUsuario = playlists.get(nomePlaylist);
		boolean foiRemovido = playlistDoUsuario.removeMusicaPeloNome(nomeMusica);
		playlists.put(nomePlaylist, playlistDoUsuario);
		
		return foiRemovido;
	}
	
	public boolean pesquisaMusicaNaPlaylist(String nomePlaylist,Musica musica) throws Exception{
		
		if(nomePlaylist == null || musica == null){
			throw new Exception("Nome da playlist e a musica nao podem ser null.");
		}
		
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio.");
		}
		
		if(!playlists.containsKey(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		
		Playlist playlistDoUsuario = playlists.get(nomePlaylist);
		return playlistDoUsuario.contemMusica(musica);
	}
	
	public boolean pesquisaMusicaNaPlaylistPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		
		if(nomePlaylist == null || nomeMusica == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao devem ser vazios ou null.");
		}
		
		if(!playlists.containsKey(nomePlaylist)){
			throw new Exception("Playlist inexistente.");
		}
		
		Playlist playlistDoUsuario = playlists.get(nomePlaylist);
		return playlistDoUsuario.contemMusicaPeloNome(nomeMusica);
	}
	
	public boolean existePlaylist(String nomePlaylist){
		return playlists.containsKey(nomePlaylist);
	}
	
	public HashMap<String, Playlist> getPlaylists(){
		return this.playlists;
	}
	
	public ArrayList<Album> sortedAlbuns(){
		ArrayList<Album> albunsOrdenados = this.albuns;
		Collections.sort(albunsOrdenados); //Usa o compareTo padrao da classe album
		return albunsOrdenados;
	}
	
	public ArrayList<Album> sortedAlbunsPorArtista(){
		ArrayList<Album> albunsOrdenados = this.albuns;
		
		Comparator <Album> porArtista = new Comparator <Album>(){
			public int compare(Album um,Album dois){
				return um.getArtista().compareTo(dois.getArtista());
			}
		};
		
		Collections.sort(albunsOrdenados,porArtista);
		return albunsOrdenados;
	}
	
	public ArrayList<Album> sortedAlbunsPorDuracao(){
		ArrayList<Album> albunsOrdenados = this.albuns;
		
		Comparator<Album> porDuracao = new Comparator <Album>(){
			public int compare(Album um,Album dois){
				return um.getDuracao() - dois.getDuracao();
			}
		};
		
		Collections.sort(albunsOrdenados,porDuracao);
		return albunsOrdenados;
	}
	
	public ArrayList<Album> sortedAlbunsPorQuantidadeDeMusicas(){
		ArrayList<Album> albunsOrdenados = this.albuns;
		
		Comparator<Album> porQuantidadeDeMusicas = new Comparator <Album>(){
			public int compare(Album um,Album dois){
				return um.getTamanho() - dois.getTamanho();
			}
		};
		
		Collections.sort(albunsOrdenados,porQuantidadeDeMusicas);
		return albunsOrdenados;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albuns == null) ? 0 : albuns.hashCode());
		result = prime * result + ((playlists == null) ? 0 : playlists.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Musiteca){
			Musiteca outraMusiteca = (Musiteca) obj;
			return this.albuns.equals(outraMusiteca.getAlbuns()) && this.playlists.equals(outraMusiteca.getPlaylists());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Musiteca [albuns=" + albuns + ", playlists=" + playlists + "]";
	}
	
}
