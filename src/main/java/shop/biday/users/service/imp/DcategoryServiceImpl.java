package shop.biday.users.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.biday.users.model.domain.DcategoryListDTO;
import shop.biday.users.model.entity.Dcategory;
import shop.biday.users.model.repository.DcategoryRepository;
import shop.biday.users.service.DcategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class DcategoryServiceImpl implements DcategoryService {

    private final DcategoryRepository DCATEGORYREPOSITORY;

    @Override
    public List<DcategoryListDTO> list() {

        List<Dcategory> dcategories = DCATEGORYREPOSITORY.findAll();

        return dcategories.stream()
                .map(dcategorie -> DcategoryListDTO.builder()
                .id(dcategorie.getId())
                .name(dcategorie.getName())
                .build())
                .collect(Collectors.toList());

    }
}

