package dominio;
import java.util.Date;

public class EntidadeDominio {

	private int id;

	private Date dtCadastro;

	public EntidadeDominio() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public void complementarDtCadastro(){
		dtCadastro = new Date();
	}
	
	
	

}
