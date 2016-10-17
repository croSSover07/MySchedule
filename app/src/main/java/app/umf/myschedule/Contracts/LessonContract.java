package app.umf.myschedule.Contracts;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by UMF on 26.09.2016.
 */

public final class LessonContract {

    public static final String CONTENT_AUTHORITY = "app.umf.myschedule";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_LESSON = "lesson";


    public final static class LessonEntry implements BaseColumns{
        public final static String TABLE_NAME="lesson";
        public final static String COLUMN_ID="id";
        public final static String COLUMN_NAME="name";
        public final static String COLUMN_TEACHER="teacher";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_LESSON);
    }

}
