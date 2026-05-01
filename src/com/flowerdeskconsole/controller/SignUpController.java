package com.flowerdeskconsole.controller;

import com.flowerdeskconsole.model.UserDAO;
import com.flowerdeskconsole.service.UserSignUpAndLoginService;
import com.flowerdeskconsole.utils.Notification;
import com.flowerdeskconsole.view.SignUpView;

public class SignUpController {
    private final SignUpView signUp;
    private final UserDAO dao;
    private final UserSignUpAndLoginService userSignUpAndLoginService;

    public SignUpController(SignUpView view, UserDAO dao, UserSignUpAndLoginService userSignUpAndLoginService) {
        this.signUp = view;
        this.dao = dao;
        this.userSignUpAndLoginService = userSignUpAndLoginService;
    }

    public void init() {
        initiateRegistration();
    }

    private void initiateRegistration() {

        String userName = signUp.getUserName().trim();
        String fullName = signUp.getFullName().toLowerCase().trim();
        String email = signUp.getEmail().trim();
        String password = signUp.getPassword().trim();
        String phoneNumber = signUp.getPhoneNumber();
        String department = signUp.getDepartment().toLowerCase().trim();
        String role = signUp.getRole().trim();

        if(userSignUpAndLoginService.isUserNameExist(userName)){
            Notification.showErrorMessage("Username  already exist!");
            init();
            return;
        }

        if(userSignUpAndLoginService.isUserEmailExist(email)){
            Notification.showErrorMessage("email id already exist!");
            init();
            return;
        }
        if(userSignUpAndLoginService.checkPasswordFormat(password)){
            Notification.showErrorMessage("Please enter the password length min 8 characters");
            init();
            return;
        }
        if(!userSignUpAndLoginService.checkPhoneNumberFormat(phoneNumber)){
            Notification.showErrorMessage("Please enter correct phone number only 10 digits");
            init();
            return;
        }
        userSignUpAndLoginService.saveUser(userName, fullName, email, password, phoneNumber, department, role);
        Notification.showSuccessMessage("...Registration successfully completed...");


    }
}
