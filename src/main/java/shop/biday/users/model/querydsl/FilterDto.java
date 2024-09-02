package shop.biday.users.model.querydsl;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.biday.users.model.domain.SearchDto;

import java.util.List;

@Data
@NoArgsConstructor
public class FilterDto {
    private SearchDto searchDto;
    private List<Long> amenities;
    private List<String> cities;

    @Builder
    public FilterDto(SearchDto searchDto, List<Long> amenities, List<String> cities) {
        this.searchDto = searchDto;
        this.amenities = amenities;
        this.cities = cities;
    }
}
