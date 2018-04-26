package tosinomotayo.annas.DB;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by tosinomotayo on 01/12/2017.
 */


@Dao
public interface HairDao
{

    @Query("select * from Hair where ID = :id")
    LiveData<List<Hair>>LoadHairInfo(String id);

    @Query("delete from Hair")
    void deleteALl();

    @Insert(onConflict = IGNORE)
    void InsertHair(Hair hair);



}
