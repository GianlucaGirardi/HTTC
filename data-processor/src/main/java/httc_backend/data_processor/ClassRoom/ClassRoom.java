package httc_backend.data_processor.ClassRoom;
import httc_backend.data_processor.TimeSlot.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH.mm.ss");
    private final String roomId;
    private final List<TimeSlot> timeSlotList;

    public ClassRoom(String roomId, String classStartTime, String classEndTime, List<String> daysOfTheWeek){
        this.roomId = roomId;
        this.timeSlotList = new ArrayList<>();
        this.addTimeSlot(classStartTime, classEndTime, daysOfTheWeek);
    }

    public String getRoomId() {
        return roomId;
    }

    public void addTimeSlot(String classStartTime, String classEndTime, List<String> daysOfTheWeek){
        if (classStartTime == null || classStartTime.isBlank() ||
                classEndTime == null || classEndTime.isBlank()) {
            return;
        }
        timeSlotList.add(new TimeSlot(LocalTime.parse(classStartTime, FORMATTER),LocalTime.parse(classEndTime, FORMATTER), daysOfTheWeek));
    }

    public boolean isClassAvailable() {
        String dayOfTheWeek = LocalDate.now().getDayOfWeek().toString().toLowerCase() + "s";
        LocalTime now = LocalTime.now();
        return timeSlotList.stream()
                .allMatch(slot ->
                   !slot.getDaysOfTheWeek().contains(dayOfTheWeek) && (now.isBefore(slot.getClassStartTime()) || now.isAfter(slot.getClassEndTime()))
                );
    }
}
