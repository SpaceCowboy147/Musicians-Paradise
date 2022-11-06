package com.dylansmusicshop.registration;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@SpringBootTest
class registerServletTest extends Mockito {

    @Test
    public void testRegisterUser() throws Exception {
registerServlet registerServlet = new registerServlet();

        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("username")).thenReturn("bobby");
        when(request.getParameter("password")).thenReturn("123");



    }

}