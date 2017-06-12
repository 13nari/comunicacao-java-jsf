/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 
 */
@SessionScoped
@ManagedBean

public class Funcionario {

    public Funcionario(String nome, String endereco, String email, String telefone, String cidade, String estado, int projeto_IdProjeto) {
        this.projeto_IdProjeto = projeto_IdProjeto;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public Funcionario()
    {
        
    }
    
    private int id;
    private int projeto_IdProjeto;
    private String nome;
    private String endereco;
    private String console;
    private String email;
    private String telefone;
    private String cidade;
    private String estado;
    private String emailPesquisa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailPesquisa() {
        return emailPesquisa;
    }

    public void setEmailPesquisa(String emailPesquisa) {
        this.emailPesquisa = emailPesquisa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProjeto_IdProjeto() {
        return projeto_IdProjeto;
    }

    public void setProjeto_IdProjeto(int projeto_IdProjeto) {
        this.projeto_IdProjeto = projeto_IdProjeto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
