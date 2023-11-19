package com.dylansmusicshop.userAdmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AdminService.class)
class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void testAddProductToDatabase() {

        adminService.addProductToDataBase("Pearl", "testName", 2, 1500.0);

    }
}