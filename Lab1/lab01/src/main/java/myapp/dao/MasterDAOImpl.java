package myapp.dao;

import myapp.logpass.Logpass;
import myapp.model.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MasterDAOImpl implements MasterDAO {


    @Autowired
    Logpass logpass; //использование данных к доступу к бд

    Logger log
            = LoggerFactory.getLogger(MasterDAOImpl.class);


    public List<Master> listAllMasters() {
        log.info("Получить список хозяев");
        try {
            ArrayList<Master> masterList = new ArrayList<Master>();
            String query = "select * from master";
            PreparedStatement ps = logpass.dataSource().getConnection().prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Master master = new Master();
                master.setId(rs.getInt(1));
                master.setName(rs.getString(2));
                master.setAddress(rs.getString(3));
                master.setPetname(rs.getString(4));
                masterList.add(master);
            }
            return masterList;

        } catch (SQLException e) {
            log.error("Ошибка, получить список хозяев не удалось "+e.getMessage());
            return null;
        }
    }

    @Override
    public Master getMaster(int id) {
        log.info("Получить хозяина с id = " + id);
        try {
            String query = "select * from master where id="+id;
            PreparedStatement ps = logpass.dataSource().getConnection().prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            Master master = new Master();
            if (rs.next()) {
                master.setId(rs.getInt(1));
                master.setName(rs.getString(2));
                master.setAddress(rs.getString(3));
                master.setPetname(rs.getString(4));
            }
            log.info("Возврат хозяина " + master.toString());
            return master;

        } catch (SQLException e) {
            log.error("Ошибка, получить хозяина не удалось " + e.getMessage());
            return null;
        }
    }

    @Override
    public Master create(Master master) {
        log.info("Создать хозяина");
        try {
            String query = "insert into master (name, address, petname)" + "values (?, ?, ?)";
            PreparedStatement ps = logpass.dataSource().getConnection().prepareStatement(query,
                            PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, master.getName());
            ps.setString(2, master.getAddress());
            ps.setString(3, master.getPetname());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                master.setId(rs.getInt(1));
            log.info("Добавлен хозяин: " + master.toString());
            return master;
        } catch (SQLException e) {
            log.error("Ошибка, создать хозяина не удалось" + e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(int id) {
        log.info("Удаление хозяина с id: " + id);
        try {
            String query = "delete from master where id="+id;
            PreparedStatement stmt = logpass.dataSource().getConnection().prepareStatement(query);
            stmt.executeUpdate();
        } catch (SQLException e) {
            log.error("Ошибка, удалить хозяина с id: " + id + " не вышло");
        }
    }

    @Override
    public void update(Master master) {
        try {
            String query = "update master set name='"+master.getName()+"', address='"+master.getAddress()+ "', petname='"+master.getPetname()+ "' WHERE id="+master.getId();
            PreparedStatement ps = logpass.dataSource().getConnection().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
