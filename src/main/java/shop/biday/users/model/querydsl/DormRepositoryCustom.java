package shop.biday.users.model.querydsl;

import java.util.List;

public interface DormRepositoryCustom {
    List<DormBookingListDTO> findBookingsBySellerId(Long userId);
}

