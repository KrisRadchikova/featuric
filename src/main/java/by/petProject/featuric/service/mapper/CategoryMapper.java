package by.petProject.featuric.service.mapper;

import by.petProject.featuric.service.interfaces.Mapper;
import by.petProject.featuric.dto.CategoryDto;
import by.petProject.featuric.entity.FtrcCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<FtrcCategory, CategoryDto> {
    @Override
    public CategoryDto toDto(FtrcCategory entity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());
        categoryDto.setDescription(entity.getDescription());
        return categoryDto;
    }

    @Override
    public FtrcCategory toEntity(CategoryDto dto) {
        FtrcCategory category = new FtrcCategory();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    @Override
    public CategoryDto toShortDto(FtrcCategory entity) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(entity.getId());
        categoryDto.setName(entity.getName());
        categoryDto.setDescription(entity.getDescription());
        return categoryDto;
    }
}
