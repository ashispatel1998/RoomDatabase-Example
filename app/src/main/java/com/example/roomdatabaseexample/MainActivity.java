package com.example.roomdatabaseexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    public static FragmentManager fragmentManager;

//    public  static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        //Initialize the object of MyAppDatabase
//        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb")
////                .build();
        // allowMainThreadQueries() is used to give the permission for database operation over main thread

        // Adding Home Fragment
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
        }

    }
}