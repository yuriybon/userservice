package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import ua.odessa.bondar.domain.Address;
import ua.odessa.bondar.service.UserService;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Test
    public void testMethod(){
        assertEquals(1,1);
        UserService us = new UserService();
        assertNotEquals(us,null);
        List<Address> addresses = us.getAddress();

        if (addresses == null)
            System.out.println("adresses = null");
        else
            System.out.println("adresses != null");
    }
}
