package shop.biday.users.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.biday.users.model.domain.DamenityAddDTO;
import shop.biday.users.service.imp.AmenityServiceImpl;
import shop.biday.users.service.imp.DamenityServiceImpl;
import shop.biday.users.service.imp.DormServiceImpl;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class DamenityController {

    private final DamenityServiceImpl DAMENITYSERVICE;

    @PostMapping("/damenity/insert")
    public ResponseEntity<Boolean> insert(@RequestBody DamenityAddDTO damenityAddDTO) {
        return ResponseEntity.ok(DAMENITYSERVICE.insert(damenityAddDTO));
    }
}
