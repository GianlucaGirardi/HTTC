package httc_backend.data_processor.Schedule;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import httc_backend.data_processor.ClassRoom.ClassRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {
    private final ObjectMapper mapper;

    public ScheduleService(ClassRoomService classRoomService){
        this.mapper = new ObjectMapper();
    }

    public List<Schedule> mapResponseToSchedules(ResponseEntity<String> response) throws JsonProcessingException {
        return  mapper.readValue(
                response.getBody(),
                new TypeReference<List<Schedule>>() {
                }
        );
    }
}
