package com.aulamobile.aulamobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("users/{user}/repos")
    Call<Cep> cepDados(@Path("user") String user);
}
