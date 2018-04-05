package com.littlefisher.core.utils.db.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.littlefisher.blog.deploy.Application;
import com.littlefisher.core.common.utils.DateUtil;

/**
 * Description: DbServiceTest.java
 *
 * Created on 2018年02月02日
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DbServiceTest {

    @Test
    public void testGetDbDateTime() {
        DateUtil.getDBDateTime();
    }
}
