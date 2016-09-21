package com.techpalle.karan.fragmentdemoproject.data;

/**
 * Created by ADMIN on 9/17/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.techpalle.karan.fragmentdemoproject.data.TechPalleContract.UserCredentialsEntry;


public class MyDatabase {

    private SQLiteDatabase database;
    private TechPalleDbHelper helper;

    public MyDatabase(Context context) {
        helper = new TechPalleDbHelper(context);
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



   /* public long updateTableName(long id, String column1, int column2){

        database = openWritableDatabaseInstance();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TableNameEntry.COLUMN_1_NAME, column1);
        contentValues.put(TableNameEntry.COLUMN_2_NAME, column2);


        String selection = TableNameEntry._ID +" = ? ";
        String[] selectionArgs = {String.valueOf(id)};

        long value = database.update(TableNameEntry.TABLE_NAME, contentValues, selection, selectionArgs);
        closeDatabaseConnection();

        return value;
    }*/


    /*public long deleteAllTableDetails() {
        database = openWritableDatabaseInstance();

        long l= database.delete(TableNameEntry.TABLE_NAME, null, null);

        closeDatabaseConnection();

        return l;
    }*/

    /*public ArrayList<Table> getTableDataInArrayList() {
        database = openReadableDatabaseInstance();

        Cursor c =  database.query(TableNameEntry.TABLE_NAME, null, null, null, null, null, null);

        ArrayList<Table> arrayListTables = new ArrayList<>();

        if(c.moveToFirst()){
            do{
                //String stringDate = Utils.SIMPLE_DATE_FORMAT.format(date.getTime());
                Table table = new Table(c.getInt(c.getColumnIndex(TableNameEntry._ID)),
                        c.getString(c.getColumnIndex(TableNameEntry.COLUMN_1_NAME)),
                        c.getInt(c.getColumnIndex(TableNameEntry.COLUMN_2_NAME)));
                arrayListTables.add(table);
            }while (c.moveToNext());
        }
        closeDatabaseConnection();

        return arrayListTables;
    }*/

    public boolean checkIfUsernameAndPasswordExist(String username, String password){
        database = openReadableDatabaseInstance();

        String selection = UserCredentialsEntry.COLUMN_USERNAME +" = ? AND "+UserCredentialsEntry.COLUMN_PASSWORD +" = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = database.query(UserCredentialsEntry.TABLE_NAME, null, selection,
                selectionArgs, null, null, null);

        boolean userExists = false;

        if(cursor.moveToFirst()){
            userExists = true;
        } else {
            userExists = false;
        }

        closeDatabaseConnection();

        return userExists;
    }

    public boolean checkIfUsernameExists(String username){
        database = openReadableDatabaseInstance();

        String selection = UserCredentialsEntry.COLUMN_USERNAME +" = ?";
        String[] selectionArgs = {username};

        Cursor cursor = database.query(UserCredentialsEntry.TABLE_NAME, null, selection,
                selectionArgs, null, null, null);

        boolean userExists = false;

        if(cursor.moveToFirst()){
            userExists = true;
        } else {
            userExists = false;
        }

        closeDatabaseConnection();

        return userExists;
    }



    public long createUserCredentials(String username, String password) {

        database = openWritableDatabaseInstance();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserCredentialsEntry.COLUMN_USERNAME, username);
        contentValues.put(UserCredentialsEntry.COLUMN_PASSWORD, password);
        long value = database.insert(UserCredentialsEntry.TABLE_NAME, null, contentValues);

        closeDatabaseConnection();

        return value;

    }

    private class TechPalleDbHelper extends SQLiteOpenHelper {

        //region SQL Statements
        private static final String SQL_CREATE_USER_CREDENTIALS_TABLE = "CREATE TABLE " + UserCredentialsEntry.TABLE_NAME + "("
                + UserCredentialsEntry._ID + " INTEGER PRIMARY KEY, "
                + UserCredentialsEntry.COLUMN_USERNAME + " TEXT NOT NULL, "
                + UserCredentialsEntry.COLUMN_PASSWORD + " TEXT NOT NULL);";

        private static final String SQL_DROP_USER_CREDENTIALS_TABLE = "DROP TABLE " + UserCredentialsEntry.TABLE_NAME + ";";
        //endregion

        private static final String DATABASE_NAME = "TechPalle.db";

        private static final int DATABASE_VERSION = 1;

        public TechPalleDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_USER_CREDENTIALS_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (newVersion > oldVersion) {
                db.execSQL(SQL_DROP_USER_CREDENTIALS_TABLE);
                onCreate(db);
            }
        }
    }


}
