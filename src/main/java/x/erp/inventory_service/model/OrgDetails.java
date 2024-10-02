package x.erp.inventory_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgDetails {
    private String address1;
    private String address2;
    private String escaletPhoneNumber;
    private String pocPhoneNumber;
    private String alternatePhoneNumber;
    private String pocEmailAddress;
    private String escaletEmailAddress;
}