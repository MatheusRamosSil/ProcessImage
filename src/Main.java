

public class Main  {

	
	public static void main(String[] args){
		 FilterImage filter = new FilterImage("./src/img/image.jpeg");
		 boolean result = filter.filterRedImage("./src/img/novaRedImage.jpeg");
	}

}
