package br.com.contato.agenda.agendaappcontato;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListarActivity extends AppCompatActivity {


    Button botao;
    ListView lista;
    List<Pessoa> contatos;
    ArrayAdapter<Pessoa> adapter;
    PessoaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        dao = new PessoaDAO(ListarActivity.this);

        botao = (Button) findViewById(R.id.botaoAdd);
        lista = (ListView) findViewById(R.id.lista_view);

        carregaDados();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chamarMainActivity();
            }
        });
    }
    private void chamarMainActivity(){

        Intent it = new Intent(ListarActivity.this, MainActivity.class);
        startActivity(it);
    }

    public void carregaDados(){
        contatos = dao.buscarPessoas();
        adapter = new ArrayAdapter<Pessoa>(ListarActivity.this,
                android.R.layout.simple_list_item_1, contatos);
        lista.setAdapter(adapter);
        dao.close();

    }

}
