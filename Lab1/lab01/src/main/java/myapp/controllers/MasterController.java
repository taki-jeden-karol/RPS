package myapp.controllers;


import myapp.dao.MasterDAO;
import myapp.model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private final MasterDAO masterDAO;

    public MasterController(MasterDAO masterDAO) {
        this.masterDAO = masterDAO;
    }

    @GetMapping
    public String menu(Model ui) {
        ui.addAttribute("masterList", masterDAO.listAllMasters());
        return "list";
    }

    @GetMapping("/crt")
    public String createForm() {
        return "crt";
    }

    @PostMapping("/crt")
    public String createMaster(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("petname") String petname) {
        Master master = new Master();
        master.setName(name);
        master.setAddress(address);
        master.setPetname(petname);
        master = masterDAO.create(master);

        return "redirect:edit/"+master.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model ui) {
        Master master = masterDAO.getMaster(id);
        ui.addAttribute("master", master);
        return "edit";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        masterDAO.delete(id);
        return "redirect:";
    }

    @GetMapping("/upd/{id}")
    public String updateFrom(@PathVariable("id") int id, Model ui) {
        ui.addAttribute("master", masterDAO.getMaster(id));
        return "upd";
    }

    @PostMapping("/upd/{id}")
    public String update(@PathVariable("id") int id,
                         @RequestParam("title") String name,
                         @RequestParam("address") String address,
                         @RequestParam("petname") String petname) {
        Master master = new Master();
        master.setId(id);
        master.setName(name);
        master.setAddress(address);
        master.setPetname(petname);
        masterDAO.update(master);
        return "redirect:/master/edit/"+master.getId();
    }



}
