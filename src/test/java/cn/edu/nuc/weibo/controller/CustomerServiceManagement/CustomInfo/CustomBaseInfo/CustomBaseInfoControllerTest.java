package cn.edu.nuc.weibo.controller.CustomerServiceManagement.CustomInfo.CustomBaseInfo;

import org.junit.Assert;
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

public class CustomBaseInfoControllerTest extends MvcTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void before() throws Exception {
		this.mockMvc =MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	
	@Test
	public void testQu1eryaByPage() throws Exception {
		MockHttpServletRequestBuilder requestBuiler = 
				MockMvcRequestBuilders.post("/CustomBaseInfo/QueryByPage");
		
		requestBuiler.accept(MediaType.TEXT_HTML);
		requestBuiler.param("page", "1");
		requestBuiler.param("rows", "3");
		requestBuiler.param("customerName", "张三");


		
		ResultActions ra = this.mockMvc.perform( requestBuiler );
		
		MvcResult mvcResult = ra.andReturn();
		ModelAndView modelAndView = mvcResult.getModelAndView();
		System.out.println(modelAndView.getViewName());
	}

}
