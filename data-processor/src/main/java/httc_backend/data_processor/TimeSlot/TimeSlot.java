package httc_backend.data_processor.TimeSlot;

import java.time.LocalTime;
import java.util.List;

public class TimeSlot {
    private LocalTime classStartTime;
    private LocalTime classEndTime;
    private List<String> daysOfTheWeek;

    public TimeSlot(LocalTime classStartTime, LocalTime classEndTime, List<String> daysOfTheWeek){
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.daysOfTheWeek = daysOfTheWeek;
    }

    public LocalTime getClassStartTime() {
        return classStartTime;
    }

    public LocalTime getClassEndTime() {
        return classEndTime;
    }

    public List<String> getDaysOfTheWeek() {
        return daysOfTheWeek;
    }
}
