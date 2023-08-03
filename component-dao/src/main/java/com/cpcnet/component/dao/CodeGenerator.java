package com.cpcnet.component.dao;


import com.cpcnet.component.dao.code.generator.DefaultCodeGenerator;

public class CodeGenerator {
    
    public static void main(String[] args) {
        DefaultCodeGenerator generator = new DefaultCodeGenerator();
        String jdbcUrl = "jdbc:mysql://mccentdbuat.china-entercom.com:3306/mc_portal_vendor?characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&useUnicode=true";
 
        String userName = "root";
        String password = "cpcnet";
        String basePackage = "com.cpcnet.component.dao.test.demo";
        String author = "Ebon Zheng";
        generator.generateCode(jdbcUrl, userName, password, basePackage, author);
    }
}