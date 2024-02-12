package com.navod.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDoeService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static{
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }
    public List<User> findUsers(){
        return users;
    }
    public User getUser(int id){
        for (User user:users){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public User saveUser(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public void deleteById(int id){
        users.remove(getUser(id));
    }
}
