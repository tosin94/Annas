package tosinomotayo.annas.DB;

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
        e.g import tosinomotayo.annas.DB.DatabaseContract.DB_entry.* (this import statement will be in the AppDatabase file)
        */
        public static final String create_tables =

                "CREATE TABLE Hair(" +

                        "ImageID    INT             NOT NULL," +
                        "ImageName  VARCHAR(30)     NOT NULL," +
                        "ImagePic   VARBINARY(MAX)  NOT NULL," +
                        "H_Price    FLOAT           NOT NULL," +

                        "PRIMARY KEY(ImageID));"
                +

                "CREATE TABLE Food(" +

                        "FoodID     INT             NOT NULL,   " +
                        "FoodName   VARCHAR(30)     NOT NULL,   " +
                        "FoodPic    VARBINARY(MAX)  NOT NULL,   " +
                        "F_Price    FLOAT           NOT NULL,   " +

                        "PRIMARY KEY(FoodID));"
                +

                "CREATE TABLE PendingOrders(" +

                        "OrderID            INT             NOT NULL,   " +
                        "ImageID            INT             NULL,       " +
                        "FoodID             INT             NULL,       " +
                        "F_Quantity         INT             NOT NULL,   " +
                        "CustomerID         VARCHAR(20)     NOT NULL,   " +
                        "Appointment        BIT             NOT NULL,   " +
                        "Appointment_Time   DATE            NOT NULL,   " +
                        "Appointment_Venue  VARCHAR(100)    NOT NULL,   " +
                        "Total_Price        FLOAT           NOT NULL,   " +

                        "FOREIGN KEY(ImageId) REFERENCES Hair(ImageId), " +
                        "FOREIGN KEY(FoodId) REFERENCES Food(FoodId),   " +
                        "PRIMARY KEY(OrderID, CustomerID));             "
                +

                "CREATE TABLE FulfilledOrders(" +

                        "OrderID    INT         NOT NULL,   " +
                        "CustomerID VARCHAR(20) NOT NULL,   " +

                        "FOREIGN KEY(OrderId, CustomerID) references PendingOrders(OrderID, CustomerID));"

        ;//SCRIPT_END

    }

}
