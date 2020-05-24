package com.jypure.demo.spring;

import org.springframework.stereotype.Service;

/**
 * @author : jiayupeng
 * @date : 2020/5/24/11:47
 */
@Service
public class SpringService {

    InnerClass inner;

    public SpringService(){
        this.inner = new InnerClass("spring service inner class");
    }

    public String saySth(){
        return inner.getName();
    }

    public InnerClass getInner(){
        return inner;
    }



    public class InnerClass{

        private String name;

        public InnerClass(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
