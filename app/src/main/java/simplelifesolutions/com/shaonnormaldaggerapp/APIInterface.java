package simplelifesolutions.com.shaonnormaldaggerapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import simplelifesolutions.com.shaonnormaldaggerapp.models.RandomUsers;

public interface APIInterface {

    @GET("api")
    Call<RandomUsers> getPeople(@Query("results") int size) ;

    @GET("api")
    Call<RandomUsers> getGenderWise(@Query("gender") String strFormat , @Query("results") int size);
}

