package com.homework.leasing.api;

import com.homework.leasing.api.model.request.LeasingApplicationRequest;
import com.homework.leasing.api.model.response.SubmitApplicationResponse;
import com.homework.leasing.service.LeasingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(LeasingController.class)
public class LeasingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeasingService service;

    @Test
    public void submit_application_successful() throws Exception {
        SubmitApplicationResponse response = new SubmitApplicationResponse();
        response.setApplicationId("mocked_id");
        response.setStatus("mocked_status");
        when(service.submit(any(LeasingApplicationRequest.class))).thenReturn(response);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/lease/application")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"applicantsEmail\":\"email@domain.lt\"," +
                        "\"applicantsPhone\":\"+370123456\"," +
                        "\"applicantsPersonalNumber\":\"123456\"," +
                        "\"applicantsSalary\":100," +
                        "\"coApplicantsPersonalNumber\":\"654321\"," +
                        "\"coApplicantsSalary\":99.9," +
                        "\"carVinNumber\":\"78910\"," +
                        "\"requestedAmount\":9999.99}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.applicationId", is(response.getApplicationId())))
                .andExpect(jsonPath("$.status", is(response.getStatus())));

        verify(service, times(1)).submit(any(LeasingApplicationRequest.class));
    }

    @Test
    public void submit_application_fail_on_validation() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/v1/lease/application")
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andExpect(status().isBadRequest());

        verify(service, times(0)).submit(any(LeasingApplicationRequest.class));
    }

}
