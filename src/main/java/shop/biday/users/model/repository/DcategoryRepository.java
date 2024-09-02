package shop.biday.users.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import shop.biday.users.model.entity.Dcategory;

import java.util.List;
import java.util.Optional;

public interface DcategoryRepository extends JpaRepository<Dcategory, Long> {
    @Override
    Optional<Dcategory> findById(Long id);

    @Override
    List<Dcategory> findAll();

}
