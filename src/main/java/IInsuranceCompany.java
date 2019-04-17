import java.time.LocalDateTime;
import java.util.List;

public interface IInsuranceCompany {

    /**
     * Name of Insurance company
     */
    String getName() throws Exception;

    /**
     * List of the risks that can be insured. List can be updated at any time
     */

    List<Risk> getAvailableRisks() throws Exception;

    void setAvailableRisks(List<Risk> value) throws Exception;
    /**
     * Sell the policy.
     *
     * @param nameOfInsuredObject Name of the insured object. Must be unique in the given period.
     * @param validFrom Date and time when policy starts. Can not be in the past
     * @param validMonths IPolicy period in months
     * @param selectedRisks List of risks that must be included in the policy
     * @return Information about policy
     */
    IPolicy sellPolicy(String nameOfInsuredObject, LocalDateTime validFrom, short validMonths, List<Risk> selectedRisks) throws Exception;

    /**
     * Add risk to the policy of insured object.
     *
     * @param nameOfInsuredObject Name of insured object
     * @param risk Risk that must be added
     * @param validFrom Date when risk becomes active. Can not be in the past
     */
    void addRisk(String nameOfInsuredObject, Risk risk, LocalDateTime validFrom) throws Exception;
    /**
     * Gets policy with a risks at the given point of time.
     *
     * @param nameOfInsuredObject Name of insured object
     * @param effectiveDate Point of date and time, when the policy effective
     */
    IPolicy getPolicy(String nameOfInsuredObject, LocalDateTime effectiveDate) throws Exception;
}
