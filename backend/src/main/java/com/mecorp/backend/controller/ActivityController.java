package com.mecorp.backend.controller;

import com.mecorp.backend.dto.ActivityDto;
import com.mecorp.backend.facade.ActivityFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ActivityController {
    private final ActivityFacade activityFacade;

    private final Map<String, WebSocketSession> websocketSessions;

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

    @GetMapping("/websocket/notif")
    public void sendNotif() {
        TextMessage textMessage = new TextMessage("new-data-arrived");
        websocketSessions.forEach((id, websocketSession) -> {
            try {
                websocketSession.sendMessage(textMessage);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
