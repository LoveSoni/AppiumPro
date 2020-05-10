package MyMockito;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class MockAnnotation {

    @Mock
    private HashMap<String,String> map;

    @Mock
    private List<Integer> listOfYears;

    MockAnnotation(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void mockNameGroups(){
        Mockito.when(map.put("name","Love Soni")).thenReturn("Love");
        System.out.println("And my name is :"+map.put("name","Love Soni"));
    }



}
