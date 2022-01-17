package com.indra.actions;

import oracle.jdbc.datasource.impl.OracleDataSource;
import org.openqa.selenium.WebDriver;
import java.sql.*;

public class DatabaseConnection {

    public DatabaseConnection(WebDriver driver) {

    }
//---------conexion a base de datos-------------------------
    public void connection() throws SQLException {
        databaseConnection("10.69.60.89","1521","DEV11G"
                ,"ACTIVATOR","ACTIVATOR", "SET serveroutput ON;BEGIN AL_RE_ACTIVADOR ('3046010569');END;)");
    }

    public void databaseConnection(String url, String port, String service, String user,
                                   String password, String sp) throws SQLException {
        OracleDataSource ods = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        // Create DataSource and connect to the local database
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//"+url+":"+port+"/"+service);
        ods.setUser(user);
        ods.setPassword(password);
        conn = ods.getConnection();
        //Close the result set, statement, and the connection
        try
        {
            // Query the employee names
            CallableStatement cs3 = conn.prepareCall(sp);
        }

        //Close the result set, statement, and the connection
        finally{
            if(conn!=null) conn.close();
        }
    }

}



