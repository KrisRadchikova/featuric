package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.repository.FtrcCategoryRepository;
import by.tms.featuric.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final FtrcCategoryRepository ftrcCategoryRepository;

    @Autowired
    public CategoryServiceImpl(FtrcCategoryRepository ftrcCategoryRepository) {
        this.ftrcCategoryRepository = ftrcCategoryRepository;
    }

    @Override
    public FtrcCategory save(FtrcCategory ftrcCategory) {
        return ftrcCategoryRepository.save(ftrcCategory);
    }

    @Override
    public FtrcCategory update(BigInteger id, FtrcCategory ftrcCategoryRequest) {
        ftrcCategoryRepository.findById(id).map(ftrcCategory -> {
            ftrcCategory.setName(ftrcCategoryRequest.getName());
            ftrcCategory.setDescription(ftrcCategoryRequest.getDescription());
            return ftrcCategoryRepository.save(ftrcCategory);
        });
        return ftrcCategoryRequest;
    }

    @Override
    public void deleteCategoryById(BigInteger id) {
        ftrcCategoryRepository.deleteById(id);
    }

    @Override
    public List<FtrcCategory> getAllCategories() {
        return ftrcCategoryRepository.findAll();
    }

    @Override
    public FtrcCategory findCategoryById(BigInteger id) {
        return ftrcCategoryRepository.findById(id).orElseThrow(ArrayIndexOutOfBoundsException::new);
    }

    @Override
    public FtrcCategory findCategoryByName(String name) {
        return ftrcCategoryRepository.findFtrcCategoryByName(name);
    }
}
