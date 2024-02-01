package it.anpr.publicmock;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
class VerifyRestTest {
	
    @Test
    void testVerify() {
    	given()
        .when()
        .accept( MediaType.APPLICATION_JSON )
        .contentType( MediaType.APPLICATION_JSON )
        .body( "{  \"data\": \"VEVTVA==\",  \"detached\": \"6c98ebbffe59cdfd0f40692522f7e063a1736ab594e2034b3681e722d98239fd\"}" )
        .post( "/ansc/verifier/verify" )
          .then()
             .statusCode(200);
    }

    @Test
    void testCompose() {
    	given()
        .when()
        .accept( MediaType.APPLICATION_JSON )
        .contentType( MediaType.APPLICATION_JSON )
        .body( "{  \"data\": \"VEVTVA==\",  \"detached\": \"6c98ebbffe59cdfd0f40692522f7e063a1736ab594e2034b3681e722d98239fd\"}" )
        .post( "/ansc/verifier/compose" )
          .then()
             .statusCode(200);
    }
    
}