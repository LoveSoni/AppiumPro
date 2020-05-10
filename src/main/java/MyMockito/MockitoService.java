package MyMockito;

import org.junit.Test;
import org.mockito.Mockito;
import org.testng.Assert;


public class MockitoService {

    @Test
    public void myService(){
        ServiceProvider serviceObject = Mockito.mock(ServiceProvider.class);
        Mockito.when(serviceObject.add(2,3)).thenReturn(5);
        Assert.assertEquals(5,serviceObject.add(2,3));
    }
}
