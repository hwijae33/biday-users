package shop.biday.users.service.imp;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.DamenityAddDTO;
import shop.biday.users.model.entity.Amenity;
import shop.biday.users.model.entity.Damenity;
import shop.biday.users.model.entity.Dorm;
import shop.biday.users.model.repository.AmenityRepository;
import shop.biday.users.model.repository.DamenityRepository;
import shop.biday.users.model.repository.DormRepository;
import shop.biday.users.service.DamenityService;


@Service
@Transactional
@RequiredArgsConstructor
public class DamenityServiceImpl implements DamenityService {

    private final DormRepository DORMREPOSITORY;
    private final DamenityRepository DAMENITYREPOSITORY;
    private final AmenityRepository AMENITYREPOSITORY;



    @Transactional
    public boolean insert(DamenityAddDTO damenityAddDTO) {
        Dorm dorm = DORMREPOSITORY.findById(damenityAddDTO.getDormId())
                .orElseThrow(() -> new RuntimeException("Dorm not found"));

        for (Long amenityId : damenityAddDTO.getAmenityId()) {
            Amenity amenity = AMENITYREPOSITORY.findById(amenityId)
                    .orElseThrow(() -> new RuntimeException("Amenity not found"));

            Damenity damenity = Damenity.builder()
                    .amenity(amenity)
                    .dorm(dorm)
                    .build();

            DAMENITYREPOSITORY.save(damenity);
        }
        return false;
    }
}
