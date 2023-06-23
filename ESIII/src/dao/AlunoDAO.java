package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import util.Conexao;
import dominio.Aluno;
import dominio.EntidadeDominio;

public class AlunoDAO implements IDAO {
	private Connection connection = null;

	public void salvar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Aluno aluno = (Aluno) entidade;


		try {
			connection = Conexao.getConnectionPostgres();

			connection.setAutoCommit(false);

			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			enderecoDAO.salvar(aluno.getEndereco());

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_aluno(nome, cpf, ");
			sql.append("dt_cadastro,  cod_endereco, curso_matriculado, nome_mae, nome_pai) VALUES (?,?,?,?,?,?, ?)");

			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);	

			pst.setString(1, aluno.getNome());
			pst.setString(2, aluno.getCpf());
			Timestamp time = new Timestamp(aluno.getDtCadastro().getTime());
			pst.setTimestamp(3, time);
			pst.setInt(4, aluno.getEndereco().getId());
			pst.setString(5, aluno.getcursoMatriculado());
			pst.setString(6, aluno.getNomeMae());
			pst.setString(7, aluno.getNomePai());
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idAlu = 0;
			if (rs.next())
				idAlu = rs.getInt(1);
			aluno.setId(idAlu);

			
			
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}



	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public void excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
