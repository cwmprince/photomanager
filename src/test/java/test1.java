import com.hs.entity.Xc;
import com.hs.service.PhotoService;
import com.hs.service.impl.PhotoServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class test1 {

    @Autowired
    private PhotoService photoService;

    @Test
    public void test1(){
        int i = photoService.updatePhoto(100, 1);
    }
}
