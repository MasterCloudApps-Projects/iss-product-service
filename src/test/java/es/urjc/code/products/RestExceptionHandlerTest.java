package es.urjc.code.products;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class RestExceptionHandlerTest {

    private TestController testController;

    private RestExceptionHandler restExceptionHandler;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
    	this.testController = new TestController();
    	this.restExceptionHandler = new RestExceptionHandler();
        mockMvc = MockMvcBuilders.standaloneSetup(testController)
                .setControllerAdvice(restExceptionHandler).build();
    }

    @Test
    public void testNotFoundException() throws Exception {
        mockMvc.perform(get("/test/not-found")).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("entity not found"));
    }
    
    @Test
    public void testBusinessException() throws Exception {
        mockMvc.perform(get("/test/business-exception")).andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.message").value("business error"));
    }

    @Test
    public void testIOException() throws Exception {
        mockMvc.perform(get("/test/io-exception")).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Bad Request"));
    }
}
