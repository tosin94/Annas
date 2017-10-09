package tosinomotayo.annas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by tosinomotayo on 06/10/2017.
 */

public class HairAppointment extends AppCompatActivity
{
    public static class DatePickerFrag extends DialogFragment
            implements DatePickerDialog.OnDateSetListener
    {

        static final Calendar c = Calendar.getInstance();

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            int year,month,day;
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),this,year,month,day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
        {
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH,month);
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        }

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

        Calendar c = DatePickerFrag.c;
        EditText chosenDate = (EditText) findViewById(R.id.chosenDate);
        String dateFormat = "dd/MM/yy";

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        chosenDate.setText(format.format(c.getTime()));

    }


}
