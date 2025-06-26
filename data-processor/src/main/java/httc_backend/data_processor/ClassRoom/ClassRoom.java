package httc_backend.data_processor.ClassRoom;
import httc_backend.data_processor.TimeSlot.TimeSlot;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH.mm.ss");
    private final String roomId;
    private final List<TimeSlot> timeSlotList;
    private final String locationCode;

    public ClassRoom(String roomId, String locationCode, String classStartTime, String classEndTime, List<String> daysOfTheWeek){
        this.roomId = roomId;
        this.timeSlotList = new ArrayList<>();
        this.locationCode = locationCode;
        this.addTimeSlot(classStartTime, classEndTime, daysOfTheWeek);
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getLocationCode() {
        return this.locationCode;
    }

    public void addTimeSlot(String classStartTime, String classEndTime, List<String> daysOfTheWeek){
        if (classStartTime == null || classStartTime.isBlank() ||
                classEndTime == null || classEndTime.isBlank()) {
            return;
        }
        timeSlotList.add(new TimeSlot(LocalTime.parse(classStartTime, FORMATTER),LocalTime.parse(classEndTime, FORMATTER), daysOfTheWeek));
    }

    public boolean isClassAvailable(String dayOfTheWeek, LocalTime time) {
        return timeSlotList.stream()
                .allMatch(slot ->
                   !slot.getDaysOfTheWeek().contains(dayOfTheWeek) || (time.isBefore(slot.getClassStartTime()) || time.isAfter(slot.getClassEndTime()))
                );
    }
}
