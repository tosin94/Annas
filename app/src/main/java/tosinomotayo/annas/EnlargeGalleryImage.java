package tosinomotayo.annas;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnlargeGalleryImage extends FragmentActivity {
    private static Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_layout);



        int image_ref = getIntent().getIntExtra("image_ref",R.drawable.error);
        //ImageView image = (ImageView) findViewById(R.id.thumb_btn);
        //image.setImageResource(mThumbIds[6]);

        //final View thumbView = findViewById(R.id.thumb_btn);
        //zoomImage(gallery, mThumbIds[image_ref]);
        //might not have even needed a fragment
    }

    class ImageAdapter extends BaseAdapter {//source of items to be displayed on the grid
        int image_ref = getIntent().getIntExtra("image_ref",R.drawable.error);


        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }


        @Override
        public int getCount() {
            return 1;
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

            imageView = (ImageView) findViewById(R.id.image_enlarge);

            imageView.setImageResource(mThumbIds[1]);
            return imageView;
        }
    }

    /*public void zoomImage(View thumbView, int image){
        final ImageView holder = (ImageView) findViewById(R.id.image_enlarge);// receive image holder
        holder.setImageResource(mThumbIds[image]); //sets the image

        //calculations
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        thumbView.getGlobalVisibleRect(startBounds);
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

        thumbView.setAlpha(0f);
        holder.setVisibility(View.VISIBLE);

        holder.setPivotX(0f);
        holder.setPivotY(0f);

        //to zoom back out


    }*/


}

