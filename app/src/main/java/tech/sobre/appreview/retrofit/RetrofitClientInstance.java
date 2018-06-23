package tech.sobre.appreview.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    private  static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY));

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null ){
            retrofit = new Retrofit.Builder()
                    .client(httpClient.build())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
