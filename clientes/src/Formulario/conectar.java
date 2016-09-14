package Formulario;

import java.sql.*;
import javax.swing.*;

public class conectar {
    Connection conect = null;
       
    public Connection conexion()
		{
			try {
				
				Class.forName("org.sqlite.JDBC");
				conect = DriverManager.getConnection("jdbc:sqlite:colegio.sqlite");
				JOptionPane.showMessageDialog(null,"Conectado");
                                
                                                        
                                
                                    
			} catch (ClassNotFoundException | SQLException e) {
				//System.out.println("error de conexion");
				JOptionPane.showMessageDialog(null,"Error de conexion"+e);
			}
			return conect;
		}
}
