package shop.biday.users.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewWithTagsDTO {

    private ReviewAddDTO review;
    private List<Long> tags;

}
