package x.erp.inventory_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import lombok.AllArgsConstructor;

// import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
// import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class ErpMain {

    
    private String orgId;

    @DynamoDbPartitionKey
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    private String sectionId;

    private String name;

    private boolean active;

    private boolean deleted;

    private String createdBy;

    private String updatedBy;

    private String createdAt;

    private String updatedAt;

    private String deletedBy;

    private String deletedAt;

    private String orgType; 

    private String orgSubType;

    private String orgCategory;

    private String orgParentId;

    
    
    //private OrgDetails orgDetails;

    // Remove these fields as they are now part of OrgDetails
    // private String address1;
    // private String address2;
    // private String escaletPhoneNumber;
    // private String pocPhoneNumber;
    // private String alternatePhoneNumber;
    // private String pocEmailAddress;
    // private String escaletEmailAddress;

    private BusinessCategory businessCategory;

    public enum BusinessCategory {
        PHARMA_DISTRIBUTOR,
        MANUFACTURING,
        RETAIL,
        HEALTHCARE_PROVIDER,
        LOGISTICS,
        RESEARCH_AND_DEVELOPMENT,
        REGULATORY_AGENCY,
        OTHER
    }
}