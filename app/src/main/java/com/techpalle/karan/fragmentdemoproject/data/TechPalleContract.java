package com.techpalle.karan.fragmentdemoproject.data;

import android.provider.BaseColumns;


public final class TechPalleContract {

    private TechPalleContract(){

    }

    public static final class UserCredentialsEntry implements BaseColumns {
        public static final String TABLE_NAME = "user_credentials";
        public static final String COLUMN_USERNAME = "column_username";
        public static final String COLUMN_PASSWORD = "column_password";
    }
}