package by.tms.featuric.resource;

import by.tms.featuric.dto.TestDto;
import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;
import by.tms.featuric.service.interfaces.TestService;
import by.tms.featuric.service.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class TestResource {
    private final TestService testService;
    private final TestMapper testMapper;

    @Autowired
    public TestResource(TestService testService, TestMapper testMapper) {
        this.testService = testService;
        this.testMapper = testMapper;
    }

    @GetMapping("/byCategory/{category}")
    public TestDto getByCategory(@PathVariable FtrcCategory category){
        return testMapper.toDto(testService.findTestByCategory(category));
    }

    @GetMapping("/byName/{name}")
    public TestDto getByName(@PathVariable String name){
        return testMapper.toDto(testService.findTestByName(name));
    }

    @GetMapping("/{id}")
    public TestDto getTest(@PathVariable BigInteger id){
        return testMapper.toDto(testService.findTestById(id));
    }

    @GetMapping("/getAll")
    public List<TestDto> getAll(){
        return testService.getAllTests().stream()
                .map(testMapper::toShortDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public TestDto save(@RequestBody TestDto testDto){
        FtrcTest test = testMapper.toEntity(testDto);
        return testMapper.toDto(testService.save(test));
    }

    @PutMapping("/{id}")
    public TestDto update(@PathVariable BigInteger id, @RequestBody TestDto testDto){
        FtrcTest test = testMapper.toEntity(testDto);
        return testMapper.toDto(testService.update(id, test));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id){
        testService.deleteTestById(id);
        return ResponseEntity.ok().build();
    }
}
