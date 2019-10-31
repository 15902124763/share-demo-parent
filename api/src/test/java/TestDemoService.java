import com.yarm.Application;
import com.yarm.service.demo.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IDEA
 * author:Yarm.Yang
 * Date:2019/10/31
 * Time:9:49
 * Des:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class TestDemoService {
    @Autowired
    private DemoService demoService;

    @Test
    public void testInsert(){
        demoService.insert(130L);
    }
}