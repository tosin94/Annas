package tosinomotayo.annas.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Sam.omotayo on 19/09/2017.
 */

@Database(entities = {Hair.class, Basket.class},version = 1)
public abstract AppDatabase extends RoomDatabase
{
    public static AppDatabase INSTANCE;

    public abstract BasketDao basketModel();

}
