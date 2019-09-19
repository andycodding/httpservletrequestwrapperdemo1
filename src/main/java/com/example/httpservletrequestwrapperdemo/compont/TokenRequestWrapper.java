package com.example.httpservletrequestwrapperdemo.compont;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class TokenRequestWrapper extends HttpServletRequestWrapper {
    TokenRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    /**
     * 修改此方法主要是因为当RequestMapper中的参数为pojo类型时，
     * 会通过此方法获取所有的请求参数并进行遍历，对pojo属性赋值
     * @return
     */
    @Override
    public Enumeration<String> getParameterNames() {
        Enumeration<String> enumeration = super.getParameterNames();
        ArrayList<String> list = Collections.list(enumeration);
        //当有token字段时动态的添加uid字段
        if (list.contains("token")){
            list.add("uid");
            return Collections.enumeration(list);
        }else {
            return super.getParameterNames();
        }
    }
    @Override
    public String[] getParameterValues(String name) {
        if ("uid".equals(name)){
            return new String[]{"1","2","3"};
        }
        return super.getParameterValues(name);
    }
}
