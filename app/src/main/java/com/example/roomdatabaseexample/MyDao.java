package com.example.roomdatabaseexample;

import androidx.room.Dao;
import androidx.room.Insert;

import java.io.Serializable;

// Data Access Object Class to access the data
// We can perform table insertion,creation,deletion,updation etc through the Dao Object

@Dao
public interface MyDao {

    //Insert Operation : Adding User
    // Here we have to pass User object as an argument
    // We have to annotate this method by @Insert For Insertion Operation
    @Insert
    public void addUser(User user);

}
