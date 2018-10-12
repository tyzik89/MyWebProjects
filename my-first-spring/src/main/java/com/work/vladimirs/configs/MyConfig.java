package com.work.vladimirs.configs;

import com.work.vladimirs.entities.days.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
@ComponentScan("com.work.vladimirs.entities.animals")
public class MyConfig {
    /*При создании контекста спринг будет искать те классы, которые помечены аннотацией @Configuration,
    и создаст объекты этих классов у себя. После чего он попытается вызывать методы в этих классах,
     которые помечены аннотацией @Bean, что значит, что такие методы будут возвращать бины (объекты),
     которые он уже поместит себе в контекст.*/
    @Bean
    public WeekDay getDay() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        switch (dayOfWeek) {
            case MONDAY: return new Monday();
            case TUESDAY: return new Tuesday();
            case WEDNESDAY: return new Wednesday();
            case THURSDAY: return new Thursday();
            case FRIDAY: return new Friday();
            case SATURDAY: return new Saturday();
            default: return new Sunday();
        }
    }

}
