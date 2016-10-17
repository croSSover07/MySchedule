package app.umf.myschedule.Contracts;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by UMF on 02.10.2016.
 */

public final class AudContract {
    public static final String CONTENT_AUTHORITY = "app.umf.myschedule";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_AUD = "aud";



    public static final class AudEntry implements BaseColumns{
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_AUD);
        public final static String TABLE_NAME="aud";
        public final static String COLUMN_ID="id";
        public final static String COLUMN_AUD="aud";


    }

}
