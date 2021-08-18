package com.config;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.serializers.LocalDateAdapter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BeansConfig {

    @Bean
    public Gson gsonConfig() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    @Bean
    public ModelMapper mapperConfig() {
        return new ModelMapper();
    }
    @Bean
    public DateTimeFormatter getDateTimeFormatter(){
        return  DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    }






}
