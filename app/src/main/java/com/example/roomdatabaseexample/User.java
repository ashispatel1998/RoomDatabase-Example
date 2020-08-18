package com.example.roomdatabaseexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Table in the database
// we can also assign the table name by assigning tableName="table_name" in @Entity()
// Example :  @Entity(tableNmae="users")
@Entity
public class User {

    // 1st Column
    @PrimaryKey
    private int id;

    //2nd Column
    @ColumnInfo(name = "user_name") // column name="user_name"
    private String name;

    //3rd Column
    @ColumnInfo(name="user_email")  // Column name="user_email"
    private String email;

    //4th Column
    @ColumnInfo(name="user_mobile")  // Column name="user_mobile"
    private String mobile;

    // To access all these variables we need to add the getter and setter method
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
