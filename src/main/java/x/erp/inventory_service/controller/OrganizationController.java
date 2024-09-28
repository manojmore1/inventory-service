package x.erp.inventory_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import x.erp.inventory_service.model.ErpMain;
import x.erp.inventory_service.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<ErpMain> createOrganization(@RequestBody ErpMain organization) {
        ErpMain createdOrganization = organizationService.createOrganization(organization);
        return new ResponseEntity<>(createdOrganization, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ErpMain> updateOrganization(@PathVariable Long id, @RequestBody ErpMain organization) {
        ErpMain updatedOrganization = organizationService.updateOrganization(id.toString(), organization);
        return ResponseEntity.ok(updatedOrganization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ErpMain> getOrganization(@PathVariable Long id) {
        ErpMain organization = organizationService.getOrganization(id.toString());
        return ResponseEntity.ok(organization);
    }
}