package springboot.demo.day01;

import springboot.demo.DemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author taobaibai
 * @create 2020-03-31 15:01
 */
@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={DemoApplication.class}) //启动整个springboot工程
@AutoConfigureMockMvc
public class MockMvcTestDemo {

    @Autowired
    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setUp(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @After
//    public void tearDown() {
//        mockMvc = null;
//    }

    @Test
    public void apiTest() throws Exception {
        MvcResult mvcResult =  mockMvc.perform( MockMvcRequestBuilders.get("/testMap") )
                                        .andExpect( MockMvcResultMatchers.status().isOk() )
                                        .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);

    }

}