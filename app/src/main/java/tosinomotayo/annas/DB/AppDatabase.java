package tosinomotayo.annas.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Sam.omotayo on 19/09/2017.
 */

@Database(entities = {Hair.class, Basket.class},version = 1)
public abstract class AppDatabase extends RoomDatabase
{
    public static AppDatabase INSTANCE;

    public abstract BasketDao basketModel();
    public abstract HairDao hairModel();
    public abstract BookingsDao bookingModel();


    public static AppDatabase getDatebaseBuilder(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"App_DB").build();
        }
        return INSTANCE;
    }


    public static void destroyInstance()
    {
        INSTANCE = null;
    }

}
