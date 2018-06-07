package project_poo_ads20181.classes;

/**
*
* @author Hugo Felipe
*/

public class Aluguel {

	private int idAluguel;
	private Atendente idAtendente = new Atendente();
	private Exemplar idExemplar = new Exemplar();
	private Usuario idUsuario = new Usuario();
	private double valor;
	
	public void setIdAluguel (int idAluguel){
        this.idAluguel = idAluguel;
        
        }
    public int getIdAluguel(){
        return this.idAluguel;
    }
    
    public void setIdAtendente (Atendente idAtendente){
        this.idAtendente = idAtendente;
    }
    public Atendente getIdAtendente(){
        return this.idAtendente;
    }

    public void setIdExemplar(Exemplar idExemplar){
        this.idExemplar = idExemplar;
    }
    public Exemplar getIdExemplar(){
        return this.idExemplar;
    }
    
    public void setIdUsuario (Usuario idUsuario){
        this.idUsuario = idUsuario;
    }
    public Usuario getIdUsuario(){
        return this.idUsuario;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return this.valor;
    }
}
