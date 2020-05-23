package myapp.dao;

import myapp.model.Master;

import java.util.List;

public interface MasterDAO {

    List<Master> listAllMasters();

    Master getMaster(int id);

    Master create(Master master);

    void delete(int id);

    void update(Master master);
}
