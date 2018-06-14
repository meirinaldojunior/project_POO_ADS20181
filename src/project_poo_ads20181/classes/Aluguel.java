package project_poo_ads20181.classes;

/**
 *
 * @author Meirinaldo
 */
public class Aluguel {

    private int idAluguel;
    private int idAtendente;
    private int idExemplar;
    private int idUsuario;
    private Double valor;

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;

    }

    public Integer getIdAluguel() {
        return this.idAluguel;
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public int getIdAtendente() {
        return this.idAtendente;
    }

    public void setIdExemplar(int idExemplar) {
        this.idExemplar = idExemplar;
    }

    public int getIdExemplar() {
        return this.idExemplar;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return this.valor;
    }

}
