package com.mecorp.backend.populator.impl;

import com.mecorp.backend.dto.ActivityDto;
import com.mecorp.backend.model.Activity;
import com.mecorp.backend.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class FullActivityPopulator implements Populator<Activity, ActivityDto> {
    @Override
    public void populate(Activity source, ActivityDto target) {
        target.setId(source.getId());
        target.setTitle(source.getTitle());
        target.setOccurrenceDate(source.getOccurrenceDate());
        target.setJiraLink(source.getJiraLink());
        target.setDescription(source.getDescription());
        target.setSpentHours(source.getSpentHours());
    }
}
