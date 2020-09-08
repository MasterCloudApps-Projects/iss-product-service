package es.urjc.code.products.infrastructure.adapter.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

public abstract class BaseIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/api";
        RestAssured.port = this.port;
    }

    enum Resources {
        V1_PRODUCTS_ENDPOINT("/v1/products");

        private final String endpoint;

        Resources(String endpoint) {
            this.endpoint = endpoint;
        }

        public String build() {
            return endpoint;
        }
    }
}
