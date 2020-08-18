package com.example.roomdatabaseexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// This class is an Abstaract Class
// Class must extends RoomDatabase
// Here we have to annotate this abstract class as an Database by using @Database(Table_name,Database_version)

@Database(entities = {User.class},version = 1)
public abstract  class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();  // Object of Data Access Object Class

}
