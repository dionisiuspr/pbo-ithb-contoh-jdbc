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
public class Main {

    public Main() {
        Controller controller =  new Controller();
        ArrayList<User> users = controller.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
    
    public static void main(String[] args) {
       new Main();
    }
}
