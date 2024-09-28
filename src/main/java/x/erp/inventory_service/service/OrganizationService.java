package x.erp.inventory_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import x.erp.inventory_service.model.ErpMain;
import software.amazon.awssdk.enhanced.dynamodb.Key;


// import java.util.Optional;

@Service
public class OrganizationService {

    // private final ErpMainRepository erpMainRepository;
    private final DynamoDbEnhancedClient dynamoDbEnhancedClient;
    private final DynamoDbTable<ErpMain> erpMainTable;

    public OrganizationService(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
        this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
        this.erpMainTable = dynamoDbEnhancedClient.table("erpMain", TableSchema.fromBean(ErpMain.class)); // Your DynamoDB table name
    }

    

    public ErpMain createOrganization(ErpMain erpMain) {
        try {
            erpMainTable.putItem(PutItemEnhancedRequest.builder(ErpMain.class).item(erpMain).build());
            System.out.println("Product saved: " + erpMain.getOrgId());
        } catch (DynamoDbException e) {
            e.printStackTrace();
        }
        return erpMain;
    }

    public ErpMain updateOrganization(String id, ErpMain erpMain) {
        try {
            ErpMain existingOrg = erpMainTable.getItem(Key.builder().partitionValue(id).build());
            if (existingOrg != null) {
                existingOrg.setName(erpMain.getName());
                // Update other fields as necessary
                erpMainTable.updateItem(existingOrg);
                return existingOrg;
            } else {
                throw new RuntimeException("Organization not found");
            }
        } catch (DynamoDbException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating organization", e);
        }
    }

    public void deleteOrganization(String id) {
        try {
            ErpMain existingOrg = erpMainTable.getItem(Key.builder().partitionValue(id).build());
            if (existingOrg != null) {
                existingOrg.setDeleted(true);
                erpMainTable.updateItem(existingOrg);
            } else {
                throw new RuntimeException("Organization not found with id: " + id);
            }
        } catch (DynamoDbException e) {
            e.printStackTrace();
            throw new RuntimeException("Error marking organization as deleted", e);
        }
    }

    public ErpMain getOrganization(String id) {
        try {
            ErpMain erpMain = erpMainTable.getItem(Key.builder().partitionValue(id).build());
            if (erpMain != null) {
                return erpMain;
            } else {
                throw new RuntimeException("Organization not found with id: " + id);
            }
        } catch (DynamoDbException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving organization", e);
        }
    }
}