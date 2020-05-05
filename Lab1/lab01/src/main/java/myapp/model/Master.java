package myapp.model;

public class Master {

private int id;
private String name;
private String address;
private String petname;

public Master(){
}

public int getId(){return id;}

public void setId(int id){this.id=id;}

public String getName(){return name;}

public void setName(String name){this.name=name;}

public String getAddress(){return address;}

public void setAddress(String address){this.address=address;}

public String getPetname(){return petname;}

public void setPetname(String petname){this.petname=petname;}

    @Override
    public String toString() {
        return "Master{" + "id=" + id + ", name='" + name + '\'' +
                ", address='" + address + '\'' + ", petname='" + petname + '\'' + '}';
    }

}
