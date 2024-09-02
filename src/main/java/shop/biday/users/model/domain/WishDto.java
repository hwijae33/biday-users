package shop.biday.users.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.entity.Dorm;
import shop.biday.users.model.entity.Wish;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WishDto {
    private Long id;
    private Dorm dorm;
    private LocalDateTime createdAt;
    
}
