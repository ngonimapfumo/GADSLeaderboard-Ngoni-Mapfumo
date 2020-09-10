package com.ngoni.gadsleaderboard.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ngoni.gadsleaderboard.R;
import com.ngoni.gadsleaderboard.apiclient.APIClient;
import com.ngoni.gadsleaderboard.apiclient.APIInterface;
import com.ngoni.gadsleaderboard.leaders.LearningLeaders;
import com.ngoni.gadsleaderboard.leaders.LearningLeadersAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFrag extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<LearningLeaders> learningLeaders;
    private LearningLeadersAdapter adapter;
    private APIInterface mAPIInterface;
    private ProgressBar progress_bar;


    public LearningLeadersFrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        recyclerView = view.findViewById(R.id.learning_leaders_recycler_view);
        progress_bar = view.findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        progress_bar.setVisibility(View.VISIBLE);

        mAPIInterface = APIClient.getApiClient().create(APIInterface.class);

        Call<List<LearningLeaders>> call = mAPIInterface.getLearningLeaders();

        call.enqueue(new Callback<List<LearningLeaders>>() {
            @Override
            public void onResponse(Call<List<LearningLeaders>> call, Response<List<LearningLeaders>> response) {
                progress_bar.setVisibility(View.INVISIBLE);

                learningLeaders = response.body();
                adapter = new LearningLeadersAdapter(getContext(), learningLeaders);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LearningLeaders>> call, Throwable t) {

            }
        });


        return view;
    }
}