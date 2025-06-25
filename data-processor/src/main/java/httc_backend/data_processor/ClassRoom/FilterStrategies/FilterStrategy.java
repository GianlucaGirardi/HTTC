package httc_backend.data_processor.ClassRoom.FilterStrategies;

import httc_backend.data_processor.ClassRoom.ClassRoom;

import java.util.List;

public interface FilterStrategy {
    List<ClassRoom> filterEmptyClassRooms(List<ClassRoom> classRooms);
}