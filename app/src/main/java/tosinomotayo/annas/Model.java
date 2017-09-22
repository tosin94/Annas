package tosinomotayo.annas;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Sam.omotayo on 22/09/2017.
 */

public class Model
{
    public int
            type,
            data;

    public String text;

    public final static int
            image_type = 0,
            text_type = 1;


    public Model(int type, String text)
    {
        this.type = type;
        this.text = text;
    }

    public Model (int type,int data) //for the start
    {
        this.type = type;
        this.data = data;
    }

}
