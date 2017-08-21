package tosinomotayo.annas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by tosinomotayo on 06/08/2017.
 */

public class HairGallery extends AppCompatActivity {
    private static int[] mThumbIds = {//original definition was Integer[] but "int []" also works and helps with sending the intent.
            //not quite sure yet why Integer[] is prefered but use int [] for now
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };



    class ImageAdapter extends BaseAdapter {

        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {//convertView is essential to app performance in terms of memory
            ImageView imageView;


            if (convertView == null) {

                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                //imageView.setPadding(8, 8, 8, 8); not used as images could have different aspect ratios
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//to allow up navigation
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        } //when nav button is clicked, a call to onOptionsItemSelected() is made

        //set GridView Parameters
        GridView gallery = (GridView) findViewById(R.id.grid_gallery);
        gallery.setAdapter(new ImageAdapter(this));//sets the data behind the gridView
        //also corresponds to class ImageAdapter below
        gallery.setLongClickable(true);
        gallery.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);// this is for batch operations
        //TODO implement  the action mode for individual views
        //the topic is "using the contextual action mode"

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {//defining the inner class i will be using
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(HairGallery.this, EnlargeGalleryImage.class);
                i.putExtra("image", position);
                i.putExtra("array", mThumbIds);
                startActivity(i);
            }
        });

        gallery.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.context_menu_gallery,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });


    }//END ON CREATE

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gallery_menu, menu);//responsible for the MAIN.XML
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
        //can use above code to set back navigation on toolbar to take you back
    }

}

