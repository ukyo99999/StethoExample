package tw.net.ukyo.stetho;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by ukyo on 2016/6/6.
 */
public class DbHelper extends SQLiteOpenHelper {


    private static SQLiteDatabase database;


    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new DbHelper(context, Constant.SQLite_DB_Name,
                    null, Constant.SQLite_DB_VERSION).getWritableDatabase();
        }

        return database;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String DATABASE_CREATE_TABLE_NEWS =
                "create table " + Constant.SQLite_Table + "("
                        + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + Constant.COLUMN1 + " TEXT,"
                        + Constant.COLUMN2 + " TEXT"
                        + ")";


        db.execSQL(DATABASE_CREATE_TABLE_NEWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
