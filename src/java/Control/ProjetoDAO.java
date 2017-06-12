/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Projeto;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author thiag
 */
@SessionScoped
@ManagedBean
public class ProjetoDAO {

    private int id;
    private String nomeProjeto;
    private String descProjeto;
    private String nomePesquisa;

    public String getNomePesquisa() {
        return nomePesquisa;
    }

    public void setNomePesquisa(String nomePesquisa) {
        this.nomePesquisa = nomePesquisa;
    }

    public String getDescProjeto() {
        return descProjeto;
    }

    public int getId() {
        return id;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setDescProjeto(String descProjeto) {
        this.descProjeto = descProjeto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public void popularProjeto() {
        MyConnection connection = new MyConnection();
        connection.conectar();

        try {
            String query = "SELECT * from projeto where nomeProjeto = '"+nomePesquisa+"';";
            connection.resultset = connection.statement.executeQuery(query);
            connection.statement = (Statement) connection.connection.createStatement();
            connection.resultset.next();
            setNomeProjeto(connection.resultset.getString("nomeProjeto"));
            setDescProjeto(connection.resultset.getString("descProjeto"));     

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        connection.desconectar();
    }
    
    public List<String> popularMenu() {
        
        MyConnection connection = new MyConnection();
        connection.conectar();
        
        List lista = new ArrayList<String>();
        
        try {
            String query = "select * from projeto";
            connection.resultset = connection.statement.executeQuery(query);
            connection.statement = (Statement) connection.connection.createStatement();
            while(connection.resultset.next())
            {
                System.out.println(connection.resultset.getString("nomeProjeto"));
                lista.add(connection.resultset.getString("nomeProjeto"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        connection.desconectar();
        return lista;
               
    }
    
    public void cadastrar()
    {  
        MyConnection connection = new MyConnection();
        
        connection.conectar();
        
        try
	{		
		String query = "INSERT INTO projeto (nomeProjeto, descProjeto) VALUES ('"+nomeProjeto+"' , '"+ descProjeto+"');"; 	
		connection.statement = (Statement) connection.connection.createStatement();
		connection.statement.executeUpdate(query);
	}
		
	catch (Exception e)
	{
            System.out.println(e.getMessage());	
	} 
       
        connection.desconectar();
        
        reset();
    }
    
    public void editarProjeto()
    {  
        MyConnection connection = new MyConnection();
        
        connection.conectar();
        
        try
	{		
		String query = "UPDATE projeto SET nomeProjeto = '"+nomeProjeto+"' , descProjeto = '"+ descProjeto+"' where nomeProjeto = '"+nomePesquisa+"'"; 	
		connection.statement = (Statement) connection.connection.createStatement();
		connection.statement.executeUpdate(query);
	}
		
	catch (Exception e)
	{
            System.out.println(e.getMessage());	
	} 
       
        connection.desconectar();
        
        reset();
    }
    
     public void deletarProjeto()
    {  
        MyConnection connection = new MyConnection();
        
        connection.conectar();
        
        try
	{		
		String query = "DELETE from projeto where nomeProjeto = '"+nomePesquisa+"'"; 	
		connection.statement = (Statement) connection.connection.createStatement();
		connection.statement.executeUpdate(query);
	}
		
	catch (Exception e)
	{
            System.out.println(e.getMessage());	
	} 
       
        connection.desconectar();
        
        reset();
    }
    
    public void reset()
    {
        setNomeProjeto(null);
        setDescProjeto(null);
        setNomePesquisa(null);
    }
}
