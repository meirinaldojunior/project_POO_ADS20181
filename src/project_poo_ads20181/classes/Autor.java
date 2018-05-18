
package project_poo_ads20181.classes;

public class Autor {
    private int id;
    private String nome;
    
     public Autor(){
         
     }
    
     public Autor( String nome) {
        this.nome = nome;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
}
