package com.indra.actions;

import com.indra.models.DataExcel;
import oracle.jdbc.datasource.impl.OracleDataSource;
import org.openqa.selenium.WebDriver;
import java.sql.*;

public class DatabaseConnection extends DataExcel {

    private static final String MSISDN = "3016877411";


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


    public void createdClients(String url, String port, String service, String user, String password,
                               String sp, String MSISDN) throws SQLException {

        OracleDataSource ods = null;
        Connection conn= null;
        ResultSet resultSet;
        // Create DataSource and connect to the local database
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@//"+url+":"+port+"/"+service);
        ods.setUser(user);
        ods.setPassword(password);
        conn = ods.getConnection();

        try
        {
            // Query the employee names
            //String msisdn= "3016876876";
            String query = "begin "+sp+"(?); end;";
            CallableStatement cs3 = conn.prepareCall(query);//"{call "+sp+" (?)}"
            cs3.setString(1,MSISDN);
            cs3.execute();
            System.out.println("se ejecuta correctamente");


        }
        //Close the result set, statement, and the connection
        finally{
            if(conn!=null) conn.close();
        }
    }
}



