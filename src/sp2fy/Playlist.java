package sp2fy;

import java.util.ArrayList;

public class Playlist {

	private ArrayList<Musica> musicas;
	
	public Playlist(){
		musicas = new ArrayList<Musica>();
	}
	
	private int getIndicePeloNome(String nomeMusica){
		for(int i = 0 ; i < musicas.size(); i++){
			if(musicas.get(i).getTitulo().equalsIgnoreCase(nomeMusica)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean adicionaMusica(Musica musicaParaAdicionar) throws Exception{
		
		if(musicaParaAdicionar == null){
			throw new Exception("Musica a ser adicionada nao pode ser null.");
		}
		
		if(musicas.contains(musicaParaAdicionar)){
			return false;
		}
		return musicas.add(musicaParaAdicionar);
	}
	
	public boolean removeMusica(Musica musicaParaRemover)throws Exception{
		if(musicaParaRemover == null){
			throw new Exception("Musica a ser removida nao pode ser null.");
		}
		return musicas.remove(musicaParaRemover);
	}
	
	public boolean removeMusicaPeloNome(String nomeMusica) throws Exception{
		if(nomeMusica == null || nomeMusica.trim().equals("")){
			throw new Exception("Nome da musica a ser removida nao pode ser vazio ou nulo.");
		}
		int indice = getIndicePeloNome(nomeMusica);
		if(indice == -1){
			return false;
		}
		musicas.remove(indice);
		return true;
	}
	
	public boolean contemMusica(Musica musicaParaBuscar) throws Exception{
		if(musicaParaBuscar == null){
			throw new Exception("Musica a ser buscada nao pode ser null.");
		}
		return musicas.contains(musicaParaBuscar);
	}
	
	public boolean contemMusicaPeloNome(String nomeMusica) throws Exception{
		
		if(nomeMusica == null || nomeMusica.trim().equals("")){
			throw new Exception("Nome da musica a ser buscada nao pode ser vaziou ou null.");
		}
		
		return getIndicePeloNome(nomeMusica) != -1;
	}
	
	public int getDuracao(){
		int duracao = 0;
		for(Musica musica : musicas){
			duracao += musica.getDuracao();
		}
		return duracao;
	}
	
	public ArrayList<Musica> getMusicas(){
		return this.musicas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musicas == null) ? 0 : musicas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Playlist){
			Playlist outraPlaylist = (Playlist) obj;
			return this.musicas.equals(outraPlaylist.getMusicas());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Playlist [playlist=" + musicas + "]";
	}
	
}
