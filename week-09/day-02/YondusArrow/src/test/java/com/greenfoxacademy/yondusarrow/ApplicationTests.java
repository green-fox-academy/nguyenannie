package com.greenfoxacademy.yondusarrow;

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

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@EnableWebMvc
public class ApplicationTests {
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
	public void successful_YonduEndPoint() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("distance", "100.0");
		params.set("time", "15.0");
		try {
			mockMvc.perform(get("/yondu")
					.contentType(contentType)
					.params(params))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.distance", is(100.0)))
					.andExpect(jsonPath("$.time", is(15.0)))
					.andExpect(jsonPath("$.speed", is(6.666666666666667)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void YonduEndPoint_withTimeisZero() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("distance", "100.0");
		params.set("time", "0");
		try {
			mockMvc.perform(get("/yondu")
					.contentType(contentType)
					.params(params))
					.andExpect(status().isBadRequest())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.error", is("Time cannot be 0")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void YonduEndPoint_withoutParam() {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.set("distance", null);
		params.set("time", null);
		try {
			mockMvc.perform(get("/yondu")
					.contentType(contentType)
					.params(params))
					.andExpect(status().isBadRequest())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.error", is("Please provide parameter")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
