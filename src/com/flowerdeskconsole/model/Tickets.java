package com.flowerdeskconsole.model;

public class Tickets {
    private int ticketID;
    private String userID;
    private String department;
    private String description;
    private String status;

    public Tickets(int ticketID, String userID,String department,
                    String description, String status) {
        this.ticketID = ticketID;
        this.department = department;
        this.userID = userID;
        this.description = description;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getUserID() {
        return userID;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
}
