package shop.biday.users.service;

import shop.biday.users.model.domain.DcategoryListDTO;

import java.util.List;

public interface DcategoryService {
    List<DcategoryListDTO> list();
}
