package cr.ac.ucr.ecci.ci1310.core.dao.impl;

import cr.ac.ucr.ecci.ci1310.core.dao.WikiDao;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Josue Cubero on 11/07/2017.
 */
public class WikiDaoImpl<K,V> implements WikiDao<K,V> { //db accesses

    private Connection conn;

    public WikiDaoImpl(){
        try {
            this.conn = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user","root");
            connectionProps.put("password","Blackfolgore666");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wiki?autoReconnect=true&useSSL=false", connectionProps);
            System.out.println("Connected to database");
        } catch(SQLException e){
            System.out.println("Connection to wiki database failed");
            e.printStackTrace();
        }
    }

    @Override
    public V getDataWithId(K id) {
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs;
            String sqlStatement = "SELECT page_id, page_title FROM page WHERE page_title LIKE ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sqlStatement);
            preparedStmt.setObject(1,"%" + id + "%");
            rs = preparedStmt.executeQuery();
            String name; //agregar mas si es necesario
            while(rs.next()){
                name = rs.getString("page_title");
                System.out.println(name);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public V getDataWithName(K name) {
        return null;
    }
}
