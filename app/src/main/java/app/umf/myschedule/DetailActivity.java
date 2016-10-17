package app.umf.myschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.HashMap;

import app.umf.myschedule.Contracts.AudContract.AudEntry;
import app.umf.myschedule.Contracts.LessonContract.LessonEntry;
import app.umf.myschedule.Contracts.ListofLessonsContracts.ListofLessonsEntry;
import app.umf.myschedule.Contracts.RingsContract.RingsEntry;
import app.umf.myschedule.Contracts.TypeLessonContract.TypeLessonEntry;
import app.umf.myschedule.Contracts.WhenTypeContract.WhenTypeEntry;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textView_time=(TextView) findViewById(R.id.textView_time);
        TextView textView_day=(TextView) findViewById(R.id.textView_day);
        TextView textView_number=(TextView) findViewById(R.id.textView_number);
        TextView textView_name=(TextView) findViewById(R.id.textView_name);
        TextView textView_teacher=(TextView) findViewById(R.id.textView_teacher);
        TextView textView_type=(TextView) findViewById(R.id.textView_type);
        TextView textView_aud=(TextView) findViewById(R.id.textView_aud);
        TextView textView_weektype=(TextView) findViewById(R.id.textView_weektype);

        HashMap<String,String> hashMap=(HashMap<String,String >) getIntent().getSerializableExtra("infohashmap");
        //TODO данные из intent.extra , create

        textView_aud.setText(hashMap.get(AudEntry.COLUMN_AUD));
        textView_day.setText(hashMap.get(ListofLessonsEntry.COLUMN_DAY));
        textView_name.setText(hashMap.get(LessonEntry.COLUMN_NAME));
        textView_number.setText(hashMap.get(ListofLessonsEntry.COLUMN_NLESS));
        textView_teacher.setText(hashMap.get(LessonEntry.COLUMN_TEACHER));
        textView_time.setText(hashMap.get(RingsEntry.COLUMN_TIME_START)+"-"+hashMap.get(RingsEntry.COLUMN_TIME_END));
        textView_type.setText(hashMap.get(TypeLessonEntry.COLUMN_TYPE));
        textView_weektype.setText(hashMap.get(WhenTypeEntry.COLUMN_TYPE));
    }

}
