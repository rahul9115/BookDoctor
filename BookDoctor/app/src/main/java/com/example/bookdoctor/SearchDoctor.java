package com.example.bookdoctor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import doctor.doctor;


public class SearchDoctor extends AppCompatActivity {
    private static String[] SUGGESTION = new String[] {
                    " Vedhas Nimkar Internal Medicine","General Physician","Pulmonologist","General Surgeon","Pediatric Cardiologist","Diabetologist ndocrinologist",
                    "Plastic Surgeon","Dermatologist","Gastroenterologist","Cardiologists"
            };
    private MaterialSearchView materialSearchView;
    private ArrayList<String> slotdata;
    ListView listView;
    ArrayAdapter arrayAdapter;
    Button button;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_doctor);

        MyDbDoctor db2=new MyDbDoctor(SearchDoctor.this);
        /*doctor d1=new doctor();
        d1.setKEY_Name("Dr. Vedhas Nimkar");
        d1.setKEY_Specialization("Internal Medicine");
        d1.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d1);

        doctor d2=new doctor();
        d2.setKEY_Name("Navin R. Davda");
        d2.setKEY_Specialization("General Physician");
        d2.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d2);

        doctor d3=new doctor();
        d3.setKEY_Name(" Pankaj Joshi");
        d3.setKEY_Specialization("General Surgery, FICS");
        d3.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d3);

        doctor d4=new doctor();
        d4.setKEY_Name("Dr. Srinivas L");
        d4.setKEY_Specialization("Pediatric Cardiology");
        d4.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d4);

        doctor d5=new doctor();
        d5.setKEY_Name("Dr. Mukta Bapat");
        d5.setKEY_Specialization("Gastroenterology");
        d5.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d5);
        doctor d6=new doctor();

        d6.setKEY_Name("Dr. Abhay Kulkarni");
        d6.setKEY_Specialization("Orthopaedics");
        d6.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d6);
        doctor d7=new doctor();
        d7.setKEY_Name("Dr. Shailesh T Kakde");
        d7.setKEY_Specialization("Nephrologist");
        d7.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d7);

        doctor d8=new doctor();
        d8.setKEY_Name("Dr. Gaurav Chaubal");
        d8.setKEY_Specialization("Transplant Surgery");
        d8.setKEY_Work_Time("10.00AM-07.00PM");
        db2.insert3(d8);*/

        listView=(ListView)findViewById(R.id.doctor_list_text);
        ArrayList<String> doctornames = new ArrayList<>();
        List<doctor> alldoctors=db2.getAllDoctor();
        for(doctor doctor1 :alldoctors){
            doctornames.add(doctor1.getKEY_Name() + " (" +  doctor1.getKEY_Specialization() + ")" + "(" + doctor1.getKEY_Work_Time() +
                    ")" );
        }
       final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,doctornames);
        listView.setAdapter(arrayAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position==0){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==1){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==2){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==3){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==4){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==5){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==6){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
               if(position==7){
                   Intent intent = new Intent(SearchDoctor.this,TimeSchedule.class);
                   startActivity(intent);
               }
           }
       });


        Toolbar toolbar=findViewById(R.id.toolbar);
        button=findViewById(R.id.done);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        materialSearchView = findViewById(R.id.search_view);
        materialSearchView.setSuggestions(SUGGESTION);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimeSchedule();

            }
        });


       /* final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Dr. Vedhas Nimkar\tInternal Medicine\n"+"₹500 "+"Mon-Sat" +
                "10:00 AM-07:00 PM");
        arrayList.add("Dr. Navin R. Davda General Physician\n" +" ₹200 \t"+" Mon-Fri\t" +
                       " 07:00 PM-08:00 PM");
        arrayList.add("₹1,000 \t"+"Mon-Wed, Fri-Sat\t" +
                        "10:00 AM-12:00 PM");
        arrayList.add("Dr. Pankaj Joshi\t General Surgery, FICS\n" +
               "₹650 \t"+"Mon-Sat\t" +
                "09:00 AM-05:00 PM");
        arrayList.add("Dr. Srinivas L\tPediatric Cardiology\n" +
                "₹650 \t"+"Mon-Sat\t" +
                "09:00 AM-05:00 PM");
        arrayList.add("Dr. Mukta Bapat\tGastroenterology\n" +
               "₹1,000 \t"+"Tue, Fri\t" +
               "05:00 PM-07:00 PM" );*/


        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
               // if(arrayAdapter.getCount()>0)
                arrayAdapter.clear();
                arrayAdapter.addAll(SUGGESTION);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.clear();
                if(newText !=null && !newText.isEmpty())
                {
                    for (String s : SUGGESTION)
                    {
                        if (s.toLowerCase().contains(newText))
                            arrayAdapter.add(s);
                    }
                }else
                {
                    arrayAdapter.addAll(SUGGESTION);
                }
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem=menu.findItem(R.id.searchMenu);
        materialSearchView.setMenuItem(menuItem);
        return super.onCreateOptionsMenu(menu);
    }
    public void TimeSchedule(){
        Intent intent = new Intent(this,TimeSchedule.class);
        startActivity(intent);
    }

}


