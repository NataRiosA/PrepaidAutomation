package com.indra.actions;

import com.indra.models.dataExcel;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.openqa.selenium.WebDriver;
import java.sql.*;

public class DatabaseConnection extends dataExcel {

    private static final String MSISDN = "3016877411";

    public DatabaseConnection(WebDriver driver) {

    }
//---------conexion a base de datos-------------------------
    public void connection() throws SQLException {
        databaseConnection(getUrlDBA(),getService()
                ,getUser(),getPassword(), "SET serveroutput ON;BEGIN AL_RE_ACTIVADOR ('"+MSISDN+"');END;)");
    }

    public void databaseConnection(String url, String service, String user,
                                   String password, String sp) throws SQLException {
        OracleDataSource ods = null;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        // Create DataSource and connect to the local database
        ods = new OracleDataSource();
        String port = "1521";
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



