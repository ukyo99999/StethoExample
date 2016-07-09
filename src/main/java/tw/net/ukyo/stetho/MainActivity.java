package tw.net.ukyo.stetho;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;// 資料庫物件
    private boolean isFirstLaunch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DbHelper.getDatabase(this);

        addSharedPreference();
        addSqlite();

    }

    /**
     * 加入SharedPreference資料
     */
    private void addSharedPreference() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(
                Constant.SP_NAME, Context.MODE_PRIVATE);

        try {
            sharedPreferences
                    .edit()
                    .putBoolean(Constant.SP_KEY_FIRST_LAUNCH, isFirstLaunch)
                    .apply();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 加入Sqlite資料庫
     */
    private void addSqlite() {

        ContentValues values = new ContentValues();

        values.put(Constant.COLUMN1, "88");
        values.put(Constant.COLUMN2, "95");

        db.insert(Constant.SQLite_Table, null, values);

    }
}
