package shop.biday.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import shop.biday.users.service.imp.RoomImgServiceImpl;

import java.io.IOException;

import java.util.Map;



@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/roomImg")
public class RoomImgController {

    private final RoomImgServiceImpl ROOMIMGSERVICE;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadFiles(
            @RequestParam(value = "roomId", required = false) Long roomId,
            @RequestParam(value = "file", required = false) MultipartFile[] files) {

        try {
            Map<String, Object> result = ROOMIMGSERVICE.uploadFiles(roomId, files);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", "File upload failed"));
        }
    }
}
