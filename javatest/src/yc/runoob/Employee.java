package yc.runoob;

public class Employee implements java.io.Serializable {

    private String name;
    private String address;
    private transient Integer SSN;
    private String phone;

    public Employee() {
    }

    public Employee(String name, String address, Integer SSN, String phone) {
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSSN() {
        return SSN;
    }

    public void setSSN(Integer SSN) {
        this.SSN = SSN;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public void whoami() {
        System.out.println("I'm " + name);
    }
}
