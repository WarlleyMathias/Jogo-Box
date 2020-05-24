package Model;

public class Lutador {
	
	private String nome;
	private String pais;
	private int idade;
	private int forca;
	private int resistencia;
	private int tecnica;
	private int rank;
	private int id;
	
	public Lutador(int id, int rank, String nome, String pais, int idade, int forca, int resistencia, int tecnica) {
		this.rank           = rank;
		this.id             = id;
		this.forca          = forca;
		this.idade          = idade;
		this.nome           = nome;
		this.pais           = pais;
		this.resistencia    = resistencia;
		this.tecnica        = tecnica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public int getTecnica() {
		return tecnica;
	}

	public void setTecnica(int tecnica) {
		this.tecnica = tecnica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

}
