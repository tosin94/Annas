package tosinomotayo.annas;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tosinomotayo on 27/08/2017.
 */

public class OrderFood extends AppCompatActivity
{

    final String[] menu_list =
            {
                    "Mains","starters","test1","test2","test3"

            };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout); //TODO add layout file

        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.order_layout);
        myRecyclerView.setAdapter(new CustomAdapter());
    }



    class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>
    {
        //TODO define dataType that will be receiving the data

        public CustomAdapter()//this will depend on the kind of data received
        {

        }

        //#######################################################
        class CustomViewHolder extends RecyclerView.ViewHolder //responsible for the way the data is represented
        {
            public CustomViewHolder(View itemView)
            {
                super(itemView);
                View viewHolder = itemView;
            }

        }
        //##############################################################

        @Override
        public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType)// responsible for the actual data
        {
            //it is of type layout inflater
            //LayoutInflater inflater = null;

            return null;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position)
        {
            //position is the viewHolders position in Recycler view

        }

        @Override
        public int getItemCount()
        {
            //will return how many items are in the data holder ( data holder will be in constructor )
            return 0;
        }

    }
}
