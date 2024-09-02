package shop.biday.users.model.domain;

import lombok.Data;

@Data
public class ReviewTagFrequencyDTO {
    private Long tagId;
    private int count;
}
