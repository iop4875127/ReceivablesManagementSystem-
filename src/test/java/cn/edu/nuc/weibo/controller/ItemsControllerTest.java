package cn.edu.nuc.weibo.controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.nuc.weibo.MvcTest;

public class ItemsControllerTest extends MvcTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void before() throws Exception {
		this.mockMvc =MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/**
	 * 车票信息列表
	 * @throws Exception
	 */
	@Test
	public void testQueryItems() throws Exception {
		MockHttpServletRequestBuilder requestBuiler = 
				MockMvcRequestBuilders.post("/queryItems");
		
		requestBuiler.accept(MediaType.TEXT_HTML);
/*		requestBuiler.param("email", "zhangsan@163.com");
		requestBuiler.param("password", "123456");*/
		ResultActions ra = this.mockMvc.perform( requestBuiler );
		
		MvcResult mvcResult = ra.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		System.out.println(modelAndView.getViewName());
	}

	@Test
	public void testEditItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditItemsSubmit() throws Exception {
		MockHttpServletRequestBuilder requestBuiler = 
				MockMvcRequestBuilders.post("/updateItems");
		
		requestBuiler.accept(MediaType.TEXT_HTML);
		requestBuiler.param("id", "17");
		requestBuiler.param("name", "豆腐干");
		requestBuiler.param("price", "23.2");
		requestBuiler.param("pic", "5.jpg");
		
		ResultActions ra = this.mockMvc.perform( requestBuiler );
		
		MvcResult mvcResult = ra.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		System.out.println(modelAndView.getViewName());
	}

	@Test
	public void testInsertItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteItems() {
		fail("Not yet implemented");
	}

}
