package tosinomotayo.annas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by tosinomotayo on 19/10/2017.
 */

public class DatePickerFrag extends DialogFragment
        implements DatePickerDialog.OnDateSetListener

{
    private Calendar c = Calendar.getInstance();
    DateHasChanged listener;

    public interface DateHasChanged
    {
        void refreshDate(Calendar calendar);
    }

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
        this.c.set(Calendar.YEAR, year);
        this.c.set(Calendar.MONTH,month);
        this.c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        listener.refreshDate(c);

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        try
        {
            listener = (DateHasChanged)context;

        }

        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement DateHasChanged Listener");
        }
    }

}

