package main.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dominio.Cidade;
import dominio.Aluno;
import dominio.Endereco;
import dominio.Estado;

/**
 * Servlet implementation class ControleCliente
 */


public class ControleAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public ControleAluno() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtEstado = request.getParameter("txtEstado");
		String txtCidade = request.getParameter("txtCidade");
		String txtLogradouro = request.getParameter("txtLogradouro");
		String txtNumero = request.getParameter("txtNumero");
		String txtNomeMae = request.getParameter("txtNomeMae");
		String txtNomePai = request.getParameter("txtNomePai");
		String txtCursoMatriculado = request.getParameter("txtCursoMatriculado");
		
		
		Estado estado = new Estado(txtEstado);
		Cidade cidade = new Cidade(txtCidade, estado);
		
		Endereco endereco = new Endereco(txtLogradouro, txtNumero, cidade, txtNumero);
		endereco.setDtCadastro(new Date());
		
	
		String txtAluno = request.getParameter("txtAluno");
		String txtCPF = request.getParameter("txtCPF");
		
				
		Aluno aluno= new Aluno(txtAluno, txtCPF, endereco, txtCursoMatriculado , txtNomePai,  txtNomeMae);
		aluno.setDtCadastro(new Date());			
		
		IFachada fachada = new Fachada();
		String msg = fachada.salvar(aluno);
		
		
		PrintWriter out = response.getWriter();
		out.print(msg);
	}

	
	
}
