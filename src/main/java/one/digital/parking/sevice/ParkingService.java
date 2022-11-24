package one.digital.parking.sevice;

import one.digital.parking.exception.ParkingNotFoundException;
import one.digital.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id  = getUUID();
        var id2  = getUUID();
        Parking parking = new Parking(id, "IMS-1111", "SC", "CELTA", "PRETO");
        Parking parking2 = new Parking(id2, "WAS-1111", "SP", "VW", "BRANCO");
        parkingMap.put(id,parking);
        parkingMap.put(id2,parking2);
    }

    public List<Parking> findAll(){

        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id){
        Parking parking = parkingMap.get(id);
        if (parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }


    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);

    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return  parking;
    }

    public Parking exit(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());

        // implementar o calculo em cima do tempo que ficou na garagem
        // var dif = parking.getEntryDate().getTime() - parking.getExitDate().getTime();

        return parking;
    }
}
