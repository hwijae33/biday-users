package shop.biday.users.model.querydsl;

import java.util.List;

public interface UsersRepositoryCustom {

    List<UsersListDTO> findUsersList();

}
