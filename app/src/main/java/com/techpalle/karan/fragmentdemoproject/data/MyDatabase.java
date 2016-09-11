package com.techpalle.karan.fragmentdemoproject.data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import com.techpalle.karan.fragmentdemoproject.data.PalleTechContract.UsersEntry;
import com.techpalle.karan.fragmentdemoproject.model.User;


public class MyDatabase {

    private SQLiteDatabase database;
    private DatabaseNameDbHelper helper;

    public MyDatabase(Context context) {
        helper = new DatabaseNameDbHelper(context);
    }

    private SQLiteDatabase openReadableDatabaseInstance() {
        return helper.getReadableDatabase();
    }

    private SQLiteDatabase openWritableDatabaseInstance() {
        return helper.getWritableDatabase();
    }

    private void closeDatabaseConnection() {
        database.close();
        helper.close();
    }



    public long updateUsers(long id, String username, int password){

        database = openWritableDatabaseInstance();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersEntry.COLUMN_USER_NAME, username);
        contentValues.put(UsersEntry.COLUMN_PASSWORD, password);


        String selection = UsersEntry._ID +" = ? ";
        String[] selectionArgs = {String.valueOf(id)};

        long value = database.update(UsersEntry.TABLE_NAME, contentValues, selection, selectionArgs);
        closeDatabaseConnection();

        return value;
    }


    public long deleteAllUserDetails() {
        database = openWritableDatabaseInstance();

        long l= database.delete(UsersEntry.TABLE_NAME, null, null);

        closeDatabaseConnection();

        return l;
    }

    public ArrayList<User> getUsersInArrayList() {
        database = openReadableDatabaseInstance();

        Cursor c =  database.query(UsersEntry.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<User> arrayListUsers = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                User user = new User(c.getInt(c.getColumnIndex(UsersEntry._ID)),
                        c.getString(c.getColumnIndex(UsersEntry.COLUMN_USER_NAME)),
                        c.getString(c.getColumnIndex(UsersEntry.COLUMN_PASSWORD)));
                arrayListUsers.add(user);
            }while (c.moveToNext());
        }
        closeDatabaseConnection();

        return arrayListUsers;
    }

    public boolean validateUser(String username, String password){

        database = openReadableDatabaseInstance();

        String[] projections = {UsersEntry._ID};
        String selection = UsersEntry.COLUMN_USER_NAME+ " = ? AND "+ UsersEntry.COLUMN_PASSWORD+ " = ?";
        String[] selectionArgs = {username, password};

        Cursor c = database.query(UsersEntry.TABLE_NAME, projections, selection, selectionArgs, null, null, null);

        boolean userExists;

        if(c!=null)
            userExists = true;
        else
            userExists= false;

        closeDatabaseConnection();

        return userExists;
    }

    public boolean checkIfUserExists(String username){

        database = openReadableDatabaseInstance();

        String[] projections = {UsersEntry._ID};
        String selection = UsersEntry.COLUMN_USER_NAME+ " = ? ";
        String[] selectionArgs = {username};

        Cursor c = database.query(UsersEntry.TABLE_NAME, projections, selection, selectionArgs, null, null, null);

        boolean userExists;

        if(c!=null)
            userExists = true;
        else
            userExists= false;

        closeDatabaseConnection();

        return userExists;
    }



    public long createRowUsersDetails(String username, String password) {

        database = openWritableDatabaseInstance();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UsersEntry.COLUMN_PASSWORD, username);
        contentValues.put(UsersEntry.COLUMN_USER_NAME, password);
        long value = database.insert(UsersEntry.TABLE_NAME, null, contentValues);

        closeDatabaseConnection();

        return value;

    }

    private class DatabaseNameDbHelper extends SQLiteOpenHelper {

        //region SQL Statements
        private final String SQL_CREATE_USERS_TABLE = "CREATE TABLE " + UsersEntry.TABLE_NAME + "("
                + UsersEntry._ID + " INTEGER PRIMARY KEY, "
                + UsersEntry.COLUMN_USER_NAME + " TEXT NOT NULL, "
                + UsersEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";

        private static final String SQL_DROP_USERS_TABLE = "DROP TABLE " + UsersEntry.TABLE_NAME + ";";
        //endregion

        private static final String DATABASE_NAME = "PalleTech.db";

        private static final int DATABASE_VERSION = 1;

        public DatabaseNameDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_USERS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (newVersion > oldVersion) {
                db.execSQL(SQL_DROP_USERS_TABLE);
                onCreate(db);
            }
        }
    }


}
