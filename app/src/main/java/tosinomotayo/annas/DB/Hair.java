package tosinomotayo.annas.DB;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by tosinomotayo on 04/12/2017.
 */

@Entity
public class Hair
{
    public @PrimaryKey String ID;

    public String ImageName;
    public float ImagePrice;
    public String ImagePath;

}
