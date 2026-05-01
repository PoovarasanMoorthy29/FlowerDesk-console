import com.flowerdeskconsole.controller.ITAgentHomePageController;
import com.flowerdeskconsole.controller.LoginController;
import com.flowerdeskconsole.controller.SignUpController;
import com.flowerdeskconsole.controller.UserHomePageController;
import com.flowerdeskconsole.model.TicketDAO;
import com.flowerdeskconsole.model.UserDAO;
import com.flowerdeskconsole.repository.FlowerDeskDB;
import com.flowerdeskconsole.service.AgentService;
import com.flowerdeskconsole.service.UserService;
import com.flowerdeskconsole.service.UserSignUpAndLoginService;
import com.flowerdeskconsole.utils.AppInfo;
import com.flowerdeskconsole.utils.InputGetter;
import com.flowerdeskconsole.view.ITAgentHomePageView;
import com.flowerdeskconsole.view.LoginView;
import com.flowerdeskconsole.view.SignUpView;
import com.flowerdeskconsole.view.UserHomePageView;

import java.util.InputMismatchException;

public class FlowerDeskApp {
    public static void main(String[] args) {
//        ITAgentHomePageView itAgentHomePageView =new ITAgentHomePageView();
//        AgentService agentService=new AgentService();
//        ITAgentHomePageController itAgentHomePageController=new ITAgentHomePageController(itAgentHomePageView,agentService);
        //object creation
        SignUpView signUpView = new SignUpView();
        FlowerDeskDB db =FlowerDeskDB.getDb();
        UserDAO dao = new UserDAO(db);
        TicketDAO ticketDAO=new TicketDAO(db);
        UserService userService =new UserService(ticketDAO);

        ITAgentHomePageView itAgentHomePageView =new ITAgentHomePageView();
        AgentService agentService=new AgentService(ticketDAO);
        ITAgentHomePageController itAgentHomePageController=new ITAgentHomePageController(itAgentHomePageView,agentService);
        UserHomePageView userHomePageView=new UserHomePageView();
        UserHomePageController userHomePageController=new UserHomePageController(userHomePageView,userService);
        UserSignUpAndLoginService userSignUpAndLoginService =new UserSignUpAndLoginService(dao,userHomePageController,
                itAgentHomePageController);
        SignUpController signUpController = new SignUpController(signUpView, dao, userSignUpAndLoginService);
        LoginView loginView=new LoginView();
        LoginController loginController=new LoginController(loginView,dao, userSignUpAndLoginService);
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("             " + AppInfo.getAppName() + "               ");
            System.out.println("----------------------------------------------------");
            System.out.println("             " + AppInfo.getAppVersion() + "            ");
            try {
                System.out.println("----Menu----");
                System.out.println("1.SignUp");
                System.out.println("2.Login");
                System.out.println("3.Exit");
                System.out.println("Enter your option: ");
                int option = Integer.parseInt(InputGetter.getInstance().next());
                if (option == 1) {
                    signUpController.init();
                } else if (option == 2) {
                    loginController.init();


                } else if (option == 3) {
                    System.out.println("-----------------------------");
                    System.out.println("|        Thank you          |");
                    System.out.println("-----------------------------");
                    InputGetter.getInstance().close();
                    System.exit(0);

                } else {
                    System.out.println("Invalid input ! Please enter valid input  ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please Give Number as input like (1 or 2 or 3");
            } catch (Exception e) {
                System.out.println("Please Give Number as input like (1 or 2 or 3");

            }

        }


    }
}
