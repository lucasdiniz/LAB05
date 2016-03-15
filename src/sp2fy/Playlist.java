package sp2fy;

import java.util.ArrayList;

public class Playlist {

	private ArrayList<Musica> playlist;
	
	public Playlist(){
		playlist = new ArrayList<Musica>();
	}
	
	private int getIndicePeloNome(String nomeMusica){
		for(int i = 0 ; i < playlist.size(); i++){
			if(playlist.get(i).getTitulo().equalsIgnoreCase(nomeMusica)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean adicionaMusica(Musica musicaParaAdicionar) throws Exception{
		
		if(musicaParaAdicionar == null){
			throw new Exception("Musica a ser adicionada nao pode ser null.");
		}
		
		if(playlist.contains(musicaParaAdicionar)){
			return false;
		}
		return playlist.add(musicaParaAdicionar);
	}
	
	public boolean removeMusica(Musica musicaParaRemover)throws Exception{
		if(musicaParaRemover == null){
			throw new Exception("Musica a ser removida nao pode ser null.");
		}
		return playlist.remove(musicaParaRemover);
	}
	
	public boolean removeMusicaPeloNome(String nomeMusica) throws Exception{
		if(nomeMusica == null || nomeMusica.trim().equals("")){
			throw new Exception("Nome da musica a ser removida nao pode ser vazio ou nulo.");
		}
		int indice = getIndicePeloNome(nomeMusica);
		if(indice == -1){
			return false;
		}
		playlist.remove(indice);
		return true;
	}
	
	public boolean contemMusica(Musica musicaParaBuscar) throws Exception{
		if(musicaParaBuscar == null){
			throw new Exception("Musica a ser buscada nao pode ser null.");
		}
		return playlist.contains(musicaParaBuscar);
	}
	
	public boolean contemMusicaPeloNome(String nomeMusica) throws Exception{
		
		if(nomeMusica == null || nomeMusica.trim().equals("")){
			throw new Exception("Nome da musica a ser buscada nao pode ser vaziou ou null.");
		}
		
		return getIndicePeloNome(nomeMusica) != -1;
	}
	
	public int getDuracao(){
		int duracao = 0;
		for(Musica musica : playlist){
			duracao += musica.getDuracao();
		}
		return duracao;
	}
	
	public ArrayList<Musica> getMusicas(){
		return this.playlist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Playlist){
			Playlist outraPlaylist = (Playlist) obj;
			return this.playlist.equals(outraPlaylist.getMusicas());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Playlist [playlist=" + playlist + "]";
	}
	
}
