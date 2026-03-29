package com.maharjan.amit.mocksstubsspies;

import java.util.List;

public class NewsLetterSender {
    private SubscribersDatabase subscribersDatabase;
    private MessagingEngine messagingEngine;

    public NewsLetterSender(SubscribersDatabase subscribersDatabase, MessagingEngine messagingEngine) {
        this.subscribersDatabase = subscribersDatabase;
        this.messagingEngine = messagingEngine;
    }

    public void sendNewsletter(String subject) {
        List<String> emails = subscribersDatabase.getSubscribers();
        if (numberOfSubscribers() == 0) {
            throw new ZeroSubscribersException();
        }
        messagingEngine.sendMessage(subject, emails);
    }

    public int numberOfSubscribers() {
        return subscribersDatabase.getSubscribers().size();
    }

    public SubscribersDatabase getSubscribersDatabase() {
        return subscribersDatabase;
    }

    public MessagingEngine getMessagingEngine() {
        return messagingEngine;
    }
}
