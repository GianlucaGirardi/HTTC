package httc_backend.data_processor.ClassRoom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class ClassRoomController {
    private final  ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService){
        this.classRoomService = classRoomService;
    }

    @GetMapping
    public ResponseEntity<?> getEmptyClassRooms(){
        try{
            return ResponseEntity.ok(this.classRoomService.getEmptyClassRooms());
        }
        catch(IllegalStateException e){
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Data is still loading. Please try again soon.");
            }
        }
}
