package sg.edu.np.mad.madapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class MyDBHandler extends SQLiteOpenHelper {

    private static MyDBHandler mInstance;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserDB.db";
    public static final String TABLE_USERS = "Users";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "UserName";
    public static final String COLUMN_DESCRIPTION = "Description";
    public static final String COLUMN_FOLLOWED = "Followed";
    private Context mCxt;
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) { // DO NOT COPY FROM POWERPOINT, JUST TYPE IT OUT U LAZY ASS
        Log.v("created db", "on create reached!");
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USERS + "(" + COLUMN_NAME + " TEXT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_FOLLOWED + " TEXT, " + COLUMN_ID + " INTEGER PRIMARY KEY )";
        db.execSQL(CREATE_USER_TABLE);
        addUser(db, new user("Reiner", "Student",1, false));
        addUser(db, new user("Luna", "Staff", 2,false));
        addUser(db, new user("Josef", "Admin",3, true));
        addUser(db, new user("Jeff", "Lecturer", 4,true));
        addUser(db, new user("David", "Student", 5,false));
        addUser(db, new user("ghost", "Student", 6,false));
        addUser(db, new user("Hazard", "Admin", 7,false));
        addUser(db, new user("Sonya", "Student",8, true));
        addUser(db, new user("Apple", "Staff",9, false));
        addUser(db, new user("Fason", "Student",10, true));
        addUser(db, new user("Mitch", "Lecturer",11, true));
        addUser(db, new user("Ern", "Lecturer",12, true));
        addUser(db, new user("Lam", "Staff",13, false));
        addUser(db, new user("Ed", "Student",14, true));
        addUser(db, new user("Ted", "Admin", 15,false));
        addUser(db, new user("Mary", "Student",16, false));
        addUser(db, new user("Blade", "Student",17, false));
        addUser(db, new user("Hale", "Staff",18, false));
        addUser(db, new user("raze", "Student",19, false));
        addUser(db, new user("Galde", "Staff",20, false));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(SQLiteDatabase db, user user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, user.getName());
        values.put(COLUMN_DESCRIPTION, user.getDescription());
        boolean followed = user.isFollowed();
        String followed_string = String.valueOf(followed);
        values.put(COLUMN_FOLLOWED, followed_string);
    
        db.insert(TABLE_USERS, null, values);

        //SQLiteDatabase db = this.getWritableDatabase(); // get sqlitedatabase instance

    }

    public ArrayList<user> getUser() {
        ArrayList<user> userlist = new ArrayList<user>();
        SQLiteDatabase db = this.getReadableDatabase();
        for (int i = 0; i < 20; i++) {
            String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_ID + "== " + i;

            Cursor cursor = db.rawQuery(query, null);
            user user = new user();
            if (cursor.moveToFirst()) {
                user.setName(cursor.getString(0));
                user.setDescription(cursor.getString(1));
                user.setFollowed(Boolean.parseBoolean(cursor.getString(2)));
                user.setId(Integer.parseInt(cursor.getString(3)));
                cursor.close();
                userlist.add(user);
            }
            else {
                user = null;
            }
            cursor.close();
        }
        db.close();
        return userlist;
    }

    public void updateUser(user user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues update_values = new ContentValues();
        update_values.put(COLUMN_FOLLOWED,String.valueOf(!user.isFollowed()));
        db.update(TABLE_USERS, update_values, COLUMN_ID + " = " + user.getId(), null );
        db.close();
    }
    public static MyDBHandler getInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new MyDBHandler(ctx.getApplicationContext());
            Log.v("Instance", String.valueOf(mInstance));
        }
        return mInstance;
    }


    private MyDBHandler(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
        this.mCxt = ctx;
    }



}




