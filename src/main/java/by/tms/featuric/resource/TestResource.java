package by.tms.featuric.resource;

import by.tms.featuric.dto.TestDto;
import by.tms.featuric.entity.FtrcCategory;
import by.tms.featuric.entity.FtrcTest;
import by.tms.featuric.service.interfaces.TestService;
import by.tms.featuric.service.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
    public TestDto getByCategory(@PathVariable FtrcCategory category) {
        log.info("GET - get test by category, path: /test/byCategory/{category}?category= " + category);
        return testMapper.toDto(testService.findTestByCategory(category));
    }

    @GetMapping("/byName/{name}")
    public TestDto getByName(@PathVariable String name) {
        log.info("GET - get test by name, path:/test/byName/{name}?name= " + name);
        return testMapper.toDto(testService.findTestByName(name));
    }

    @GetMapping("/{id}")
    public TestDto getTest(@PathVariable BigInteger id) {
        log.info("GET - get test by ID, path: /test/{id}?id= " + id);
        return testMapper.toDto(testService.findTestById(id));
    }

    @GetMapping("/getAll")
    public List<TestDto> getAll() {
        log.info("GET - get all tests, path: /test/getAll");
        return testService.getAllTests().stream()
                .map(testMapper::toShortDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/save")
    public TestDto save(@RequestBody TestDto testDto) {
        log.info("POST - save test, path: /test/save");
        FtrcTest test = testMapper.toEntity(testDto);
        return testMapper.toDto(testService.save(test));
    }

    @PutMapping("/{id}")
    public TestDto update(@PathVariable BigInteger id, @RequestBody TestDto testDto) {
        log.info("PUT - update test, path: /test/{id}?id= " + id);
        FtrcTest test = testMapper.toEntity(testDto);
        return testMapper.toDto(testService.update(id, test));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable BigInteger id) {
        log.info("DELETE - delete test, path: /test/{id}?id= " + id);
        testService.deleteTestById(id);
        return ResponseEntity.ok().build();
    }
}
