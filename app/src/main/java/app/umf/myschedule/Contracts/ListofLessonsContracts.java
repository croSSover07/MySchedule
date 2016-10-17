package app.umf.myschedule.Contracts;

import android.net.Uri;

/**
 * Created by UMF on 01.10.2016.
 */

public final class ListofLessonsContracts {

    public static final String CONTENT_AUTHORITY = "app.umf.myschedule";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_LISTOFLESSONS = "listoflessons";

    public final static class ListofLessonsEntry{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_LISTOFLESSONS);
        public final static String TABLE_NAME="listoflessons";
        public final static String COLUMN_ID="id";
        public final static String COLUMN_DAY="day";
        public final static String COLUMN_NLESS="numberlesson";//number lesson
        public final static String COLUMN_LESSON_ID="id_lesson";
        public final static String COLUMN_WHEN_TYPE="id_when_type";
        public final static String COLUMN_TYPE_LESSON="id_type_lessson";
        public final static String COLUMN_AUD_ID="id_aud";
    }

}
