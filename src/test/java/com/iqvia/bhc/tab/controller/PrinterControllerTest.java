package com.iqvia.bhc.tab.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PrinterControllerTest {
	
	@Autowired
	private PrinterController printCtrl;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void controllNotNull() throws Exception {
		assertThat(printCtrl).isNotNull();
	}
	
	@Test
	public void testEcho() throws Exception {
		this.mockMvc.perform(get("/echo"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello IQVIA.")));
	}
	
	@Test
	public void testGetExampleJson() throws Exception {
		this.mockMvc.perform(get("/example"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().json("{\n"
				+ "    \"schedule_time\": \"2022-12-31 12:31\",\n"
				+ "    \"message_content\": \"HELLO: IQVIA\"\n"
				+ "}"));
	}
}
