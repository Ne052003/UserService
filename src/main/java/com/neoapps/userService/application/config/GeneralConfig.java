package com.neoapps.userService.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {
        "com.neoapps.userService.domain.usecases",
        "com.neoapps.userService.infrastructure.driven_adapters.repository",
        "com.neoapps.userService.infrastructure.driven_adapters.mappers",
        "com.neoapps.userService.infrastructure.entry_points"
}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
})
public class GeneralConfig {
}
