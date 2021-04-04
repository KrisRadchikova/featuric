package by.tms.featuric.service.mapper;

import by.tms.featuric.dto.TestDto;
import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;
import by.tms.featuric.entity.FtrcUser;
import by.tms.featuric.service.interfaces.CategoryService;
import by.tms.featuric.service.interfaces.Mapper;
import by.tms.featuric.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TestMapper implements Mapper<FtrcTest, TestDto> {

    private final QuestionMapper questionMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public TestMapper(QuestionMapper questionMapper, UserService userService, CategoryService categoryService) {
        this.questionMapper = questionMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public TestDto toDto(FtrcTest entity) {
        TestDto testDto = new TestDto();
        testDto.setId(entity.getId());
        testDto.setName(entity.getName());
        testDto.setImage(entity.getImage());
        testDto.setDescription(entity.getDescription());
        testDto.setCategory(entity.getCategory().toString());
        testDto.setQuestions(entity.getQuestions()
                .stream()
                .map(questionMapper::toDto)
                .collect(Collectors.toList()));
        return testDto;
    }

    @Override
    public FtrcTest toEntity(TestDto dto) {
        FtrcCategory category = null;
        if (dto.getCategory() != null) {
            category = categoryService.findCategoryById(dto.getId());
        }
        FtrcUser user = userService.findUserById(dto.getId());
        FtrcTest test = new FtrcTest();
        test.setId(dto.getId());
        test.setName(dto.getName());
        test.setImage(dto.getImage());
        test.setDescription(dto.getDescription());
        test.setCategory(category);
        test.setQuestions(dto.getQuestions()
                .stream()
                .map(questionMapper::toEntity)
                .collect(Collectors.toList()));
        return test;
    }

    @Override
    public TestDto toShortDto(FtrcTest entity) {
        TestDto testDto = new TestDto();
        testDto.setId(entity.getId());
        testDto.setName(entity.getName());
        testDto.setImage(entity.getImage());
        testDto.setDescription(entity.getDescription());
        testDto.setCategory(entity.getCategory().toString());
        return testDto;
    }
}
