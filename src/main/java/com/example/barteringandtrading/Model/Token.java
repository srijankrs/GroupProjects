package com.example.barteringandtrading.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="Token")
public class Token {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="token_id")
    private int tokenID;

    @Column(name="user_id" , unique=true)
    private int userID;

    @Column(name="authenticationToken")
    private String authenticationToken;

    @Column(name="secretKey")
    private String secretKey;

    @Column(name="email_id")
    private String emailId;
}
