package tosinomotayo.annas.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by tosinomotayo on 04/12/2017.
 */

@Entity
public class Hair
{
    public @NonNull @PrimaryKey String id;

    public String name;
    public double price;
    public String details;

}
