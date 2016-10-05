package app.umf.myschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.HashMap;

import app.umf.myschedule.Contracts.AudContract;
import app.umf.myschedule.Contracts.LessonContract;
import app.umf.myschedule.Contracts.ListofLessons;
import app.umf.myschedule.Contracts.RingsContract;
import app.umf.myschedule.Contracts.TypeLessonContract;
import app.umf.myschedule.Contracts.WhenTypeContract;

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

        textView_aud.setText(hashMap.get(AudContract.COLUMN_AUD));
        textView_day.setText(hashMap.get(ListofLessons.COLUMN_DAY));
        textView_name.setText(hashMap.get(LessonContract.COLUMN_NAME));
        textView_number.setText(hashMap.get(ListofLessons.COLUMN_NLESS));
        textView_teacher.setText(hashMap.get(LessonContract.COLUMN_TEACHER));
        textView_time.setText(hashMap.get(RingsContract.COLUMN_TIME_START)+"-"+hashMap.get(RingsContract.COLUMN_TIME_END));
        textView_type.setText(hashMap.get(TypeLessonContract.COLUMN_TYPE));
        textView_weektype.setText(hashMap.get(WhenTypeContract.COLUMN_TYPE));
    }

}
