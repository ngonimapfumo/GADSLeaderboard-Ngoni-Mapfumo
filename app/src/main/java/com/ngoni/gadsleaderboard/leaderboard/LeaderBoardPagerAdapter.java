package com.ngoni.gadsleaderboard.leaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ngoni.gadsleaderboard.Fragments.LearningLeadersFrag;
import com.ngoni.gadsleaderboard.Fragments.SkillsIQLeadersFrag;

public class LeaderBoardPagerAdapter extends FragmentPagerAdapter {

    public LeaderBoardPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LearningLeadersFrag();
            case 1:
                return new SkillsIQLeadersFrag();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        if (position == 0) {
            title = "Learning Leaders";
        }else{
            title = "SkillIQ Leaders";
        }
        return title;
    }


}
