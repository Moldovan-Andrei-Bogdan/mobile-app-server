package com.mecorp.backend.controller;

import com.mecorp.backend.dto.ActivityDto;
import com.mecorp.backend.facade.ActivityFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {
    private final ActivityFacade activityFacade;

    @GetMapping("")
    public List<ActivityDto> getAllActivities() {
        return this.activityFacade.getActivityList();
    }

    @GetMapping("/{activityId}")
    public ActivityDto getActivityById(@PathVariable Integer activityId) throws Exception {
        return this.activityFacade.getActivityById(activityId);
    }

    @PostMapping("")
    public ActivityDto createActivity(@RequestBody @Valid ActivityDto activityDto) {
        return this.activityFacade.createActivity(activityDto);
    }

    @PostMapping(value="", params = "multiple")
    public List<ActivityDto> createActivities(@RequestBody @Valid List<ActivityDto> activityDtoList) {
        return this.activityFacade.createActivities(activityDtoList);
    }

    @PutMapping("/{activityId}")
    public ActivityDto updateActivity(@PathVariable Integer activityId, @RequestBody @Valid ActivityDto activityDto) throws Exception {
        return this.activityFacade.updateActivity(activityId, activityDto);
    }

    @DeleteMapping("/{activityId}")
    public ActivityDto deleteActivity(@PathVariable Integer activityId) throws Exception {
        return this.activityFacade.deleteActivity(activityId);
    }
}
