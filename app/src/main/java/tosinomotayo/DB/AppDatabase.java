package tosinomotayo.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static tosinomotayo.DB.DatabaseContract.DB_entry.*;

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
        db.execSQL(create_tables);//create_tables is from DB_entry (using static imports so i can use the variable directly)

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
       try
       {
           //this is where i will place any modifications to the database
           //if no modification, then this method should be empty

       }
       catch(Exception ex)
       {
           //TODO add a logger that writes to a file
       }

    }

}
