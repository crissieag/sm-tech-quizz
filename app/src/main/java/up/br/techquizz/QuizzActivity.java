package up.br.techquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizzActivity extends AppCompatActivity {

    //private TextView teste;
    TextView pergunta;
    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);


        //busca na instancia de shared preference o conteúdo (nome do jogador) salvo com a chave (playerNameKey)
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.mainPrefsKey), Context.MODE_PRIVATE);
        String playerName = sharedPref.getString(getString(R.string.playerNameKey), "TESTE");


    }

    public void trocarPergunta(View view)
    {
        pergunta = findViewById(R.id.txt_pergunta);
        opt1 = findViewById(R.id.opt_1);
        opt2 = findViewById(R.id.opt_2);
        opt3 = findViewById(R.id.opt_3);
        opt4 = findViewById(R.id.opt_4);
        String nova_pergunta = "";
        String nova_opt1 = "";
        String nova_opt2 = "";
        String nova_opt3 = "";
        String nova_opt4 = "";

        if(pergunta.getText().toString().contains("w")){
            nova_pergunta = "Qual o comando git para mudar de branch?";
            nova_opt1 = "git checkout <nome-da-branch>";
        } else{
            nova_pergunta = "Qual dessas linguagens é fracamente tipada?";
            nova_opt1 = "Ruby";
            nova_opt2 = "C++";
            nova_opt3 = "Scala";
            nova_opt4 = "Dart";
        }

        pergunta.setText(nova_pergunta);
        opt1.setText(nova_opt1);
        opt2.setText(nova_opt2);
        opt3.setText(nova_opt3);
        opt4.setText(nova_opt4);

    }
}