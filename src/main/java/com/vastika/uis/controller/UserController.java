package com.vastika.uis.controller;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class UserController {

    public static void main(String[] args) {
        String decision = "";
        UserService userService = new UserServiceImpl();
        do{
            String operation = JOptionPane.showInputDialog("Enter operation: save|update|delete|get|list");
            switch (operation){
                case "save":
                    User user = getUser("save");
                    int saved = userService.saveUser(user);
                    if (saved >= 1) {
                        JOptionPane.showMessageDialog(null, "user info saved in db");
                    }else{
                        JOptionPane.showMessageDialog(null, "error in the db");
                    }
                    break;
                case "update":
                    User updatedUser = getUser("update");
                    int update = userService.saveUser(updatedUser);
                    if (update >= 1) {
                        JOptionPane.showMessageDialog(null, "user info updated in db");
                    }else{
                        JOptionPane.showMessageDialog(null, "error in the db");
                    }
                    break;
                case "delete":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    int delete = userService.deleteUser(id);
                    if (delete >= 1) {
                        JOptionPane.showMessageDialog(null, "user info deleted from db");
                    }else{
                        JOptionPane.showMessageDialog(null, "error in the db");
                    }
                    break;
                case "get":
                    id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    user = userService.getUserById(id);
                    System.out.println("========================");
                    printUserInfo(user);
                    System.out.println("========================");
                    break;

                case "list":
                    List<User> users = userService.getAllUser();
                    for(User u: users){
                        printUserInfo(u);
                    }
                    break;
            }
            decision = JOptionPane.showInputDialog("Do you want to continue? Enter y|n");
        }
        while (decision.equalsIgnoreCase("y"));
        JOptionPane.showMessageDialog(null,"Bye bye!!! Thank you for user this!");
    }

    public static User getUser(String type){
        User user = new User();
        if(type.equals("update")){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
            user.setId(id);
        }
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile no: "));
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
        LocalDate dob = LocalDate.parse(JOptionPane.showInputDialog("Enter DOB: "));
        boolean active = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter is user active?"));
        user.setUsername(username);
        user.setPassword(password);
        user.setSalary(salary);
        user.setMobileNo(mobileNo);
        user.setDob(dob);
        user.setActive(active);
        return user;
    }

    public static void printUserInfo(User user){
        System.out.println("User Id: "+user.getId());
        System.out.println("User name is: "+user.getUsername());
        System.out.println("Password is: " +user.getPassword());
        System.out.println("Mobile no is: "+user.getMobileNo());
        System.out.println("Salary is : "+user.getSalary());
        System.out.println("DOB is: "+user.getDob());
        System.out.println("Is the user active: "+user.isActive());
    }
}
