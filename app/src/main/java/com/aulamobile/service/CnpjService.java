package com.aulamobile.service;

import com.aulamobile.entity.Cep;
import com.aulamobile.entity.Cnpj;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CnpjService {

    @GET("{cnpj}")
    Call<Cnpj> cnpjDados(@Path("cnpj") String cnpj);
}
