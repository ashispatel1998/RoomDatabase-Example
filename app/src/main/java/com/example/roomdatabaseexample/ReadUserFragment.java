package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ReadUserFragment extends Fragment {
    private TextView user_info;
    public ReadUserFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_user, container, false);
        user_info=view.findViewById(R.id.user_info);

        // Read information from room database\
        // Return value is List
        List<User> users=MainActivity.myAppDatabase.myDao().getUsers();

        // Variable
        String info="";

        // Displaying user info in the text view
        for(User user:users){

            int id=user.getId();
            String name=user.getName();
            String email=user.getEmail();
            String mobile=user.getMobile();

            info=info+"\n\n"+" id :"+id+"\n Name :"+name+"\n Email :"+email+"\n Mobile :"+mobile;
            user_info.setText(info);
        }

        return view;
    }
}