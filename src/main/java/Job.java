import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Job {

    private int startTime;
    public int endTime;
    public BigDecimal hourlyRate;

    public void setStartTime(int timeToSet) throws StartTimeTooEarlyException {
        int fivePm = 17;
        if(timeToSet >= fivePm) {
            this.startTime = timeToSet;
        } else {
            throw new StartTimeTooEarlyException();
        }
    }

    public String calculateAmountOwed() {
        BigDecimal hoursWorked = new BigDecimal(Double.valueOf(this.endTime - this.startTime).toString());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(hourlyRate.multiply(hoursWorked));
    }

    public void setEndTime(int endTimeToSet) throws EndTimeTooLateException {
        int fourAm = 28;
        if(endTimeToSet <= fourAm){
            this.endTime = endTimeToSet;
        } else {
            throw new EndTimeTooLateException();
        }
    }

    public void setFamily(Family familyToSet) {
    }
}
