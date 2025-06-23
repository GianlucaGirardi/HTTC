package httc_backend.data_processor.Schedule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
    private String courseID;
    private String termCode;
    private String session;
    private String classStatus;
    private String locationCode;
    private String instructionModeCode;
    private String roomCode;
    private String buildingCode;
    private String room;
    private String classStartTime;
    private String classEndTime;
    private String modays;
    private String tuesdays;
    private String wednesdays;
    private String thursdays;
    private String fridays;
    private String saturdays;
    private String sundays;
    private String classStartDate;
    private String classEndDate;
    private String enrollmentCapacity;

    @JsonCreator
    public Schedule(
            @JsonProperty("courseID") String courseID,
            @JsonProperty("termCode") String termCode,
            @JsonProperty("session") String session,
            @JsonProperty("classStatus") String classStatus,
            @JsonProperty("locationCode") String locationCode,
            @JsonProperty("instructionModeCode") String instructionModeCode,
            @JsonProperty("roomCode") String roomCode,
            @JsonProperty("buildingCode") String buildingCode,
            @JsonProperty("room") String room,
            @JsonProperty("classStartTime") String classStartTime,
            @JsonProperty("classEndTime") String classEndTime,
            @JsonProperty("modays") String modays,
            @JsonProperty("tuesdays") String tuesdays,
            @JsonProperty("wednesdays") String wednesdays,
            @JsonProperty("thursdays") String thursdays,
            @JsonProperty("fridays") String fridays,
            @JsonProperty("saturdays") String saturdays,
            @JsonProperty("sundays") String sundays,
            @JsonProperty("classStartDate") String classStartDate,
            @JsonProperty("classEndDate") String classEndDate,
            @JsonProperty("enrollmentCapacity") String enrollmentCapacity
    ) {
        this.courseID = courseID;
        this.termCode = termCode;
        this.session = session;
        this.classStatus = classStatus;
        this.locationCode = locationCode;
        this.instructionModeCode = instructionModeCode;
        this.roomCode = roomCode;
        this.buildingCode = buildingCode;
        this.room = room;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.modays = modays;
        this.tuesdays = tuesdays;
        this.wednesdays = wednesdays;
        this.thursdays = thursdays;
        this.fridays = fridays;
        this.saturdays = saturdays;
        this.sundays = sundays;
        this.classStartDate = classStartDate;
        this.classEndDate = classEndDate;
        this.enrollmentCapacity = enrollmentCapacity;
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getInstructionModeCode() {
        return instructionModeCode;
    }

    public void setInstructionModeCode(String instructionModeCode) {
        this.instructionModeCode = instructionModeCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(String classStartTime) {
        this.classStartTime = classStartTime;
    }

    public String getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getModays() {
        return modays;
    }

    public void setModays(String modays) {
        this.modays = modays;
    }

    public String getTuesdays() {
        return tuesdays;
    }

    public void setTuesdays(String tuesdays) {
        this.tuesdays = tuesdays;
    }

    public String getWednesdays() {
        return wednesdays;
    }

    public void setWednesdays(String wednesdays) {
        this.wednesdays = wednesdays;
    }

    public String getThursdays() {
        return thursdays;
    }

    public void setThursdays(String thursdays) {
        this.thursdays = thursdays;
    }

    public String getFridays() {
        return fridays;
    }

    public void setFridays(String fridays) {
        this.fridays = fridays;
    }

    public String getSaturdays() {
        return saturdays;
    }

    public void setSaturdays(String saturdays) {
        this.saturdays = saturdays;
    }

    public String getSundays() {
        return sundays;
    }

    public void setSundays(String sundays) {
        this.sundays = sundays;
    }

    public String getClassStartDate() {
        return classStartDate;
    }

    public void setClassStartDate(String classStartDate) {
        this.classStartDate = classStartDate;
    }

    public String getClassEndDate() {
        return classEndDate;
    }

    public void setClassEndDate(String classEndDate) {
        this.classEndDate = classEndDate;
    }

    public String getEnrollmentCapacity() {
        return enrollmentCapacity;
    }

    public void setEnrollmentCapacity(String enrollmentCapacity) {
        this.enrollmentCapacity = enrollmentCapacity;
    }
}
