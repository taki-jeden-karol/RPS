/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beabs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Алиса
 */
public class StfBeab implements IStfBeab, Serializable{

    private List<String> nameList = new ArrayList<>();

    @PostConstruct
    private void init() {
        nameList = new ArrayList<>();
    }
    
    @Override
    public void addName(String name) {
        nameList.add(name);
    }

    @Override
    public List<String> returnList() {
        return nameList;
    }
    
}
