package A11;

//imports for c
import javax.swing.JOptionPane;

//imports for w
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//imports for g
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.io.BufferedWriter;
import java.io.FileWriter;

//for vi
import java.util.Scanner;



public class Ask1{
	public static void main(String args[]) {
		
		//check for number of arguments
		checkargs(args);
				
		char m =  args[0].charAt(0); // get char m from the first string
		int l = convertL(args);
		
		checkM(m);
		checkL(l);
		
		drawE(m, l);
		
		//recursion for main with l -= 1
		if(l<=5) return;
		args[1] = Integer.toString(--l);
		main(args);
		
		//get new l and do the same thing
			l = getL(m);
			checkL(l);
			drawE(m, l);
			
			if(l<=5) return;
			args[1] = Integer.toString(--l);
			main(args);
		
	}
	
	
	
	
	
	static int getL(char m) {
		int l = 0;
			if(m != 'w') {  
				try {
					System.out.println("Give a the next length(-1 to exit)");
					Scanner scan = new Scanner(System.in); 
					l = scan.nextInt();
					//scan.close();
				}catch (Exception e) {
					System.out.println("INVALID ARGUMENT!");
					System.exit(5);
				}
			}
			else { 
				try {
					l = Integer.parseInt((JOptionPane.showInputDialog("Give a the next length(-1 to exit)", 5)));
				}catch (Exception e) {
					System.out.println("INVALID ARGUMENT!");
					System.exit(6);
				}
			}
			
			return l;
			
		}
	
	
	
	public static void checkM(char m){
		if ( !( (m == 'c') || (m == 'w') || (m == 'f') || (m == 'g') ) ){
			System.out.println("INVALID  ARGUMENT!\n first argument must be c for console, w for window, f for file or g for gui.");
			System.exit(3);
		}
	}
	
	
	public static void checkL(int l){
		if( l == -1 ) System.exit(0);
		
		if ( !( (l >= 5) && (l <= 20) ) ){
			System.out.println("INVALID  ARGUMENT!\n The second argument the height must be between 5 and 20.");
			System.exit(4);
		}
	}
	
	
	public static void checkargs(String args[]){
		if( !(args.length == 2) ) {
			System.out.println("INVALID COMMANDLINE ARGUMENTS!");
			System.exit(1);
		}
	}
	
	
	public static int convertL(String args[]) {
		int l = 0;
		try {
			l = Integer.parseInt(args[1]);  // get int l from the second string
		}catch (NumberFormatException e){
			System.out.println("INVALID COMMANDLINE ARGUMENTS!");
			System.exit(2);
		}
		
		return l;
	}
	
	
	
	public static void drawE(char m, int l){
		//switch to draw E accordingly
				switch (m) {
				case 'c': {
					DrawConsolE(l);
					break;
				}
				case 'w':{
					DrawDWindowE(l);
					break;
				}
				case 'f':{
					DrawFileE(l);
					break;
				}
				case 'g':{
					drawΕgraphics(l);
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + m);
				}
	}
	
	
	public static void DrawConsolE(int l){
		String s = "";
		for (int i = 0; i < l; i++){
			if( ( (i == 0) || (i == l/2) || (i == l - 1) ) || ( (l % 2 == 0) && (i == l/2 -1) ) ){s += l <= 10 ?"*****\n" : "********\n";}
			else {s += "*\n";}
		}
		System.out.println(s);
	}
	
	
	public static void DrawDWindowE(int l){
		UIManager.put("OptionPane.messageFont", new Font("Lucida Console", Font.BOLD, 14));

		String s = "";
		for (int i = 0; i < l; i++){
			if( ( (i == 0) || (i == l/2) || (i == l - 1) ) || ( (l % 2 == 0) && (i == l/2 -1) ) ){s += l <= 10 ?"*****\n" : "********\n";}
			else {s += "*\n";}
		}
		JOptionPane.showMessageDialog(null, s, "E with window", 1);
	}
	
	
	public static void DrawFileE(int l){
		try {
			String s = "<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\"/>\r\n"
					+ "</head>\r\n"
					+ "<body><font size=\" " + l + " \"\">E with font size =" + l + "</font></body>\r\n"
					+ "</html>";
			BufferedWriter writer = new BufferedWriter(new FileWriter("E.html"));
			writer.write(s);
			writer.close();
		}catch (Exception e) {
			System.out.println("Ππόβλημα: "+e);		}
	}
	
	
	public static void drawΕgraphics(int L) {
		Frame f = new Frame("Ζωγραυίζοντας το Ε") {
			public void paint (Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.draw(new Line2D.Double(50, 350, 50, 50));//aristera  //1 arxizei aristera
			g2.draw(new Line2D.Double(50, 350, 200, 350));//katv	//2, 4 idia gia or
			g2.draw(new Line2D.Double(50, 50, 200, 50)); //panv		//3 mikos(or)
			g2.draw(new Line2D.Double(50, 200, 200, 200));//mesh
			}
		};
		f.setSize(400,400);
		f.setVisible(true);
	}
} 
