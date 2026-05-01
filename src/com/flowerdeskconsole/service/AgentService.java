package com.flowerdeskconsole.service;

import com.flowerdeskconsole.model.TicketDAO;
import com.flowerdeskconsole.utils.Notification;

public class AgentService {
    private TicketDAO dao;
    public AgentService(TicketDAO dao){
        this.dao=dao;
    }

    public void getActiveTicket() {
        dao.getActiveTickets();
    }

    public void updateStatus(String userId) {
        dao.updateStatusOfUser(userId);
        Notification.showSuccessMessage("Status updated!!!");

    }
}
