package com.greenfoxacademy.pallidaretakeexam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfoxacademy.pallidaretakeexam.models.entities.Clothing;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PallidaretakeexamApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class PallidaretakeexamApplicationTests {

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
    public void successful_Warehouse_Query() {
//        Clothing clothing1 = new Clothing(16, "Strecth Steamed Pencil Skirt", "Calvin Klein", "skirts","s", 39 );
//        Clothing clothing2 = new Clothing(18, "Strecth Steamed Pencil Skirt","Calvin Klein", "skirts","m",39  );
//        List<Clothing> clothes = new ArrayList<>(Arrays.asList(clothing1, clothing2));

        try {
            mockMvc.perform(get("/warehouse/query")
                    .contentType(contentType)
                    .param("price", "50")
                    .param("type", "lower"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is("ok")))
                    .andExpect(jsonPath("$clothes[*].id", containsInAnyOrder(16, 18)))
                    .andExpect(jsonPath("$clothes[*].itemName", containsInAnyOrder("Strecth Steamed Pencil Skirt", "Strecth Steamed Pencil Skirt")))
                    .andExpect(jsonPath("$clothes[*].manufacturer", containsInAnyOrder("Calvin Klein", "Calvin Klein")))
                    .andExpect(jsonPath("$clothes[*].category", containsInAnyOrder("skirts", "skirts")))
                    .andExpect(jsonPath("$clothes[*].size", containsInAnyOrder("s","m")))
                    .andExpect(jsonPath("$clothes[*].unitPrice", containsInAnyOrder(39,39)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void successful_Warehouse_Query_test2() {
        Clothing clothing1 = new Clothing(16, "Strecth Steamed Pencil Skirt", "Calvin Klein", "skirts","s", 39 );
        Clothing clothing2 = new Clothing(18, "Strecth Steamed Pencil Skirt","Calvin Klein", "skirts","m",39  );
        List<String> clothes = new ArrayList<>(Arrays.asList(asJsonString(clothing1), asJsonString(clothing2)));

        try {
            mockMvc.perform(get("/warehouse/query")
                    .contentType(contentType)
                    .param("price", "50")
                    .param("type", "lower"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(contentType))
                    .andExpect(jsonPath("$.result", is("ok")))
                    .andExpect(jsonPath("$.clothes", is(clothes)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
