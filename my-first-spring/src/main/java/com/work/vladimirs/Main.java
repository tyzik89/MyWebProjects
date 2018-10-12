package com.work.vladimirs;

import com.work.vladimirs.configs.MyConfig;
import com.work.vladimirs.entities.animals.Dog;
import com.work.vladimirs.entities.days.WeekDay;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        //Создаём пустой спринговый контекст, который будет искать свои бины по аннотациям в указанном пакете
        //ApplicationContext context = new AnnotationConfigApplicationContext("com.work.vladimirs.entities");
        //варианты подключения конфигов
        //отдельный конфиг
        //ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        //пакет конфигов
        //ApplicationContext context = new AnnotationConfigApplicationContext("com.work.vladimirs.configs");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        WeekDay weekDay = context.getBean(WeekDay.class);
        Dog dog = context.getBean(Dog.class);
        System.out.println(dog.getName());
        System.out.println("It's " + weekDay.getWeekdayName() + " today!");

        /*//Полуяаем из контекста кота, контекст уже хранит котта в себе. Просто указываем контексту дать нам бин нужного класса
        Cat cat = context.getBean(Cat.class);
        //Достаём из контекста собачку.
        // Для объектов классов spring задаём имя по умолчанию Dog --> dog, BufferedReader --> bufferedReader.
        // Вариант с котом удобнее
        Dog dog = (Dog) context.getBean("dog");
        //Получаем бин попугая и по имени и по классу
        //на случай, если в контексте окажется несколько бинов одного класса, по имени можно указать какой именно бин
        //нам нужен
        Parrot parrot = context.getBean("parrot-kesha", Parrot.class);

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());*/
    }
}
