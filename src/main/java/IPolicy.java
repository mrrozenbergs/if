import java.time.LocalDateTime;
import java.util.List;

public interface IPolicy {
    /**
     * Name of insured object
     */
    String getNameOfInsuredObject() throws Exception;
    /**
     * Date when policy becomes active
     */
    LocalDateTime getValidFrom() throws Exception;
    /**
     * Date when policy becomes inactive
     */
    LocalDateTime getValidTill() throws Exception;
    /**
     * Total price of the policy. Calculate by summing up all insured risks.
     * Take into account that risk price is given for 1 full year. IPolicy/risk period can be shorter.
     */
    double getPremium() throws Exception;
    /**
     * Initially included risks or risks at specific moment of time.
     */
    List<Risk> getInsuredRisks() throws Exception;
}
