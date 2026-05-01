package com.flowerdeskconsole.controller;

import com.flowerdeskconsole.service.UserService;
import com.flowerdeskconsole.utils.Notification;
import com.flowerdeskconsole.view.UserHomePageView;

public class UserHomePageController {
    private static int ticketIdCount=1;
    private UserHomePageView homePageView;
    private UserService userService;

    public UserHomePageController(UserHomePageView view,UserService userService){
        this.homePageView=view;
        this.userService=userService;
        this.homePageView.setController(this);
    }
    public void init(){
        homePageView.userMenu();
    }

    public void createTickets() {
        int ticketId=ticketIdCount++;
        String usrID= homePageView.getUserId();
        String department= homePageView.getDepartment();
        String description=homePageView.getDescription();
        String status= "open";
        userService.createTicket(ticketId,usrID,department,description,status);
        Notification.showSuccessMessage("Ticket successfully raised ");
        Notification.showSuccessMessage("we will make you device work!!");
    }

    public void ViewTicketStatus() {
        String userId= homePageView.getUserId();
        userService.getMyTicketStatus(userId);
    }
}
