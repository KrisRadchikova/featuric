package by.tms.featuric.service.interfaces;

import by.tms.featuric.entity.FtrcCategory;

import java.math.BigInteger;
import java.util.List;

public interface CategoryService {

    FtrcCategory save(FtrcCategory ftrcCategory);

    FtrcCategory update(BigInteger id, FtrcCategory ftrcCategory);

    void deleteCategoryById(BigInteger id);

    List<FtrcCategory> getAllCategories();

    FtrcCategory findCategoryById(BigInteger id);

    FtrcCategory findCategoryByName(String name);
}
