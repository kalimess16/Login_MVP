package com.example.login_mvp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.login_mvp.R;
import com.example.login_mvp.data.model.Personal;
import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "Information.db";
    private static final int VERSION = 1;

    private static final String TABLE_NAME = "personal";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PHONE = "phone";
    private static final String ADD = "address";
    private static final String GENDER = "gender";

    private Context mContext;

    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "
                + TABLE_NAME
                + " ("
                + ID
                + " integer primary key, "
                + NAME
                + " "
                + "TEXT, "
                + PHONE
                + " TEXT, "
                + ADD
                + " TEXT, "
                + GENDER
                + " "
                + "TEXT)";
        db.execSQL(sqlQuery);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(mContext.getString(R.string.drop_table) + TABLE_NAME);
        onCreate(db);
    }

    List<Personal> getAllPersonal() {
        List<Personal> list = new ArrayList<>();
        String sqlQuery = mContext.getString(R.string.selectALL) + " " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Personal p = new Personal();
                p.setName(cursor.getString(1));
                p.setPhone(cursor.getString(2));
                p.setAdd(cursor.getString(3));
                p.setGender(cursor.getString(4));
                list.add(p);
            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return list;
    }

    void addPersonal(Personal personal) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, personal.getName());
        values.put(PHONE, personal.getPhone());
        values.put(ADD, personal.getAdd());
        values.put(GENDER, personal.getGender());

        database.insert(TABLE_NAME, null, values);
        database.close();
    }
}
