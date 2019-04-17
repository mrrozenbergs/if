import exceptions.PremiumException;
import exceptions.RiskException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Policy implements IPolicy {

    private String nameOfInsuredObject;
    private LocalDateTime validFrom;
    private short validMonths;
    private List<Risk> risks = new ArrayList<>();
    private boolean active;

    public Policy() {
        active = false;
    }

    public Policy(String nameOfInsuredObject, LocalDateTime validFrom, short validMonths, List<Risk> risks) {
        this.nameOfInsuredObject = nameOfInsuredObject;
        this.validFrom = validFrom;
        this.validMonths = validMonths;
        this.risks = risks;
        this.active = false;
    }

    public void setNameOfInsuredObject(String nameOfInsuredObject) {
        this.nameOfInsuredObject = nameOfInsuredObject;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
        if (LocalDateTime.now().isAfter(validFrom)) {
            active = true;
        }
    }

    public short getValidMonths() {
        return validMonths;
    }

    public void setValidMonths(short validMonths) {
        this.validMonths = validMonths;
    }


    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }

    @Override
    public String getNameOfInsuredObject() {
        return nameOfInsuredObject;
    }

    @Override
    public LocalDateTime getValidFrom() {
        return validFrom;
    }


    @Override
    public LocalDateTime getValidTill() {
        return validFrom.plusMonths(validMonths);
    }

    @Override
    public double getPremium() throws Exception {
        double premium = 0;
        if (risks.isEmpty()) {
            throw new PremiumException();
        } else {
            for (Risk price : risks) {
                premium = premium + ((price.getYearlyPrice() / 12) * validMonths);
            }
        }
        return premium;
    }

    @Override
    public List<Risk> getInsuredRisks() throws Exception {
        if (risks.isEmpty()) {
            throw new RiskException();
        } else {
            return risks;
        }
    }
}
