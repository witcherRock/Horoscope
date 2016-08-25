package com.witcher.horoscope.di.module;

import com.witcher.horoscope.common.ConstantsURL;
import com.witcher.horoscope.data.IRestApi;
import com.witcher.horoscope.model.HoroscopeModel;
import com.witcher.horoscope.presenters.CheckSunSignPresenter;
import com.witcher.horoscope.presenters.HoroscopePresenter;
import com.witcher.horoscope.presenters.SelectSunSignPresenter;
import com.witcher.horoscope.presenters.SelectTopicPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Александр on 17.08.2016.
 */
@Module
public class ApplicationModule  {

    @Provides
    @Singleton
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    @Provides
    @Singleton
    public IRestApi provideRestApi(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsURL.URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        return  retrofit.create(IRestApi.class);
    }

    @Provides
    @Singleton
    public HoroscopeModel provideHoroscopeModel(){ return new HoroscopeModel(); }

    @Provides
    @Singleton
    public SelectSunSignPresenter provideSelectSunSignPresenter(){ return new SelectSunSignPresenter(); }

    @Provides
    @Singleton
    public SelectTopicPresenter provideSelectTopicPresenter() { return new SelectTopicPresenter(); }

    @Provides
    @Singleton
    public HoroscopePresenter provideHoroscopePresenter(){ return new HoroscopePresenter(); }

    @Provides
    @Singleton
    public CheckSunSignPresenter provideCheckSunSignPresenter(){ return new CheckSunSignPresenter(); }
}