package up.br.techquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RankingActivity extends AppCompatActivity {

    TextView nomePlayer;
    TextView pontuacaoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        nomePlayer = findViewById(R.id.nome);
        pontuacaoPlayer = findViewById(R.id.pontuacao);

        // getting the bundle back from the android
        Bundle bundle = getIntent().getExtras();

        // getting the string back
        String nome = bundle.getString("mainPrefsKey", "default");
        String pontuacao = bundle.getString("playerPrefsKey", "default");

        nomePlayer.setText(nome);
        pontuacaoPlayer.setText(pontuacao);
    }
}