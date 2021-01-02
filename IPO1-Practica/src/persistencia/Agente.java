package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Agente {

    protected static Agente mInstancia = null;
    protected static Connection mBD;
    private static String url = "jdbc:ucanaccess://src\\IPO1_BBDD.accdb";
    private static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
  

    private Agente() throws Exception {
        conectar();
    }
    public static Agente getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new Agente();
        }
        return mInstancia;
    }
    private void conectar() throws Exception {
        Class.forName(driver);
        mBD = DriverManager.getConnection(url, "", "");
    }   
    public void desconectar() throws Exception {
        mBD.close();
    }
    public ResultSet leer(String SQL) throws SQLException, Exception {
    	Statement st =mBD.createStatement();
    	ResultSet resultado = st.executeQuery(SQL);    
        return resultado;
    }
    public int modificar(String SQL) throws SQLException, Exception {
        Statement st =mBD.createStatement();
        int res = st.executeUpdate(SQL);
        return res;
    }   
}
