package com.homework.leasing.api;

import com.homework.leasing.api.model.request.LeasingApplicationRequest;
import com.homework.leasing.api.model.response.LeasingApplicationResponse;
import com.homework.leasing.api.model.response.LeasingApplicationStatusResponse;
import com.homework.leasing.api.model.response.SubmitApplicationResponse;
import com.homework.leasing.service.LeasingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/lease")
public class LeasingController {

    private final LeasingService leasingService;

    private final Logger logger = LoggerFactory.getLogger(LeasingController.class);

    @Autowired
    public LeasingController(LeasingService leasingService) {
        this.leasingService = leasingService;
    }

    @PostMapping(value ="/application", produces = "application/json")
    public SubmitApplicationResponse submitApplication(@Valid @RequestBody LeasingApplicationRequest application) {
        logger.info("Incoming lease application");
        return leasingService.submit(application);
    }

    @GetMapping(value ="/application/{applicationId}", produces = "application/json")
    public LeasingApplicationResponse fetchApplication(@PathVariable(value = "applicationId") String applicationId) {
        return leasingService.fetchApplication(applicationId);
    }

    @GetMapping(value = "/application/{applicationId}/status", produces = "application/json")
    public LeasingApplicationStatusResponse fetchStatus(@PathVariable(value = "applicationId") String applicationId) {
        return leasingService.fetchApplicationStatus(applicationId);
    }


}
