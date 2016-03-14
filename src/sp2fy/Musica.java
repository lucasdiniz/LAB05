package sp2fy;

public class Musica {
	
	private String titulo,genero;
	private int duracao;
	
	public Musica(String nome,int duracao,String genero)throws Exception{
		if(nome == null || nome.trim().equals("")){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio.");
		}
		if(genero == null || genero.trim().equals("")){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		if(duracao <= 0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		
		this.titulo = nome;
		this.genero = genero;
		this.duracao = duracao;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public int getDuracao(){
		return this.duracao;
	}
	
	public String getGenero(){
		return this.genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Musica){
			Musica outraMusica = (Musica) obj;
			return this.duracao == outraMusica.getDuracao() && this.titulo.equalsIgnoreCase(outraMusica.getTitulo());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Musica [titulo=" + titulo + ", genero=" + genero + ", duracao="
				+ duracao + "]";
	}
	
}
