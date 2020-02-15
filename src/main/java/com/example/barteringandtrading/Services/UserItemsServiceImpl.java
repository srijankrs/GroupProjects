package com.example.barteringandtrading.Services;

import com.example.barteringandtrading.Dao.UserItemsDAO;
import com.example.barteringandtrading.Dao.UserItemsDAOImpl;
import com.example.barteringandtrading.Model.UserItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserItemsServiceImpl implements UserItemsService {

    @Autowired
    private UserItemsDAO userItemsDAO;

    @Override
    public void searchItem(long userId) {

    }

    @Override
    public String addItem(UserItem userItem) throws IOException {
        return userItemsDAO.addItems(userItem);
    }
}
