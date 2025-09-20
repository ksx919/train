package com.fanxin.train.generator.server;

import com.fanxin.train.generator.util.DbUtil;
import com.fanxin.train.generator.util.Field;
import com.fanxin.train.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ServerGenerator {
    static boolean readOnly = false;
    static String vuePath = "web/src/views/MainPage/";
    static String serverPath = "[module2]/src/main/java/com/fanxin/train/[module1]/";
    static String pomPath = "train-generator\\pom.xml";
    static {
        new File(serverPath).mkdirs();
    }

    public static void main(String[] args) throws Exception {
        // 获取mybatis-generator
        String generatorPath = getGeneratorPath();
        // 比如generator-config-member.xml，得到module = member
        String module1 = generatorPath.replace("src/main/resources/generator-config-", "").replace(".xml", "");
        String module2 = "train-"+module1;
        System.out.println("module1: " + module1);
        System.out.println("module2: " + module2);
        serverPath = serverPath.replace("[module1]", module1);
        serverPath = serverPath.replace("[module2]", module2);
        // new File(servicePath).mkdirs();
        System.out.println("servicePath: " + serverPath);

        // 读取table节点
        Document document = new SAXReader().read("train-generator/" + generatorPath);
        Node table = document.selectSingleNode("//table");
        System.out.println(table);
        Node tableName = table.selectSingleNode("@tableName");
        Node domainObjectName = table.selectSingleNode("@domainObjectName");
        System.out.println(tableName.getText() + "/" + domainObjectName.getText());

        // 为DbUtil设置数据源
        Node connectionURL = document.selectSingleNode("//@connectionURL");
        Node userId = document.selectSingleNode("//@userId");
        Node password = document.selectSingleNode("//@password");
        System.out.println("url: " + connectionURL.getText());
        System.out.println("user: " + userId.getText());
        System.out.println("password: " + password.getText());
        DbUtil.url = connectionURL.getText();
        DbUtil.user = userId.getText();
        DbUtil.password = password.getText();

        // 示例：表名 jiawa_test
        // Domain = JiawaTest
        String Domain = domainObjectName.getText();
        // domain = jiawaTest
        String domain = Domain.substring(0, 1).toLowerCase() + Domain.substring(1);
        // do_main = jiawa-test
        String do_main = tableName.getText().replaceAll("_", "-");
        // 表中文名
        String tableNameCn = DbUtil.getTableComment(tableName.getText());
        List<Field> fieldList = DbUtil.getColumnByTableName(tableName.getText());
        Set<String> typeSet = getJavaTypes(fieldList);

        // 组装参数
        Map<String, Object> param = new HashMap<>();
        param.put("module",module1);
        param.put("Domain", Domain);
        param.put("domain", domain);
        param.put("do_main", do_main);
        param.put("tableNameCn", tableNameCn);
        param.put("fieldList", fieldList);
        param.put("typeSet", typeSet);
        param.put("readOnly", readOnly);
        System.out.println("组装参数：" + param);

//        gen(Domain, param,"service","service");
//        gen(Domain, param,"serviceImpl","serviceImpl");
//        gen(Domain, param,"controller","controller" );
//        gen(Domain, param, "req", "saveReq");
//        gen(Domain, param, "req", "queryReq");
//        gen(Domain, param, "resp", "queryResp");
        genVue(do_main, param);
    }

    private static void gen(String Domain, Map<String, Object> param,String packageName, String target) throws IOException, TemplateException {
        FreemarkerUtil.initConfig(target + ".ftl");
        String toPath;
        if (Objects.equals(target, "serviceImpl")){
            toPath = serverPath + "service/impl/";
        }else{
            toPath = serverPath + packageName + "/";
        }
        new File(toPath).mkdirs();
        String Target = target.substring(0,1).toUpperCase() + target.substring(1);
        String fileName = toPath + Domain + Target + ".java";
        System.out.println("开始生成：" + fileName);
        FreemarkerUtil.generator(fileName, param);
    }

    private static void genVue(String do_main, Map<String, Object> param) throws IOException, TemplateException {
        FreemarkerUtil.initConfig("vue.ftl");
        do_main = do_main.substring(0, 1).toUpperCase()+do_main.substring(1)+"Page";
        new File(vuePath).mkdirs();
        String fileName = vuePath + do_main + ".vue";
        System.out.println("开始生成：" + fileName);
        FreemarkerUtil.generator(fileName, param);
    }

    private static String getGeneratorPath() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Map<String, String> map = new HashMap<>();
        map.put("pom", "http://maven.apache.org/POM/4.0.0");
        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        Document document = saxReader.read(pomPath);
        Node node = document.selectSingleNode("//pom:configurationFile");
        System.out.println(node.getText());
        return node.getText();
    }

    /**
     * 获取所有的Java类型，使用Set去重
     */
    private static Set<String> getJavaTypes(List<Field> fieldList) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < fieldList.size(); i++) {
            Field field = fieldList.get(i);
            set.add(field.getJavaType());
        }
        return set;
    }
}
