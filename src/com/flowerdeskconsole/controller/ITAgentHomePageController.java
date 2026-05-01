package com.flowerdeskconsole.controller;

import com.flowerdeskconsole.service.AgentService;
import com.flowerdeskconsole.view.ITAgentHomePageView;

public class ITAgentHomePageController {
    private ITAgentHomePageView agentView;
    private AgentService agentService;

    public ITAgentHomePageController(ITAgentHomePageView view,AgentService service){
        this.agentService=service;
        this.agentView=view;
        this.agentView.setController(this);
    }
    public void init(){
      agentView.showMenu();

    }
    public void getActiveTicket(){
        agentService.getActiveTicket();

    }

    public void updateTicketStatus() {
        String userId=agentView.getUserId();
        agentService.updateStatus(userId);
    }
}
