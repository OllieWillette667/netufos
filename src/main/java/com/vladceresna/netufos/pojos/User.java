package com.vladceresna.netufos.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class User {
    private String name,
                   description,
                   login,
                   mail,
                   schoolId,
                   lastActiveDateAndTime,
                   registrationDateAndTime;
    private UserType type;
    private ArrayList<String> friends,
                              chatIds,
                              postIds;

    public User(String name, String login, String mail) {
        this.name = name;
        this.login = login;
        this.mail = mail;
    }
}
