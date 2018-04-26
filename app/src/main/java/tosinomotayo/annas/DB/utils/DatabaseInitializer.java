package tosinomotayo.annas.DB.utils;

import tosinomotayo.annas.DB.AppDatabase;
import tosinomotayo.annas.DB.Hair;

import android.os.AsyncTask;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tosinomotayo on 08/02/2018.
 */

//initialise Database with test data

public class DatabaseInitializer
{

    public static void PopulateAsync(final AppDatabase db)
    {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    private static void populateTestData(AppDatabase db)
    {
        //db.bookingModel().deleteAll();
        db.hairModel().deleteALl();

        Hair test = addHair(db, "PB194","Weave",67.00,"hello");


    }

    private static Hair addHair(final AppDatabase db, String id, String name, double price, String details)
    {
        Hair hair = new Hair();
        hair.id = id;
        hair.name = name;
        hair.price = price;
        hair.details = details;
        db.hairModel().InsertHair(hair);
        return hair;


    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>
    {
        private final AppDatabase MDB;

        PopulateDbAsync(AppDatabase db)
        {
            MDB = db;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            populateTestData(MDB);
            return null;
        }
    }
}
