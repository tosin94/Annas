package tosinomotayo.annas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import tosinomotayo.annas.TestDBModel;

/**
 * Created by tosinomotayo on 26/04/2018.
 */

public class TestDBActivity extends AppCompatActivity
{
    private TextView text;
    private TestDBModel model;
    private Button LoadDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_activity);

        text = (TextView)findViewById(R.id.databaseConents);
        model = ViewModelProviders.of(this).get(TestDBModel.class);
        LoadDB = (Button)findViewById(R.id.loadData);

        populateDB();
        SubscribeUI();

    }

    private void populateDB()
    {
        model.createDB();
    }

    private void SubscribeUI()
    {
        model.getResult().observe(this, new Observer<String>()
        {
            @Override
            public void onChanged(@Nullable String s)
            {
                text.setText(s);
            }
        });
    }

    public void onLoadClicked(View view)
    {
        populateDB();
        SubscribeUI();
    }

}
