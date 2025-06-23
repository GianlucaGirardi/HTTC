package httc_backend.data_processor.ClassRoom;

import httc_backend.data_processor.Schedule.Schedule;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClassRoomService {
    private final List<ClassRoom> classRooms;
    private final Set<String> classRoomSet;
    private boolean isClassroomsLoaded = false;

    public ClassRoomService(){
        this.classRoomSet = new HashSet<>();
        this.classRooms = new ArrayList<>();
    }

    public List<ClassRoom> getEmptyClassRooms() {
        if (!isClassroomsLoaded) {
            throw new IllegalStateException("Classroom data is loaded yet");
        }
        return filterEmptyClassRooms(this.classRooms);
    }

    public void mapSchedulesToClassRooms(List<Schedule> schedules)  {
        schedules.forEach(schedule -> {
            String roomCode = schedule.getRoomCode();
            String startTime = schedule.getClassStartTime();
            String endTime = schedule.getClassEndTime();

            if(!classRoomSet.contains(roomCode)){
                classRoomSet.add(roomCode);
                classRooms.add(new ClassRoom(roomCode, startTime, endTime, getDaysOfTheWeek(schedule)));
            }
            else{
                Objects.requireNonNull(classRooms.stream().filter(item ->
                        item.getRoomId().equals(roomCode)
                ).findFirst().orElse(null)).addTimeSlot(startTime, endTime, getDaysOfTheWeek(schedule));
            }
        });
        setIsClassRoomsLoaded(true);
    }

    private List<ClassRoom> filterEmptyClassRooms(List<ClassRoom> classRooms){
        return classRooms.stream().filter(ClassRoom::isClassAvailable).collect(Collectors.toList());
    }

    private List<String> getDaysOfTheWeek(Schedule schedule){
        return Arrays.stream(Schedule.class.getDeclaredFields())
                .filter(field -> {
                    try{
                        return "Y".equals(Schedule.class.getMethod("get" + capitalizeFirstLetter(field.getName())).invoke(schedule));
                    }
                    catch(Exception e){
                        return false;
                    }
                }).map(Field::getName).collect(Collectors.toList());
    }

    public String capitalizeFirstLetter(String str){
        if (str == null || str.isEmpty()){
            return str;
        }
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setIsClassRoomsLoaded(boolean isClassRoomsLoaded){
        this.isClassroomsLoaded = isClassRoomsLoaded;
    }

    public boolean getIsClassroomsLoaded() {
        return isClassroomsLoaded;
    }
}
