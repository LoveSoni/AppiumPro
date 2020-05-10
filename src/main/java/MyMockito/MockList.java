package MyMockito;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MockList {

    @Test
    public void mockListTest(){
        List<Integer> inputList = new ArrayList<Integer>(){
            {
                add(5);add(6);add(7);
            }
        };
        List<Integer> mockListObject = Mockito.mock(List.class);
        Mockito.when(mockListObject.size()).thenReturn(5);
        Assert.assertEquals(mockListObject.size(),5);
    }
}
