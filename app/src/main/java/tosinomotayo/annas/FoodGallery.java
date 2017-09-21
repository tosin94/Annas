package tosinomotayo.annas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by tosinomotayo on 16/08/2017.
 */

public class FoodGallery extends AppCompatActivity
{
    //TODO lock the on long click to just one item or disable long click in its entirety if it does not work

    ActionMode actionMode;


    private static int[] images = {R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };//TODO REMOVE THIS AND PULL DATA FROM THE DATBASE INSTEAD (FOR THE FUTURE)

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_layout);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.food_toolbar);
        setSupportActionBar(toolbar);

        final GridView gallery = (GridView) findViewById(R.id.food_grid);
        gallery.setAdapter(new F_adapter(this));//making the context the foodGallery activity

        // add back arrow to toolbar
        if (getSupportActionBar() != null)
        {//if its active
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//to allow up navigation
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } //when nav button is clicked, a call to onOptionsItemSelected() is made


        gallery.setClickable(true);
        gallery.setLongClickable(true);

        //gallery.setChoiceMode(GridView.CHOICE_MODE_SINGLE);
        gallery.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                view.setSelected(true);
                if (actionMode != null) {//basically if actionMode is active then do nothing
                    return false;
                }

                actionMode = FoodGallery.this.startActionMode(modeCallback);
                return true;
            }
        });

        //enlarge image when its is clicked
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent i = new Intent(FoodGallery.this, EnlargeGalleryImage.class);
                i.putExtra("image", position);
                i.putExtra("array", images);
                startActivity(i);
            }
        });
    }




    //implementing handler for contextual toolbar

    private ActionMode.Callback modeCallback = new ActionMode.Callback()
    {//startActionMode() calls this interface

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu)
        {
            mode.getMenuInflater().inflate(R.menu.context_menu_gallery,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu)
        {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item)
        {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode)
        {
            actionMode = null;

        }
    };

    class F_adapter extends BaseAdapter
    {
        private Context context;


        public F_adapter(Context c)
        {

            context = c;
        }

        @Override
        public int getCount()
        {

            return images.length;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

            ImageView imageView;
            Point outSize = new Point();

            if(convertView == null) {

                imageView = new ImageView(context);

                Display display = getWindowManager().getDefaultDisplay();//using window manager because this is a request from the activity context
                display.getSize(outSize);
                int width = ( outSize.x ) * 20/100;
                int height = ( outSize.y ) * 20/100;

                imageView.setLayoutParams(new GridView.LayoutParams(width, height));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            else{
                imageView = (ImageView)convertView;
            }
            imageView.setImageResource(images[position]);
            return imageView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.gallery_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch(id)
        {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
