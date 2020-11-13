package ru.job4j.design.srp;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class DataModel {
    public static void main(String[] args) throws IOException, TemplateException {
        // Конфигурация
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(DataModel.class, "/");
        cfg.setDefaultEncoding("UTF-8");
        // модель данных
        Map<String, Object> root = new HashMap<>();

        root.put("name", "Freemarker");
        root.put("name2", "Freemarker2");
        // шаблон
        Template temp = cfg.getTemplate("test.ftl");
        // обработка шаблона и модели данных
        Writer out = new OutputStreamWriter(System.out);
        // вывод в консоль
       temp.process(root, out);
        //System.out.println(temp.toString());
        String str = temp.toString();
        System.out.println(str);
    }


}
