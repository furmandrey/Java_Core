package ru.geekbrains.lesson8.provider;

import ru.geekbrains.lesson8.entity.WeatherData;
import ru.geekbrains.lesson8.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherProvider {

    void getWeather(Periods periods) throws IOException, SQLException;

    List<WeatherData> getAllFromDb() throws IOException, SQLException;
}
