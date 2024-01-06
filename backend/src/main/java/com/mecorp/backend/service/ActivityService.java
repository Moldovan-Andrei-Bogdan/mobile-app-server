package com.mecorp.backend.service;

import com.mecorp.backend.model.Activity;
import com.mecorp.backend.repository.ActivityRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;

    public Activity createActivity(Activity activity) {
        return this.activityRepository.save(activity);
    }

    public List<Activity> createActivities(List<Activity> activities) {
        return this.activityRepository.saveAll(activities);
    }

    public Activity updateActivity(Integer id, Activity activity) throws Exception {
        Activity existingActivity = this.getActivityById(id);
        activity.setId(existingActivity.getId());

        return this.activityRepository.save(activity);
    }

    public Activity deleteActivity(Integer id) throws Exception {
        Activity activity = this.getActivityById(id);
        this.activityRepository.delete(activity);

        return activity;
    }

    public List<Activity> getActivityList() {
        return this.activityRepository.findAll();
    }

    public Activity getActivityById(Integer id) throws Exception {
        Optional<Activity> activityOptional = this.activityRepository.findById(id);

        return activityOptional.orElseThrow(() -> new Exception("No Activity with this id exists"));
    }
}
