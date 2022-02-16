package ru.geekbrains.lesson8.configuration;

public final class GlobalSettings {

    private static GlobalSettings INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "9odBDDO7ZCq2EfS9TubfwPxQvv20nYT7";

    private final String DB_FILENAME = "application.db";

    private GlobalSettings() {
    }

    public static GlobalSettings getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new GlobalSettings();
        }
        return INSTANCE;
    }

    public String getDbFileName() {
        return DB_FILENAME;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
