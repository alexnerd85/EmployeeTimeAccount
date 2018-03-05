/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexnerd.employeetimeaccount.controllertests;

import com.alexnerd.employeetimeaccount.controller.MainController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author Aleksey
 */
public class MainControllerTest {
    
    @Test
    public void testMainController() throws Exception {
        MainController controller = new MainController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("app/main"));

    }
    
}
