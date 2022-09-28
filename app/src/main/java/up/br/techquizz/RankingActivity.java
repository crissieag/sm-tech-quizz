package up.br.techquizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import up.br.techquizz.Adapter.JogadorAdapter;
import up.br.techquizz.model.Jogador;
import up.br.techquizz.repository.JogadoresRepository;

public class RankingActivity extends AppCompatActivity {

    private RecyclerView recyclerViewJogadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        recyclerViewJogadores = findViewById(R.id.jogadores_recyclerview);
        recyclerViewJogadores.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Jogador> jogadores = JogadoresRepository.getInstance().get();
        JogadorAdapter jogadorAdapter = new JogadorAdapter(jogadores);
        recyclerViewJogadores.setAdapter(jogadorAdapter);
    }
}