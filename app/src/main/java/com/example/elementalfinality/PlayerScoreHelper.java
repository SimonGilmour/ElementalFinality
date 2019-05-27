package com.example.elementalfinality;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlayerScoreHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "score.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "ScoreBoard";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String SCORE = "score";

    public SQLiteDatabase sqlBase;

    public PlayerScoreHelper(Context obContext)
    {
        super(obContext, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String sCreate = "CREATE TABLE " +
                TABLE_NAME + "(" +
                ID + "integer primary key autoincrement, " +
                NAME + "String not null, " +
                SCORE + "int not null);";

        sqLiteDatabase.execSQL(sCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME); //delete the table
        onCreate(sqLiteDatabase); //recreate that table
    }

    public void onOpen()  throws SQLException
    {
        sqlBase = this.getWritableDatabase();
    }

    public void close()
    {
        sqlBase.close();
    }

    public long createScore(PlayerScore score)
    {
        ContentValues cvs = new ContentValues();

        cvs.put("NAME", score.name);
        cvs.put("SCORE", score.score);

        long autoid = sqlBase.insert(TABLE_NAME, null, cvs);
        score.id = autoid;
        return autoid;
    }

}
