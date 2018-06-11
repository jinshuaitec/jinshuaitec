package com.jinstec;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jins
 * @date on 2018/4/17.
 */
public class GenMain {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        boolean overWrite = true;
        String genConfig = "/generator/generatorConfig.xml";
        File configFile = new File(GenMain.class.getResource(genConfig).getFile());
        ConfigurationParser cp = new ConfigurationParser(list);
        Configuration configuration = null;
        try {
            configuration = cp.parseConfiguration(configFile);
        }catch (IOException | XMLParserException e){
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overWrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(configuration,callback,list);
        }catch (InvalidConfigurationException e){
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
