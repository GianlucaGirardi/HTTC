package httc_backend.data_processor.StartUpLoader;

import com.fasterxml.jackson.core.JsonProcessingException;
import httc_backend.data_processor.ClassRoom.ClassRoomService;
import httc_backend.data_processor.PublicApiClient.PublicApiClient;
import httc_backend.data_processor.Schedule.ScheduleService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StartUpDataLoader {
    private final PublicApiClient publicApiClient;
    private final ScheduleService scheduleService;
    private final ClassRoomService classRoomService;

    public StartUpDataLoader(PublicApiClient publicApiClient, ScheduleService scheduleService, ClassRoomService classRoomService){
        this.publicApiClient = publicApiClient;
        this.scheduleService = scheduleService;
        this.classRoomService = classRoomService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadClassesOnStartUp() throws JsonProcessingException {
        ResponseEntity<String> response = publicApiClient.fetchSchedulesFromConcordiaApi();
        classRoomService.mapSchedulesToClassRooms(scheduleService.mapResponseToSchedules(response));
    }
}
