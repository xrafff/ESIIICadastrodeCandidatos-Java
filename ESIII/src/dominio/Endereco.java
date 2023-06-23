package dominio;

public class Endereco extends EntidadeDominio {
	private String logradouro;
	private String numero;
	private Cidade cidade;
	private String cep;
	
	public Endereco(String logradouro, String numero, Cidade cidade, String cep){
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public String validar(){
		StringBuilder sb = new StringBuilder();
		
		if(logradouro == null || logradouro.trim().equals("")){
			sb.append("LOGRADOURO É UM CAMPO OBRIGATÓRIO!");
		}
		
		if(numero == null || numero.trim().equals("")){
			sb.append("NÚMERO É UM CAMPO OBRIGAT�RIO!");
		}
		
		if(cidade.getEstado().getNome() == null || cidade.getEstado().getNome() .trim().equals("")){
			sb.append("ESTADO É UM CAMPO OBRIGATÓRIO!");
		}
		
		if(cidade.getNome() == null || cidade.getNome() .trim().equals("")){
			sb.append("CIDADE É UM CAMPO OBRIGATÓRIO!");
		}	
		
		
		if(sb.length()>0){
			return sb.toString();
		}else{
			return null;
		}
		
		
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	

}
