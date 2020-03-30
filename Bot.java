package Main;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class Bot{
	static int A = 0;
	static int S = 1;
	static int J = 2;
	static int K = 3;
	static int L = 4;
	static boolean start = false;
	static int colors = 0;
	static int[] x = {0,0,0,0,0};
	static int[] y = {0,0,0,0,0};
	static Robot robot;
	
	public static Robot getRobot()
	{
		return robot;
	}
	public static void setRobot() throws AWTException
	{
		robot = new Robot();
	}
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		setRobot();
		System.out.println("Posicione o cursor sob a primeira tecla e aguarde.");
		Thread.sleep(1000);
		GET_C(robot);
		
		Thread GREEN = new Thread(SC_GREEN);
		Thread RED = new Thread(SC_RED);
		Thread YELLOW = new Thread(SC_YELLOW);
		Thread BLUE = new Thread(SC_BLUE);
		Thread ORANGE = new Thread(SC_ORANGE);
		
		GREEN.start();
		RED.start();
		YELLOW.start();
		BLUE.start();
		ORANGE.start();
	}
	 private static Runnable SC_GREEN = new Runnable() {
	        public void run() {
	            try{
	            	Robot robot = new Robot();
	            	Color c;
	            	while(true)
	            	{
	            		c = robot.getPixelColor(x[0], y[0]);
	            		if( c.getGreen() > 80 )
		        		{
		            		System.out.println("[S]: VERDE " + c.getRed() + " / " + c.getGreen() + " / " + c.getBlue());
							SendNote a = new SendNote(A);
							a.run();
		        		}
	            	}

	            } catch (Exception e){}
	 
	        }
	    };
	    
	 private static Runnable SC_RED = new Runnable() {
	        public void run() {
	            try{
	            	Robot robot = new Robot();
	            	Color c;
	            	while(true)
	            	{
	            		c = robot.getPixelColor(x[1], y[1]);
		        		if( c.getRed() > 100 )
		        		{
		        			System.out.println("[S]: VERMELHO " + c.getRed() + " / " + c.getGreen() + " / " + c.getBlue());
							SendNote s = new SendNote(S);
							s.run();
		        		}
	            	}

	            } catch (Exception e){}
	 
	        }
	    };
		 private static Runnable SC_YELLOW = new Runnable() {
		        public void run() {
		            try{
		            	Robot robot = new Robot();
		            	while(true)
		            	{
		            		Color c = robot.getPixelColor(x[2], y[2]);
		        			if(c.getGreen() > 100 && c.getRed() > 100)
			        		{
			        			System.out.println("[S]: AMARELO " + c.getRed() + " / " + c.getGreen() + " / " + c.getBlue());
								SendNote j = new SendNote(J);
								j.run();
			        		}
		            	}

		            } catch (Exception e){}
		 
		        }
		    };
			 private static Runnable SC_BLUE = new Runnable() {
			        public void run() {
			            try{
			            	Robot robot = new Robot();
			            	while(true)
			            	{
			            		Color c = robot.getPixelColor(x[3], y[3]);
			            		if(c.getBlue() > 50 || c.getGreen() > 50)
				        		{
				        			//System.out.println("[S]: AZUL " + c.getRed() + " / " + c.getGreen() + " / " + c.getBlue());
									SendNote k = new SendNote(K);
									k.run();
				        		}
			            	}

			            } catch (Exception e){}
			 
			        }
			    };
				 private static Runnable SC_ORANGE = new Runnable() {
				        public void run() {
				            try{
				            	Robot robot = new Robot();
				            	while(true)
				            	{
				            		Color c = robot.getPixelColor(x[4], y[4]);
				            		if(c.getRed() > 50 || c.getGreen() > 50)
					        		{
					        			//System.out.println("[S]: LARANJA " + c.getRed() + " / " + c.getGreen() + " / " + c.getBlue());
										SendNote l = new SendNote(L);
										l.run();
					        		}
				            	}

				            } catch (Exception e){}
				 
				        }
				    };
	
	public static void GET_C(Robot color) throws InterruptedException, AWTException
	{
		x[colors] = MouseInfo.getPointerInfo().getLocation().x;
		y[colors] = MouseInfo.getPointerInfo().getLocation().y;
		System.out.println("Registrado nova cordenada para tecla " + (colors + 1) + "/5 C: ( " + x + " | " + y + ")" );
		colors++;
		System.out.println("COR CADASTRADA: " + color.getPixelColor(x[colors - 1], y[colors - 1]));
		if( colors == 5 )
		{
			start = true;
			System.out.println("CORDENADAS SETADAS, INICIANDO O BOT !");
			color.mouseMove((MouseInfo.getPointerInfo().getLocation().x - 50 ), MouseInfo.getPointerInfo().getLocation().y - 470);
		}else{
			System.out.println("Posicione o Mouse para coletar a cordenada " + colors);
			color.mouseMove((MouseInfo.getPointerInfo().getLocation().x + 130 ), MouseInfo.getPointerInfo().getLocation().y);
			Thread.sleep(1000);
			GET_C(color);
		}
	}
}
