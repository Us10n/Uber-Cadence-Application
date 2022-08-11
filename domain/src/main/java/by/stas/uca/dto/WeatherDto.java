package by.stas.uca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {
    private Long id;
    private LocalDateTime date;
    private String cityName;
    private Float aitTemperature;
}
