import exceptions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InsuranceCompany implements IInsuranceCompany {

    private String name = "IF";
    private List<Risk> risksAvailable = new ArrayList<>();
    private List<Policy> policies = new ArrayList<>();


    @Override
    public String getName() throws Exception {
        if (name == null) {
            throw new NameNotFoundException();
        } else {
            return name;
        }
    }

    @Override
    public List<Risk> getAvailableRisks() throws Exception {
        if (risksAvailable.isEmpty()) {
            throw new RiskNotFoundException();
        } else {
            return risksAvailable;
        }
    }

    @Override
    public void setAvailableRisks(List<Risk> value) throws Exception {
        if (value.isEmpty()) {
            throw new RiskNotFoundException();
        } else {
            risksAvailable.addAll(value);
        }
    }

    @Override
    public IPolicy sellPolicy(String nameOfInsuredObject, LocalDateTime validFrom, short validMonths, List<Risk> selectedRisks) throws Exception {
        Policy policy;
        if (policies.stream().anyMatch(a -> nameOfInsuredObject.equals(a.getNameOfInsuredObject())
                && a.getValidFrom().isBefore(validFrom)
                || a.getValidTill().isAfter(validFrom))) {
            throw new PolicyAlreadyExistsException();
        } else if (validFrom.isBefore(LocalDateTime.now())) {
            throw new IncorrectInputException();
        } else {
            policy = new Policy();
            policy.setNameOfInsuredObject(nameOfInsuredObject);
            policy.setValidFrom(validFrom);
            policy.setRisks(selectedRisks);
            policy.setValidMonths(validMonths);
        }
        policies.add(policy);

        return policy;
    }

    @Override
    public void addRisk(String nameOfInsuredObject, Risk risk, LocalDateTime validFrom) throws Exception {
        if (getPolicy(nameOfInsuredObject, validFrom) == null) {
            throw new PolicyNotFoundException();
        } else {
            Policy policy = (Policy) getPolicy(nameOfInsuredObject, validFrom);
            List<Risk> insuredRisks = policy.getInsuredRisks();
            insuredRisks.add(risk);
            policy.setRisks(insuredRisks);
        }
    }

    @Override
    public IPolicy getPolicy(String nameOfInsuredObject, LocalDateTime effectiveDate) throws Exception {
        return policies.stream()
                .filter(a -> nameOfInsuredObject.equals(a.getNameOfInsuredObject()) && effectiveDate.isBefore(a.getValidTill())
                        && effectiveDate.isAfter(a.getValidFrom()) || effectiveDate.isEqual(a.getValidFrom()))
                .findAny()
                .orElseThrow(PolicyNotFoundException::new);
    }
}
