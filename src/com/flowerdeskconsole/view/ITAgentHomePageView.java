package com.flowerdeskconsole.view;

import com.flowerdeskconsole.controller.ITAgentHomePageController;
import com.flowerdeskconsole.utils.InputGetter;
import java.util.InputMismatchException;

public class ITAgentHomePageView {
    private ITAgentHomePageController controller;

    public void setController(ITAgentHomePageController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        while(true) {
            try {

                System.out.println("-------------------------------------------------------");
                System.out.println("|                   Agents Menu                        |");
                System.out.println("-------------------------------------------------------");
                System.out.println("1.ViewActiveTickets");
                System.out.println("2.setStatus ");
                System.out.println("3.Exit");
                System.out.println("Enter your option:");
                int option= Integer.parseInt(InputGetter.getInstance().next());
                if(option==1){
                   controller.getActiveTicket();

                }
                else if(option==2){
                    controller.updateTicketStatus();
                }
                else if(option==3){
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("please enter valid input");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
    public String getUserId(){
        System.out.println("Enter your user id:");
        return InputGetter.getInstance().next();

    }


}
