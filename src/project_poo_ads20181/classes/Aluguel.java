package project_poo_ads20181.classes;

/**
*
* @author Hugo Felipe
*/

public class Aluguel {

	private Integer idAluguel;
	private Usuario idAtendente = new Usuario();
	//private Exemplar idExemplar = new Exemplar();
	private Usuario idUsuario = new Usuario();
	private Integer valor;
	
	public void setIdAluguel (Integer idAluguel){
        this.idAluguel = idAluguel;
        
        }
    public Integer getIdAluguel(){
        return this.idAluguel;
    }
    
    public void setIdAtendente (Usuario idAtendente){
        this.idAtendente = idAtendente;
    }
    public Usuario getIdAtendente(){
        return this.idAtendente;
    }

//    public void setIdExemplar(Exemplar idExemplar){
//        this.idExemplar = idExemplar;
//    }
//    public Exemplar getIdExemplar(){
//        return this.idExemplar;
//    }
    
    public void setIdUsuario (Usuario idUsuario){
        this.idUsuario = idUsuario;
    }
    public Usuario getIdUsuario(){
        return this.idUsuario;
    }
    
    public void setValor(Integer valor){
        this.valor = valor;
    }
    public Integer getValor(){
        return this.valor;
    }

    }
   

