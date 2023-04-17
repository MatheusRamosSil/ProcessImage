
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class FilterImage {
    private File file;
    private BufferedImage image;


    public FilterImage(String pathImage) {

        try{
            this.file = new File(pathImage);
            this.image = ImageIO.read(file);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }


    public boolean filterRedImage(String pathImage) {
        int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
                
            	int pixelImage = image.getRGB(iteratorLine, iteratorCol);
                Color color = new Color(pixelImage);

                int redPixelImage = color.getRed();
                int greenPixelImage = color.getGreen();
                int bluePixelImage = color.getBlue();
             
                Color neoColor = new Color(redPixelImage,0,0);
                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());

            }
        }

         return savedImage(pathImage);
    }

    
    public boolean filterBlue(String pathImage) {
		
    	int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
                int pixelImage = image.getRGB(iteratorLine, iteratorCol);
                Color color = new Color(pixelImage);

                int redPixelImage = color.getRed();
                int greenPixelImage = color.getGreen();
                int bluePixelImage = color.getBlue();

                Color neoColor = new Color(0,0,bluePixelImage);

                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());

            }
        }

         return savedImage(pathImage);
	}
    
    public boolean filterGreen(String pathImage) {
		
    	int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
                int pixelImage = image.getRGB(iteratorLine, iteratorCol);
                Color color = new Color(pixelImage);

                int redPixelImage = color.getRed();
                int greenPixelImage = color.getGreen();
                int bluePixelImage = color.getBlue();

                Color neoColor = new Color(0,greenPixelImage,0);

                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());

            }
        }

         return savedImage(pathImage);
	}
    

    private boolean savedImage(String name) {
        try {
            File neoFile = new File(name);
            ImageIO.write(image, "PNG", neoFile);
            return true;

        } catch (Exception e) {
           e.printStackTrace();
           return false;
        }

    }


	public boolean grayScaleFilter(String pathImage) {
		    int line = image.getWidth();
	        int collunm = image.getHeight();

	        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
	            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
	                int pixelImage = image.getRGB(iteratorLine, iteratorCol);
	                Color color = new Color(pixelImage);

	                int redPixelImage = color.getRed();
	                int greenPixelImage = color.getGreen();
	                int bluePixelImage = color.getBlue();
	                
	                int mediaColors = (redPixelImage + greenPixelImage + bluePixelImage)/3;

	                Color neoColor = new Color(mediaColors,mediaColors,mediaColors);

	                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());

	            }
	        }

	         return savedImage(pathImage);
	}
	
	
	public boolean filterNegative(String pathImage) {
		int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
                int pixelImage = image.getRGB(iteratorLine, iteratorCol);
                Color color = new Color(pixelImage);

                int redPixelNegative = 255 -color.getRed();
                int greenPixelNegative = 255 - color.getGreen();
                int bluePixelNegative = 255 - color.getBlue();

                Color neoColor = new Color(redPixelNegative,greenPixelNegative,bluePixelNegative);
                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());

            }
        }
        
        return savedImage(pathImage);
	}


	public boolean filterBrightnes(String name, float scaleBrightness) {
		int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
                int pixelImage = image.getRGB(iteratorLine, iteratorCol);
                Color color = new Color(pixelImage);

                int redPixel = color.getRed();
                int greenPixel = color.getGreen();
                int bluePixel = color.getBlue();
                
                redPixel = (int) (scaleBrightness * redPixel );
                greenPixel = (int) (scaleBrightness * greenPixel );
                bluePixel = (int) (scaleBrightness * bluePixel );
                
                redPixel = Math.max(Math.min(255, redPixel), 0);
                greenPixel = Math.max(Math.min(255, greenPixel), 0);
                bluePixel = Math.max(Math.min(255, bluePixel), 0);

                Color neoColor = new Color(redPixel,greenPixel,bluePixel);
                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());

            }
        }
        
        return savedImage(name);
		
	}

	
	public boolean filterLimiarImage(String name) {
		int line = image.getWidth();
        int collunm = image.getHeight();

        int limiar = 128;
        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
                
            	int pixelImage = image.getRGB(iteratorLine, iteratorCol);
                int color = (pixelImage & 0xff);

                if (color < limiar) {
                	image.setRGB(iteratorLine, iteratorCol, Color.BLACK.getRGB());
                }else {
                	image.setRGB(iteratorLine, iteratorCol, Color.WHITE.getRGB());
                }
            }
        }
        
        return savedImage(name);
		
	}


	public boolean scaleRedGray(String pathImage) {
		int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
      
            	int pixelImage = image.getRGB(iteratorLine, iteratorCol);
      
                Color color = new Color(pixelImage);

                int redPixelImage = color.getRed();
                int greenPixelImage = color.getGreen();
                int bluePixelImage = color.getBlue();
                Color neoColor = new Color(redPixelImage,redPixelImage,redPixelImage);

                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());
              
            }
        }
        
        return savedImage(pathImage);
	}


	public boolean scaleGreenGray(String pathImage) {
		int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
      
            	int pixelImage = image.getRGB(iteratorLine, iteratorCol);
      
                Color color = new Color(pixelImage);

                int redPixelImage = color.getRed();
                int greenPixelImage = color.getGreen();
                int bluePixelImage = color.getBlue();
                
                int mediaColors = (redPixelImage + greenPixelImage + bluePixelImage)/3;
                Color neoColor = new Color(greenPixelImage,greenPixelImage,greenPixelImage);

                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());
              
            }
        }
        
        return savedImage(pathImage);
	}
	
	public boolean scaleBlueGray(String pathImage) {
		int line = image.getWidth();
        int collunm = image.getHeight();

        for(int iteratorLine = 0; iteratorLine < line; iteratorLine++){
            for(int iteratorCol = 0; iteratorCol < collunm; iteratorCol++){
      
            	int pixelImage = image.getRGB(iteratorLine, iteratorCol);
      
                Color color = new Color(pixelImage);

                int redPixelImage = color.getRed();
                int greenPixelImage = color.getGreen();
                int bluePixelImage = color.getBlue();
                
                int mediaColors = (redPixelImage + greenPixelImage + bluePixelImage)/3;
                Color neoColor = new Color(bluePixelImage,bluePixelImage,bluePixelImage);

                image.setRGB(iteratorLine, iteratorCol, neoColor.getRGB());
              
            }
        }
        
        return savedImage(pathImage);
	}

	
	

	

  

    
    
}