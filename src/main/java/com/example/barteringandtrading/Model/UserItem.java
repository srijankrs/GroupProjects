package com.example.barteringandtrading.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="user_items")
public class UserItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "item_for")
    private String itemFor;

    @Column(name = "item_required")
    private String itemsRequired;

    @Column(name = "item_value")
    private double itemValue;

    @Column(name = "required_item_list_delta_value")
    private int requiredItemListDeltaValue;

    @Column
    private boolean deleted;

}
