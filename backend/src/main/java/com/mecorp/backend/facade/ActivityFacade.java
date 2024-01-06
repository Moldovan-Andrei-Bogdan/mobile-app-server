package com.mecorp.backend.facade;

import com.mecorp.backend.dto.ActivityDto;
import com.mecorp.backend.model.Activity;
import com.mecorp.backend.populator.impl.FullActivityPopulator;
import com.mecorp.backend.populator.impl.FullActivityReversePopulator;
import com.mecorp.backend.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityFacade {
    private final ActivityService activityService;

    private final FullActivityPopulator fullActivityPopulator;

    private final FullActivityReversePopulator fullActivityReversePopulator;

    public ActivityDto createActivity(ActivityDto activityDto) {
        Activity activity = new Activity();
        this.fullActivityReversePopulator.populate(activityDto, activity);

        Activity savedActivity = this.activityService.createActivity(activity);
        ActivityDto savedActivityDto = new ActivityDto();
        this.fullActivityPopulator.populate(savedActivity, savedActivityDto);

        return savedActivityDto;
    }

    public List<ActivityDto> createActivities(List<ActivityDto> activityDtoList) {
        List<Activity> activityList = new ArrayList<>();

        for (ActivityDto activityDto : activityDtoList) {
            Activity activity = new Activity();
            this.fullActivityReversePopulator.populate(activityDto, activity);
            activityList.add(activity);
        }

        List<Activity> result = this.activityService.createActivities(activityList);
        List<ActivityDto> savedActivityDtos = new ArrayList<>();

        for (Activity activity : result) {
            ActivityDto activityDto = new ActivityDto();
            this.fullActivityPopulator.populate(activity, activityDto);
            savedActivityDtos.add(activityDto);
        }

        return savedActivityDtos;
    }

    public ActivityDto updateActivity(Integer id, ActivityDto activityDto) throws Exception {
        Activity activity = new Activity();
        this.fullActivityReversePopulator.populate(activityDto, activity);

        Activity updatedActivity = this.activityService.updateActivity(id, activity);
        ActivityDto updatedActivityDto = new ActivityDto();
        this.fullActivityPopulator.populate(updatedActivity, updatedActivityDto);

        return updatedActivityDto;
    }

    public ActivityDto deleteActivity(Integer id) throws Exception {
        Activity deletedActivity = this.activityService.deleteActivity(id);
        ActivityDto deletedActivityDto = new ActivityDto();
        this.fullActivityPopulator.populate(deletedActivity, deletedActivityDto);

        return deletedActivityDto;
    }

    public List<ActivityDto> getActivityList() {
        List<Activity> activityList = this.activityService.getActivityList();
        List<ActivityDto> activityDtoList = new ArrayList<>();

        for (Activity activity : activityList) {
            ActivityDto activityDto = new ActivityDto();
            this.fullActivityPopulator.populate(activity, activityDto);
            activityDtoList.add(activityDto);
        }

        return activityDtoList;
    }

    public ActivityDto getActivityById(Integer id) throws Exception {
        Activity activity = this.activityService.getActivityById(id);
        ActivityDto activityDto = new ActivityDto();
        this.fullActivityPopulator.populate(activity, activityDto);

        return activityDto;
    }
}
