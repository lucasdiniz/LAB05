package sp2fy;

import java.util.ArrayList;
import java.util.HashMap;

public class Playlist {

	private HashMap<String, ArrayList<Musica>> playlists;
	
	public Playlist(){
		playlists = new HashMap<String, ArrayList<Musica>>();
	}
	
	public boolean existePlaylist(String nomeDaPlaylist)throws Exception{
		
		if(nomeDaPlaylist == null || nomeDaPlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio ou null.");
		}
		
		return playlists.containsKey(nomeDaPlaylist);
	}
	
	public boolean criaPlaylist(String nomeDaPlaylist) throws Exception{
		if(nomeDaPlaylist == null ||nomeDaPlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio ou null.");
		}
		playlists.put(nomeDaPlaylist, new ArrayList<Musica>());
		return true;
	}
	
	public boolean adiciona(String nomePlaylist, Musica musicaParaAdicionar) throws Exception{
		if(nomePlaylist == null || musicaParaAdicionar == null){
			throw new Exception("Nome da playlist e musica nao podem ser null.");
		}
		
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio.");
		}
		
		if(!existePlaylist(nomePlaylist)){
			criaPlaylist(nomePlaylist);
		}
		
		ArrayList<Musica> musicasDaPlaylist = playlists.get(nomePlaylist);
		
		if(musicasDaPlaylist.contains(musicaParaAdicionar)){
			throw new Exception("Musica ja esta na playlist.");
		}

		musicasDaPlaylist.add(musicaParaAdicionar);
		playlists.put(nomePlaylist, musicasDaPlaylist);
		return true;

	}
	
	public boolean remove(String nomePlaylist,Musica musica) throws Exception{
		
		if(nomePlaylist == null || musica == null){
			throw new Exception("Nome da playlist e musica nao podem ser null.");
		}
		
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio.");
		}
		
		if(!existePlaylist(nomePlaylist)){
			throw new Exception("Impossivel remover, playlist inexistente.");
		}
		
		ArrayList<Musica> musicasAtuais = playlists.get(nomePlaylist);
		
		if(!musicasAtuais.contains(musica)){
			throw new Exception("Impossivel remover musica nao contida na playlist.");
		}
	
		musicasAtuais.remove(musica);
		playlists.put(nomePlaylist, musicasAtuais);
		return true;
	}
	
	public boolean removePeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		
		if(nomeMusica == null || nomePlaylist == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao podem ser vazios ou null.");
		}
		
		if(!existePlaylist(nomePlaylist)){
			throw new Exception("Impossivel remover, playlist inexistente.");
		}

		int indice = getIndiceNaPlaylist(nomeMusica, nomePlaylist);
		
		if(indice == -1) throw new Exception("Impossivel remover musica nao contida na playlist.");
		else{
			ArrayList<Musica> listaDeMusicas = playlists.get(nomePlaylist);
			listaDeMusicas.remove(indice);
			playlists.put(nomePlaylist, listaDeMusicas);
		}
		
		return true;
	}
	
	public boolean existeMusica(String nomePlaylist,Musica musica) throws Exception{
		
		if(musica == null || nomePlaylist == null){
			throw new Exception("Nome da playlist e musica nao podem ser null.");
		}
		
		if(nomePlaylist.trim().equals("")){
			throw new Exception("Nome da playlist nao pode ser vazio.");
		}
		
		if(!playlists.containsKey(nomePlaylist)){
			throw new Exception("Impossivel pesquisar em playlist inexistente.");
		}
		
		return playlists.get(nomePlaylist).contains(musica);
	}
	
	public boolean existeMusicaPeloNome(String nomePlaylist,String nomeMusica) throws Exception{
		
		if(nomeMusica == null || nomePlaylist == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao podem ser vazious ou null.");
		}
		
		if(!playlists.containsKey(nomePlaylist)){
			return false;
		}
		
		return getIndiceNaPlaylist(nomeMusica, nomePlaylist) != -1;
	}
	
	private int getIndiceNaPlaylist(String nomeMusica,String nomePlaylist) throws Exception{
		
		if(nomeMusica == null || nomePlaylist == null || nomePlaylist.trim().equals("") || nomeMusica.trim().equals("")){
			throw new Exception("Nome da playlist e nome da musica nao podem vazios ser null.");
		}
		
		ArrayList<Musica> listaDeMusicas = playlists.get(nomePlaylist);
		
		for(int i = 0 ; i < listaDeMusicas.size() ; i++){
			if(listaDeMusicas.get(i).getTitulo().equalsIgnoreCase(nomeMusica)){
				return i;
			}
		}
		return -1;
	}
	
	
}
