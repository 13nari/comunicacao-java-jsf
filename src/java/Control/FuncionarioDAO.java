/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Funcionario;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean

public class FuncionarioDAO {

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjeto_IdProjeto() {
        return projeto_IdProjeto;
    }

    public void setProjeto_IdProjeto(int projeto_IdProjeto) {
        this.projeto_IdProjeto = projeto_IdProjeto;
    }

    public String getEmailPesquisa() {
        return emailPesquisa;
    }

    public void setEmailPesquisa(String emailPesquisa) {
        this.emailPesquisa = emailPesquisa;
    }
    
    public void reset() {
        setNome(null);
        setEndereco(null);
        setCidade(null);
        setEmail(null);
        setEstado(null);
        setCidade(null);
        setTelefone(null);
        setConsole(null);
        setEmailPesquisa(null);
    }
    
    public int retornarIdProjeto(String nomeProjeto) {
        MyConnection connection = new MyConnection();
        connection.conectar();

        try {
            String query = "SELECT idProjeto from projeto where nomeProjeto = " + nomeProjeto + "';";
            connection.resultset = connection.statement.executeQuery(query);
            connection.statement = (Statement) connection.connection.createStatement();
            connection.resultset.next();
            System.out.println(connection.resultset.getInt("idProjeto"));
            return connection.resultset.getInt("idProjeto");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }
    
    public String retornarNomeProjeto(int Projeto_IdProjeto) {
        MyConnection connection = new MyConnection();
        connection.conectar();

        try {
            String query = "SELECT nomeProjeto from projeto where idProjeto = '"+Projeto_IdProjeto+"';";
            connection.resultset = connection.statement.executeQuery(query);
            connection.statement = (Statement) connection.connection.createStatement();
            connection.resultset.next();
            return connection.resultset.getString("nomeProjeto");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void cadastrar() {
        MyConnection connection = new MyConnection();

        connection.conectar();

        try {
            String query = "INSERT INTO empregado (nomeEmpregado, endEmpregado, emailEmpregado, projeto_IdProjeto, telEmpregado, cidEmpregado, estEmpregado) VALUES ('" + nome + "' , '" + endereco + "' , '" + email + "', '" + this.retornarIdProjeto(console) + "', '" + telefone + "', '" + cidade + "','" + estado + "');";
            //String query = "INSERT into empregado (nomeEmpregado) value ('"+nome+"')";
            connection.statement = (Statement) connection.connection.createStatement();
            connection.statement.executeUpdate(query);
            System.out.println(this.retornarIdProjeto(console));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        connection.desconectar();
        reset();
    }
    
    public void editarFuncionario() {
        MyConnection connection = new MyConnection();
        connection.conectar();
        try {
            String query = "UPDATE empregado SET nomeEmpregado = '"+nome+"', emailEmpregado = '"+email+"', cidEmpregado = '"+cidade+"', telEmpregado='"+telefone+"', endEmpregado='"+endereco+"', estEmpregado='"+estado+"', projeto_IdProjeto = '"+this.retornarIdProjeto(console)+"' where emailEmpregado = '"+emailPesquisa+"' ";
            connection.statement = (Statement) connection.connection.createStatement();
            connection.statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        connection.desconectar();
        reset();
    }
    
    public void deletarFuncionario() {
        MyConnection connection = new MyConnection();
        connection.conectar();
        try {
            String query = "DELETE from empregado WHERE emailEmpregado = '"+emailPesquisa+"'";
            connection.statement = (Statement) connection.connection.createStatement();
            connection.statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        connection.desconectar();
        reset();
    }

    public void popularFuncionario() {
        MyConnection connection = new MyConnection();
        connection.conectar();

        try {
            String query = "SELECT * from empregado where emailEmpregado = '"+emailPesquisa+"';";
            connection.resultset = connection.statement.executeQuery(query);
            connection.statement = (Statement) connection.connection.createStatement();
            connection.resultset.next();
            setNome(connection.resultset.getString("nomeEmpregado"));
            setCidade(connection.resultset.getString("cidEmpregado"));
            setEmail(connection.resultset.getString("emailEmpregado"));
            setConsole(retornarNomeProjeto(connection.resultset.getInt("projeto_IdProjeto")));
            setTelefone(connection.resultset.getString("telEmpregado"));
            setEstado(connection.resultset.getString("estEmpregado"));
            setEndereco(connection.resultset.getString("endEmpregado"));
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        connection.desconectar();
    }

}
