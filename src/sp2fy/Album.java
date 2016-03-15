package sp2fy;

import java.util.ArrayList;

public class Album implements Comparable<Album>{
	
	private final int MIN_ANO = 1900;
	private ArrayList <Musica> faixas;
	private String titulo,artista;
	private int ano;
	private boolean isFavorite;

	public Album(String titulo,String artista,int ano) throws Exception{
		
		if(titulo == null || titulo.trim().equals("")){
			throw new Exception("Titulo do album nao pode ser vazio ou nulo.");
		}
		
		if(artista == null || artista.trim().equals("")){
			throw new Exception("Nome do artista nao pode ser vazio ou nulo.");
		}
		
		if(ano <= MIN_ANO){
			throw new Exception("Ano do album deve ser maior que 1900.");
		}
		
		this.faixas = new ArrayList <Musica>();
		this.titulo = titulo;
		this.artista = artista;
		this.ano = ano;
		this.isFavorite = false;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	public boolean isFavorito(){
		return this.isFavorite;
	}
	
	public void mudaStatusDeFavorito(){
		this.isFavorite = (isFavorite == true)? false : true;
	}
	
	public boolean adicionaMusica(Musica novaMusica) throws Exception{

		if(novaMusica == null){
			throw new Exception("Musica a ser adicionada nao pode ser nula.");
		}
	
		if(faixas.contains(novaMusica)){
			return false;
		}

		return faixas.add(novaMusica);
	}
	
	public Musica getMusicaNaFaixa(int indice) throws Exception{
		if(indice <= 0){
			throw new Exception("O numero da faixa deve ser positivo.");
		}
		if(indice > faixas.size()){
			throw new Exception("Numero da faixa maior que o total de musicas no album.");
		}
		return faixas.get(indice - 1); //Pois albuns de musica sao indexados a partir de 1
	}
	
	public int getDuracao(){
		int duracaoTotal = 0;
		for(Musica mus : faixas){
			duracaoTotal += mus.getDuracao();
		}
		return duracaoTotal;
	}
	
	public String getArtista(){
		return this.artista;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public boolean removeMusica(String tituloParaRemover) throws Exception{
		
		if(tituloParaRemover == null || tituloParaRemover.trim().equals("")){
			throw new Exception("Musica a ser removida nao pode ser nula ou vazia.");
		}
		
		int indice = getIndicePeloTitulo(tituloParaRemover);
		
		if(indice == -1) return false;
	
		faixas.remove(indice);
		return true;
		
	}
	
	public boolean existeMusica(String tituloDaMusica) throws Exception{
		
		if(tituloDaMusica == null || tituloDaMusica.trim().equals("")){
			throw new Exception("Musica a ser buscada nao pode ser nula ou vazia.");
		}
		return getIndicePeloTitulo(tituloDaMusica) != -1;

	}
	
	private int getIndicePeloTitulo(String titulo){
		for(int i = 0 ; i < faixas.size() ; i++){
			if(faixas.get(i).getTitulo().equalsIgnoreCase(titulo)){
				return i;
			}
		}
		return -1;
	}


	@Override
	public String toString() {
		return titulo + " by " + artista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Album){
			Album outroAlbum = (Album) obj;
			return this.artista.equalsIgnoreCase(outroAlbum.getArtista()) && this.titulo.equalsIgnoreCase(outroAlbum.getTitulo());
		}
		return false;
	}

	@Override
	public int compareTo(Album outroAlbum) {
		return this.ano - outroAlbum.getAno();
	}
}
