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
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tosinomotayo on 27/08/2017.
 */

public class OrderFood extends AppCompatActivity
{

    private ArrayList<Object> textList = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);

        textList.add(new Model(Model.image_type,R.drawable.icon));
        textList.add(new Model(Model.text_type,"Main"));
        textList.add(new Model(Model.text_type,"drinks"));
        textList.add(new Model(Model.text_type, "hello"));
        textList.add(new Model(Model.text_type,"Desert"));
        textList.add(new Model(Model.text_type,"Main"));
        textList.add(new Model(Model.text_type,"drinks"));
        textList.add(new Model(Model.text_type, "hello"));
        textList.add(new Model(Model.text_type,"Desert"));
        textList.add(new Model(Model.text_type,"Main"));
        textList.add(new Model(Model.text_type,"drinks"));
        textList.add(new Model(Model.text_type, "hello"));
        textList.add(new Model(Model.text_type,"Desert"));
        textList.add(new Model(Model.text_type,"Main"));
        textList.add(new Model(Model.text_type,"drinks"));
        textList.add(new Model(Model.text_type, "hello"));
        textList.add(new Model(Model.text_type,"Desert"));


        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);

        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.order_recycler);
        myRecyclerView.setAdapter(new CustomAdapter(this,textList));
        myRecyclerView.setLayoutManager(layout);

    }


    class CustomAdapter extends RecyclerView.Adapter
    {
        private ArrayList<Object> data = new ArrayList();
        private LayoutInflater inflater = getLayoutInflater();
        private Context context;

        public CustomAdapter(Context ctx, ArrayList<Object> textList)
        {
            this.data = textList;
            this.context = ctx;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View itemView;
            switch (viewType)
            {
                case Model.text_type:
                    itemView = inflater.inflate(R.layout.text_view_order,parent,false);
                    return new TextViewHolder(itemView);

                case Model.image_type:
                    itemView = inflater.inflate(R.layout.image_view_order,parent,false);
                    return new ImageViewHolder(itemView);
            }

            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
        {
            Model object = (Model)data.get(position);
            if ( object != null)
            {
                switch ( object.type)
                {
                    case Model.image_type:
                        ((ImageViewHolder) holder).image.setImageResource(object.data);
                        ((ImageViewHolder) holder).image.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Toast.makeText(OrderFood.this,"you have clicked " + ((Model) data.get(position)).data,Toast.LENGTH_SHORT).show();

                            }
                        });
                        break;

                    case Model.text_type:
                        ((TextViewHolder) holder).textView.setText(object.text);
                        ((TextViewHolder) holder).textView.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                Toast.makeText(OrderFood.this,"you have clicked: " + ((Model) data.get(position)).text,Toast.LENGTH_SHORT).show();
                            }
                        });
                        break;
                }
            }
        }

        @Override
        public int getItemCount()
        {
            return data.size();
        }

        @Override
        public int getItemViewType(int position)
        {
            Model object = (Model)data.get(position);
            switch(object.type)
            {
                case Model.image_type:
                    return Model.image_type;

                case Model.text_type:
                    return Model.text_type;
            }
            return super.getItemViewType(position);
        }

        //#######################################################
        //              TextView Holder
        //#######################################################
        class TextViewHolder extends RecyclerView.ViewHolder
        {
            TextView textView;

            public TextViewHolder(View itemView)
            {
                super(itemView);
                this.textView = (TextView) itemView.findViewById(R.id.orderTextView);

            }
        }
        //##############################################################
        //                  TextView Holder
        //##############################################################

        //#######################################################
        //              ImageView Holder
        //#######################################################
        class ImageViewHolder extends RecyclerView.ViewHolder
        {
            ImageView image;

            public ImageViewHolder(View itemView)
            {
                super(itemView);
                this.image = (ImageView) itemView.findViewById(R.id.recycler_image);

            }
        }
        //#######################################################
        //              ImageView Holder
        //#######################################################

    }


}
