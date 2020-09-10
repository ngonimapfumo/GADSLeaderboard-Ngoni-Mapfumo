package com.ngoni.gadsleaderboard.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ngoni.gadsleaderboard.R;
import com.ngoni.gadsleaderboard.apiclient.APIClient;
import com.ngoni.gadsleaderboard.apiclient.APIInterface;
import com.ngoni.gadsleaderboard.skillsiq.SkillIQ;
import com.ngoni.gadsleaderboard.skillsiq.SkillIQAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillsIQLeadersFrag extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<SkillIQ> skillIQ;
    private SkillIQAdapter adapter;
    private APIInterface mAPIInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);

        recyclerView = view.findViewById(R.id.skill_iq_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mAPIInterface = APIClient.getApiClient().create(APIInterface.class);

        Call<List<SkillIQ>> call = mAPIInterface.getSkillIQLeaders();
        call.enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {


                skillIQ = response.body();
                adapter = new SkillIQAdapter(getContext(), skillIQ);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {

            }
        });

        return view;
    }
}