package com.example.properapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mynameismidori.currencypicker.ExtendedCurrency;

import java.util.ArrayList;
import java.util.Calendar;

public class budget_planning extends AppCompatActivity {

   EditText shopping,car,education,entertainment,grocery,foodndrink,health,travel,other;
   Switch shopping_switch,car_switch,education_switch,entertainment_switch,grocery_switch,foodndrink_switch,health_switch,travel_switch,other_switch;
   FloatingActionButton add_budget_button;
   Boolean shopping_state,car_state,education_state,entertainment_state,grocery_state,foodndrink_state,health_state,travel_state,other_state;
   DatabaseHelper mydb;
   String[] user = new String[2];
   RelativeLayout car_budget;
   RelativeLayout edu_budget;
   RelativeLayout ent_budget;
    RelativeLayout food_budget;
    RelativeLayout grocery_budget;
    RelativeLayout health_budget;
    RelativeLayout shopping_budget;
    RelativeLayout travel_budget;
    RelativeLayout other_budget;
    TextView other_thershold;
    TextView travel_thershold;
    TextView shopping_thershold;
    TextView health_thershold;
    TextView grocery_thershold;
    TextView food_thershold;
    TextView ent_thershold;
    TextView edu_thershold;
    TextView car_thershold;
    TextView other_used;
    TextView travel_used;
    TextView shopping_used;
    TextView health_used;
    TextView grocery_used;
    TextView food_used;
    TextView ent_used;
    TextView edu_used;
    TextView car_used;
    ProgressBar other_progress;
    ProgressBar travel_progress;
    ProgressBar shopping_progress;
    ProgressBar health_progress;
    ProgressBar grocery_progress;
    ProgressBar food_progress;
    ProgressBar ent_progress;
    ProgressBar edu_progress;
    ProgressBar car_progress;



   Calendar calendar;
   int currentmonth;
   int currentyear;
   String startDate;

