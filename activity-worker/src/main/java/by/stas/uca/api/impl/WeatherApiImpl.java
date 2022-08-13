package by.stas.uca.api.impl;

import by.stas.uca.api.WeatherApi;
import by.stas.uca.dto.WeatherDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class WeatherApiImpl implements WeatherApi {

    @Value("${weatherApi.url: default}")
    private String url;
    @Value("${weatherApi.appid: default}")
    private String appId;
    @Value("${weatherApi.units: metric}")
    private String units;
    @Value("${weatherApi.endpoints.currentWeather: default}")
    private String currentWeatherEndpoint;

    private final RestTemplate restTemplate;

    public WeatherApiImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<WeatherDto> loadCurrentWeather(String cityName) {
        String fullUrl = url + currentWeatherEndpoint;
        String uri = createUri(fullUrl, appId, units, cityName);
        WeatherDto weatherDto;
        try {
            String responseBody = restTemplate.getForEntity(uri, String.class).getBody();
            Float airTemperature = new Gson().fromJson(responseBody, JsonObject.class)
                    .getAsJsonObject("main")
                    .get("temp")
                    .getAsFloat();
            weatherDto = new WeatherDto(null, cityName, airTemperature);
        } catch (HttpClientErrorException e) {
            weatherDto = null;
        }

        return Optional.ofNullable(weatherDto);
    }


    private String createUri(String url, String appId, String units, String cityName) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", cityName)
                .queryParam("appid", appId)
                .queryParam("units", units)
                .toUriString();
    }
}
