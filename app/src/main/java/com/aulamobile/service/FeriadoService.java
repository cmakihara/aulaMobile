package com.aulamobile.service;

import com.aulamobile.entity.Feriado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FeriadoService {

    /**
     *
     * @param user
     * @Query("") String query
     */

    @GET("{user}&token=Y2xtYWtpaGFyYUBob3RtYWlsLmNvbSZoYXNoPTczNzUwNDgy")
    Call<List<Feriado>> listFeriados( @Path("user") String user);

}
