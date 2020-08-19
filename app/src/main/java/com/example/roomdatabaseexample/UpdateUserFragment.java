package com.example.roomdatabaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUserFragment extends Fragment {

    private Button btn_update;
    private EditText txt_user_id,txt_user_name,txt_user_email,txt_user_mobile;

    public UpdateUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_update_user, container, false);

        txt_user_id=view.findViewById(R.id.update_user_id);
        txt_user_name=view.findViewById(R.id.update_user_name);
        txt_user_email=view.findViewById(R.id.update_user_email);
        txt_user_mobile=view.findViewById(R.id.update_user_mobile);
        btn_update=view.findViewById(R.id.update_btn);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=Integer.parseInt(txt_user_id.getText().toString().trim());
                String name=txt_user_name.getText().toString().trim();
                String email=txt_user_email.getText().toString().trim();
                String mobile=txt_user_mobile.getText().toString().trim();

                User user=new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setMobile(mobile);

                MainActivity.myAppDatabase.myDao().updateUser(user);

                Toast.makeText(getActivity(),"User updated with id :"+id,Toast.LENGTH_LONG).show();

                txt_user_id.setText("");
                txt_user_name.setText("");
                txt_user_email.setText("");
                txt_user_mobile.setText("");


            }
        });

        return view;
    }
}