package httc_backend.data_processor.ClassRoom.FilterStrategies;

import httc_backend.data_processor.ClassRoom.ClassRoom;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("filterTimeDate")
public class FilterStrategyTimeDate implements FilterStrategy{
    public static final String DAY_PREFIX = "s";

    @Override
    public List<ClassRoom> filterEmptyClassRooms(List<ClassRoom> classRooms, Map<String, Object> paramMap) {
        String dayOfTheWeek = (String) paramMap.getOrDefault("dayOfTheWeek", LocalDate.now().getDayOfWeek().toString().toLowerCase() + DAY_PREFIX);
        Object time = paramMap.get("time");
        LocalTime parsedTime = (time instanceof String) ? LocalTime.parse((String) time) : LocalTime.now();
        return classRooms.stream().filter(classRoom -> classRoom.isClassAvailable(dayOfTheWeek, parsedTime)).collect(Collectors.toList());
    }
}
