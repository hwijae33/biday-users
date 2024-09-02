package shop.biday.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.biday.users.model.domain.TagDto;
import shop.biday.users.service.imp.TagServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TagController {

    private final TagServiceImpl TAGSERVICE;

    @GetMapping("/tag/list")
    public ResponseEntity<List<TagDto>> list(){
        return ResponseEntity.ok(TAGSERVICE.list());
    }
}
