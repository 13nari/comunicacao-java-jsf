/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@SessionScoped
@ManagedBean

public class MyConnection {
    
   public Connection connection = null;
   public Statement statement = null;
   public ResultSet resultset = null;
            
        public void conectar()
	{
		String servidor = "jdbc:mysql://localhost:3306/inatelgames";
		String usuario = "root";
		String senha = "root";
		String driver = "com.mysql.jdbc.Driver"; 
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(servidor, usuario, senha);
                        statement = (Statement) connection.createStatement();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
        
        public void desconectar()
	{
		try
		{
			connection.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
