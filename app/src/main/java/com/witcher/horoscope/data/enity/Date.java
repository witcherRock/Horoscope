package com.witcher.horoscope.data.enity;

import org.simpleframework.xml.Attribute;

/**
 * Created by Александр on 08.08.2016.
 */
public class Date {                         // Даты прогнозов.
    @Attribute  private String tomorrow;
    @Attribute  private String tomorrow02;
    @Attribute  private String yesterday;
    @Attribute  private String today;

    public String getTomorrow ()
    {
        return tomorrow;
    }
    public void setTomorrow (String tomorrow)
    {
        this.tomorrow = tomorrow;
    }

    public String getTomorrow02 ()
    {
        return tomorrow02;
    }
    public void setTomorrow02 (String tomorrow02)
    {
        this.tomorrow02 = tomorrow02;
    }

    public String getYesterday ()
    {
        return yesterday;
    }
    public void setYesterday (String yesterday)
    {
        this.yesterday = yesterday;
    }

    public String getToday ()
    {
        return today;
    }
    public void setToday (String today)
    {
        this.today = today;
    }

    @Override
    public String toString()
    {
        return "Date [tomorrow = "
                +tomorrow+", tomorrow02 = "
                +tomorrow02+", yesterday = "
                +yesterday+", today = "
                +today+"]";
    }
}
