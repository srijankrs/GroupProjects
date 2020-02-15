package com.example.barteringandtrading.Services;

import com.example.barteringandtrading.Model.UserItem;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface UserItemsService {

    void searchItem(long userId);

    String addItem(UserItem userItem) throws IOException;
}
