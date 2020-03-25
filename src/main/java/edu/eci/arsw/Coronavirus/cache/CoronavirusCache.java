package edu.eci.arsw.Coronavirus.cache;

public interface CoronavirusCache {
    public void save (String j);
    public boolean isSave();
    public boolean isAlive();
    public String load();
}