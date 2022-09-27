package up.br.techquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizzActivity extends AppCompatActivity {

    TextView pergunta;
    Button opt1;
    Button opt2;
    Button opt3;
    Button opt4;
    TextView pontua;
    // Inicializando variáveis
    int perguntaAtual = 0; // baseado no index
    int pontuacao = 0;
    String respostaEscolhida = "";
    int totalPerguntas = DinamicaPerguntas.perguntas.length;
String nome = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        Bundle bundle = getIntent().getExtras();

        // getting the string back
        nome = bundle.getString("mainPrefsKey", "default");
        pergunta = findViewById(R.id.txt_pergunta);
        opt1 = findViewById(R.id.btn_opt1);
        opt2 = findViewById(R.id.btn_opt2);
        opt3 = findViewById(R.id.btn_opt3);
        opt4 = findViewById(R.id.btn_opt4);
        pontua = findViewById(R.id.txt_pontua);

        // Inicializa na primeira pergunta
        novaPergunta();

        //busca na instancia de shared preference o conteúdo (nome do jogador) salvo com a chave (playerNameKey)
//        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.mainPrefsKey), Context.MODE_PRIVATE);
//        String playerName = sharedPref.getString(getString(R.string.playerNameKey), "TESTE");


    }

    // Código antigo --não apagar
    public void trocarPergunta(View view)
    {
//        String nova_pergunta = "";
//        String nova_opt1 = "";
//        String nova_opt2 = "";
//        String nova_opt3 = "";
//        String nova_opt4 = "";
//
//        if(pergunta.getText().toString().contains("website")){
//            if(opt3.isPressed()){
//                pontuacao += 5;
//            }else {
//                pontuacao += 0;
//            }
//            nova_pergunta = "Qual o comando git para mudar de branch?";
//            nova_opt1 = "git branch --checkout <nome-da-branch>";
//            nova_opt2 = "git checkout -b <nome-da-branch>";
//            nova_opt3 = "git checkout <nome-da-branch>";
//            nova_opt4 = "git branch <nome-da-branch>";
//        } else if(pergunta.getText().toString().contains("branch")){
//            if(opt3.isPressed()){
//                pontuacao += 5;
//            }else {
//                pontuacao += 0;
//            }
//            nova_pergunta = "Qual dessas linguagens é fracamente tipada?";
//            nova_opt1 = "Ruby";
//            nova_opt2 = "C++";
//            nova_opt3 = "Scala";
//            nova_opt4 = "Dart";
//        } else if(pergunta.getText().toString().contains("tipada")) {
//            if (opt1.isPressed()) {
//                pontuacao += 5;
//            } else {
//                pontuacao += 0;
//            }
//            nova_pergunta = "Como centralizar horizontalmente uma div container?";
//            nova_opt1 = ".container {max-width: 1200px; margin: 0 auto}";
//            nova_opt2 = ".container {max-width: 1200px; center: 0 auto}";
//            nova_opt3 = ".container {max-width: 1200px; padding: 0 auto}";
//            nova_opt4 = ".container {max-width: 1200px; center-h: auto}";
//        }else{
//            if (opt1.isPressed()) {
//                pontuacao += 5;
//            } else {
//                pontuacao += 0;
//            }
//        }
//
//        pergunta.setText(nova_pergunta);
//        opt1.setText(nova_opt1);
//        opt2.setText(nova_opt2);
//        opt3.setText(nova_opt3);
//        opt4.setText(nova_opt4);
//        pontua.setText("Pontuação: " + pontuacao);
    }

    // Função atrelada aos botões de escolhas
    public void onClick(View view){
        // Captura o botão opção que foi pressionado pelo usuário
        Button botaoPressionado = (Button) view;

        // Extrai o texto e transforma em string
        respostaEscolhida = botaoPressionado.getText().toString();

        // Faz a comparação com o array de respostas corretas
        if(respostaEscolhida.equals(DinamicaPerguntas.corretas[perguntaAtual])){
            pontuacao = pontuacao + 5;
        }else{
            pontuacao =+ 0;
        }

        pontua.setText("Pontuação: " + pontuacao);

        // Soma um no index da pergunta atual
        perguntaAtual++;

        // Muda para a próxima pergunta
        novaPergunta();
    }

    public void novaPergunta(){

        // Quando percorrer todas as perguntas, prossegue para a próxima activity
        if(perguntaAtual == totalPerguntas){
            mostrarRanking();
        }

        // Alterando os textos com base no index do array
        pergunta.setText(DinamicaPerguntas.perguntas[perguntaAtual]);
        opt1.setText(DinamicaPerguntas.escolhas[perguntaAtual][0]);
        opt2.setText(DinamicaPerguntas.escolhas[perguntaAtual][1]);
        opt3.setText(DinamicaPerguntas.escolhas[perguntaAtual][2]);
        opt4.setText(DinamicaPerguntas.escolhas[perguntaAtual][3]);
    }

    
    public void mostrarRanking(){
        Intent intent = new Intent(this, RankingActivity.class);

        // Converte em string o valor da pontuacao, pois é um inteiro
        String pontuacaoValue = String.valueOf(pontuacao);

        //cria objeto bundle
        Bundle bundle = new Bundle();

        //salva o valor do bundle, relacionado a key/chave
        bundle.putString("mainPrefsKey", nome);
        bundle.putString("playerPrefsKey", pontuacaoValue);

        //atribui o objeto bundle a intent
        intent.putExtras(bundle);

        startActivity(intent);
    }
}