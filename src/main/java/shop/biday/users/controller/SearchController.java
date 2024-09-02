package shop.biday.users.controller;


import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.biday.users.model.domain.SearchDto;
import shop.biday.users.model.querydsl.DormDto;
import shop.biday.users.model.querydsl.FilterDto;
import shop.biday.users.service.imp.SearchService;

import java.util.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @PostMapping("/town/list")
    public ResponseEntity<List<String>> showTownList(@RequestBody SearchDto searchDto) {
        return ResponseEntity.ok(searchService.findByCity(searchDto.getCity()));
    }

    @GetMapping("/showAll")
    public ResponseEntity<Page<DormDto>> findAllList(Pageable pageable) {

        return ResponseEntity.ok(searchService.findAllList(pageable));
    }

    @PostMapping("/search")
    public ResponseEntity<List<DormDto>> findList(@RequestBody SearchDto searchDto) {
        return ResponseEntity.ok(searchService.findList(searchDto));
    }

    @PostMapping("/search/filter")
    public ResponseEntity<List<DormDto>> findByFilter(@RequestBody FilterDto filterDto) {

        return ResponseEntity.ok(searchService.findByFilter(filterDto));
    }
}
