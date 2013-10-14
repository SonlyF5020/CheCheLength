import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void shouldJudgeWhenUnitIsTheSame() throws Exception {
        MyLength threeMeter = new MyLength(3 , "M");
        MyLength anotherThreeMeter = new MyLength(3, "M");
        MyLength fourMeter = new MyLength(4 , "M");
        assertThat(threeMeter,is(anotherThreeMeter));
        assertThat(threeMeter.equals(fourMeter),is(false));
    }

    @Test
    public void differentUnitCanCompare() throws Exception {
        MyLength threeMeter = new MyLength(3 , "M");
        MyLength threeHandredMM = new MyLength(300, "CM");
        assertThat(threeMeter,is(threeHandredMM));
    }

    @Test
    public void sameUnitCaculate() throws Exception {
        MyLength threeMeter = new MyLength(3, "M");
        MyLength fourMeter = new MyLength(4, "M");
        MyLength oneMeter = fourMeter.minus(threeMeter);
        MyLength sevenMeter = fourMeter.add(threeMeter);
        assertThat(oneMeter,is(new MyLength(1 , "M")));
        assertThat(sevenMeter,is(new MyLength(7 , "M")));
    }

    @Test
    public void differentUnitCaculate() throws Exception {
        MyLength threeHandredMM = new MyLength(300, "MM");
        MyLength fourMeter = new MyLength(4, "M");
        MyLength oneMeter = fourMeter.minus(threeHandredMM);
        MyLength sevenMeter = fourMeter.add(threeHandredMM);
        assertThat(oneMeter,is(new MyLength(1 , "M")));
        assertThat(oneMeter,is(new MyLength(100 , "CM")));
        assertThat(sevenMeter,is(new MyLength(7 , "M")));
        assertThat(sevenMeter,is(new MyLength(700 , "CM")));
    }
}
