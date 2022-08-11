package by.stas.uca.api.impl;

import by.stas.uca.api.WeatherApi;
import by.stas.uca.dto.WeatherDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Persistent;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Persistent
@AllArgsConstructor
public class WeatherApiImpl implements WeatherApi {

    @Value("${api.url}")
    private String url;
    @Value("${api.id}")
    private String apiId;
    @Value("${api.units:metric}")
    private String units;
    @Value("${api.endpoints.currentWeather}")
    private String currentWeatherEndpoint;

    private final RestTemplate restTemplate;

    @Override
    public Optional<WeatherDto> loadCurrentWeather(String cityName) {
        String uri = createUri(url, apiId, units, cityName);
        String responseBody = restTemplate.getForEntity(uri, String.class, currentWeatherEndpoint).getBody();

        return Optional.empty();
    }


    private String createUri(String url, String apiId, String units, String cityName) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", cityName)
                .queryParam("apiid", apiId)
                .queryParam("units", units)
                .toUriString();
    }
}
