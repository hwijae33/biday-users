package shop.biday.users.service;

import shop.biday.users.model.domain.DormAddDTO;
import shop.biday.users.model.domain.DormDTO;

public interface DormService {

    Long insert(DormAddDTO dormAddDTO);

    DormDTO getDormById(Long id);
}
