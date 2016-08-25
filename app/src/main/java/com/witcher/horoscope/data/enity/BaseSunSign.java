package com.witcher.horoscope.data.enity;

import org.simpleframework.xml.Element;

/**
 * Created by Александр on 18.08.2016.
 */
public class BaseSunSign  {
    @Element    protected String tomorrow;
    @Element    protected String tomorrow02;
    @Element    protected String yesterday;
    @Element    protected String today;

    public String getTomorrow () { return tomorrow; }
    public void setTomorrow (String tomorrow) { this.tomorrow = tomorrow; }

    public String getTomorrow02 () { return tomorrow02; }
    public void setTomorrow02 (String tomorrow02) { this.tomorrow02 = tomorrow02; }

    public String getYesterday () { return yesterday; }
    public void setYesterday (String yesterday) { this.yesterday = yesterday; }

    public String getToday () { return today; }
    public void setToday (String today) { this.today = today;}

    @Override
    public String toString()
    {
        return "ClassPojo [tomorrow = "
                +tomorrow+", tomorrow02 = "
                +tomorrow02+", yesterday = "
                +yesterday+", today = "
                +today+"]";
    }
}
