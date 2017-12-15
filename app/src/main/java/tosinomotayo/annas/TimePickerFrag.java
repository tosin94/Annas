package tosinomotayo.annas;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by tosinomotayo on 19/10/2017.
 */

public class TimePickerFrag extends DialogFragment implements TimePickerDialog.OnTimeSetListener
{
    TimeHasChanged listener;
    private final Calendar c  = Calendar.getInstance();

    public interface TimeHasChanged
    {
        void TimeChangedListener(Calendar c);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        int hour,minute;
        hour = this.c.get(Calendar.HOUR_OF_DAY);
        minute = this.c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute,true);
        //"this" is saying the listener is in ths class (I could have made it
        //the hairappointment class if i wanted, all i had to do was make it an enclosing class
        //instead i am using interfaces to implement the listener so i can send info to the parent activity, this is why i have overrided
        //onAttach() )

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        try
        {
            listener = (TimeHasChanged)context;
        }

        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement TimeHasChanged Listener");

        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
    {
        this.c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        this.c.set(Calendar.MINUTE,minute);
        listener.TimeChangedListener(this.c);

    }
}
