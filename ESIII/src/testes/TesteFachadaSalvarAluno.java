package testes;

//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

import main.controle.Fachada;
import main.controle.IFachada;
import dominio.Aluno;
import dominio.Cidade;
import dominio.Endereco;
import dominio.Estado;

public class TesteFachadaSalvarAluno {

	public static void main(String[] args) {
		
		Estado sp = new Estado("SÃO PAULO");
		Cidade suzano = new Cidade("Suzano", sp);
		Endereco endereco = new Endereco("Av teste dois", "123",suzano, "08576315");
		endereco.setCep("08576315");
		endereco.setDtCadastro(new Date());

		Aluno aluno  = new Aluno("Cleberson ", "3323498", endereco, "ADS", "Giovanna da Silva MSOL", "Desconhecido");
		aluno.setDtCadastro(new Date());
		
		if (aluno.getEndereco() != null) {
		    aluno.validarDados();
		}
		IFachada fachada = new Fachada();
		
		System.out.println(fachada.salvar(aluno));
		
	}

}
