package tosinomotayo.annas.DB;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

/**
 * Created by tosinomotayo on 15/12/2017.


@Dao
public interface BookingsDao
{

    @Query("select * from Bookings where booking_id = :bookingID")
    Bookings LoadBooking(String id);

    @Query("delete from Bookings")
    void deleteAll();
}
**/