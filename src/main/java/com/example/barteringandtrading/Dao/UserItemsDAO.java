package com.example.barteringandtrading.Dao;

import com.example.barteringandtrading.Model.UserItem;

import java.io.IOException;
import java.util.List;

public interface UserItemsDAO {
    List<String> searchUserItems();

    String addItems(UserItem userItem) throws IOException;

    long generateNewId();
}
