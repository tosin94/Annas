package tosinomotayo.DB;

import android.provider.BaseColumns;

/**
 * Created by Sam.omotayo on 19/09/2017.
 */

public final class DatabaseContract
{

    private DatabaseContract()
    {
        // just making sure no one can instantiate from this class
    }

    public static class DB_entry implements BaseColumns
    {
        /*
        can instantiate columns here and then import all of them using the wildcard operator
        e.g import tosinomotayo.DB.DatabaseContract.DB_entry.* (this import statement will be in the AppDatabase file)
        */
        public static final String table_queries =

                "CREATE TABLE Hair(" +
                "ImageID INT, NOT NULL," +
                "ImageName  VARCHAR(30)     NOT NULL," +
                "ImagePic   VARBINARY(MAX)  NOT NULL," +
                "H_Price    FLOAT           NOT NULL," +

                "PRIMARY KEY(ImageID));" +

                "CREATE TABLE Food(" +
                ""
    }



}
