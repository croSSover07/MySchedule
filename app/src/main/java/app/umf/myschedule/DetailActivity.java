package app.umf.myschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

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

        //TODO данные из intent.extra , create
    }

}
