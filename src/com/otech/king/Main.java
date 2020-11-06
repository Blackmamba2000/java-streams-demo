package com.otech.king;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach ❌ (not recommended)
        List<Person> females = new ArrayList<>();
        for (Person person : people){
            if(person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }
        System.out.println();
        System.out.println("~~~ Imperative Approach ~~~");
        females.forEach(System.out::println);
        System.out.println();



        // Declarative approach ✅ (recommended)
        System.out.println();
        System.out.println("~~~ Declarative Approach ~~~");
        females.forEach(System.out::println);
        System.out.println();


        // Filter
        System.out.println();
        System.out.println("~~~ Filter Approach ~~~");
        System.out.println();

        List<Person> females_too = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        females_too.forEach(System.out::println);

        // Sort
        System.out.println();
        System.out.println("~~~ Sort Approach ~~~");
        System.out.println();

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);

        // All match
        System.out.println();
        System.out.println("~~~ All Match ~~~");
        System.out.println();

        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);

        System.out.println(allMatch);


        // Any match
        System.out.println();
        System.out.println("~~~ All Match ~~~");
        System.out.println();

        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);

        System.out.println(anyMatch);


        // None match
        System.out.println();
        System.out.println("~~~ None Match ~~~");
        System.out.println();

        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println(noneMatch);

        // Max
        System.out.println();
        System.out.println("~~~ MAX ~~~");
        System.out.println();

        // Optional<Person> max = people.stream()
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Min
        System.out.println();
        System.out.println("~~~ MIN ~~~");
        System.out.println();

        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Group
        System.out.println();
        System.out.println("~~~ GROUP ~~~");
        System.out.println();

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Karl King", 35, Gender.MALE),
                new Person("Kaydene King", 36, Gender.FEMALE),
                new Person("Sandra Williams", 57, Gender.FEMALE),
                new Person("Mark Drake", 59, Gender.MALE),
                new Person("Mike King", 30, Gender.MALE),
                new Person("Juliann Green", 36, Gender.FEMALE)
        );
    }
}