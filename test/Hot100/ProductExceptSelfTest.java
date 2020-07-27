package Hot100;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductExceptSelfTest {
    @Test
    public void productExceptSelf() throws Exception {
        ProductExceptSelf productExceptSelf=new ProductExceptSelf();
        productExceptSelf.productExceptSelf(new int[]{1,2,3,4});
    }

}