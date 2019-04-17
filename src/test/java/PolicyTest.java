import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PolicyTest {
    List<Risk> risks = new ArrayList<>();
    Policy policy = new Policy();

    @Before
    public void setUp() {
        risks.add(new Risk("demolition", 100));
        risks.add(new Risk("theft", 200));
        risks.add(new Risk("flood", 300));
        risks.add(new Risk("fire", 400));

        policy.setRisks(risks);
        policy.setValidMonths((short) 12);
        policy.setValidFrom(LocalDateTime.of(2019,1,1,1,1,1,1));
        policy.setNameOfInsuredObject("Car");
    }

    @Test
    public void getValidFromTest() {
        Assert.assertTrue(policy.getValidFrom().isEqual(LocalDateTime.of(2019,1,1,1,1,1,1)));
    }

    @Test
    public void getValidTillTest() {
        Assert.assertTrue(policy.getValidTill().isEqual(LocalDateTime.of(2020,1,1,1,1,1,1)));
    }

    @Test
    public void getPremiumTest() {
        try {
            Assert.assertEquals(1000, policy.getPremium(), 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getInsuredRisksTest() {
        try {
            Assert.assertArrayEquals("Expected same result", risks.toArray(), policy.getInsuredRisks().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
