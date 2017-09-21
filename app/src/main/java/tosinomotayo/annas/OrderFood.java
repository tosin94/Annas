package tosinomotayo.annas;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tosinomotayo on 27/08/2017.
 */

public class OrderFood extends AppCompatActivity
{
    private ArrayList<String> textList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);

        textList.add("main");
        textList.add("desert");
        textList.add("drinks");
        textList.add( "hello");
        textList.add("main");
        textList.add("desert");
        textList.add("drinks");
        textList.add( "hello");
        textList.add("main");
        textList.add("desert");
        textList.add("drinks");
        textList.add( "hello");
        textList.add("main");
        textList.add("desert");
        textList.add("drinks");
        textList.add( "hello");

        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.order_recycler);
        myRecyclerView.setAdapter(new CustomAdapter(this));
        myRecyclerView.setLayoutManager(layout);

    }


    //#######################################################
    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        public myViewHolder(View itemView)
        {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.orderTextView);

            textView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {


                }
            });
        }
    }
    //##############################################################

    class CustomAdapter extends RecyclerView.Adapter<myViewHolder>
    {
        private LayoutInflater inflater = getLayoutInflater();
        private Context context;

        public CustomAdapter(Context ctx)
        {
            this.context = ctx;
        }

        @Override
        public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView = inflater.inflate(R.layout.order_content,parent,false);

            return new myViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(myViewHolder holder, int position)
        {
            String textItem = textList.get(position);
            holder.textView.setText(textItem);

        }

        @Override
        public int getItemCount()
        {
            return textList.size();
        }
    }
}
