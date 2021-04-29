package by.tms.featuric.resource;

import by.tms.featuric.dto.CategoryDto;
import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.service.interfaces.CategoryService;
import by.tms.featuric.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryResource {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryResource(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/byId/{id}")
    public CategoryDto getCategory(@PathVariable BigInteger id){
        return categoryMapper.toDto(categoryService.findCategoryById(id));
    }

    @GetMapping("/byName/{name}")
    public CategoryDto getByName(@PathVariable String name){
        return categoryMapper.toDto(categoryService.findCategoryByName(name));
    }

    @GetMapping("/getAll")
    public List<CategoryDto> getAllCategories(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return categoryService.getAllCategories().stream()
                .map(categoryMapper::toShortDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public CategoryDto save(@RequestBody CategoryDto categoryDto){
        FtrcCategory category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryService.save(category));
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable BigInteger id, @RequestBody CategoryDto categoryDto){
        FtrcCategory category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }
}
