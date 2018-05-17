package project_poo_ads20181.classes;

/**
*
* @author Hugo Felipe
*/

public class Aluguel {

	private int idAluguel;
	private Atendente idAtendente;
	private Exemplar idExemplar;
	private Usuario cpf;
	private double valor;
	
	public void setIdAluguel (Integer idAluguel){
        this.idAluguel = idAluguel;
        
        }
    public Integer getIdAluguel(){
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
    public Exemplar getExemplar(){
        return this.idExemplar;
    }
    
    public void setCpf (Usuario cpf){
        this.cpf = cpf;
    }
    public Usuario getCpf(){
        return this.cpf;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return this.valor;
    }

}
