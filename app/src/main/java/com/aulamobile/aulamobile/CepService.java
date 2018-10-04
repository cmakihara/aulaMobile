package com.aulamobile.aulamobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("{cep}/json")
    Call<Cep> cepDados(@Path("cep") String user);
}
