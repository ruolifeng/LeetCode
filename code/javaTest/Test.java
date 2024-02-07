package javaTest;

import java.util.Arrays;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    // forEach
    List features = Arrays.asList(
      "Lambdas",
      "Default Method",
      "Stream API",
      "Date and Time API"
    );
    features.forEach(n -> System.out.println(n));

    // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
    features.forEach(System.out::println);
  }
}
