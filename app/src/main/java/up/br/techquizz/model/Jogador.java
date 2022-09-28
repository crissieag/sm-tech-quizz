package up.br.techquizz.model;

public class Jogador {
    String nomeJogador;
    String pontuacaoJogador;

    public Jogador(String nome, String pontuacaoValue) {
        nomeJogador = nome;
        pontuacaoJogador = pontuacaoValue;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }
    public String getPontuacaoJogador(){
        return pontuacaoJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public void setPontuacaoJogador(String pontuacaoJogador) {
        this.pontuacaoJogador = pontuacaoJogador;
    }
}
