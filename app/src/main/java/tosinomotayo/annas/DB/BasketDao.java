package tosinomotayo.annas.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

/**
 * Created by tosinomotayo on 04/12/2017.


@Dao
public interface BasketDao
{
    @Query("select * from Basket")
    Basket loadBasketContents();

    @Query("delete from Basket")
    void deleteAll();

}
**/