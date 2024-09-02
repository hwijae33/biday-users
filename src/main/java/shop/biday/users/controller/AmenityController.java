package shop.biday.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.biday.users.model.domain.AmenityListDTO;
import shop.biday.users.service.imp.AmenityServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityServiceImpl AMENITYSERVICE;


    @GetMapping("/amenity/list")
    public ResponseEntity<List<?>> list(){
        return ResponseEntity.ok(AMENITYSERVICE.list());
    }
}
