package br.com.contato.agenda.agendaappcontato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaDAO dao;
    EditText edNome;
    EditText edEmail;
    EditText edTelefone;
    RatingBar rClass;
    Button bEnviar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao = new PessoaDAO(MainActivity.this);

        edNome = (EditText) findViewById(R.id.txtNome);
        edEmail = (EditText) findViewById(R.id.txtEmail);
        edTelefone = (EditText) findViewById(R.id.txtTelefone);
        rClass = (RatingBar) findViewById(R.id.ratClassificacao);
        bEnviar = (Button) findViewById(R.id.btnEnviar);


        //criar o evento click do botao
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });


    }//fim do onCreate

    public void cadastrar(){
        pessoa = new Pessoa();
        pessoa.setNome(edNome.getText().toString());
        pessoa.setEmail(edEmail.getText().toString());
        pessoa.setTelefone(edTelefone.getText().toString());
        pessoa.setClassificacao(rClass.getProgress());


        dao.insere(pessoa);
        Toast.makeText(MainActivity.this,"Sucesso", Toast.LENGTH_LONG).show();

    }


}
