package project_poo_ads20181.classes;

public class Categoria {

    private int idCategoria;
    private String nomeCategoria;
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
  /*  public Categoria (String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    } */
        
    public Categoria(String string) {
		// TODO Auto-generated constructor stub
	}

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public void setNomeCategoria (String nomeCategoria){
        this.nomeCategoria = nomeCategoria;    
        }    
    
    public String getNomeCategoria(){
        return this.nomeCategoria;
    }
}
