package com.example.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;


/**
 * code generator
 */
public class CodeGenerator {

    static String[] tables = {"cloth","user","customer","transactions","supplier"};


    public static void main(String[] args) throws Exception {
        for (String table : tables) {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            String outputDir = System.getProperty("user.dir") + "/../auto_generate/demo/";
            System.out.println(outputDir);
            gc.setOutputDir(outputDir);
            gc.setAuthor("generator");
            gc.setOpen(false);
            gc.setIdType(IdType.UUID);
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setUrl("jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf8");
            dsc.setDriverName("com.mysql.jdbc.Driver");
            dsc.setUsername("root");
            dsc.setPassword("1528609904");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
//            pc.setModuleName("user");
            pc.setParent("com.example.demo");
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            // 如果模板引擎是 freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            // 自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输入文件名称
                    return outputDir + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            //模板配置
            TemplateConfig templateConfig = new TemplateConfig();
            templateConfig.setXml(null);
            mpg.setTemplate(templateConfig);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            strategy.setEntityLombokModel(true);
            strategy.setRestControllerStyle(true);
            strategy.setInclude(table);
//            strategy.setControllerMappingHyphenStyle(true);
            strategy.setTablePrefix(pc.getModuleName() + "_");
//            strategy.setSuperControllerClass("cn.com.chicken.tool.base.BaseController");
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();
        }
    }
}
