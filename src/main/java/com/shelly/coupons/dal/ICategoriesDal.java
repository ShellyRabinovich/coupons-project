package com.shelly.coupons.dal;
import com.shelly.coupons.dto.CategoriesDTO;
import com.shelly.coupons.entities.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICategoriesDal extends CrudRepository<Category, Long> {

    @Query("SELECT new com.shelly.coupons.dto.CategoriesDTO" +
            "(ca.id, ca.name) " +
            "FROM Category ca")
    List<CategoriesDTO> findAllCategories();

}

