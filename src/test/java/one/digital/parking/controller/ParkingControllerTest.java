package one.digital.parking.controller;

import io.restassured.RestAssured;
import one.digital.parking.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Matches;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest {

    @LocalServerPort
    private int randomPort;
    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        RestAssured.port =randomPort;
    }
    @Test
    @Order(1)
    void whenfindAllTheCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value())  ;
    }

//    @Test
//    @Order(2)
//    void whenCreateThenCheckIsCreated() {
//
//        var createDTO = new ParkingCreateDTO();
//        createDTO.setColor("Amarelo");
//        createDTO.setLicense("WRT-5521");
//        createDTO.setModel("BRASILIA");
//        createDTO.setState("AM");
//        RestAssured.given()
//                .when()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(createDTO)
//                .post("/parking")
//                .then()
//                .statusCode(HttpStatus.CREATED.value())
//                .body("license", Matchers.equalTo("WRT-5521"))
//                .body("color", Matchers.equalTo("AMARELO"));
//    }
}