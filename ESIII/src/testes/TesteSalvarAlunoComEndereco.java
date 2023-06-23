package testes;

//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

import dao.AlunoDAO;
import dominio.Cidade;
import dominio.Aluno;
import dominio.Endereco;
import dominio.Estado;


public class TesteSalvarAlunoComEndereco {

	public static void main(String[] args) {
		Estado sp = new Estado("SÃO PAULO");
		Cidade suzano = new Cidade("Suzano", sp);
		Endereco endereco = new Endereco("Av teste", "123",suzano, "08576315");
		endereco.setCep("08576315");
		endereco.setDtCadastro(new Date());
		
		
		
			
		Aluno carlos = new Aluno("Carlos", "12345678910", endereco, "medicina", "fulaninha", "jorge");
		carlos.setDtCadastro(new Date());
		
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.salvar(carlos);
		
		System.out.println(carlos.getId());
		
	}

}
