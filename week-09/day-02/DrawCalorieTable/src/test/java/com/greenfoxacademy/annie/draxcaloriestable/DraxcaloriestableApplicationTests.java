package com.greenfoxacademy.annie.draxcaloriestable;

import com.greenfoxacademy.annie.draxcaloriestable.Entity.Food;
import com.greenfoxacademy.annie.draxcaloriestable.Service.FoodDbServiceImpl;
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
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@EnableWebMvc
public class DraxcaloriestableApplicationTests {
	@Autowired
	FoodDbServiceImpl foodDbService;

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
	public void successful_getFoods() {
		List<Food> foods = foodDbService.findAll();
		try {
			mockMvc.perform(get("/drax")
					.contentType(contentType))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$[0].id", is(1)))
					.andExpect(jsonPath("$[0].name", is("curry")))
					.andExpect(jsonPath("$[0].amount", is(1)))
					.andExpect(jsonPath("$[0].calorie", is(175)))
					.andExpect(jsonPath("$[1].id", is(2)))
					.andExpect(jsonPath("$[1].name", is("egg boiled")))
					.andExpect(jsonPath("$[1].amount", is(1)))
					.andExpect(jsonPath("$[1].calorie", is(80)))
					.andExpect(jsonPath("$[2].id", is(3)))
					.andExpect(jsonPath("$[2].name", is("egg fried")))
					.andExpect(jsonPath("$[2].amount", is(1)))
					.andExpect(jsonPath("$[2].calorie", is(100)))
					.andExpect(jsonPath("$[3].id", is(4)))
					.andExpect(jsonPath("$[3].name", is("egg omelette")))
					.andExpect(jsonPath("$[3].amount", is(1)))
					.andExpect(jsonPath("$[3].calorie", is(120)))
					.andExpect(jsonPath("$[4].id", is(6)))
					.andExpect(jsonPath("$[4].name", is("chapati")))
					.andExpect(jsonPath("$[4].amount", is(3)))
					.andExpect(jsonPath("$[4].calorie", is(60)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void successful_addFoods() {
		try {
			mockMvc.perform(post("/drax")
					.contentType(contentType)
					.content(("{\n" +
							"        \"name\": \"chapati\",\n" +
							"        \"amount\": 1,\n" +
							"        \"calorie\": 60\n" +
							"}")))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.id", is(6)))
					.andExpect(jsonPath("$.name", is("chapati")))
					.andExpect(jsonPath("$.amount", is(1)))
					.andExpect(jsonPath("$.calorie", is(60)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void successful_modifyFoods() {
		try {
			mockMvc.perform(put("/drax?name=chapati")
					.contentType(contentType)
					.content(("{\n" +
							"\t\"amount\": 4\n" +
							"}")))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.id", is(6)))
					.andExpect(jsonPath("$.name", is("chapati")))
					.andExpect(jsonPath("$.amount", is(4)))
					.andExpect(jsonPath("$.calorie", is(60)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void successful_deleteFoods() {
		try {
			mockMvc.perform(delete("/drax?name=chapati")
					.contentType(contentType))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.name", is("chapati")))
					.andExpect(jsonPath("$.amount", is(4)))
					.andExpect(jsonPath("$.calorie", is(60)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
