package project_poo_ads20181.classes;

/**
*
* @author Hugo Felipe
*/

public class Usuario {

        private int idUsuario;
    	private String cpf;
	private String nome;
        private String senha;

	
	public Usuario() {
	}
	
    public void setCpf (String cpf){
        this.cpf = cpf;
        
        }
    public String getcpf(){
        return this.cpf;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public void setIdUsuario (int idUsuario){
        this.idUsuario = idUsuario;
    }
    public int getIdUsuario(){
        return this.idUsuario;
    }
    
    public void setSenha (String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
	
}
