package com.techpalle.karan.fragmentdemoproject.data;


import android.provider.BaseColumns;


public final class PalleTechContract {

    private PalleTechContract(){

    }

    public static final class UsersEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_USER_NAME = "username";
        public static final String COLUMN_PASSWORD = "password";
    }
}
