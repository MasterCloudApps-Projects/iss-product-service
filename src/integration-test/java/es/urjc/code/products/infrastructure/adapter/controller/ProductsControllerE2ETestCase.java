package es.urjc.code.products.infrastructure.adapter.controller;

import static es.urjc.code.products.infrastructure.adapter.controller.BaseE2ETestCase.Resources.V1_PRODUCTS_ENDPOINT;
import static es.urjc.code.products.infrastructure.adapter.controller.BaseE2ETestCase.Resources.V1_PRODUCTS_GET_CAR_ENDPOINT;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import es.urjc.code.products.application.domain.Product;
import es.urjc.code.products.infrastructure.annotation.IT;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@IT
@ActiveProfiles("test")
class ProductsControllerE2ETestCase extends BaseE2ETestCase {


    @Test
    void shouldRetrieveAllProducts() {
    	
    	// given
    	final RequestSpecification requestSpecification = given()
                .log().all()
                .contentType(APPLICATION_JSON_VALUE);
    	
        // when
        final Response response = requestSpecification
                .when()
                .get(V1_PRODUCTS_ENDPOINT.build());
  
        // then
        @SuppressWarnings("unchecked")
		final List<Product> productsResponse = response
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .contentType(APPLICATION_JSON_VALUE)
                .extract().response().as(List.class);
        
        assertThat(productsResponse).isNotEmpty();
    }
    
    @Test
    void shouldRetrieveProduct() {
    	
    	// given
    	final RequestSpecification requestSpecification = given()
                .log().all()
                .contentType(APPLICATION_JSON_VALUE);
    	
        // when
        final Response response = requestSpecification
                .when()
                .get(V1_PRODUCTS_GET_CAR_ENDPOINT.build());
        
        // then
        final Product productResponse = response
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .contentType(APPLICATION_JSON_VALUE)
                .extract().response().as(Product.class);
        
        assertThat(productResponse.getId()).isNotEmpty();
        

    }
}
