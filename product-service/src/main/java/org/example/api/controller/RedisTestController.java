package org.example.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.model.FilledService;
import org.example.model.FilledServiceStep;
import org.example.repository.FilledServiceRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/redis")
@RequiredArgsConstructor
public class RedisTestController {
    private final FilledServiceRepository filledServiceRepository;

    private final RedisTemplate<String, String> redisTemplate;

    @PostMapping("/service")
    public FilledService saveService(@RequestBody FilledService filledService) {
        return this.filledServiceRepository.save(filledService);
    }


    @PostMapping("/service-step")
    public void saveServiceStep(@RequestBody FilledServiceStep filledServiceStep) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        FilledService filledService = this.filledServiceRepository.findById(filledServiceStep.getFilledServiceId()).orElse(null);
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        zSetOps.add(filledService.getId(), mapper.writeValueAsString(filledServiceStep), 2);
    }

    @GetMapping("/service-step")
    public List<FilledServiceStep> getServiceStep(@RequestParam String key) throws JsonProcessingException {
        ZSetOperations<String, String> zSetOps = redisTemplate.opsForZSet();
        Set<String> jsonStrings = zSetOps.range(key, 0, -1);

        List<FilledServiceStep> filledServiceSteps = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        for (String jsonString : jsonStrings) {
            try {
                FilledServiceStep filledServiceStep = mapper.readValue(jsonString, FilledServiceStep.class);
                filledServiceSteps.add(filledServiceStep);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return filledServiceSteps;
    }
}
