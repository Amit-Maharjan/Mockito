package com.maharjan.amit.mocksstubsspies;

import java.util.ArrayList;
import java.util.List;

public class SubscribersDatabase {
    public List<String> getSubscribers() {
        List<String> subscribers = new ArrayList<>();
        subscribers.add("A");
        subscribers.add("B");
        subscribers.add("C");

        return subscribers;
    }
}
