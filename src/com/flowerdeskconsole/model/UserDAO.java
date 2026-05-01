package com.flowerdeskconsole.model;

import com.flowerdeskconsole.repository.FlowerDeskDB;

public class UserDAO {
    private FlowerDeskDB db;
    public UserDAO(FlowerDeskDB db){
        this.db=db;
    }
    public void saveToDb(User user) {
        sendToDb(user);
    }
    private void sendToDb(User user) {
        db.save(user);
    }
    public boolean checkUserNameIsExisted(String username){
        return db.checkUserName(username); // if it is existed
    }
    public boolean checkUserEmailIsExisted(String email) {
        return checkEmailInDB(email);
    }
    private boolean checkEmailInDB(String email) {
        return db.checkEmail(email);
    }

    public boolean checkCredits(String email, String password, String role) {
        return checkWithDb(email, password,  role);
    }

    private boolean checkWithDb(String email, String password, String role) {
        return db.authenticate(email,password,role);
    }
}
