package httc_backend.data_processor.ClassRoom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class ClassRoomController {
    private final  ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService){
        this.classRoomService = classRoomService;
    }

    @PostMapping
    public ResponseEntity<?> getEmptyClassRooms(
            @RequestParam(defaultValue = "filterTimeDate") String filterKey,
            @RequestBody Map<String, Object> paramMap
    ){
        try{
            return ResponseEntity.ok(this.classRoomService.getEmptyClassRooms(filterKey, paramMap));
        }
        catch(IllegalStateException e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Data is still loading. Please try again soon.");
            }
        }
}
