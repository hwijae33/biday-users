package shop.biday.users.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.AmenityListDTO;
import shop.biday.users.model.entity.Amenity;
import shop.biday.users.model.repository.AmenityRepository;
import shop.biday.users.service.AmenityService;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private final AmenityRepository AMENITYREPOSITORY;

    @Override
    public List<AmenityListDTO> list() {

        List<Amenity> amenities = AMENITYREPOSITORY.findAll();

        return amenities.stream()
                .map(dcategory -> AmenityListDTO.builder()
                .id(dcategory.getId())
                .name(dcategory.getName())
                .build())
                .collect(Collectors.toList());

    }
}

