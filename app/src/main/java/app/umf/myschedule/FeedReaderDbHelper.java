package app.umf.myschedule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.umf.myschedule.Contracts.AudContract;
import app.umf.myschedule.Contracts.LessonContract;
import app.umf.myschedule.Contracts.ListofLessons;
import app.umf.myschedule.Contracts.TypeLessonContract;
import app.umf.myschedule.Contracts.WhenTypeContract;

/**
 * Created by UMF on 23.09.2016.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="FeedREader.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
   // private static final String DEFAULT_TYPE = " DEFAULT NULL";

    private static final String COMMA_SEP = ",";


    private   final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ListofLessons.TABLE_NAME+" ("+
                    ListofLessons.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    ListofLessons.COLUMN_DAY+TEXT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessons.COLUMN_LESSON_ID+INT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessons.COLUMN_NLESS+INT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessons.COLUMN_WHEN_TYPE+INT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessons.COLUMN_AUD_ID+INT_TYPE+" NOT NULL"+COMMA_SEP+
                    ListofLessons.COLUMN_TYPE_LESSON+INT_TYPE+" NOT NULL"+COMMA_SEP+
                    "FOREIGN KEY("+ListofLessons.COLUMN_LESSON_ID+") REFERENCES "  + LessonContract.TABLE_NAME+"("+LessonContract.COLUMN_ID+")"  +COMMA_SEP+
                    "FOREIGN KEY("+ListofLessons.COLUMN_TYPE_LESSON+") REFERENCES "  + TypeLessonContract.TABLE_NAME+"("+TypeLessonContract.COLUMN_ID+")"  +COMMA_SEP+
                    "FOREIGN KEY("+ListofLessons.COLUMN_AUD_ID+") REFERENCES "  + AudContract.TABLE_NAME+"("+AudContract.COLUMN_ID+")"  +COMMA_SEP+
                    "FOREIGN KEY("+ListofLessons.COLUMN_WHEN_TYPE+") REFERENCES "  + WhenTypeContract.TABLE_NAME+"("+TypeLessonContract.COLUMN_ID+")"  +
                    " )";

    private final String SQL_CREATE_ENTRIES2=
            "CREATE TABLE " + LessonContract.TABLE_NAME+" ("+
                    LessonContract.COLUMN_ID+ " INTEGER PRIMARY KEY,"+
                    LessonContract.COLUMN_NAME+ TEXT_TYPE+ " NOT NULL"+COMMA_SEP +
                    LessonContract.COLUMN_TEACHER+ TEXT_TYPE+ " NOT NULL"+
                    " )";
    private final String SQL_CREATE_ENTRIES3=
            "CREATE TABLE "+ WhenTypeContract.TABLE_NAME+" ("+
                    WhenTypeContract.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    WhenTypeContract.COLUMN_TYPE+TEXT_TYPE+
                    " )";
    private final String SQL_CREATE_ENTRIES4=
            "CREATE TABLE "+ TypeLessonContract.TABLE_NAME+" ("+
                    TypeLessonContract.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    TypeLessonContract.COLUMN_TYPE+TEXT_TYPE+
                    " )";
    private final String SQL_CREATE_ENTRIES5=
            "CREATE TABLE "+ AudContract.TABLE_NAME+" ("+
                    AudContract.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    AudContract.COLUMN_AUD+TEXT_TYPE+
                    " )";





    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ListofLessons.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES2 =
            "DROP TABLE IF EXISTS " + LessonContract.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES4 =
            "DROP TABLE IF EXISTS " + TypeLessonContract.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES3 =
            "DROP TABLE IF EXISTS " + WhenTypeContract.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES5 =
            "DROP TABLE IF EXISTS " + AudContract.TABLE_NAME;

    public FeedReaderDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES5);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES4);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES3);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES2);
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES2);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES3);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES4);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES5);


        onCreate(sqLiteDatabase);
    }

}
