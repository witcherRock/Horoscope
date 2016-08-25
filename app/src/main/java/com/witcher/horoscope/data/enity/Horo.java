package com.witcher.horoscope.data.enity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Александр on 08.08.2016.
 */

@Root
public class Horo {
    @Element    private Date date;           // Даты:вчера, сегодня, завтра, послезавтра.

    // Классы с предсказаниями по знакам зодиака.
    @Element    private Pisces          pisces;         // Рыбы.
    @Element    private Sagittarius     sagittarius;    // Стрелец.
    @Element    private Gemini          gemini;         // Близнецы.
    @Element    private Leo             leo;            // Лев.
    @Element    private Aquarius        aquarius;       // Водолей.
    @Element    private Virgo           virgo;          // Дева.
    @Element    private Taurus          taurus;         // Телец.
    @Element    private Aries           aries;          // Овен.
    @Element    private Libra           libra;          // Весы.
    @Element    private Scorpio         scorpio;        // Скорпион.
    @Element    private Capricorn       capricorn;      // Козерог.
    @Element    private Cancer          cancer;         // Раки.

    private String[] content;   // ????

    public String[] getContent ()
    {
        return content;
    }
    public void setContent (String[] content)
    {
        this.content = content;
    }

    public Pisces getPisces ()
    {
        return pisces;
    }
    public void setPisces (Pisces pisces)
    {
        this.pisces = pisces;
    }

    public Sagittarius getSagittarius ()
    {
        return sagittarius;
    }
    public void setSagittarius (Sagittarius sagittarius)
    {
        this.sagittarius = sagittarius;
    }

    public Gemini getGemini ()
    {
        return gemini;
    }
    public void setGemini (Gemini gemini)
    {
        this.gemini = gemini;
    }

    public Leo getLeo ()
    {
        return leo;
    }
    public void setLeo (Leo leo)
    {
        this.leo = leo;
    }

    public Aquarius getAquarius ()
    {
        return aquarius;
    }
    public void setAquarius (Aquarius aquarius)
    {
        this.aquarius = aquarius;
    }

    public Date getDate ()
    {
        return date;
    }
    public void setDate (Date date)
    {
        this.date = date;
    }

    public Virgo getVirgo ()
    {
        return virgo;
    }
    public void setVirgo (Virgo virgo)
    {
        this.virgo = virgo;
    }

    public Taurus getTaurus ()
    {
        return taurus;
    }
    public void setTaurus (Taurus taurus)
    {
        this.taurus = taurus;
    }

    public Aries getAries ()
    {
        return aries;
    }
    public void setAries (Aries aries)
    {
        this.aries = aries;
    }

    public Libra getLibra ()
    {
        return libra;
    }
    public void setLibra (Libra libra)
    {
        this.libra = libra;
    }

    public Scorpio getScorpio ()
    {
        return scorpio;
    }
    public void setScorpio (Scorpio scorpio)
    {
        this.scorpio = scorpio;
    }

    public Capricorn getCapricorn ()
    {
        return capricorn;
    }
    public void setCapricorn (Capricorn capricorn)
    {
        this.capricorn = capricorn;
    }

    public Cancer getCancer ()
    {
        return cancer;
    }
    public void setCancer (Cancer cancer)
    {
        this.cancer = cancer;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pisces = "
                +pisces+", sagittarius = "
                +sagittarius+", gemini = "
                +gemini+", leo = "
                +leo+", aquarius = "
                +aquarius+", date = "
                +date+", virgo = "
                +virgo+", taurus = "
                +taurus+", content = "
                +content+", aries = "
                +aries+", libra = "
                +libra+", scorpio = "
                +scorpio+", capricorn = "
                +capricorn+", cancer = "
                +cancer+"]";
    }
}
