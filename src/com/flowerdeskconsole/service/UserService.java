package com.flowerdeskconsole.service;

import com.flowerdeskconsole.model.TicketDAO;
import com.flowerdeskconsole.model.Tickets;

public class UserService {
    private TicketDAO dao;
    public UserService(TicketDAO dao){
        this.dao=dao;
    }

    public void createTicket(int ticketID, String userID, String department,
                             String description, String status) {
        Tickets newTicket=new Tickets(ticketID,userID,department,description,status);
        dao.createTicket(newTicket);
    }

    public void getMyTicketStatus(String userId) {
        dao.getTickerStatusOfUser(userId);
    }
}
