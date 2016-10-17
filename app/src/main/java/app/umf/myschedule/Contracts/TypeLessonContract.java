package app.umf.myschedule.Contracts;

import android.net.Uri;

/**
 * Created by UMF on 02.10.2016.
 */

public final class TypeLessonContract {

    public static final String CONTENT_AUTHORITY = "app.umf.myschedule";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_TYPELESSON = "typelesson";

    public final static class TypeLessonEntry{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TYPELESSON);

        public final static String TABLE_NAME="typelesson";
        public final static String COLUMN_ID="id";
        public final static String COLUMN_TYPE="type_lesson";
    }

}
