package com.flowerdeskconsole.view;

import com.flowerdeskconsole.utils.InputGetter;

public class LoginView {
    public void getLoginBanner(){
        System.out.println("-------------------------------------------");
        System.out.println("|                Login Page               |");
        System.out.println("-------------------------------------------");

    }
    public String getEmail(){
        System.out.println("Enter your email:");
        return InputGetter.getInstance().next();
    }
    public String getPassword(){
        System.out.println("Enter your password:");
        return InputGetter.getInstance().next();
    }
    public String getRole(){
        System.out.println("Enter your role( U /A):");
        return InputGetter.getInstance().next();
    }
}
