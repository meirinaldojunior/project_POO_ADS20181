
package project_poo_ads20181.classes;

/**
 *
 * @author Meirinaldo Júnior
 */
public class Atendente {
    private int idAtendente;
    private String nome;
    private String cpf;

    public Atendente(int idAtendente, String nome, String cpf) {
        this.idAtendente = idAtendente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Atendente() {
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
