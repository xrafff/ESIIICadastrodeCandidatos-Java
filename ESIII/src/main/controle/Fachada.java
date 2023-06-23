package main.controle;

import java.util.List;

import dao.AlunoDAO;
import dao.IDAO;
import dominio.Aluno;
import dominio.EntidadeDominio;

public class Fachada implements IFachada {

	public String salvar(EntidadeDominio entidade) {
		Aluno aluno = (Aluno)entidade;
		StringBuilder sb = new StringBuilder();
		
				
		validaNull(sb, aluno.validarDados());
		validaNull(sb, aluno.validarDados());
		
		if(sb.length()==0){
			aluno.complementarDtCadastro();
			IDAO dao = new AlunoDAO();
			dao.salvar(aluno);
			return "Aluno SALVO COM SUCESSO!";
		}		
		
		return sb.toString();
	}

	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void validaNull(StringBuilder sb, String msg){
		if(msg != null){
			sb.append(msg);
		}
	}

}
