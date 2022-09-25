package up.br.techquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class QuizzActivity extends AppCompatActivity {

    private TextView teste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);


        //busca na instancia de shared preference o conteúdo (nome do jogador) salvo com a chave (playerNameKey)
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.mainPrefsKey), Context.MODE_PRIVATE);
        String playerName = sharedPref.getString(getString(R.string.playerNameKey), "TESTE");

        teste = findViewById(R.id.teste);
       teste.setText(playerName);


    }
}