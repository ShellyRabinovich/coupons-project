package com.shelly.coupons.logic;


import com.shelly.coupons.consts.Const;
import com.shelly.coupons.dal.ICategoriesDal;
import com.shelly.coupons.dto.CategoriesDTO;
import com.shelly.coupons.entities.Category;
import com.shelly.coupons.enums.ErrorType;
import com.shelly.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoriesLogic {
    @Autowired
    private ICategoriesDal categoriesDal;

    public long createCategory(Category category) throws ServerException {
        // Validations
        try {
            categoriesDal.save(category);
            return category.getId();
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to create category" + category.toString(), e);
        }
    }

    public void updateCategory(Category category) throws ServerException {
        // Validations
        try {
            categoriesDal.save(category);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to update category. id: " + category.getId(), e);
        }
    }

    public Category getCategory(long id) throws ServerException {
        try {
            Category category = categoriesDal.findById(id).get();
            return category;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get category. id: " + id, e);
        }

    }

    public void deleteCategory(long id) throws ServerException {
        try {
            categoriesDal.deleteById(id);
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to remove category. id: " + id, e);
        }
    }

    public List<CategoriesDTO> getAllCategories() throws ServerException {
        try {
            List<CategoriesDTO> categories = categoriesDal.findAllCategories();
            return categories;
        } catch (Exception e) {
            throw new ServerException(ErrorType.GENERAL_ERROR, "Failed to get all categories", e);
        }

    }
}
