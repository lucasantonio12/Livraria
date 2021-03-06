/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Usuario extends Livro{
    private String nome;
    private String telefone;
    private Date dataNascimento;
    private String cpf;
    private String login;
    private String senha;
    private List<Livro> listaLivros;
    private boolean admin;

    public Usuario() {
        admin = false;
        this.listaLivros = new ArrayList<Livro>();
    }

    public Usuario(String nome, String telefone, Date dataNascimento, String cpf, String login, String senha, boolean admin) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
        this.listaLivros = new ArrayList<Livro>();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
    
    
    
    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", telefone=" + telefone + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha + '}';
    }
    
    
}
