package httc_backend.data_processor.ClassRoom.FilterStrategies;

import httc_backend.data_processor.ClassRoom.ClassRoom;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("filterByCampus")
public class FilterStrategyByCampus implements FilterStrategy{
    private final FilterStrategyTimeDate filterStrategyTimeDate;

    public FilterStrategyByCampus(FilterStrategyTimeDate filterStrategyTimeDate){
        this.filterStrategyTimeDate = filterStrategyTimeDate;
    }

    @Override
    public List<ClassRoom> filterEmptyClassRooms(List<ClassRoom> classRooms, Map<String, Object> paramMap) {
        List<String> campuses = (List<String>) paramMap.get("campuses");
        List<ClassRoom> classRoomsPerCampus = classRooms.stream().filter(classRoom -> campuses.contains(classRoom.getLocationCode())).toList();
        return filterStrategyTimeDate.filterEmptyClassRooms(classRooms, paramMap)
                .stream().filter(classRoomsPerCampus::contains).collect(Collectors.toList());
    }
}
