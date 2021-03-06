package com.web.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class UserController {

    @Autowired
    private UserDaoService userService;


    //get all users
    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    //get user by id
    @GetMapping(path = "/users/{id}")
    public CollectionModel<User> getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if(user == null){
            throw new UserNotFoundException("User with id: " + id + " not found");
        }

        //HATEOAS
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(UserController.class).getAllUsers());
        Link link = linkBuilder.withRel("all-users");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        CollectionModel<User> result = CollectionModel.of(userList, link);

        return result;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);
        //returns this URI location to update the user's browser to go to the new user URL
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();




        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.deleteUser(id);
        if(user == null) {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
    }

}
