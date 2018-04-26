package tosinomotayo.annas.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by tosinomotayo on 04/12/2017.
 *

// todo will now change basket to only be used for food items not hair anymore
@Entity(foreignKeys =
        {
                @ForeignKey(entity = Hair.class,
                parentColumns = "ID",
                childColumns = "hair_id")

        })


public class Basket
{
    public @NonNull @PrimaryKey String id;

    @ColumnInfo(name = "hair_id")
    public String hairID;

}
**/