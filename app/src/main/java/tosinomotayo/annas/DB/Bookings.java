package tosinomotayo.annas.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by tosinomotayo on 04/12/2017.
 */

@Entity(foreignKeys =
        {
                @ForeignKey( entity = Hair.class,
                        parentColumns = "id",
                        childColumns ="hair_id"  )
        })
public class Bookings
{
    public @NonNull @PrimaryKey String booking_id;

    public Date BookingDate;
    public String location;

    @ColumnInfo(name = "hair_id")
    public String hairID;

}
