package app.umf.myschedule.Contracts;

import android.net.Uri;

/**
 * Created by umf on 05.10.16.
 */

public final class RingsContract {
    public static final String CONTENT_AUTHORITY = "app.umf.myschedule";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_RINGS = "rings";

    public final static class RingsEntry{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_RINGS);

        public final static String TABLE_NAME="rings";
        public final static String COLUMN_ID="id";
        public final static String COLUMN_TIME_START="time_start";
        public final static String COLUMN_TIME_END="time_end";
    }

}
