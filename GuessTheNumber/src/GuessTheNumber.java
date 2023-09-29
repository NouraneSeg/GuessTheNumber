import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumber implements ActionListener {

	private static JPanel panel;	
	private static JFrame frame;
	private static JLabel label;
	private static JButton button;
	private static JTextField textfield;
	private static JLabel message;
	private static JLabel tries;
	
	static int i=3;
	
	static Random r = new Random();
	static int low = 1;
	static int high = 100;
	static int number = r.nextInt(high-low) + low;
	
	public static void main(String[] args) {
		
		System.out.println(number);

        panel=new JPanel();
        panel.setLayout(null);
        
    	frame= new JFrame("Guess The Number");
    	frame.setSize(350,300);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.add(panel);
   		        
        label = new JLabel("Enter a number between 1 and 100 :");
        label.setBounds(45,5,300,100);
        panel.add(label);

        textfield= new JTextField();
        textfield.setBounds(262,48,50,15);
        panel.add(textfield);
        
        button = new JButton("Go!");
        button.setBounds(138,75,55,25);
        button.addActionListener(new GuessTheNumber());
        panel.add(button);
        
        message=new JLabel();
        message.setBounds(60,70,300,100);
        panel.add(message);
        
        tries=new JLabel(i+" tries left");
        tries.setBounds(135,90,300,100);
        panel.add(tries);
        
		frame.setVisible(true);
	
    	}

	@Override
	public void actionPerformed(ActionEvent e) {
		i--;
		if (i<0) {
			message.setText("GAME OVER ... try again ");
		}
		else {
		tries.setText(i+" tries left");
		String t = textfield.getText();
		int x=Integer.parseInt(t);  
		if (x<number) message.setText("WRONG.. hint : enter a bigger number");
		if (x==number) { 
						message.setText("CONGRAT! u guessed the right number");
						tries.setText("");
						i=-1;
					}
		if (x>number) message.setText("hint : enter a smaller number");
		}
	}

	}
