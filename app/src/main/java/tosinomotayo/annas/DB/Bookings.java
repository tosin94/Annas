package tosinomotayo.annas.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by tosinomotayo on 04/12/2017.
 */

@Entity
public class Bookings
{
    public @PrimaryKey String id;

    public Date BookingDate;


}
