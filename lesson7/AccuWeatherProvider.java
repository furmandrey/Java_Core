package ru.geekbrains.lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.lesson7.enums.Periods;

import java.io.IOException;
import java.util.List;


public class AccuWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";
    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException {
        String cityKey = detectCityKey();
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();

            String rawBody = response.body().string();


            List<WeatherResponse> weatherResponse = objectMapper.readValue(rawBody,
                    new TypeReference<List<WeatherResponse>>() {
                    });

            if (weatherResponse.isEmpty()) {
                System.out.println("Not found result");
                return;
            }

            // Получаем объект...
            WeatherResponse currentConditionResponse = weatherResponse.get(0);

            System.out.printf("В городе %s на дату %s ожидается \"%s\", температура %s %s\n\n",
                    ApplicationGlobalState.getInstance().getSelectedCity(),
                    currentConditionResponse.getLocalObservationDateTime(),
                    currentConditionResponse.getWeatherText(),
                    currentConditionResponse.getTemperature().getMetric().getValue(),
                    currentConditionResponse.getTemperature().getMetric().getUnit());

        }

    }

    @Override
    public void getWeatherIn5Days(Periods periods) throws IOException {
        String cityKey = detectCityKey();

        if (periods.equals(Periods.FIVE_DAYS)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegments("daily/5day")
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String rawBody = response.body().string();

            if (rawBody.isEmpty()) {
                System.out.println("Not found result");
                return;
            }

            WeatherIn_5_DaysResponse weatherIn_5_DaysResponse = objectMapper.readValue(
                    rawBody, WeatherIn_5_DaysResponse.class);

            List<DailyForecast> dailyForecasts = weatherIn_5_DaysResponse.getDailyForecasts();
            for (DailyForecast dailyForecast : dailyForecasts) {
                Temperature5Days temperature = dailyForecast.getTemperature();
                System.out.printf("В городе %s на дату %s ожидается днём \"%s\", ночью \"%s\", температура - от %s С до %s С\n",
                        ApplicationGlobalState.getInstance().getSelectedCity(),
                        dailyForecast.getDate(),
                        dailyForecast.getDay().getIconPhrase(),
                        dailyForecast.getNight().getIconPhrase(),
                        TemperatureConverters.FahrenheitCelsius(temperature.getMinimum().getValue()),
                        TemperatureConverters.FahrenheitCelsius(temperature.getMaximum().getValue()));
            }
        }
    }


    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Произвожу поиск города " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Найден город " + cityName + " в стране " + countryName);
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }
}
