package tosinomotayo.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import tosinomotayo.DB.DatabaseContract.DB_entry.*;

/**
 * Created by Sam.omotayo on 19/09/2017.
 */

public class AppDatabase extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "APP_DB";
    private static final int DATABASE_VERSION = 1;


    public AppDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

}
