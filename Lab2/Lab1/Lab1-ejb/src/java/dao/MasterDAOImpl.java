/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import model.Master;
import sin.intr;

/**
 *
 * @author Алиса
 */
@Stateless
public class MasterDAOImpl implements MasterDAO <Master>{
    private static final Logger LOGGER = Logger.getLogger(MasterDAO.class.getName());
    
    private final String url = "jdbc:mysql://localhost:3306/javalab?useSSL=false&useUnicode=true&serverTimezone=UTC";
    private final String usr = "root";
    private final String pass = "12232";
    private static Connection connection;
    
    @PostConstruct
    private void initializa() {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, usr, pass);
        } catch (Exception e) {
            LOGGER.warning("Error, connection failed");
        }
    }

    @Override
    public List<Master> listAllMasters() {
        List<Master> masterList = new ArrayList<>();
       String query = "select * from master";
       try {
           PreparedStatement ps = connection.prepareStatement(query);
           ResultSet rs = ps.executeQuery();
           while (rs.next()) {
               Master master = new Master();
               master.setId(rs.getInt(1));
               master.setName(rs.getString(2));
               master.setAddress(rs.getString(2));
               master.setPetname(rs.getString(2));
               masterList.add(master);
           }
           return masterList;
       } catch (Exception e) {
           LOGGER.warning("Error: " + e.getMessage());
           return null;
       }
    }

    @Override
    public Master getMaster(int id) {
         String query = "select * from master where id="+id;
       try {
           PreparedStatement stmt = connection.prepareStatement(query);
           ResultSet rs = stmt.executeQuery();
           Master master = new Master();
           if (rs.next()) {
               master.setId(rs.getInt(1));
               master.setName(rs.getString(2));
               master.setAddress(rs.getString(2));
               master.setPetname(rs.getString(2));
           }
           return master;
       } catch (Exception e) {
           LOGGER.warning("Error: " + e.getMessage());
           return null;
       }
    }

    @Override
    public void delete(int id) {
        String query = "delete from master where id="+id;
       try {
           PreparedStatement stmt = connection.prepareStatement(query);
           stmt.setInt(1,id);
           stmt.executeUpdate();
       } catch (Exception e) {
           LOGGER.warning("Error: " + e.getMessage());
       }
    }

    @Override
    public void update(Master model) {
        String query = "update master set name = ?, address = ?, petname = ? where id ="+model.getId();
       try {
           PreparedStatement stmt = connection.prepareStatement(query);
           stmt.setString(1,model.getName());
           stmt.setString(2, model.getAddress());
           stmt.setString(3, model.getPetname());
           stmt.executeUpdate();
       } catch (Exception e) {
           LOGGER.warning("Error: " + e.getMessage());
       }
    }

    @Override
    @Interceptors(intr.class)
    public Master create(Master model) {
       String query = "insert into master (name, address, petname) values(?,?,?)";
       try {
           PreparedStatement stmt = connection.prepareStatement(query,
                   PreparedStatement.RETURN_GENERATED_KEYS);
           stmt.setString(1, model.getName());
           stmt.setString(2, model.getAddress());
           stmt.setString(3, model.getPetname());
           stmt.executeUpdate();
           ResultSet rs = stmt.getGeneratedKeys();
           if (rs.next()) {
               model.setId(rs.getInt(1));     
           }
           return model;
       } catch (Exception e) {
           LOGGER.warning("Error: " + e.getMessage());
           return null;
       }
    }
   
    
}
