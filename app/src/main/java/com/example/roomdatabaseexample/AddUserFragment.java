package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AddUserFragment extends Fragment {

    private EditText user_id,user_name,user_email,user_mobile;
    private Button btn_add_user;

    MyAppDatabase myAppDatabase;

    public AddUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_user, container, false);
        user_id=view.findViewById(R.id.user_id);
        user_name=view.findViewById(R.id.user_name);
        user_email=view.findViewById(R.id.user_email);
        user_mobile=view.findViewById(R.id.user_mobile);
        btn_add_user=view.findViewById(R.id.btn_add_user);

        try {
            myAppDatabase = Room.databaseBuilder(getActivity(), MyAppDatabase.class, "userdb").allowMainThreadQueries()
                    .build();
        }catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

        try {
            btn_add_user.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //Getting The Data
                    int userid = Integer.parseInt(user_id.getText().toString().trim());
                    String username = user_name.getText().toString().trim();
                    String useremail = user_email.getText().toString().trim();
                    String usermobile = user_mobile.getText().toString().trim();

                    //Adding the information in Database
                    // Creating object of Entity class

                    User user = new User();
                    user.setId(userid);
                    user.setName(username);
                    user.setEmail(useremail);
                    user.setMobile(usermobile);

                    // Saving the data into the database
                    myAppDatabase.myDao().addUser(user);

                    Toast.makeText(getActivity(), "User data saved with id :" + userid, Toast.LENGTH_SHORT).show();
                    user_id.setText("");
                    user_name.setText("");
                    user_email.setText("");
                    user_mobile.setText("");

                }
            });
        }
        catch (Exception e){
            Toast.makeText(getActivity(),e.getMessage().toString(),Toast.LENGTH_LONG).show();
        }

        return view;
    }

}