/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihandatabase;

import java.util.ArrayList;
/**
 *
 * @author hanschristian
 */
public class View {

    public View() {
        Controller controller =  new Controller();
//        controller.getAllUsers();      
        
        // show all users
        ArrayList<User> users = controller.getAllUsers();
        
        if (users.size() > 0) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Mohon maaf ada kesalahan, silakan coba kembali");
        }
        
        User specificUser = controller.getUser("Budi", "Jl. Dipati Ukur");
//        System.out.println(specificUser);
        
        User newUser = new User();
        newUser.setName("Budi");
        newUser.setAddress("Jalan DU");
        newUser.setAge(15);
        newUser.setPhone("08261212323");
        // newUser.setName(textfieldName.getText());
        
        boolean status = controller.insertNewUser(newUser);
        if(status) {
            System.out.println("Insert Sukses");
        } else {
            System.out.println("Insert Gagal");
        }
        
        User newUser2 = new User();
        newUser2.setName("Joel");
        newUser2.setAddress("Jalan Kenari");
        newUser2.setAge(90);
        newUser2.setPhone("085345329834");
        
        boolean status2 = controller.insertNewUser(newUser2);
        if(status2) {
            System.out.println("Insert Sukses");
        } else {
            System.out.println("Insert Gagal");
        }
    }
    
    public static void main(String[] args) {
       new View();
    }
}
