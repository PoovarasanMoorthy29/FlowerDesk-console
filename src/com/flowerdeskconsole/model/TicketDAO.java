package com.flowerdeskconsole.model;

import com.flowerdeskconsole.repository.FlowerDeskDB;

public class TicketDAO {
    private FlowerDeskDB db;
    public TicketDAO(FlowerDeskDB db){
        this.db=db;
    }
    public void createTicket(Tickets newTicket) {
        db.appendTheTicket(newTicket);
    }

    public void getTickerStatusOfUser(String userId) {
        db.getUserTicketStatus(userId);
    }

    public void getActiveTickets() {
        db.getActiveTicketList();
    }

    public void updateStatusOfUser(String userId) {
        db.updateUserStatus(userId);
    }
}
