package shop.biday.users.service.imp;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.AmenityListDTO;
import shop.biday.users.model.domain.RoomDetailDTO;
import shop.biday.users.model.domain.SearchDto;
import shop.biday.users.model.querydsl.DormDto;
import shop.biday.users.model.querydsl.FilterDto;
import shop.biday.users.model.querydsl.SearchRepo;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchService {
    private final SearchRepo searchRepo;

    public List<DormDto> findList(SearchDto searchDto) {
        return searchRepo.findList(searchDto);
    }

    public Page<DormDto> findAllList(Pageable pageable) {
        return searchRepo.findAllList(pageable);
    }


    public List<String> findByCity(String city) {
        return searchRepo.findByCity(city);
    }

    public List<DormDto> findByFilter(FilterDto filterDto) {
        return searchRepo.findByFilter(filterDto);
    }

    public List<RoomDetailDTO> findAllRoom(SearchDto searchDto, Long dormId) {
        return searchRepo.findAllRoom(searchDto, dormId);
    }

    public List<AmenityListDTO> findAmenity(Long dormId) {
        return searchRepo.findAmenity(dormId);
    }

}