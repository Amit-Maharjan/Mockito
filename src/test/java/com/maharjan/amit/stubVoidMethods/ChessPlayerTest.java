package com.maharjan.amit.stubVoidMethods;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ChessPlayerTest {
    @Test
    public void assignCategorySpyTest() throws Exception {
        ChessPlayer chessPlayer = new ChessPlayer("Amit", 30);
        ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

        // Do-Nothing: Instruct a method call to perform no action at all
        doNothing().when(chessPlayerSpy).assignCategory();
        chessPlayerSpy.assignCategory();

//        Assert.assertEquals("Senior", chessPlayerSpy.getCategory());
        Assert.assertNull(chessPlayerSpy.getCategory());
    }

    @Test
    public void assignCategoryMockTest() throws Exception {
        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);

        when(chessPlayerMock.getAge()).thenReturn(30);
        // Do-Call-Real-Method: Used to call the real method upon a mock object
        doCallRealMethod().when(chessPlayerMock).assignCategory();
        doCallRealMethod().when(chessPlayerMock).getCategory();

        chessPlayerMock.assignCategory();

        Assert.assertEquals("Senior", chessPlayerMock.getCategory());
    }

    @Test(expected = Exception.class)
    public void assignCategoryMockExceptionTest() throws Exception {
        ChessPlayer chessPlayerMock = mock(ChessPlayer.class);
        doThrow(Exception.class).when(chessPlayerMock).assignCategory();
        chessPlayerMock.assignCategory();
    }

    @Test
    public void assignScoreStatsTest() {
        ChessPlayer chessPlayer = new ChessPlayer("Amit", 30);
        ChessPlayer chessPlayerSpy = Mockito.spy(chessPlayer);

        // Do-Answer: Returns an answer implementation from void
        doAnswer((chessP) -> {
                    ChessPlayer player = (ChessPlayer) chessP.getMock();
                    player.setWins(3);
                    player.setPoints(9);
                    return null;
                }).when(chessPlayerSpy).assignScoreStats();

        chessPlayerSpy.assignScoreStats();

        Assert.assertSame(3, chessPlayerSpy.getWins());
        Assert.assertSame(9, chessPlayerSpy.getPoints());
    }
}
