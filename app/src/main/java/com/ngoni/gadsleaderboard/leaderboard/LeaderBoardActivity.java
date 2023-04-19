package com.ngoni.gadsleaderboard.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.ngoni.gadsleaderboard.R;
import com.ngoni.gadsleaderboard.ui.SubmitActivity;

public class LeaderBoardActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        toolbar =  findViewById(R.id.tool_bar_leaderboard);

        setSupportActionBar(toolbar);

        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Intent intent = new Intent(LeaderBoardActivity.this, SubmitActivity.class);
                startActivity(Intent(LearderBoardActivity.this,SubmitActivity.class));
                
                
            }
        });

        LeaderBoardPagerAdapter householdPagerAdapter = new LeaderBoardPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager =  findViewById(R.id.pager);
        viewPager.setAdapter(householdPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }
}
