package ru.denisqaa.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Init extends AbstractAnnotationConfigDispatcherServletInitializer {

  // Метод, указывающий на класс конфигурации
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }


  // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения html.
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[]{
        WebConfiguration.class
    };
  }


  /* Данный метод указывает url, на котором будет базироваться приложение */
  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

}
