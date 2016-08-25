package com.witcher.horoscope.data.enity;

/**
 * Created by Александр on 08.08.2016.
 */
public class Leo extends BaseSunSign{   // Лев.
    @Override
    public String toString()
    {
        return "Leo [tomorrow = "
                +tomorrow+", tomorrow02 = "
                +tomorrow02+", yesterday = "
                +yesterday+", today = "
                +today+"]";
    }
}
