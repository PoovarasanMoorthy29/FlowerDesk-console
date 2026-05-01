package com.flowerdeskconsole.view;

import com.flowerdeskconsole.utils.InputGetter;

public class SignUpView {
    public String getUserName(){
        System.out.println("Enter Your UserName or Employee ID:");
        return InputGetter.getInstance().next();
    }
    public String getFullName(){
        System.out.println("Enter your Full Name:");
        String fullName=InputGetter.getInstance().nextLine();
        InputGetter.getInstance().nextLine();
        return fullName;
    }
    public String getEmail(){
        System.out.println("Enter your Email:");
        return InputGetter.getInstance().next();
    }
    public String getPassword(){
        System.out.println("Enter your Password:");
        return InputGetter.getInstance().next();
    }
    public String getPhoneNumber(){
        System.out.println("Enter your phone number:");
        return InputGetter.getInstance().next();
    }
    public String getDepartment(){
        System.out.println("Enter your DepartmentName:");
        return InputGetter.getInstance().next();
    }
    public String getRole(){
        System.out.println("\n1.User(U)\n2.IT agent(A)\nEnter your Role(U/A) :");
        return InputGetter.getInstance().next();
    }


}
