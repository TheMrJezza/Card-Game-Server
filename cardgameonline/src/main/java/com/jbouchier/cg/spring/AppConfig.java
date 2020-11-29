package com.jbouchier.cg.spring;

import com.jbouchier.cg.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Value("${player-amount}")
    private int defaultPlayerAmount;

    @Scope("singleton")
    @Bean
    public Game gameSession() {
        return new Game(defaultPlayerAmount);
    }
}