    BottomNavigationView bottomNav;
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_planning);

        shopping= findViewById(R.id.shopping_edittext);
        car=findViewById(R.id.car_edittext);
        education =findViewById(R.id.education_edittext);
        entertainment= findViewById(R.id.entertainment_edittext);
        foodndrink= findViewById(R.id.Food_n_drink_edittext);
        grocery= findViewById(R.id.grocery_edittext);
        health =findViewById(R.id.health_edittext);
        travel = findViewById(R.id.travel_edittext);
        other= findViewById(R.id.other_edittext);
        other_thershold = findViewById(R.id.other_threshold);
        travel_thershold = findViewById(R.id.travel_threshold);
        shopping_thershold = findViewById(R.id.shopping_threshold);
        health_thershold = findViewById(R.id.health_threshold);
        grocery_thershold = findViewById(R.id.grocery_threshold);
        food_thershold = findViewById(R.id.food_threshold);
        ent_thershold = findViewById(R.id.ent_threshold);
        edu_thershold = findViewById(R.id.edu_threshold);
        car_thershold = findViewById(R.id.car_threshold);
        other_used = findViewById(R.id.other_usage);
        travel_used = findViewById(R.id.travel_usage);
        shopping_used = findViewById(R.id.shopping_usage);
        health_used = findViewById(R.id.health_usage);
        grocery_used = findViewById(R.id.grocery_usage);
        food_used = findViewById(R.id.food_usage);
        ent_used = findViewById(R.id.ent_usage);
        edu_used = findViewById(R.id.edu_usage);
        car_used = findViewById(R.id.car_usage);
        other_progress = findViewById(R.id.other_budget);
        travel_progress = findViewById(R.id.travel_budget);
        shopping_progress= findViewById(R.id.shopping_budget);
        health_progress= findViewById(R.id.health_budget);
        grocery_progress= findViewById(R.id.grocery_budget);
        food_progress= findViewById(R.id.food_budget);
        ent_progress= findViewById(R.id.ent_budget);
        edu_progress= findViewById(R.id.edu_budget);
        car_progress= findViewById(R.id.car_budget);

        other_budget = findViewById(R.id.rl_other_progress);
        travel_budget = findViewById(R.id.rl_travel_progress);
        shopping_budget= findViewById(R.id.rl_shopping_progress);
        health_budget= findViewById(R.id.rl_health_progress);
        grocery_budget= findViewById(R.id.rl_grocery_progress);
        food_budget= findViewById(R.id.rl_food_progress);
        ent_budget= findViewById(R.id.rl_ent_progress);
        edu_budget= findViewById(R.id.rl_edu_progress);
        car_budget= findViewById(R.id.rl_car_progress);










        shopping.setText("-1");
        car.setText("-1");
        education.setText("-1");
        entertainment.setText("-1");
        foodndrink.setText("-1");
        grocery.setText("-1");
        health.setText("-1");
        travel.setText("-1");
        other.setText("-1");
        calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        // month = month + 1;
        int year = calendar.get(Calendar.YEAR);
        currentmonth =month+1;
        currentyear =year;
        startDate = "1/"+(month+1)+"/"+year;


        shopping.setVisibility(View.INVISIBLE);
        car.setVisibility(View.INVISIBLE);
        education.setVisibility(View.INVISIBLE);
        entertainment.setVisibility(View.INVISIBLE);
        foodndrink.setVisibility(View.INVISIBLE);
        grocery.setVisibility(View.INVISIBLE);
        health.setVisibility(View.INVISIBLE);
        travel.setVisibility(View.INVISIBLE);
        other.setVisibility(View.INVISIBLE);
        car_budget.setVisibility(View.GONE);
        shopping_budget.setVisibility(View.GONE);
        edu_budget.setVisibility(View.GONE);
        ent_budget.setVisibility(View.GONE);
        food_budget.setVisibility(View.GONE);
        grocery_budget.setVisibility(View.GONE);
        health_budget.setVisibility(View.GONE);
        travel_budget.setVisibility(View.GONE);
        other_budget.setVisibility(View.GONE);




        shopping_switch= findViewById(R.id.switch_shopping);
        car_switch=findViewById(R.id.switch_car);
        education_switch =findViewById(R.id.switch_education);
        entertainment_switch= findViewById(R.id.switch_entertainment);
        foodndrink_switch= findViewById(R.id.switch_food_n_drink);
        grocery_switch= findViewById(R.id.switch_grocery);
        health_switch=findViewById(R.id.switch_health);
        travel_switch= findViewById(R.id.switch_travel);
        other_switch= findViewById(R.id.switch_other);

        shopping_switch.setChecked(false);
        car_switch.setChecked(false);
        education_switch.setChecked(false);
        entertainment_switch.setChecked(false);
        foodndrink_switch.setChecked(false);
        grocery_switch.setChecked(false);
        health_switch.setChecked(false);
        travel_switch.setChecked(false);
        other_switch.setChecked(false);

        add_budget_button= findViewById(R.id.add_budget_button);
        mydb = new DatabaseHelper(this);
        user =mydb.get_currentuser();

        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListner);

        Double[] budget = mydb.getDataBudget(user[0],user[1]);
        if(budget != null)
        {
            shopping.setText(budget[0].toString());
            if(budget[0] !=-1)
            {
                Double threshold= -1.00;
                threshold = budget[0];
                shopping_budget.setVisibility(View.VISIBLE);
                shopping.setVisibility(View.VISIBLE);
                shopping_switch.setChecked(true);
                shopping_thershold.setVisibility(View.VISIBLE);
                shopping_thershold.setText(threshold.toString());
                String category_name = "Shopping";
                Double shopping_usage = category_total_euro_new(category_name);
                shopping_used.setVisibility(View.VISIBLE);
                shopping_used.setText(shopping_usage.toString());
                shopping_progress.setVisibility(View.VISIBLE);
                int shopping_percent = (int)((shopping_usage/threshold)*100.00);
                shopping_progress.setProgress(shopping_percent);
                if(shopping_usage>=budget[0])
                {
                    shopping_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    shopping_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));

                }

            }
            else
            {
                shopping_budget.setVisibility(View.GONE);


            }
            car.setText(budget[1].toString());
            if(budget[1]!=-1)
            {
                car.setVisibility(View.VISIBLE);
                car_switch.setChecked(true);
                car_budget.setVisibility(View.VISIBLE);
                car_thershold.setVisibility(View.VISIBLE);
                car_thershold.setText(budget[1].toString());
                Double car_usage = category_total_euro_new("Car");
                car_used.setVisibility(View.VISIBLE);
                car_used.setText(car_usage.toString());
                car_progress.setVisibility(View.VISIBLE);
                int car_percent = (int)((car_usage/budget[1])*100.00);
                car_progress.setProgress(car_percent);
                if(car_usage>=budget[1])
                {
                    car_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    car_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));

                }


            }
            else
            {
                car_budget.setVisibility(View.GONE);
            }
            education.setText(budget[2].toString());
            if(budget[2]!=-1)
            {
                edu_budget.setVisibility(View.VISIBLE);
                education.setVisibility(View.VISIBLE);
                education_switch.setChecked(true);
                edu_thershold.setVisibility(View.VISIBLE);
                edu_thershold.setText(budget[2].toString());
                Double edu_usage = category_total_euro_new("Education");
                edu_used.setVisibility(View.VISIBLE);
                edu_used.setText(edu_usage.toString());
                edu_progress.setVisibility(View.VISIBLE);
                int edu_percent = (int)((edu_usage/budget[2])*100.00);
                edu_progress.setProgress(edu_percent);
                if(edu_usage>=budget[2])
                {
                    edu_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                    {
                        edu_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));

                    }

            }
            else
            {
                edu_budget.setVisibility(View.GONE);
            }
            entertainment.setText(budget[3].toString());
            if(budget[3]!=-1)
            {
                ent_budget.setVisibility(View.VISIBLE);
                entertainment.setVisibility(View.VISIBLE);
                entertainment_switch.setChecked(true);
                ent_thershold.setVisibility(View.VISIBLE);
                ent_thershold.setText(budget[3].toString());
                Double ent_usage = category_total_euro_new("Entertainment");
                ent_used.setVisibility(View.VISIBLE);
                ent_used.setText(ent_usage.toString());
                ent_progress.setVisibility(View.VISIBLE);
                int ent_percent = (int)((ent_usage/budget[3])*100.00);
                ent_progress.setProgress(ent_percent);
                if(ent_usage>=budget[3])
                {
                    ent_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    ent_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));

                }

            }
            else
            {
                ent_budget.setVisibility(View.GONE);
            }
            foodndrink.setText(budget[4].toString());
            if(budget[4]!=-1)
            {
                food_budget.setVisibility(View.VISIBLE);
                foodndrink.setVisibility(View.VISIBLE);
                foodndrink_switch.setChecked(true);
                food_thershold.setVisibility(View.VISIBLE);
                food_thershold.setText(budget[4].toString());
                Double food_usage = category_total_euro_new("Food n Drink");
                food_used.setVisibility(View.VISIBLE);
                food_used.setText(food_usage.toString());
                food_progress.setVisibility(View.VISIBLE);
                int food_percent = (int)((food_usage/budget[4])*100.00);
                food_progress.setProgress(food_percent);
                if(food_usage>=budget[4])
                {
                    food_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    food_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));

                }

            }
            else
            {
                food_budget.setVisibility(View.GONE);
            }
            grocery.setText(budget[5].toString());
            if(budget[5]!=-1)
            {
                grocery_budget.setVisibility(View.VISIBLE);
                grocery.setVisibility(View.VISIBLE);
                grocery_switch.setChecked(true);
                grocery_thershold.setVisibility(View.VISIBLE);
                grocery_thershold.setText(budget[5].toString());
                Double grocery_usage = category_total_euro_new("Grocery");
                grocery_used.setVisibility(View.VISIBLE);
                grocery_used.setText(grocery_usage.toString());
                grocery_progress.setVisibility(View.VISIBLE);
                int grocery_percent = (int)((grocery_usage/budget[5])*100.00);
                grocery_progress.setProgress(grocery_percent);
                if(grocery_usage>=budget[5])
                {
                    grocery_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    grocery_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));

                }

            }
            else
            {
                grocery_budget.setVisibility(View.GONE);
            }
            health.setText(budget[6].toString());
            if(budget[6]!=-1)
            {
                health_budget.setVisibility(View.VISIBLE);
                health.setVisibility(View.VISIBLE);
                health_switch.setChecked(true);
                health_thershold.setVisibility(View.VISIBLE);
                health_thershold.setText(budget[6].toString());
                Double health_usage = category_total_euro_new("Health");
                health_used.setVisibility(View.VISIBLE);
                health_used.setText(health_usage.toString());
                health_progress.setVisibility(View.VISIBLE);
               int health_percent = (int)((health_usage/budget[6])*100.00);
                health_progress.setProgress(health_percent);
                if(health_usage>=budget[6])
                {
                    health_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    health_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));
                }

            }
            else
            {
                health_budget.setVisibility(View.GONE);
            }
            travel.setText(budget[7].toString());
            if(budget[7]!=-1)
            {
                travel_budget.setVisibility(View.VISIBLE);
               travel.setVisibility(View.VISIBLE);
                travel_switch.setChecked(true);
                travel_thershold.setVisibility(View.VISIBLE);
                travel_thershold.setText(budget[7].toString());
                Double travel_usage = category_total_euro_new("Travel");
                travel_used.setVisibility(View.VISIBLE);
                travel_used.setText(travel_usage.toString());
                travel_progress.setVisibility(View.VISIBLE);
                int travel_percent = (int)((travel_usage/budget[7])*100.00);
                travel_progress.setProgress(travel_percent);
                if(travel_usage>=budget[7])
                {
                    travel_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    travel_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));
                }

            }
            else
            {
                travel_budget.setVisibility(View.GONE);
            }
            other.setText(budget[8].toString());
            if(budget[8]!=-1)
            {
                other_budget.setVisibility(View.VISIBLE);
                other.setVisibility(View.VISIBLE);
                other_switch.setChecked(true);
                other_thershold.setVisibility(View.VISIBLE);
                other_thershold.setText(budget[8].toString());
                Double other_usage = category_total_euro_new("Other");
                other_used.setVisibility(View.VISIBLE);
                other_used.setText(other_usage.toString());
                other_progress.setVisibility(View.VISIBLE);
                int other_percent = (int)((other_usage/budget[8])*100.00);
                other_progress.setProgress(other_percent);
                if(other_usage>=budget[8])
                {
                    other_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
                else
                {
                    other_progress.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.darkgreen)));
                }

            }
            else
            {
                other_budget.setVisibility(View.GONE);
            }
        }


        shopping_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopping_state = shopping_switch.isChecked();
                if(shopping_state)
                {
                    shopping.setText("0");
                    shopping.setVisibility(View.VISIBLE);
                }
                if(!shopping_state)
                {
                    shopping.setText("-1");
                    shopping.setVisibility(View.INVISIBLE);
                }
            }
        });



        car_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                car_state = car_switch.isChecked();
                if(car_state)
                {
                    car.setText("0");
                    car.setVisibility(View.VISIBLE);
                }
                if(!car_state)
                {
                    car.setText("-1");
                    car.setVisibility(View.INVISIBLE);
                }
            }
        });



        education_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                education_state = education_switch.isChecked();
                if(education_state )
                {
                    education.setText("0");
                    education.setVisibility(View.VISIBLE);
                }
                if(!education_state)
                {
                    education.setText("-1");
                    education.setVisibility(View.INVISIBLE);
                }
            }
        });


        entertainment_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entertainment_state = entertainment_switch.isChecked();
                if(entertainment_state)
                {
                    entertainment.setText("0");
                    entertainment.setVisibility(View.VISIBLE);
                }
                if(!entertainment_state)
                {
                    entertainment.setText("-1");
                    entertainment.setVisibility(View.INVISIBLE);
                }
            }
        });


        foodndrink_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodndrink_state = foodndrink_switch.isChecked();
                if(foodndrink_state)
                {
                    foodndrink.setText("0");
                    foodndrink.setVisibility(View.VISIBLE);
                }
                if(!foodndrink_state)
                {
                    foodndrink.setText("-1");
                    foodndrink.setVisibility(View.INVISIBLE);
                }
            }
        });


        grocery_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grocery_state = grocery_switch.isChecked();
                if(grocery_state)
                {
                    grocery.setText("0");
                    grocery.setVisibility(View.VISIBLE);
                }
                if(!grocery_state)
                {
                    grocery.setText("-1");
                    grocery.setVisibility(View.INVISIBLE);
                }
            }
        });


        health_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                health_state = health_switch.isChecked();
                if(health_state)
                {
                    health.setText("0");
                    health.setVisibility(View.VISIBLE);
                }
                if(!health_state)
                {
                    health.setText("-1");
                    health.setVisibility(View.INVISIBLE);
                }
            }
        });


        travel_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                travel_state = travel_switch.isChecked();
                if(travel_state)
                {
                    travel.setText("0");
                    travel.setVisibility(View.VISIBLE);
                }
                if(!travel_state )
                {
                    travel.setText("-1");
                    travel.setVisibility(View.INVISIBLE);
                }
            }
        });


        other_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                other_state = other_switch.isChecked();
                if(other_state)
                {
                    other.setText("0");
                    other.setVisibility(View.VISIBLE);
                }
                if(!other_state)
                {
                    other.setText("-1");
                    other.setVisibility(View.INVISIBLE);
                }
            }
        });





        add_budget_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               boolean inserted= mydb.insertDataBudget(Double.parseDouble(shopping.getText().toString()),
                        Double.parseDouble(car.getText().toString()),
                        Double.parseDouble(education.getText().toString()),
                        Double.parseDouble(entertainment.getText().toString()),
                        Double.parseDouble(foodndrink.getText().toString()),
                        Double.parseDouble(grocery.getText().toString()),
                        Double.parseDouble(health.getText().toString()),
                        Double.parseDouble(travel.getText().toString()),
                        Double.parseDouble(other.getText().toString()),user[0],user[1]);

                if (inserted) {
                    Toast.makeText(getApplicationContext(), "Value is Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Value not Inserted", Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(getApplicationContext(), com.example.properapp.MainActivity.class));
                finish();
            }
        });

        bottom_navigation_helper();


    }

    @SuppressLint("ResourceAsColor")
    public void bottom_navigation_helper()
    {
        bottomNav.setItemIconTintList(null);
        MenuItem menuItem = bottomNav.getMenu().findItem(R.id.Nav_Dashboard);
        menuItem.setIcon(R.drawable.ic_dashboard_black_24dp);
        SpannableString s = new SpannableString(menuItem.getTitle());
        s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s.length(), 0);
        menuItem.setTitle(s);

        MenuItem menuItem2 = bottomNav.getMenu().findItem(R.id.Nav_Dashboard);
        SpannableString s2 = new SpannableString(menuItem2.getTitle());
        s2.setSpan(new ForegroundColorSpan(R.color.darkergreen), 0, s2.length(), 0);
        s2.setSpan(new RelativeSizeSpan(0.90f),0,s2.length(),0);
        menuItem2.setTitle(s2);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.Nav_Dashboard:

                            startActivity(new Intent(budget_planning.this,MainActivity.class));
                            finish();

                            break;
                        case R.id.Nav_List:
                            Intent show1 = new Intent(budget_planning.this, ListView.class);
                            startActivity(show1);
                            finish();

                            break;

                        case R.id.Nav_Add:
                            Intent show2 = new Intent(budget_planning.this, ListView_Checked.class);
                            startActivity(show2);
                            finish();
                            break;
                    }
                    return true;
                }
            };


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            //backToast.show();
            startActivity(new Intent(budget_planning.this,MainActivity.class));
        }
        backPressedTime = System.currentTimeMillis();
    }
    public Double category_total_euro_new (String category)
    {
        Double total_category_sum=0.00;
        ArrayList<ExpenseIncome> arrayList = new ArrayList<>();
        arrayList =mydb.get_Overview_Category_monthly(category,startDate,user[0],user[1]);
        ExpenseIncome obj;
        int i=0;
        int l=0;
        String default_currency =mydb.getDataSettings(user[0],user[1]);
        l=arrayList.size();
        if(arrayList != null) {
            while (i < l) {
                obj = arrayList.get(i);
                String obj_currencyname = obj.getCurrencyname();
                ExtendedCurrency currencyset = ExtendedCurrency.getCurrencyByName(obj_currencyname);
                String obj_currencycode = currencyset.getCode();

                String to4 = obj_currencycode;
                Double moneyValue4 = obj.getAmount();


                Double rateValue = mydb.getcurrency_rate_date(to4,obj.getDate());
                Double resultVal4 = moneyValue4 / rateValue;
                Double total_money_default_category=resultVal4;

                if(default_currency!=null) {
                    ExtendedCurrency currencyset1 = ExtendedCurrency.getCurrencyByName(default_currency);
                    String currency_code = currencyset1.getCode();
                    Double money_expense = resultVal4;

                    Double rateValue1 = mydb.getcurrency_rate_date(currency_code,obj.getDate());
                    total_money_default_category = money_expense * rateValue1;

                }

                total_category_sum= total_category_sum+total_money_default_category;


                i=i+1;

            }
            return total_category_sum;


        }
        else {
            total_category_sum =0.00;
            return  total_category_sum;
        }

    }




}
