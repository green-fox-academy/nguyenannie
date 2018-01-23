package com.greenfoxacademy.roracargo;

import com.greenfoxacademy.roracargo.Model.CargoFill;
import com.greenfoxacademy.roracargo.Model.CargoStatus;
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

	private CargoStatus cargoStatus= new CargoStatus(0,0,0,"empty", false);
	private CargoFill cargoFill = new CargoFill();
	private int fill_amount = 0;

	@Test
	public void successful_CargoStatus_rocketEndPoint() {
		try {
			mockMvc.perform(get("/rocket")
					.contentType(contentType))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.caliber25", is(0)))
					.andExpect(jsonPath("$.caliber30", is(0)))
					.andExpect(jsonPath("$.caliber50", is(0)))
					.andExpect(jsonPath("$.shipstatus", is("empty")))
					.andExpect(jsonPath("$.ready", is(false)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void successful_CargoFill_rocketfillEndPoint() {
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.set("caliber", ".50");
		params.set("amount", "5000");

		fill_amount += 5000;
		cargoFill.setShipstatus(String.valueOf(fill_amount * 100 /12500) + "%");
		cargoFill.setReady(false);
		cargoFill.setAmount(5000);
		cargoFill.setReceived(".50");

		try {
			mockMvc.perform(get("/rocket/fill")
					.contentType(contentType)
					.params(params))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.received", is(cargoFill.getReceived())))
					.andExpect(jsonPath("$.amount", is(cargoFill.getAmount())))
					.andExpect(jsonPath("$.shipstatus", is(cargoFill.getShipstatus())))
					.andExpect(jsonPath("$.ready", is(cargoFill.isReady())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void successful_Ready_CargoFill_rocketfillEndPoint() {
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.set("caliber", ".30");
		params.set("amount", "12500");

		fill_amount += 12500;
		cargoFill.setShipstatus("full");
		cargoFill.setReady(true);
		cargoFill.setAmount(12500);
		cargoFill.setReceived(".30");

		try {
			mockMvc.perform(get("/rocket/fill")
					.contentType(contentType)
					.params(params))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.received", is(cargoFill.getReceived())))
					.andExpect(jsonPath("$.amount", is(cargoFill.getAmount())))
					.andExpect(jsonPath("$.shipstatus", is(cargoFill.getShipstatus())))
					.andExpect(jsonPath("$.ready", is(cargoFill.isReady())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void successful_Overloaded_CargoFill_rocketfillEndPoint() {
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.set("caliber", ".25");
		params.set("amount", "30000");

		fill_amount += 30000;
		cargoFill.setShipstatus("overloaded");
		cargoFill.setReady(true);
		cargoFill.setAmount(30000);
		cargoFill.setReceived(".25");

		try {
			mockMvc.perform(get("/rocket/fill")
					.contentType(contentType)
					.params(params))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(jsonPath("$.received", is(cargoFill.getReceived())))
					.andExpect(jsonPath("$.amount", is(cargoFill.getAmount())))
					.andExpect(jsonPath("$.shipstatus", is(cargoFill.getShipstatus())))
					.andExpect(jsonPath("$.ready", is(cargoFill.isReady())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
