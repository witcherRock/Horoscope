package com.witcher.horoscope.data.enity;

/**
 * Created by Александр on 08.08.2016.
 */
public class Cancer extends BaseSunSign {   // Рак.
    @Override
    public String toString()
    {
        return "Cancer [tomorrow = "
                +tomorrow+", tomorrow02 = "
                +tomorrow02+", yesterday = "
                +yesterday+", today = "
                +today+"]";
    }
}
