package shop.biday.users.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.biday.users.model.domain.ReviewWithTagsDTO;
import shop.biday.users.model.domain.RtagAddDTO;
import shop.biday.users.model.domain.StatsAndReviewDTO;
import shop.biday.users.model.repository.ReviewRepository;
import shop.biday.users.service.imp.ReviewServiceImpl;
import shop.biday.users.service.imp.RtagServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewServiceImpl REVIEWSERVICE;
    private final RtagServiceImpl RTAGSERVICE;
    private final ReviewRepository REVIEWREPOSITORY;


    @PostMapping("/write")
    public HashMap<String, Object> write(@RequestBody ReviewWithTagsDTO reviewWithTagsDTO) {

        HashMap<String, Object> resultMap = new HashMap();


        try {
            Long savedReview = REVIEWSERVICE.write(reviewWithTagsDTO.getReview());

            if (reviewWithTagsDTO.getTags() != null && !reviewWithTagsDTO.getTags().isEmpty()) {

                for (Long tagId : reviewWithTagsDTO.getTags()) {
                    RtagAddDTO rtagAddDTO = RtagAddDTO.builder()
                            .reviewId(savedReview)
                            .tagId(List.of(tagId))
                            .build();

                    RTAGSERVICE.insert(rtagAddDTO);
                }
            }
            resultMap.put("result", "success");

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("result", "fail");
        }

        return resultMap;
    }



    @GetMapping("/{dormId}")
    public ResponseEntity<StatsAndReviewDTO> getReviewsByDormId(@PathVariable Long dormId) {

        return new ResponseEntity<>(REVIEWSERVICE.getStatsAndReviews(dormId), HttpStatus.OK);
    }


}
