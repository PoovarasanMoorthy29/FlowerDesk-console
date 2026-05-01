package com.flowerdeskconsole.repository;

import com.flowerdeskconsole.model.Tickets;
import com.flowerdeskconsole.model.User;

import java.util.ArrayList;
import java.util.List;

public class FlowerDeskDB {
    private static  FlowerDeskDB db=null;

    public static FlowerDeskDB getDb() {
        if(db==null){
            db=new FlowerDeskDB();
            return db;
        }
        return db;
    }

    private static List<User> userDatabase=new ArrayList<>();
    private static List<Tickets> ticketsDatabase=new ArrayList<>();

    public void save(User user) {
        saveUser(user);
    }

    private void saveUser(User user) {
        userDatabase.add(user);
    }

    public boolean checkUserName(String username) {
        for(User user:userDatabase){
            if(user.getUserName().equalsIgnoreCase(username)){
                return true;
            }
        }
        return false;
    }

    public boolean checkEmail(String email) {
        for(User user:userDatabase){
            if(user.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;

    }

    public boolean authenticate(String email, String password, String role) {
        for(User user:userDatabase){
            if(user.getEmail().equals(email) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equalsIgnoreCase(role)){
                return true;

            }
        }
        return false;

    }


    public void appendTheTicket(Tickets newTicket) {
        ticketsDatabase.add(newTicket);

    }

    public void getUserTicketStatus(String userId) {
        for(Tickets ticket:ticketsDatabase){
            if(ticket.getUserID().equalsIgnoreCase(userId)){
                System.out.println("Ticket id:"+ticket.getTicketID());
                System.out.println("User id:"+ticket.getUserID());
                System.out.println("Department:"+ticket.getDepartment());
                System.out.println("Description:"+ticket.getDescription());
                System.out.println("Status:"+ticket.getStatus());
            }
        }
    }

    public void getActiveTicketList() {
        for(Tickets ticket:ticketsDatabase){
            if(ticket.getStatus().equalsIgnoreCase("open")){
                System.out.println("Ticket id:"+ticket.getTicketID()+"   " +
                        "User ID: "+ticket.getUserID()+"   "+
                        "Department : "+ticket.getDepartment() +"    "+
                        "Description: "+ticket.getDescription()+"  " +
                        "Status: "+ticket.getStatus());
            }
        }
    }

    public void updateUserStatus(String userId) {
        for(Tickets ticket:ticketsDatabase){
            if(ticket.getUserID().equalsIgnoreCase(userId)){
                ticket.setStatus("InProgress");
            }
        }
    }
}
