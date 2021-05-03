package by.tms.featuric.service.impl;

import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.exception.ExistsException;
import by.tms.featuric.exception.IndexOutOfBoundsException;
import by.tms.featuric.exception.NotFoundException;
import by.tms.featuric.repository.FtrcCategoryRepository;
import by.tms.featuric.service.interfaces.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final FtrcCategoryRepository ftrcCategoryRepository;

    @Autowired
    public CategoryServiceImpl(FtrcCategoryRepository ftrcCategoryRepository) {
        this.ftrcCategoryRepository = ftrcCategoryRepository;
    }

    @Override
    public FtrcCategory save(FtrcCategory ftrcCategory) {
        log.info("Method - save category");
        if (ftrcCategoryRepository.findFtrcCategoryByName(ftrcCategory.getName()) != null) {
            throw new ExistsException("Category exists");
        }
        return ftrcCategoryRepository.save(ftrcCategory);
    }

    @Override
    public FtrcCategory update(BigInteger id, FtrcCategory ftrcCategoryRequest) {
        log.info("Method - update category");
        ftrcCategoryRepository.findById(id).map(ftrcCategory -> {
            ftrcCategory.setName(ftrcCategoryRequest.getName());
            ftrcCategory.setDescription(ftrcCategoryRequest.getDescription());
            return ftrcCategoryRepository.save(ftrcCategory);
        });
        return ftrcCategoryRequest;
    }

    @Override
    public void deleteCategoryById(BigInteger id) {
        log.info("Method - delete category by ID");
        if (ftrcCategoryRepository.findById(id).isPresent()) {
            ftrcCategoryRepository.deleteById(id);
        } else {
            throw new NotFoundException("Category with id " + id + " not found");
        }
    }

    @Override
    public List<FtrcCategory> getAllCategories() {
        log.info("Method - get all categories");
        return ftrcCategoryRepository.findAll();
    }

    @Override
    public FtrcCategory findCategoryById(BigInteger id) {
        log.info("Method - find category by ID");
        return ftrcCategoryRepository.findById(id).orElseThrow(IndexOutOfBoundsException::new);
    }

    @Override
    public FtrcCategory findCategoryByName(String name) {
        log.info("Method - find category by name");
        boolean b = ftrcCategoryRepository.findFtrcCategoryByName(name) != null;
        if (b) {
            return ftrcCategoryRepository.findFtrcCategoryByName(name);
        } else {
            throw new NotFoundException("Category not found");
        }
    }
}
