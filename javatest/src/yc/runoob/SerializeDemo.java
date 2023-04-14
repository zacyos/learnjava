package yc.runoob;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setName("Reyan Ali");
        e.setAddress("Phokka Kuan, Ambehta Peer");
        e.setSSN(123456);
        e.setPhone("1234567890");

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }
}
