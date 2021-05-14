package com.web.app.user;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> userList = new ArrayList<>();
    private static int usersCount = 3;

    static {
        userList.add(new User(1, "Adam", new Date()));
        userList.add(new User(2, "Bill", new Date()));
        userList.add(new User(3, "Chance", new Date()));
    }

    public List<User> getAll(){
        return userList;
    }

    public User saveUser(User newUser){
        newUser.setId((++usersCount));
        userList.add(newUser);
        return newUser;
    }

    public User getUser(int id){
        for(User user: userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteUser(int id){
        Iterator<User> iterator = userList.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
