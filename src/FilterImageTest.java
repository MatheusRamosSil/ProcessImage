import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilterImageTest {
	
	 private FilterImage filter;
	
	 @BeforeEach
	public void setUp() {
		 filter = new FilterImage("./src/img/image.jpeg");
	}
	 
	 
    @Test
    public void create_filter_red_to_image(){
        boolean result = filter.filterRedImage("./src/img/novaRedImage.jpeg");

        assertEquals(true, result);
    }
    
    @Test
    public void create_filter_grayScale_to_image(){
       
        boolean result = filter.grayScaleFilter("./src/img/novaImage.jpeg");

        assertEquals(true, result);
    }
    
    @Test
    public void create_filter_negative(){
        
        boolean result = filter.filterNegative("./src/img/negativeImage.jpeg");

        assertEquals(true, result);
    }
    
    @Test
    public void create_filter_brightness() {
    	  
    	  boolean result = filter.filterBrightnes("./src/img/lightImaga.jpeg",0.5f);
    
    	  assertEquals(true, result);
    }
    
    @Test
    public void create_filter_blue() {
    	  
    	  boolean result = filter.filterBlue("./src/img/BlueImaga.jpeg");
    
    	  assertEquals(true, result);
    }
    
    @Test
    public void create_filter_green() {
    	 
    	  boolean result = filter.filterGreen("./src/img/GreenImaga.jpeg");
    
    	  assertEquals(true, result);
    }
    
    
    @Test
    public void create_filter_limiar() {
    	boolean  result = filter.filterLimiarImage("./src/img/limiarImaga.jpeg");
    	 assertEquals(true, result);
    }
    
    @Test
    public void create_filter_red_grey() {
    	boolean  result = filter.scaleRedGray("./src/img/redGrayImaga.jpeg");
   	    assertEquals(true, result);
    }
    
    @Test
    public void create_filter_green_gray() {
    	boolean  result = filter.scaleGreenGray("./src/img/greenGrayImaga.jpeg");
   	    assertEquals(true, result);
    }
    
    @Test
    public void create_filter_blue_gray() {
    	boolean  result = filter.scaleBlueGray("./src/img/blueGrayImaga.jpeg");
   	    assertEquals(true, result);
    }
    
}
