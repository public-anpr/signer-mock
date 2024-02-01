package it.anpr.publicmock;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
class SignerRestTest {
	
    @Test
    void testSign() {
    	given()
        .when()
        .accept( MediaType.APPLICATION_JSON )
        .contentType( MediaType.APPLICATION_JSON )
        .body( "{  \"jsonBase64\": \"VEVTVA==\",  \"username\": \"user1\",  \"otpPwd\": \"13232\",  \"userPwd\": \"pass1\"}" )
        .post( "/ansc/signer/sign" )
          .then()
             .statusCode(200);
    }

    @Test
    void testSignpdf() {
    	given()
        .when()
        .accept( MediaType.APPLICATION_JSON )
        .contentType( MediaType.APPLICATION_JSON )
        .body( "{  \"pdfBase64\": \"VEVTVA==\",  \"username\": \"user1\",  \"otpPwd\": \"13232\",  \"userPwd\": \"pass1\"}" )
        .post( "/ansc/signer/signpdf" )
          .then()
             .statusCode(200);
    }
    
    @Test
    void testSigillopdf() {
    	given()
        .when()
        .accept( MediaType.APPLICATION_JSON )
        .contentType( MediaType.APPLICATION_JSON )
        .body( "{  \"pdfBase64\": \"VEVTVA==\"}" )
        .post( "/ansc/signer/sigillopdf" )
          .then()
             .statusCode(200);
    }
    
}