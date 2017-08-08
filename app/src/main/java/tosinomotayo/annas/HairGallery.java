package tosinomotayo.annas;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);

        //set GridView Parameters
        GridView gallery = (GridView) findViewById(R.id.grid_gallery);
        gallery.setAdapter(new ImageAdapter(this));//sets the data behind the gridView
        //also corresponds to class ImageAdapter below

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {//defining the inner class i will be using
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //a Toast is a view containing a quick little message for the user
                //Toast.makeText(HairGallery.this, "", Toast.LENGTH_SHORT).show(); //here no message is being specified
                /////////// or ///////////////////////////////////////////////////////////////////////////////////////////////////////
                //                                                                                                                  //
                //Toast.makeText(HairGallery.this, "" + position, Toast.LENGTH_SHORT).show();//to show the identifier for the image///
                // Or just dont have a Toast.makeText() callback                                                                                                                 //
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //zoomImage(position);

                Intent i = new Intent(HairGallery.this, EnlargeGalleryImage.class);
                i.putExtra("image", position);
                i.putExtra("array",mThumbIds);
                startActivity(i);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//to allow up navigation
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //when nav button is clicked, a call to onOptionsItemSelected() is made

    }

    class ImageAdapter extends BaseAdapter{//source of items to be displayed on the grid

        private Context mContext;

        public ImageAdapter(Context c){
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


            if(convertView == null){

                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
            }
    }

    /*@Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }//to ensure back button is working*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {//"android.R.id.home" is thw action for back navigation
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
        //cam use above code to set back navigation on toolbar to take you back
    }

    public void zoomImage(int image){
        final ImageView holder = (ImageView) findViewById(R.id.image_enlarge);// receive image holder
        holder.setImageResource(mThumbIds[image]); //sets the image

        //calculations
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        //thumbView.getGlobalVisibleRect(startBounds);
        findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset); //this is the frame layout in fragment_layout
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);


        float startScale;
        if ((float) finalBounds.width() / finalBounds.height() >(float) startBounds.width() / startBounds.height())
        {

            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        }
        else{

            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight =startScale *finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height())/2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;

        }

        //thumbView.setAlpha(0f);
        holder.setVisibility(View.VISIBLE);

        holder.setPivotX(0f);
        holder.setPivotY(0f);

        //to zoom back out


    }


}

