package one.digital.parking.controller;

import one.digital.parking.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("parking")
public class ParkingController {

    @GetMapping
    public List<Parking> findAll(){
        var parking = new Parking();
        parking.setColor("Preto");
        parking.setLicense("MSS-1111");
        parking.setModel("Fiat Argo");
        parking.setState("AM");

        return Arrays.asList(parking, parking);
    }
}
