package com.greenfoxacademy.restexercise;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.core.Is.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestexerciseApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class RestexerciseApplicationTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf-8"));

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void successful_DoublingEndPoint() {
        try {
            mockMvc.perform(get("/doubling")
                    .contentType(contentType).param("input", "15"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.input", is(15)))
                    .andExpect(jsonPath("$.result", is(30)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void doublingEndPoint_notProvidingInput_should_return_ErrorMessage() {
        try {
            mockMvc.perform(get("/doubling")
                    .contentType(contentType)
                    .param("input", ""))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.error", is("Please provide an input!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_greeterEndPoint() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("name", "annie");
        params.set("title", "cat");
        try {
            mockMvc.perform(get("/greeter")
                    .contentType(contentType)
                    .params(params))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.welcome_Message", is("Oh, hi there annie, my dear cat!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void greeterEndPoint_notProvidingNameParam_should_return_ErrorMessage() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("name", null);
        params.set("title", "cat");
        try {
            mockMvc.perform(get("/greeter")
                    .contentType(contentType)
                    .params(params))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.error", is("Please provide a name or a title!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void greeterEndPoint_notProvidingTitleParam_should_return_ErrorMessage() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("name", "annie");
        params.set("title", null);
        try {
            mockMvc.perform(get("/greeter")
                    .contentType(contentType)
                    .params(params))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.error", is("Please provide a name or a title!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void greeterEndpoint_notProvidingAnyParam_should_return_ErrorMessage() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("name", null);
        params.set("title", null);
        try {
            mockMvc.perform(get("/greeter")
                    .contentType(contentType)
                    .params(params))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.error", is("Please provide a name or a title!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_appendsEndpoint_Test1() {
        try {
            mockMvc.perform(get("/appends/kuty")
                    .contentType(contentType))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.appended", is("kutya")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_appendsEndpoint_Test2() {
        try {
            mockMvc.perform(get("/appends/annie")
                    .contentType(contentType))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.appended", is("anniea")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_DoUntilSum_EndPoint() {
        try {
            mockMvc.perform(post("/dountil/sum")
                    .contentType(contentType)
                    .content("{\n" + "  \"until\": 5\n" + "}"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is(15)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_DoUntilMultiple_EndPoint() {
        try {
            mockMvc.perform(post("/dountil/factor")
                    .contentType(contentType)
                    .content("{\n" + "  \"until\": 5\n" + "}"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is(120)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dountilEndPoint_notProviding_PathVariable() {
        try {
            mockMvc.perform(post("/dountil/null")
                    .contentType(contentType)
                    .content("{\n" + "  \"until\": 5\n" + "}"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.error", is("Please provide an input!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dountilEndPoint_notProviding_Input() {
        try {
            mockMvc.perform(post("/dountil/sum")
                    .contentType(contentType)
                    .content("{\n" + "  \"until\":\"\"\n" + "}"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.error", is("Please provide an input!")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_ArraysEndPoint_With_WhatIsSum() {
        try {
            mockMvc.perform(post("/arrays")
                    .contentType(contentType)
                    .content(("{\"what\": \"sum\", \"numbers\": [1, 2, 5, 10]}")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is(18)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_ArraysEndPoint_With_WhatIsMultiple() {
        try {
            mockMvc.perform(post("/arrays")
                    .contentType(contentType)
                    .content(("{\"what\": \"multiple\", \"numbers\": [1, 2, 5, 10]}")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is(100)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_ArraysEndPoint_With_WhatIsDouble() {
        try {
            Integer[] result = {2,4,10,20};
            mockMvc.perform(post("/arrays")
                    .contentType(contentType)
                    .content(("{\"what\": \"double\", \"numbers\": [1, 2, 5, 10]}")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* random message return -> haven't found the way to test yet
    @Test
    public void successful_sithEndPoint() {
        try {
            mockMvc.perform(post("/sith")
                    .contentType(contentType)
                    .content(("{\n" + "  \"text\": \"This is my example sentence. Just for fun.\"\n" + "}")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.sith_text", is("Is this example my sentence. Err..err.errFor just fun. Arrgh. Uhm.")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    @Test
    public void successful_translateEndPoint_With_WhatIsSum() {
        try {
            mockMvc.perform(post("/translate")
                    .contentType(contentType)
                    .content(("{\n" +
                            "  \"text\": \"Ez egy példamondat. Remélem célbatalál.\",\n" +
                            "  \"lang\": \"hu\"\n" +
                            "}")))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.translated",
                            is("Evez evegy pévéldavamovondavat. Revemévélevem cévélbavatavalávál.")))
                    .andExpect(jsonPath("$.lang", is("teve")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
