package edu.eci.arsw.Coronavirus.cache;

public interface CoronavirusCache {
    public void save (String name, String json);
    public boolean isSave(String name);
    public boolean isAlive(String name);
    public String load(String name);
}