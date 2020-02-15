package com.example.barteringandtrading.Error;

import com.example.barteringandtrading.Model.UserItem;

public class UserItemNotInsertedException extends  RuntimeException {

    public UserItemNotInsertedException(UserItem userItem){
        super("User item for "+userItem.getItemFor()+" not added.");
    }
}
