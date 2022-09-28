package up.br.techquizz.repository;

import java.util.ArrayList;

import up.br.techquizz.model.Jogador;

public class JogadoresRepository {
    // instancia statica do repositorio
    private static JogadoresRepository jogadoresRepository;

    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public static JogadoresRepository getInstance(){
        if (jogadoresRepository == null){
            jogadoresRepository = new JogadoresRepository();
        }
        return jogadoresRepository;
    }
    private JogadoresRepository (){

    }
    public Jogador getByIndex(int index){
        return jogadores.get(index);
    }
    public ArrayList<Jogador> get(){
        return jogadores;
    }
    public void save(Jogador jogador){
        jogadores.add(jogador);
    }
    public void delete(Jogador jogador){
        jogadores.remove(jogador);
    }
    public void update(int index, Jogador jogador){
        jogadores.set(index,jogador);
    }


}
