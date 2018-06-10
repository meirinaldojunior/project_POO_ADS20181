
package project_poo_ads20181.classes;

/**
 *
 * @author Meirinaldo Júnior
 */
public class Atendente {
    private Integer idAtendente;
    private String nome;
    private String cpf;

    public Atendente(Integer idAtendente, String nome, String cpf) {
        this.idAtendente = idAtendente;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Atendente() {
    }

    public Integer getIdAtendente() {
        return idAtendente;
    }

    public void setIdAtendente(Integer idAtendente) {
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
