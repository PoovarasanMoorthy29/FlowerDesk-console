package com.flowerdeskconsole.service;

import com.flowerdeskconsole.controller.ITAgentHomePageController;
import com.flowerdeskconsole.controller.UserHomePageController;
import com.flowerdeskconsole.model.User;
import com.flowerdeskconsole.model.UserDAO;
import com.flowerdeskconsole.utils.Notification;
import com.flowerdeskconsole.utils.Validation;

public class UserSignUpAndLoginService {
    private final UserDAO dao;
    private final UserHomePageController homePageController;
    private final ITAgentHomePageController agentHomePageController;

    public UserSignUpAndLoginService(UserDAO dao,UserHomePageController homePageController,
                                     ITAgentHomePageController agentHomePageController){
        this.dao=dao;
        this.homePageController=homePageController;
        this.agentHomePageController=agentHomePageController;
    }


    public boolean isUserNameExist(String username){
        return dao.checkUserNameIsExisted(username);
    }


    public boolean isUserEmailExist(String email) {
        return dao.checkUserEmailIsExisted(email);
    }

    public boolean checkPasswordFormat(String password) {
        return Validation.checkPasswordLength(password);
    }

    public boolean checkPhoneNumberFormat(String phoneNumber) {
        return Validation.checkPhoneNumberLength(phoneNumber);
    }

    public void saveUser(String userName, String fullName,
                         String email, String password,String phoneNumber,
                         String department, String role){
        User user=new User(userName, fullName, email, password, phoneNumber, department, role);
        dao.saveToDb(user);
    }

    public void checkLoginCredits(String email, String password, String role) {
        boolean matches=dao.checkCredits(email,password,role);
        if(matches && role.equalsIgnoreCase("U")){
            Notification.showSuccessMessage("Logged in successfully");
            homePageController.init();
        }
        else if(matches && role.equalsIgnoreCase("A")){
            Notification.showSuccessMessage("Logged in successfully");
            agentHomePageController.init();


        }
        else{
            Notification.showErrorMessage("!!!! -Please enter correct login credentials- !!!!");
        }
    }
}
