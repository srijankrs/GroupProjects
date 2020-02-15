package com.example.barteringandtrading.Dao;

import com.example.barteringandtrading.Model.Token;
import com.example.barteringandtrading.Model.User;
import com.example.barteringandtrading.Model.UserItem;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@Slf4j
@Component
public class UserItemsDAOImpl implements UserItemsDAO{

    @Autowired
    private Client client;

    @Override
    public List<String> searchUserItems() {

        return new ArrayList<>();
    }

    @Override
    public String addItems(UserItem userItem) throws IOException {

        IndexResponse response = client.prepareIndex("users", "employee",String.valueOf(userItem.getId()))
                .setSource(jsonBuilder()
                        .startObject()
                        .field("itemFor", userItem.getItemFor())
                        .field("itemValue", userItem.getItemValue())
                        .endObject()
                )
                .get();
       log.info("response id:"+response.getId());
        return response.getResult().toString();

    }
}
