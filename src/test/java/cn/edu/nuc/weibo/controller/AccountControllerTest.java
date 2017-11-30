package cn.edu.nuc.weibo.controller;

import static org.junit.Assert.*;

import org.junit.Before;
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

public class AccountControllerTest extends MvcTest{

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void before() throws Exception {
		this.mockMvc =MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testForward() {
		
	}

	@Test
	public void testLogin() throws Exception {
		MockHttpServletRequestBuilder requestBuiler = 
				MockMvcRequestBuilders.post("/login");
		
		requestBuiler.accept(MediaType.TEXT_HTML);
		requestBuiler.param("email", "zhangsan@163.com");
		requestBuiler.param("password", "123456");
		ResultActions ra = this.mockMvc.perform( requestBuiler );
		
		MvcResult mvcResult = ra.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		System.out.println(modelAndView.getViewName());
	}

	@Test
	public void testAddAccount() throws Exception {
		MockHttpServletRequestBuilder requestBuiler = 
				MockMvcRequestBuilders.post("/addAccount");
		
		requestBuiler.accept(MediaType.TEXT_HTML);
		requestBuiler.param("email", "aaa@163.com");
		requestBuiler.param("nickName", "2433754916");
		requestBuiler.param("password", "aaaa1234");
		
		ResultActions ra = this.mockMvc.perform( requestBuiler );
		
		MvcResult mvcResult = ra.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		System.out.println(modelAndView.getViewName());
	}
	
}
