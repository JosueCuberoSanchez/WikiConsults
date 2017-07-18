package cr.ac.ucr.ecci.ci1310.core.dao.impl;

import cr.ac.ucr.ecci.ci1310.core.dao.WikiDao;
import cr.ac.ucr.ecci.ci1310.model.Page;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
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

    @SuppressWarnings("unchecked")
    @Override
    public V getDataWithId(K id) {
        String title = null; //agregar mas si es necesario
        String idd = null;
        String date = null;
        Page page = null;
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs;
            String sqlStatement = "SELECT page_id, page_title, page_touched FROM page WHERE page_id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sqlStatement);
            preparedStmt.setObject(1,id);
            rs = preparedStmt.executeQuery();
            while(rs.next()) {
                title = rs.getString("page_title");
                idd = rs.getString("page_id");
                date = rs.getString("page_touched");
                page = new Page(title,idd,date);
                page.printData();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return (V)(page);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <V> List<V> getDataWithName(K name) {
        List<V> pages = new LinkedList<>();
        Page page = null;
        try{
            Statement stmt = this.conn.createStatement();
            ResultSet rs;
            String sqlStatement = "SELECT page_id, page_title, page_touched FROM page WHERE page_title LIKE ?";
            PreparedStatement preparedStmt = conn.prepareStatement(sqlStatement);
            preparedStmt.setObject(1,"%" + name + "%");
            rs = preparedStmt.executeQuery();
            String title; //agregar mas si es necesario
            String id;
            String date;
            while(rs.next()){
                title = rs.getString("page_title");
                id = rs.getString("page_id");
                date = rs.getString("page_touched");
                page = new Page(title,id,date);
                page.printData();
                pages.add((V)(page));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pages;
    }
}
