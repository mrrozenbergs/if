import exceptions.PolicyAlreadyExistsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class InsuranceCompanyTest {

    String name = "IF";
    List<Risk> risksAvailable = new ArrayList<>();
    List<Policy> policies = new ArrayList<>();
    InsuranceCompany insuranceCompany = new InsuranceCompany();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        risksAvailable.add(new Risk("demolition", 100));
        risksAvailable.add(new Risk("theft", 200));
        risksAvailable.add(new Risk("flood", 300));
        risksAvailable.add(new Risk("fire", 400));

        policies.add(new Policy("Car",LocalDateTime.of(2019,1,1,1,1,1,1), (short) 12, risksAvailable));
        policies.add(new Policy("Apartment",LocalDateTime.of(2019,6,1,1,1,1,1), (short) 18, risksAvailable));
        policies.add(new Policy("Office",LocalDateTime.of(2019,10,1,1,1,1,1), (short) 6, risksAvailable));
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("IF", this.name);
    }

    @Test
    public void getAvailableRisksTest(){
        try {
            insuranceCompany.setAvailableRisks(risksAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertArrayEquals("Risks", risksAvailable.toArray(), insuranceCompany.getAvailableRisks().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setAvailableRisksTest(){
        List<Risk> list = new ArrayList<>();
        Risk risk = new Risk();
        risk.setName("accident");
        risk.setYearlyPrice(50);
        list.add(risk);
        try {
            insuranceCompany.setAvailableRisks(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertArrayEquals("arrays are equal", list.toArray(), insuranceCompany.getAvailableRisks().toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void sellPolicyTest(){
        try {
            insuranceCompany.sellPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1),(short) 12, risksAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Assert.assertEquals("Car2", insuranceCompany.getPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1) ).getNameOfInsuredObject());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void ifCreatingSamePoliciesTest(){
        exception.expect(PolicyAlreadyExistsException.class);
        exception.expectMessage("Policy already exists!");
        try {
            insuranceCompany.sellPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1),(short) 12, risksAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            insuranceCompany.sellPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1),(short) 12, risksAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addRiskTest(){
        Risk risk = new Risk();
        risk.setName("accident");
        risk.setYearlyPrice(50);

        try {
            insuranceCompany.sellPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1),(short) 12, risksAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            insuranceCompany.addRisk("Car2", risk, LocalDateTime.of(2019,10,1,1,1,1,1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Assert.assertEquals(risk, insuranceCompany.getPolicy("Car2", LocalDateTime.of(2019,1,1,1,1,1,1))
                    .getInsuredRisks().stream().filter(a -> "accident".equals(a.getName())).findAny().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPolicyTest(){
        try {
            insuranceCompany.sellPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1),(short) 12, risksAvailable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals("Car2", insuranceCompany.getPolicy("Car2", LocalDateTime.of(2019,10,1,1,1,1,1) ).getNameOfInsuredObject());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
