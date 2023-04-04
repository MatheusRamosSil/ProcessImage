import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class FilterImageTest {
    @Test
    public void create_filter_red_to_image(){
        FilterImage filter = new FilterImage("./src/img/image.jpeg");
        boolean result = filter.filterRedImage("./src/img/novaRedImage.jpeg");

        assertEquals(true, result);
    }
    
    @Test
    public void create_filter_grayScale_to_image(){
        FilterImage filter = new FilterImage("./src/img/image.jpeg");
        boolean result = filter.grayScaleFilter("./src/img/novaImage.jpeg");

        assertEquals(true, result);
    }
    
    @Test
    public void create_filter_negative(){
        FilterImage filter = new FilterImage("./src/img/image.jpeg");
        boolean result = filter.filterNegative("./src/img/negativeImage.jpeg");

        assertEquals(true, result);
    }
    
    @Test
    public void create_filter_brightness() {
    	  FilterImage filter = new FilterImage("./src/img/image.jpeg");
    	  boolean result = filter.filterBrightnes("./src/img/lightImaga.jpeg",0.5f);
    
    	  assertEquals(true, result);
    }
    
}
