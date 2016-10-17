package app.umf.myschedule;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.umf.myschedule.Contracts.AudContract.AudEntry;
import app.umf.myschedule.Contracts.LessonContract.LessonEntry;
import app.umf.myschedule.Contracts.ListofLessonsContracts.ListofLessonsEntry;
import app.umf.myschedule.Contracts.RingsContract.RingsEntry;
import app.umf.myschedule.Contracts.TypeLessonContract.TypeLessonEntry;
import app.umf.myschedule.Contracts.WhenTypeContract.WhenTypeEntry;

;
;

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
            "CREATE TABLE " + ListofLessonsEntry.TABLE_NAME+" ("+
                    ListofLessonsEntry.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    ListofLessonsEntry.COLUMN_DAY+TEXT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessonsEntry.COLUMN_LESSON_ID+INT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessonsEntry.COLUMN_NLESS+INT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessonsEntry.COLUMN_WHEN_TYPE+INT_TYPE+" NOT NULL" +COMMA_SEP +
                    ListofLessonsEntry.COLUMN_AUD_ID+INT_TYPE+" NOT NULL"+COMMA_SEP+
                    ListofLessonsEntry.COLUMN_TYPE_LESSON+INT_TYPE+" NOT NULL"+COMMA_SEP+
                    "FOREIGN KEY("+ ListofLessonsEntry.COLUMN_LESSON_ID+") REFERENCES "  + LessonEntry.TABLE_NAME+"("+LessonEntry.COLUMN_ID+")"  +COMMA_SEP+
                    "FOREIGN KEY("+ ListofLessonsEntry.COLUMN_TYPE_LESSON+") REFERENCES "  + TypeLessonEntry.TABLE_NAME+"("+TypeLessonEntry.COLUMN_ID+")"  +COMMA_SEP+
                    "FOREIGN KEY("+ ListofLessonsEntry.COLUMN_AUD_ID+") REFERENCES "  + AudEntry.TABLE_NAME+"("+AudEntry.COLUMN_ID+")"  +COMMA_SEP+
                    "FOREIGN KEY("+ ListofLessonsEntry.COLUMN_WHEN_TYPE+") REFERENCES "  + WhenTypeEntry.TABLE_NAME+"("+ WhenTypeEntry.COLUMN_ID+")"  +
                    " )";

    private final String SQL_CREATE_ENTRIES2=
            "CREATE TABLE " + LessonEntry.TABLE_NAME+" ("+
                    LessonEntry.COLUMN_ID+ " INTEGER PRIMARY KEY,"+
                    LessonEntry.COLUMN_NAME+ TEXT_TYPE+ " NOT NULL"+COMMA_SEP +
                    LessonEntry.COLUMN_TEACHER+ TEXT_TYPE+ " NOT NULL"+
                    " )";
    private final String SQL_CREATE_ENTRIES3=
            "CREATE TABLE "+ WhenTypeEntry.TABLE_NAME+" ("+
                    WhenTypeEntry.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    WhenTypeEntry.COLUMN_TYPE+TEXT_TYPE+
                    " )";
    private final String SQL_CREATE_ENTRIES4=
            "CREATE TABLE "+ TypeLessonEntry.TABLE_NAME+" ("+
                    TypeLessonEntry.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    TypeLessonEntry.COLUMN_TYPE+TEXT_TYPE+
                    " )";
    private final String SQL_CREATE_ENTRIES5=
            "CREATE TABLE "+ AudEntry.TABLE_NAME+" ("+
                    AudEntry.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    AudEntry.COLUMN_AUD+TEXT_TYPE+
                    " )";
    private final String SQL_CREATE_ENTRIES6=
            "CREATE TABLE "+ RingsEntry.TABLE_NAME+" ("+
                    RingsEntry.COLUMN_ID+" INTEGER PRIMARY KEY,"+
                    RingsEntry.COLUMN_TIME_START+TEXT_TYPE+ COMMA_SEP+
                    RingsEntry.COLUMN_TIME_END+TEXT_TYPE+
                    " )";





    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ListofLessonsEntry.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES2 =
            "DROP TABLE IF EXISTS " + LessonEntry.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES4 =
            "DROP TABLE IF EXISTS " + TypeLessonEntry.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES3 =
            "DROP TABLE IF EXISTS " + WhenTypeEntry.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES5 =
            "DROP TABLE IF EXISTS " + AudEntry.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES6=
            "DROP TABLE IF EXISTS " + RingsEntry.TABLE_NAME;
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
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES2);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES3);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES4);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES5);
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES6);


        onCreate(sqLiteDatabase);
    }

}
