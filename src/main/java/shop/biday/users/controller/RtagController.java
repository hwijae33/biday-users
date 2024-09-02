package shop.biday.users.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.biday.users.model.domain.RtagAddDTO;
import shop.biday.users.service.imp.RtagServiceImpl;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RtagController {

    private final RtagServiceImpl RTAGSERVICE;


    @PostMapping("/rtag/insert")
    public ResponseEntity<Boolean> insert(@RequestBody RtagAddDTO rtagAddDTO) {
        return ResponseEntity.ok(RTAGSERVICE.insert(rtagAddDTO));
    }
}
