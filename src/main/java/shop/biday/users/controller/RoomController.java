package shop.biday.users.controller;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.biday.users.model.domain.RoomAddDTO;
import shop.biday.users.model.domain.RoomDetailDTO;
import shop.biday.users.service.imp.RoomServiceImpl;


import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin
@RequiredArgsConstructor
public class RoomController {

    private final RoomServiceImpl ROOMSERVICE;


    @PostMapping("/room/insert")
    public ResponseEntity<?> insert(@RequestBody RoomAddDTO roomAddDTO) {
        return ResponseEntity.ok(ROOMSERVICE.insert(roomAddDTO));
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<List<?>> getRoomIdsByDormId(@PathVariable("id") Long dormId) {
        return ResponseEntity.ok(ROOMSERVICE.getRoomIdsByDormId(dormId));
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<List<?>> getRoomByDormId(@PathVariable("id") Long dormId) {
        return ResponseEntity.ok(ROOMSERVICE.getRoomByDormId(dormId));
    }



}
