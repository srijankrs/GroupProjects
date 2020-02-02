package com.example.barteringandtrading.Dao;

import com.example.barteringandtrading.Model.User;

import java.util.List;

public interface UserDAO {

    public int saveAdminDetail(User user);

    public int adminLogin(String emailId , String password);

    public List<User> getAdminData();
}
