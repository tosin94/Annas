package tosinomotayo.annas;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import tosinomotayo.annas.DB.AppDatabase;
import tosinomotayo.annas.DB.Hair;
import tosinomotayo.annas.DB.utils.DatabaseInitializer;

/**
 * Created by tosinomotayo on 26/04/2018.
 */

public class TestDBModel extends AndroidViewModel
{
    private AppDatabase DB;
    private LiveData<String> result;

    public TestDBModel(@NonNull Application application)
    {
        super(application);
    }

    public void createDB()
    {
        DB = AppDatabase.getDatebaseBuilder(this.getApplication());
        DatabaseInitializer.PopulateAsync(DB);
        SubscribeUItoDBchanges();
    }

    public LiveData<String> getResult()
    {
        return result;
    }

    private void SubscribeUItoDBchanges()
    {
        LiveData<List<Hair>> info = DB.hairModel().LoadHairInfo("PB194");

        result = Transformations.map(info, new Function<List<Hair>, String>()
        {
            @Override
            public String apply(List<Hair> input)
            {
                StringBuilder sb = new StringBuilder();

                for (Hair hair: input)
                {
                    sb.append(String.format(Locale.UK,"%s, %f, %s \n",hair.name, hair.price, hair.details));
                }
                return sb.toString();
            }
        });


    }
}
