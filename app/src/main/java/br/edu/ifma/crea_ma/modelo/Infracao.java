package br.edu.ifma.crea_ma.modelo;

/**
 * Created by josemar on 13/09/17.
 */

public class Infracao {
    private Long id;
    private String nomeNotificado;
    private String dadosObra;
    private String etapasConcluidas;
    private String infracoesCometidas;
    private Double valorMulta;
    private Double notaInfracao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeNotificado() {
        return nomeNotificado;
    }

    public void setNomeNotificado(String nomeNotificado) {
        this.nomeNotificado = nomeNotificado;
    }

    public String getDadosObra() {
        return dadosObra;
    }

    public void setDadosObra(String dadosObra) {
        this.dadosObra = dadosObra;
    }

    public String getEtapasConcluidas() {
        return etapasConcluidas;
    }

    public void setEtapasConcluidas(String etapasConcluidas) {
        this.etapasConcluidas = etapasConcluidas;
    }

    public String getInfracoesCometidas() {
        return infracoesCometidas;
    }

    public void setInfracoesCometidas(String infracoesCometidas) {
        this.infracoesCometidas = infracoesCometidas;
    }

    public Double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(Double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Double getNotaInfracao() {
        return notaInfracao;
    }

    public void setNotaInfracao(Double notaInfracao) {
        this.notaInfracao = notaInfracao;
    }


}
