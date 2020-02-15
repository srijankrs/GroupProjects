package com.example.barteringandtrading.Dao;

import com.example.barteringandtrading.Error.UserItemNotInsertedException;
import com.example.barteringandtrading.Error.UserNotFoundException;
import com.example.barteringandtrading.Model.UserItem;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Slf4j
@Component
public class UserItemsDAOImpl implements UserItemsDAO{

    @Autowired
    private Client client;

    @Override
    public List<String> searchUserItems() {

        //throw new UserNotFoundException(123);

        return new ArrayList<>();
    }

    @Override
    public String addItems(@NonNull UserItem userItem) {

        IndexResponse response ;

        try{
            response = client.prepareIndex("bat","useritems",String.valueOf(generateNewId()))
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("item_for", userItem.getItemFor())
                            .field("items_required",userItem.getItemsRequired())
                            .endObject()
                    )
                    .get();
            log.info("response id:"+response.getId());
        }
        catch (Exception e){
            log.error("Exception occurred while adding user items to elastic search"+ Arrays.toString(e.getStackTrace()));
            throw new UserItemNotInsertedException(userItem);
        }

        return response.getResult().toString();
    }

    public long generateNewId(){
        return new Random().nextLong();
    }
}
