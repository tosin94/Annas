package tosinomotayo.annas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tosinomotayo on 06/10/2017.
 */

public class HairAppointment extends AppCompatActivity implements DatePickerFrag.DateHasChanged
{
    Calendar c;
    @Override
    public void refreshDate(Calendar calendar)
    {
        //basically acts as a listener for the date set action
        this.c = calendar;

        EditText chosenDate = (EditText) findViewById(R.id.chosenDate);
        String dateFormat = "dd/MM/yy";

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        chosenDate.setText(format.format(this.c.getTime()));//TODO need to find a way of making this run after the user has chosen the date
        Log.d("Date changed:", "date has first");

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hair_appointment);

    }

    public void ShowDatePicker (View v)
    {
        DialogFragment newFrag = new DatePickerFrag();
        newFrag.show(getSupportFragmentManager(),"datePicker");

    }

    public void OpenHairGallery(View v)
    {
        Intent i;
        i = new Intent(this,HairGallery.class);
        startActivity(i);

    }


    public void importFromBasket(View v)
    {

    }

}
