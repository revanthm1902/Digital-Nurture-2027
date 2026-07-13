import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Create Mock Object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Inject Mock into Service
        MyService service = new MyService(mockApi);

        // Call the Method
        service.fetchData();

        // Verify Interaction
        verify(mockApi).getData();

    }

}