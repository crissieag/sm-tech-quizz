package up.br.techquizz.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import up.br.techquizz.R;
import up.br.techquizz.model.Jogador;

public class  JogadorAdapter extends RecyclerView.Adapter<JogadorAdapter.JogadorViewHolder> {
    private ArrayList<Jogador> jogadores;

    public JogadorAdapter(ArrayList<Jogador> jogadores){
        this.jogadores = jogadores;

    }
    @NonNull
    @Override
    // Cria o objeto que descreve a view de um item e as informações sobre seu lugar em recycler view
    public JogadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View layout = inflater.inflate(R.layout.view_jogador_ranking,parent,false);
        return new JogadorViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull JogadorViewHolder holder, int position) {
        Jogador jogador = jogadores.get(position);

        TextView textViewName = holder.itemView.findViewById(R.id.text_name);
        TextView textViewPontuacao = holder.itemView.findViewById(R.id.text_pontuacao);

        textViewName.setText(jogador.getNomeJogador());
        textViewPontuacao.setText(jogador.getPontuacaoJogador());
    }

    @Override
    // informando quantos itens tem lista de jogadores
    public int getItemCount() {
        return jogadores.size();
    }

    public static class JogadorViewHolder
            extends RecyclerView.ViewHolder{

        public JogadorViewHolder(View view){
            super(view);
        }
    }
}
