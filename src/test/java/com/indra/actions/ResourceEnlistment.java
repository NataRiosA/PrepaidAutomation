package com.indra.actions;

import com.indra.models.DataExcel;
import java.util.ArrayList;
import java.util.List;

public class ResourceEnlistment extends DataExcel {
    UninstallCBSServices uninstallCBSServices = new UninstallCBSServices();
    DatabaseConnection databaseConnection = new DatabaseConnection();
    ReadFileXLSX fileXLSX = new ReadFileXLSX();

    /**  Este metodo retorna una lista de los valores de la columna especificada, la columna de excel donde estan ya sea
     * los msisdn o los msi */
    public List<String> Enlistment(int columna){
            fileXLSX.readFileExcel();
            List<ArrayList<String>> dataTest = new ArrayList<>();
            List<String> listCol = new ArrayList<>();

            dataTest = fileXLSX.excelArray.subList(10,fileXLSX.excelArray.size());

            for (int i = 0 ; i< dataTest.size(); i++){
                String a;
                a= String.valueOf(dataTest.get(i));
                listCol.add(a.split(",")[columna].replace("]","").trim());

            }
        System.out.println(listCol);
        return listCol;
    }
    /** ejemplo del metodo que ejecutaria los dos procesos para cada linea tanto los servicios del SOAP como los SP */
    public void ejecutarTodo(){
        for (int i = 0 ; i< Enlistment(2).size(); i++){
            // llamado a la ejecucion de los servicios
            uninstallCBSServices.performLineCleaning(getUrlGatewayCBS(), getUrlGatewayMG(),Enlistment(2).get(i));
            //llamado a la ejecucion de SPs
        }
    }

}