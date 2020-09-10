package com.ngoni.gadsleaderboard.apiclient;

import com.ngoni.gadsleaderboard.leaders.LearningLeaders;
import com.ngoni.gadsleaderboard.skillsiq.SkillIQ;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("/api/hours")
    Call<List<LearningLeaders>> getLearningLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQ>> getSkillIQLeaders();


}
