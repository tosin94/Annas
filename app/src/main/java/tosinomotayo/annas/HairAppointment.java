package tosinomotayo.annas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tosinomotayo on 06/10/2017.
 */

public class HairAppointment extends AppCompatActivity implements DatePickerFrag.DateHasChanged,TimePickerFrag.TimeHasChanged
{
    Calendar date,time;
    String chosenTime;

    @Override
    public void TimeChangedListener(Calendar calendar)
    {
        time = calendar;
        EditText selcetedTime = (EditText)findViewById(R.id.selectedTime);
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int minute = time.get(Calendar.MINUTE);

        if ( hour >= 12)
            chosenTime = hour + ":" + minute + "pm";

        else
            chosenTime = hour + ":" + minute + "am";

        selcetedTime.setText(chosenTime);

    }

    @Override
    public void refreshDate(Calendar calendar)
    {
        //basically acts as a listener for the date set action
        this.date = calendar;

        EditText chosenDate = (EditText) findViewById(R.id.chosenDate);
        String dateFormat = "dd/MM/yy";

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        chosenDate.setText(format.format(this.date.getTime()));

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

    public void ShowTimePicker(View v )
    {
        DialogFragment timePicker = new TimePickerFrag();
        timePicker.show(getSupportFragmentManager(),"TimePicker");

    }
    
}
