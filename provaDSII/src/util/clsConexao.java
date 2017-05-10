package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author CAIO
 */
public class clsConexao {    
    
    private final String nomeBanco = "db_ProvaDSI";
    private final String usuario = "sa";
    private final String senha = "12345";   
        
    
    public static void main(String[] args) {
        
        clsConexao c = new clsConexao();
        boolean conectado = c.testarConexao();        
        if(conectado)
        {
            System.out.println("Sucesso : Conectou no banco");
        } 
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("net.sourceforge.jtds.jdbc.Driver");            
        Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/"+nomeBanco, usuario, senha);        
        
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;dataBaseName="+nomeBanco+";", usuario, senha);
        return con;    
    }
    
    public boolean  testarConexao()
    {        
        try {
            Connection con = getConnection();
            if(con != null){
                return true;
            }else
                return false;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    } 
}
