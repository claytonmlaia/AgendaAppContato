package br.com.contato.agenda.agendaappcontato;


import java.io.Serializable;

public class Pessoa implements Serializable {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private int classificacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String toString(){
        return  nome+"\n"+email+"\n"+telefone;
    }
}
