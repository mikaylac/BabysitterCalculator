import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;

public class JobTest {

    @Test(expected = StartTimeTooEarlyException.class)
    public void shouldThrowStartTimeTooEarlyExceptionIfStartTimeIsBeforeFiveOclock() throws Exception {
        Job job = new Job();
        int threePm = 15;
        job.setStartTime(threePm);
    }

    @Test (expected = EndTimeTooLateException.class)
    public void shouldThrowEndTimeTooLateExceptionIfEndTimeIsAfterFourAm() throws Exception {
        Job job = new Job();
        int fiveAm = 29;
        job.setEndTime(fiveAm);
    }

    @Test
    public void shouldCalculateAmountOwed() throws Exception {
        Job job = new Job();
        int fivePm = 17;
        job.setStartTime(fivePm);

        int tenPm = 22;
        job.endTime = tenPm;
        BigDecimal fifteenDollars = new BigDecimal("15.00");
        job.hourlyRate = fifteenDollars;
        
        BigDecimal seventyFiveDollars = new BigDecimal("75.00");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        assertEquals(decimalFormat.format(seventyFiveDollars.doubleValue()), job.calculateAmountOwed());

        int twelveAm = 24;
        job.endTime = twelveAm;

        BigDecimal oneHundredFiveDollars = new BigDecimal("105.00");
        assertEquals(decimalFormat.format(oneHundredFiveDollars.doubleValue()), job.calculateAmountOwed());
    }

}