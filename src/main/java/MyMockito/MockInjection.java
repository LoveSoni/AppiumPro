package MyMockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class MockInjection {

    @Mock
    List<String> mockList;

    @InjectMocks
    Student mockStudent;

    MockInjection(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockInjector(){
        Mockito.when(mockList.get(0)).thenReturn("Love");
        System.out.println(mockList.get(0));
        Mockito.when(mockList.size()).thenReturn(1);
        System.out.println(mockList.size());

        System.out.print(mockStudent.getNameList().get(0));

        mockList.add(1,"new Member"); // if we will add value directly and will not def the behaviour(behaviour means like when and then)
                // then with the mockStudent as well as for mockList object we will get null

        System.out.println(mockList.get(1));

        System.out.println(mockStudent.getNameList().get(1));
    }
}

class Student{
    private List<String> nameList;
    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }


}
