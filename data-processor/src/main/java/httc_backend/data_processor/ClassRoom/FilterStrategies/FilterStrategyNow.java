package httc_backend.data_processor.ClassRoom.FilterStrategies;

import httc_backend.data_processor.ClassRoom.ClassRoom;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component("filterNow")
public class FilterStrategyNow implements FilterStrategy{
    public static final String DAY_PREFIX = "s";

    @Override
    public List<ClassRoom> filterEmptyClassRooms(List<ClassRoom> classRooms) {
        String dayOfTheWeek = LocalDate.now().getDayOfWeek().toString().toLowerCase() + DAY_PREFIX;
        LocalTime now = LocalTime.now();
        return classRooms.stream().filter(classRoom -> classRoom.isClassAvailable(dayOfTheWeek, now)).collect(Collectors.toList());
    }
}