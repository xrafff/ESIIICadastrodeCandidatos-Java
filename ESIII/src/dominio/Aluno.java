package dominio;


public class Aluno extends Pessoa {

	private String cpf;
	private Endereco endereco;
	private String cursoMatriculado;
	private String nomeMae;
	private String nomePai;
	/*
	private String telefone1;
	private String telefone2;
	private String telefone3;
	*/

	public Aluno(String nome, String cpf, Endereco endereco, String cursoMatriculado, String nomeMae, String nomePai ) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cursoMatriculado=cursoMatriculado;
		this.nomeMae=nomeMae;
		this.nomePai=nomePai;
		/*this.telefone1=telefone1;
		this.telefone2=telefone2;
		this.telefone3=telefone3;
		*/
	}

		
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	/*
	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	
	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2= telefone2;
	}
	
	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone2= telefone3;
	}
	*/

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getcursoMatriculado() {
		return cursoMatriculado;
	}
	public void setcursoMatriculado(String cursoMatriculado) {
		this.cursoMatriculado=cursoMatriculado;
	}


	public String getNomeMae() {
		return nomeMae;
	}


	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}


	public String getNomePai() {
		return nomePai;
	}


	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	public String validarDados(){
		StringBuilder sb = new StringBuilder();
		
		if(nome == null || nome.trim().equals("")){
			sb.append("NOME � UM CAMPO OBRIGAT�RIO!");
		}
		
		if(cpf == null || cpf.trim().equals("")){
			sb.append("CPF � UM CAMPO OBRIGAT�RIO!");
		}
		
	
		String msgEndereco = endereco.validar();
		
		if(msgEndereco != null){
			sb.append(msgEndereco);
		}
		
		
		if(sb.length()>0){
			return sb.toString();
		}else{
			return null;
		}		
		
	}

	
	
}
