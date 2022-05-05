package com.worldlineapi.perfectnumber;

import com.worldlineapi.perfectnumber.controller.PerfectNumberController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class PerfectNumberApplicationTests {


    private MockMvc mockMvc;
    @InjectMocks
    private PerfectNumberController perfectNumberController;




    @BeforeEach
    public void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(perfectNumberController)
                .build();
    }

     @Test
    void testSinglePerfectNumber() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/perfectnumber/single")
                        .param("num", "28")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("true"));

        mockMvc.perform(MockMvcRequestBuilders.post("/perfectnumber/single")
                .param("num", "38")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("false"));

    }

    @Test
    void testSinglePerfectNumberWrongParams() throws Exception
    {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/single")
                                .param("num", "not a long")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/single")
                                .param("wrong key", "6")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


    @Test
    void testPerfectNumberInRange() throws Exception
    {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("start", "300")
                                .param("end", "10000")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[496,8128]"));
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("start", "2")
                                .param("end", "10000")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[6,28,496,8128]"));

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("start", "8")
                                .param("end", "25")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));


    }

    @Test
    void testPerfectNumberInRangeWrongParams() throws Exception
    {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("end", "3")
                                .param("start", "10000")
                )
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("start", "not a long")
                                .param("end", "8")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("start", "4")
                                .param("end", "not a long")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("wrong start key", "2")
                                .param("end", "500")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());



        mockMvc.perform(
                        MockMvcRequestBuilders.post("/perfectnumber/inrange")
                                .param("everything", "is")
                                .param("wrong", "here")
                )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
