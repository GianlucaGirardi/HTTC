package httc_backend.data_processor.ClassRoom.FilterStrategies;

import httc_backend.data_processor.ClassRoom.ClassRoom;

import java.util.List;
import java.util.Map;

public interface FilterStrategy {
    List<ClassRoom> filterEmptyClassRooms(List<ClassRoom> classRooms, Map<String, Object> paramMap);
}