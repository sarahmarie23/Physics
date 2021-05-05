package Physics;

import java.text.DecimalFormat;

public class em {
	public final static double target = 1.75882E11;
	private static DecimalFormat df = new DecimalFormat("#.##%");


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double voltage = 275;
		double current = 2.5;
		double radius = 0.03;
		
		double[] voltarr = {100, 125, 150, 175, 200, 225, 250, 275, 300}; //voltage 100-300 V; increments of 25V
		double[] radarr = {0.02, 0.03, 0.04, 0.05, 0.06}; // radius 2 - 6 cm, increments of 1 cm;
		double[] currarr = {0.25, 0.5, 0.75, 1, 1.25, 1.5, 1.75, 2, 2.25, 2.5}; // current 0.25-2.5 A, increments of 0.25 A
		
		//double result = (calculate(voltage, current, radius));
		
		for(int i = 0; i < voltarr.length; i++) {
			for(int j = 0; j < radarr.length; j++) {
				for(int k = 0; k < currarr.length; k++) {
					double curr = Math.pow(currarr[k], -2);
					double rad = Math.pow(radarr[j], -2);
					double volt = voltarr[i];
					double constant = 3574594.641;
					double calc = (constant * volt * curr * rad);
					
					double percent = (percentError(target, calc));
					if(Math.abs(percent) < 0.01) {
						System.out.printf("%n Voltage = " + volt + " V%n Current = " + currarr[k] + " A %n Radius = " + radarr[j] + " m%n Result = " + calc + "%n");
						System.out.println(" Percent error " + df.format(percentError(target, calc)));
					}
				}
			}
		}
		
		

	}
	
	public static double calculate(double voltage, double current, double radius) {
		
		double curr = Math.pow(current, -2);
		double rad = Math.pow(radius, -2);
		double constant = 3574594.641;
		
		double result = (constant * voltage * curr * rad); 
		return result;
	}
	
	public static double percentError(double target, double result) {
		double percent = ((result - target)/target);
		
		return percent;
	}
	
	

}
