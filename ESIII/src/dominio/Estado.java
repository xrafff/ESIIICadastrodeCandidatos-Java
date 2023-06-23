package dominio;

public class Estado extends EntidadeDominio {

	public String nome;
	
	public Estado(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
