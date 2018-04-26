package tosinomotayo.annas;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



import java.util.ArrayList;

import tosinomotayo.annas.DB.AppDatabase;


public class EnlargeGalleryImage extends AppCompatActivity {

    final private ArrayList<Integer> basket = new ArrayList<>();
    private int[] tempImageHolder = new int[1];
    //SQLiteDatabase db;
    ContentValues values;
    //AppDatabase dbHelper  = new AppDatabase(this); //TODO remember to close the datbase in onDestroy()
    Cursor dbResults;
    String [] columns = {"image"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //db = dbHelper.getWritableDatabase();


        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//to allow up navigation
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        final int [] imageHolder = getIntent().getIntArrayExtra("array");

        zoomImage(imageHolder, 0);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.image_info:
                return true;

            case android.R.id.home:
                finish();
                return true;

            case R.id.add_basket:
                this.tempImageHolder = getIntent().getIntArrayExtra("array");
                //AddToBasket();
                this.tempImageHolder = null;
                //dbResults = db.query("BASKET",columns,)
                //Toast.makeText(EnlargeGalleryImage.this,"test "+ this.basket.get(0) + " helooooo size is" + this.basket.size(),Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.context_menu_gallery, menu);
        return true;
    }


    public void zoomImage(int [] imageHolder, int image){

        final ImageView holder = (ImageView) findViewById(R.id.image_enlarge);// receive image holder
        //holder.setImageResource(mThumbIds[image]); //sets the image
        holder.setImageResource(imageHolder[image]);

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

    /**final public void AddToBasket()
    {
        db.execSQL("insert into BASKET value("+this.tempImageHolder[0]+")");
        //this.basket.add(this.tempImageHolder[0]);
    }

    final public void AddToBasket(int pos )
    {
        db.execSQL("insert into BASKET value("+pos+")");
        //this.basket.add(pos);

    }**/

    @Override
    protected void onPause()
    {
        //TODO place code for persistence here
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        //dbHelper.close();
        super.onDestroy();
    }
}

