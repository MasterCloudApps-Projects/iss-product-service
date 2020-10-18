package es.urjc.code.products.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import es.urjc.code.products.Application;


@Configuration
@Import(Application.class)
public class TestConfig {
}
