import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTests extends AbstractTest{
    @Test
    public void webTest() {

    }

    @BeforeClass
    public void init(){
        super.init();
        
        startDriver();
    }
}
