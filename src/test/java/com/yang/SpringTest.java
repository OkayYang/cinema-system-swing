package com.yang;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void ContextText(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String names[] = applicationContext.getBeanDefinitionNames();
        for (String name:names
        ) {
            System.out.println("容器中对象名称"+name);
        }

    }
}
