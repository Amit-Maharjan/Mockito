package com.maharjan.amit.defaultMockBehaviour;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {
    @Mock(answer = Answers.RETURNS_DEFAULTS)
    Animal animal;

    @Test
    public void testAnimal1() {
        Animal mockAnimal = mock(Animal.class); // Default Behaviour of Mock

        Assert.assertNull(mockAnimal.getZooKeeper());
        Assert.assertEquals(0, mockAnimal.getAge());
    }

    @Test
    public void testAnimal2() {
        // Return Defaults: Objects and Methods return NULL, primitives are default values
        Animal mockAnimal = mock(Animal.class, RETURNS_DEFAULTS);

        Assert.assertNull(mockAnimal.getZooKeeper());
        Assert.assertEquals(0, mockAnimal.getAge());
    }

    @Test
    public void testAnimal3() {
        // testAnimal2 = testAnimal3
        Assert.assertNull(this.animal.getZooKeeper());
        Assert.assertEquals(0, this.animal.getAge());
    }

    @Test
    public void testAnimal4() {
        // Returns Smart Null
        Animal mockAnimal = mock(Animal.class, RETURNS_SMART_NULLS);

        System.out.println(mockAnimal.getZooKeeper());
        Assert.assertNotNull(mockAnimal.getZooKeeper()); // This is not null, its Smart Null

//        System.out.println(mockAnimal.getZooKeeper().getName()); // ERROR: Null Pointer Exception
    }

    @Test
    public void testAnimal5() {
        // Returns Mocks: Replaces object with mocked instance to avoid possible null pointer exception
        Animal mockAnimal = mock(Animal.class, RETURNS_MOCKS);
        System.out.println(mockAnimal.getZooKeeper().getName());
        Assert.assertEquals("", mockAnimal.getZooKeeper().getName());
    }

    @Test
    public void testAnimal6() {
        // Returns Deep Stubs
        Animal mockAnimal = mock(Animal.class, RETURNS_DEEP_STUBS);
        System.out.println(mockAnimal.getZooKeeper().getName());
        Assert.assertNull(mockAnimal.getZooKeeper().getName());

        when(mockAnimal.getZooKeeper().getName()).thenReturn("ZooKeeper");
        System.out.println(mockAnimal.getZooKeeper().getName());
        Assert.assertEquals("ZooKeeper", mockAnimal.getZooKeeper().getName());
    }
}
