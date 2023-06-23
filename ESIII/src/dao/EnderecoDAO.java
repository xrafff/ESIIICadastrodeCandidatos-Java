
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import util.Conexao;
import dominio.Endereco;
import dominio.EntidadeDominio;



public class EnderecoDAO implements IDAO {	
	private Connection connection;
	private boolean ctrlTransaction = true;
	
	public EnderecoDAO(){}
	
	public EnderecoDAO(Connection connection){
		this.connection = connection;
	}
	
	public void salvar(EntidadeDominio entidade) {
		
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tb_endereco(nome_cidade_fk, logradouro, numero, dt_cadastro, cep) ");
		sql.append("VALUES (?, ?, CAST(? AS INTEGER), ?, ?)");

		try {
		    if (connection == null) {
		        connection = Conexao.getConnectionPostgres();
		    } else {
		        ctrlTransaction = false;
		    }

		    connection.setAutoCommit(false);

		    pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

		    pst.setString(1, end.getCidade().getNome());
		    pst.setString(2, end.getLogradouro());
		    pst.setString(3, end.getNumero());
		    pst.setTimestamp(4, new Timestamp(end.getDtCadastro().getTime()));
		    pst.setString(5, end.getCep());

		    pst.executeUpdate();
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			
			connection.commit();					
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
