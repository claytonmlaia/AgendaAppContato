package br.com.contato.agenda.agendaappcontato;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends SQLiteOpenHelper {


    public PessoaDAO(Context context) {
        //parâmetros:
        //context é uma identificação para poder manipular
        // o arquivo
        super(context, "agenda", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE pessoa " +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome TEXT NOT NULL," +
                " email TEXT NOT NULL," +
                " telefone TEXT NOT NULL,  site TEXT , " +
                " classificacao INTEGER NOT NULL)";
        db.execSQL(sql);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //String sql ="DROP TABLE IF EXISTS pessoa";
        //db.execSQL(sql);
        //onCreate(db);
    }




    public void insere(Pessoa pessoa){
        //pede permissão para gravar no banco
        SQLiteDatabase bd = getWritableDatabase();
        //o objeto do tipo ContentValues é um map do java usa o esquema chave e valor
        ContentValues dados = new ContentValues();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("telefone", pessoa.getTelefone());
        dados.put("classificacao", pessoa.getClassificacao());
        bd.insert("pessoa", null, dados);
    }


    public List<Pessoa> buscarPessoas() {
        String sql = "SELECT * FROM pessoa order by nome";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Pessoa> listaPessoas = new ArrayList<>();
        cursor.moveToFirst();
        do {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pessoa.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            pessoa.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            pessoa.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            pessoa.setClassificacao(cursor.getInt(cursor.getColumnIndex("classificacao")));
            listaPessoas.add(pessoa);
        } while (cursor.moveToNext());

        cursor.close();
        return listaPessoas;
    }








}
