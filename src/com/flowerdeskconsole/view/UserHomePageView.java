package com.flowerdeskconsole.view;

import com.flowerdeskconsole.controller.UserHomePageController;
import com.flowerdeskconsole.utils.InputGetter;

import java.util.InputMismatchException;

public class UserHomePageView {
    private UserHomePageController controller;

    public void setController(UserHomePageController controller) {
        this.controller = controller;
    }

    public void userMenu() {
        while(true) {
            try {
                System.out.println("---------------------------------------------------------");
                System.out.println("|                     User Menu                         |");
                System.out.println("---------------------------------------------------------");
                System.out.println("1.Create Ticket\n" +
                        "2.ViewTicket status\n" +
                        "3.Logout");
                System.out.println("Enter your option:");
                int option = Integer.parseInt(InputGetter.getInstance().next());

                if (option == 1) {
                    controller.createTickets();

                }
                else if(option==2){
                    controller.ViewTicketStatus();
                }
                else if(option ==3){
                    break;
                }
                else{
                    System.out.println("Enter correct input");
                }

            } catch (InputMismatchException e) {
                System.out.println("please choose appropriate number ");
            } catch (RuntimeException e) {
                System.out.println("please correct input");
            }

        }

    }
    public String getUserId(){
        System.out.println("Enter your userId:");
        return InputGetter.getInstance().next();
    }
    public String getDescription(){
        System.out.println("Enter the description of issue:");
        String issue=InputGetter.getInstance().nextLine();
        InputGetter.getInstance().nextLine();
        return issue;
    }
    public String getDepartment(){
        System.out.println("Enter your department:");
        return InputGetter.getInstance().next();
    }
}
