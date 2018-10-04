package com.aulamobile.service;

import com.aulamobile.entity.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGitService  {

    @GET("users/{user}/repos")
    Call<List<Repo>> listRepos(@Path("user") String user);

}

