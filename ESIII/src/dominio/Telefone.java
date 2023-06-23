package dominio;

public class Telefone extends EntidadeDominio {

	    private String tipo;
	    private String numero;
	    private int cod_tipo;
	    
	    public Telefone(String tipo, String numero) {
	        this.tipo = tipo;
	        this.numero = numero;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public String getNumero() {
	        return numero;
	    }
   
		public int getCod_tipo() {
			return cod_tipo;
		}

		public void setCod_tipo(int cod_tipo) {
			this.cod_tipo = cod_tipo;
		}
		
	     	       
	    
	}
	

