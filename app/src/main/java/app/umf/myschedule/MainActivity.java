package app.umf.myschedule;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import app.umf.myschedule.Contracts.AudContract.AudEntry;
import app.umf.myschedule.Contracts.LessonContract.LessonEntry;
import app.umf.myschedule.Contracts.ListofLessonsContracts.ListofLessonsEntry;
import app.umf.myschedule.Contracts.RingsContract.RingsEntry;
import app.umf.myschedule.Contracts.TypeLessonContract.TypeLessonEntry;
import app.umf.myschedule.Contracts.WhenTypeContract.WhenTypeEntry;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private FeedReaderDbHelper mFeedReaderDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mFeedReaderDbHelper = new FeedReaderDbHelper(this);
        insertall();

        //TODO  четность/нечетность недели


    }


    private void insertall() {
        insertWhenType();
        insertTypeLesson();
        insertAud();
        insertLesson();
        insertListofLessons();
        insertRings();
    }
//region заполнение
    private void insertListofLessons() {
        SQLiteDatabase db=mFeedReaderDbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,1);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"monday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,2);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,1);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,1);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,1);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,3);
        long newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"monday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,3);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,1);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,3);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,1);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"monday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,3);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,2);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,2);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,4);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"monday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,4);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,1);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,3);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,5);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"tuesday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,2);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,4);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,4);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,1);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,3);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,6);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"tuesday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,3);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,5);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,5);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,2);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,3);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,7);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"wednesday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,4);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,6);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,1);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,3);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,8);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"wednesday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,5);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,4);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,3);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,1);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,9);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"wednesday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,6);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,3);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,1);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(ListofLessonsEntry.COLUMN_ID,10);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"friday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,3);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,2);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,1);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,3);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();
        contentValues.put(ListofLessonsEntry.COLUMN_ID,11);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"friday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,4);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,3);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,1);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();
        contentValues.put(ListofLessonsEntry.COLUMN_ID,12);
        contentValues.put(ListofLessonsEntry.COLUMN_DAY,"friday");
        contentValues.put(ListofLessonsEntry.COLUMN_NLESS,5);
        contentValues.put(ListofLessonsEntry.COLUMN_LESSON_ID,6);
        contentValues.put(ListofLessonsEntry.COLUMN_AUD_ID,3);
        contentValues.put(ListofLessonsEntry.COLUMN_TYPE_LESSON,3);
        contentValues.put(ListofLessonsEntry.COLUMN_WHEN_TYPE,1);
        newRowid=db.insert(ListofLessonsEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

    }

    private void insertAud() {
        SQLiteDatabase db=mFeedReaderDbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(AudEntry.COLUMN_ID,1);
        contentValues.put(AudEntry.COLUMN_AUD,"ауд 38");
        long newRowid=db.insert(AudEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(AudEntry.COLUMN_ID,3);
        contentValues.put(AudEntry.COLUMN_AUD,"ОЦ-1");
        newRowid=db.insert(AudEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(AudEntry.COLUMN_ID,4);
        contentValues.put(AudEntry.COLUMN_AUD,"ОЦ-3");
        newRowid=db.insert(AudEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(AudEntry.COLUMN_ID,2);
        contentValues.put(AudEntry.COLUMN_AUD,"ауд 40");
        newRowid=db.insert(AudEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(AudEntry.COLUMN_ID,5);
        contentValues.put(AudEntry.COLUMN_AUD,"ауд Л410");
        newRowid=db.insert(AudEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();


    }

    private void insertLesson() {
        SQLiteDatabase db=mFeedReaderDbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();


        contentValues.put(LessonEntry.COLUMN_ID,1);
        contentValues.put(LessonEntry.COLUMN_NAME,"Методи захисту iнформацii комп'ютерних системах");
        contentValues.put(LessonEntry.COLUMN_TEACHER,"Скрипник I.А");
        long newRowid = db.insert(LessonEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(LessonEntry.COLUMN_ID,2);
        contentValues.put(LessonEntry.COLUMN_NAME,"Сучасна прикл. алгебра та ООП та цив.захист");
        contentValues.put(LessonEntry.COLUMN_TEACHER,"Вербицький В.Г.");
        newRowid = db.insert(LessonEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(LessonEntry.COLUMN_ID,3);
        contentValues.put(LessonEntry.COLUMN_NAME,"Ком'ютерне моделювання економiчних задач");
        contentValues.put(LessonEntry.COLUMN_TEACHER,"Вербицький В.Г.");
        newRowid = db.insert(LessonEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(LessonEntry.COLUMN_ID,4);
        contentValues.put(LessonEntry.COLUMN_NAME,"Нейрокомп'ютернi системи");
        contentValues.put(LessonEntry.COLUMN_TEACHER,"Безверхий А.I.");
        newRowid = db.insert(LessonEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(LessonEntry.COLUMN_ID,5);
        contentValues.put(LessonEntry.COLUMN_NAME,"Професiйна iноземна мова");
        contentValues.put(LessonEntry.COLUMN_TEACHER,"Демiхова О.Г.");
        newRowid = db.insert(LessonEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(LessonEntry.COLUMN_ID,6);
        contentValues.put(LessonEntry.COLUMN_NAME,"Технологiя створення WEB-застосункiв");
        contentValues.put(LessonEntry.COLUMN_TEACHER,"Попiвщий В.I.");
        newRowid = db.insert(LessonEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();





    }

    private void insertTypeLesson() {
        SQLiteDatabase db=mFeedReaderDbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(TypeLessonEntry.COLUMN_ID,1);
        contentValues.put(TypeLessonEntry.COLUMN_TYPE,"лекция");
        long newRowid=db.insert(TypeLessonEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(TypeLessonEntry.COLUMN_ID,2);
        contentValues.put(TypeLessonEntry.COLUMN_TYPE,"практика");
        newRowid=db.insert(TypeLessonEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();

        contentValues.put(TypeLessonEntry.COLUMN_ID,3);
        contentValues.put(TypeLessonEntry.COLUMN_TYPE,"лабораторная работа");
        newRowid=db.insert(TypeLessonEntry.TABLE_NAME,null,contentValues);
        contentValues.clear();
    }

    private void insertWhenType() {
        SQLiteDatabase db = mFeedReaderDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(WhenTypeEntry.COLUMN_ID, 1);
        contentValues.put(WhenTypeEntry.COLUMN_TYPE, "числитель");
        long newRowid = db.insert(WhenTypeEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(WhenTypeEntry.COLUMN_ID, 2);
        contentValues.put(WhenTypeEntry.COLUMN_TYPE, "знаменатель");
        newRowid = db.insert(WhenTypeEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(WhenTypeEntry.COLUMN_ID, 3);
        contentValues.put(WhenTypeEntry.COLUMN_TYPE, "числитель/знаменатель");
        newRowid = db.insert(WhenTypeEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();


    }
    private void insertRings()
    {
        SQLiteDatabase db = mFeedReaderDbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(RingsEntry.COLUMN_ID, 1);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "8:45");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "10:05");
        long newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(RingsEntry.COLUMN_ID, 2);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "10:15");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "11:35");
        newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(RingsEntry.COLUMN_ID, 3);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "11:45");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "13:05");
        newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(RingsEntry.COLUMN_ID, 4);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "13:35");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "14:55");
        newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(RingsEntry.COLUMN_ID, 5);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "15:05");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "16:25");
        newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();


        contentValues.put(RingsEntry.COLUMN_ID, 6);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "16:35");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "17:55");
        newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(RingsEntry.COLUMN_ID, 7);
        contentValues.put(RingsEntry.COLUMN_TIME_START, "18:05");
        contentValues.put(RingsEntry.COLUMN_TIME_END, "19:25");
        newRowid = db.insert(RingsEntry.TABLE_NAME, null, contentValues);
        contentValues.clear();
    }
//endregion

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private   ArrayList<HashMap<String,String>> local=new ArrayList<HashMap<String,String>>();

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            final ListView listView = (ListView) rootView.findViewById(R.id.list_item);

            int numberday = getArguments().getInt(ARG_SECTION_NUMBER) - 1;
            //запуск detailactivity
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //TODO: передавать правильно в интент
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    String text_numberpair=((TextView) view.findViewById(R.id.textview_number)).getText().toString();
                    HashMap<String,String> aa=findByNumber(local,text_numberpair);
                    intent.putExtra("infohashmap",aa);
                    startActivity(intent);
                }
            });

            switch (numberday) {
                case 0:
                {

                    local=chooseFromDB("monday",1);
                    textView.setText("Monday");
                    setInListView(listView,local);
                    break;
                }
                case 1:
                {
                    local=chooseFromDB("tuesday",1);
                    textView.setText("Tuesday");
                    setInListView(listView,local);
                    break;
                }
                case 2:
                {
                    local=chooseFromDB("wednesday",1);
                    textView.setText("Wednesday");
                    setInListView(listView,local);
                    break;
                }
                case 3:
                {
                    //TODO добавить четверг и проверки на null
//
                    break;
                }
                case 4:
                {
                    local=chooseFromDB("friday",1);
                    textView.setText("Friday");
                    setInListView(listView,local);
                    break;
                }
            }

            return rootView;

        }
        private HashMap<String,String> findByNumber(ArrayList<HashMap<String,String>> list,String number)
        {

//поменять
            //вродебы ок
            for (HashMap<String,String> a:list) {
               if( a.containsValue(number)) {
                   return a ;
               }
            }

            return null;
        }
        private void  setInListView(ListView locallistview, ArrayList<HashMap<String,String>> list)
        {//поменять//вроде бы ок
            ArrayList<String> b=new ArrayList<>();//список номеров пар
            ArrayList<String> c=new ArrayList<>();//список string в которой содержиться get(1)-lesson.name+(get(2) -aud.aud)+(get(3)- typelesson.type)
            for(int i=0;i<list.size();i++)
            {
                b.add(list.get(i).get(ListofLessonsEntry.COLUMN_NLESS));
                c.add(list.get(i).get(LessonEntry.COLUMN_NAME)+"\n"+
                        list.get(i).get(AudEntry.COLUMN_AUD)+"\n"+
                        list.get(i).get(TypeLessonEntry.COLUMN_TYPE));
            }
            locallistview.setAdapter(new CustomAdapter( getActivity(),b,c));
        }
        private ArrayList<HashMap<String,String>> chooseFromDB(String day, int when_type)
        {
            ArrayList<HashMap<String,String>> a=new ArrayList<>();
            FeedReaderDbHelper dbHelper=new FeedReaderDbHelper(getContext());
            //TODO поменять запрос,
            Cursor c=dbHelper.getReadableDatabase().rawQuery("select listoflessons.numberlesson,lesson.name, " +
                    "aud.aud,typelesson.type_lesson,rings.time_start,rings.time_end,lesson.teacher,when_type.type_week,listoflessons.day " +
                    "from listoflessons   join  aud on listoflessons.id_aud=aud.id " +
                                        " join lesson on listoflessons.id_lesson=lesson.id " +
                                        " join typelesson on listoflessons.id_type_lessson=typelesson.id " +
                                        " join when_type on listoflessons.id_when_type=when_type.id " +
                                        " join rings on listoflessons.numberlesson=rings.id"+
                    " where listoflessons.day=\""+day+"\"  and ( when_type.id="+when_type+" or when_type.id=3	)	",null);
            if(c.moveToFirst())
            {
                do {
                    HashMap<String,String> hashMap=new HashMap<String,String>();
                    for(int i=0 ;i<c.getColumnCount();i++)
                    {
                        hashMap.put(c.getColumnName(i),c.getString(i));
                    }
                    a.add(hashMap);

                }
                while(c.moveToNext());
            }

            return a;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            //count of pages
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
            }
            return null;
        }
    }
}
