package org.example.linkedListQueue;

import java.util.LinkedList;

enum AnimalType {
    DOG, CAT
}

abstract class Animal {
    AnimalType type;
    String name;
    int order;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }

    public String info() {
        return order + ") type: " + type + ", name: " + name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(AnimalType.DOG, name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(AnimalType.CAT, name);
    }
}

class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order;

    public AnimalShelter() {
        this.order = 1;
    }

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if(animal.type == AnimalType.DOG) dogs.addLast((Dog) animal);
        else if(animal.type == AnimalType.CAT) cats.addLast((Cat) animal);
    }

    public Animal dequeueDog() {
        return dogs.poll();
    }

    public Animal dequeueCat() {
        return cats.poll();
    }

    public Animal dequeue() {
        if(dogs.size() == 0 && cats.size() == 0) return null;
        else if(dogs.size() == 0) return cats.poll();
        else if(cats.size() == 0) return dogs.poll();

        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        if(cat.order < dog.order) return cats.poll();
        else return dogs.poll();
    }
}

public class LinkedListQueue {
    public static void main(String[] args) {
        Dog d1 = new Dog("puppy1");
        Dog d2 = new Dog("puppy2");
        Dog d3 = new Dog("puppy3");
        Cat c1 = new Cat("cat1");
        Cat c2 = new Cat("cat2");
        Cat c3 = new Cat("cat3");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        System.out.println(as.dequeueCat().info());
        System.out.println(as.dequeueDog().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());
        System.out.println(as.dequeue().info());

    }
}
