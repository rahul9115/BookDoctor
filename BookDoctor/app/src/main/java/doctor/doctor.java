package doctor;

public class doctor {
    public   String KEY_ID1="doctors_id";
    public   String KEY_Name="Name";
    public   String KEY_Specialization="specialization";
    public   String KEY_Work_Time="time_slot";

    public String getKEY_Name() {
        return KEY_Name;
    }

    public void setKEY_Name(String KEY_Name) {
        this.KEY_Name = KEY_Name;
    }

    public String getKEY_Specialization() {
        return KEY_Specialization;
    }

    public void setKEY_Specialization(String KEY_Specialization) {
        this.KEY_Specialization = KEY_Specialization;
    }

    public String getKEY_Work_Time() {
        return KEY_Work_Time;
    }

    public void setKEY_Work_Time(String KEY_Work_Time) {
        this.KEY_Work_Time = KEY_Work_Time;
    }
}
