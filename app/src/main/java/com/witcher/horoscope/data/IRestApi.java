package com.witcher.horoscope.data;

import com.witcher.horoscope.data.enity.Horo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Александр on 17.08.2016.
 */
public interface IRestApi {
    @GET("r/export/utf/xml/daily/{typeHoroscope}")
    Observable<Horo> getHoroscope(@Path("typeHoroscope") String typeHoroscope);
}
