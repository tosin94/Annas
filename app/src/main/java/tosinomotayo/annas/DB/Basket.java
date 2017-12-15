package tosinomotayo.annas.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tosinomotayo on 04/12/2017.
 */

@Entity(foreignKeys =
        {
                @ForeignKey(entity = Hair.class,
                parentColumns = "ID",
                childColumns = "hair_id")

        })


public class Basket
{
    public @PrimaryKey String id;

    @ColumnInfo(name = "hair_id")
    public String hairID;

}
