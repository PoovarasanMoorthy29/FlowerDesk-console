package com.flowerdeskconsole.controller;

import com.flowerdeskconsole.model.UserDAO;
import com.flowerdeskconsole.service.UserSignUpAndLoginService;
import com.flowerdeskconsole.view.LoginView;

public class LoginController {
    private LoginView loginView;
    private UserDAO dao;
    private UserSignUpAndLoginService userSignUpAndLoginService;

    public LoginController(LoginView view, UserDAO dao, UserSignUpAndLoginService userSignUpAndLoginService) {
        this.loginView=view;
        this.dao = dao;
        this.userSignUpAndLoginService = userSignUpAndLoginService;
    }

    public void init(){
        login();

    }
    private void login(){
        String email= loginView.getEmail();
        String password= loginView.getPassword();
        String role= loginView.getRole().toLowerCase();
        userSignUpAndLoginService.checkLoginCredits(email,password,role);

    }
}
