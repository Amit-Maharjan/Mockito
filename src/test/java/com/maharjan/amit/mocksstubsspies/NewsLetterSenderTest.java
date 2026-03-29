package com.maharjan.amit.mocksstubsspies;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class NewsLetterSenderTest {
    @Test
    public void constructorAssignDatabaseTest() {
        SubscribersDatabase database = new SubscribersDatabase();
        MessagingEngine engine = mock(MessagingEngine.class); // Mock
        NewsLetterSender sender = new NewsLetterSender(database, engine);

        Assert.assertSame(database, sender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribersTest() {
        SubscribersDatabase databaseMock = mock(SubscribersDatabase.class);
        MessagingEngine engineMock = mock(MessagingEngine.class);

        NewsLetterSender sender = new NewsLetterSender(databaseMock, engineMock);

        // Stub = Mock + Instructions for how to response to certain method calls
        List<String> subscriberList = Arrays.asList("email1", "email2", "email3", "email4", "email5", "email6");
        when(databaseMock.getSubscribers()).thenReturn(subscriberList);

        Assert.assertEquals(6, sender.numberOfSubscribers());
    }

    // Spy: This is created when you require both class logic and to stub some of it methods
    @Test(expected = ZeroSubscribersException.class)
    public void sendNewsletterZeroSubscribersThrownTest() {
//        NewsLetterSender newsLetterSenderSpy = spy(NewsLetterSender.class); // Spy requires zero argument constructor
        NewsLetterSender sender = new NewsLetterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsLetterSender newsLetterSenderSpy = spy(sender);

        when(newsLetterSenderSpy.numberOfSubscribers()).thenReturn(0);

        newsLetterSenderSpy.sendNewsletter("SUBJECT");
    }
}
