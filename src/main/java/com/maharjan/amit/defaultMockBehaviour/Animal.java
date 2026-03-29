package com.maharjan.amit.defaultMockBehaviour;

public class Animal {
    private ZooKeeper zooKeeper;
    private int age;

    public Animal(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    public ZooKeeper getZooKeeper() {
        return zooKeeper;
    }

    public int getAge() {
        return age;
    }
}
