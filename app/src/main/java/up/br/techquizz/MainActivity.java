package up.br.techquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay;
    private TextInputEditText inputPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPlayerName = findViewById(R.id.textInputEditName);
        btnPlay = findViewById(R.id.btnPlay);

        //seta o botão como desabilitado
        btnPlay.setEnabled(false);

        //adiciona listener para responder a mudanças de texto no input
        inputPlayerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence!= null && charSequence.length() > 2){
                    //habilita botão caso o valor do input seja maior que zero e diferente de vazio
                    btnPlay.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });

        View.OnClickListener btnPlayerName = view -> {
            //cria intent quando o botão é acionado, enviando para a activity do quizz
            Intent intent = new Intent(this, QuizzActivity.class);

            //salva o valor do input na variável e o converte em string - pois é um editable
            String message = inputPlayerName.getText().toString();

            //pega o shared preferences da activity, para que seja recuperado o conteúdo do input
            SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.mainPrefsKey), Context.MODE_PRIVATE);

            //utiliza classe editor para alterar o arquivo associado ao shared preferences
            SharedPreferences.Editor editor = sharedPref.edit();

            //usa o editor para adicionar um valor de string no arquivo com a chave - utiliza a chave para pesquisar
            editor.putString(getString(R.string.playerNameKey), message);
            editor.apply();

            //faz o redirecionamento para a activity do quizz
            startActivity(intent);
        };

        btnPlay.setOnClickListener((btnPlayerName));
    }
}