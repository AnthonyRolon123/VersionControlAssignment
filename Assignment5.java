package cop2805;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assignment5 
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                GUI();
            }
        });
    }
    
    public static void GUI()
    {
        MyFrame frame = new MyFrame();//making an instance
    }
}

class MyFrame extends JFrame
{
    public JTextField firstNumber = new JTextField();//variables that can be used by name
    public JTextField secondNumber = new JTextField();
    public JLabel output = new JLabel("Result:");
    public JButton calculate = new JButton("Calculate");
    public String[] arr = new String[]{"Add", "Subtract", "Multiply", "Divide"};
    public JComboBox box = new JComboBox(arr);
    
    public MyFrame()
    {
        super();
        init();
    }
    
    private void init()
    {
        this.setTitle("My First Swing Application");//stuff to make screen layout and size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,2));
        this.add(new JLabel("First Number:"));
        this.add(firstNumber);
        this.add(new JLabel("Second Number:"));
        this.add(secondNumber);
        this.add(new JLabel());
        this.add(box);
        this.add(new JLabel());
        this.add(calculate);
        this.add(output);
        int frameWidth = 400;
        int frameHeight = 200;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((int) screenSize.getWidth()-frameWidth,0,frameWidth,frameHeight);
        this.setVisible(true);
        
        calculate.addActionListener(new ActionListener()//action listener to see if button was clicked
        {
            public void actionPerformed(ActionEvent e)
            {
                double firstNum = Double.parseDouble(firstNumber.getText());//grabbing num from first box
                double secondNum = Double.parseDouble(secondNumber.getText());//Grabbing num from second box
                
                String comboIndex = box.getSelectedItem().toString();//seeing if drop down was add, subtract, etc
                
                switch(comboIndex)//switch case to go through different cases
                {
                    case "Add":
                        output.setText("Result: " + String.valueOf(Add(firstNum,secondNum)));
                        break;
                    case "Subtract":
                        output.setText("Result: " + String.valueOf(Subtract(firstNum,secondNum)));
                        break;
                    case "Multiply":
                        output.setText("Result: " + String.valueOf(Multiply(firstNum,secondNum)));
                        break;
                    case "Divide":
                        output.setText("Result: " + String.valueOf(Divide(firstNum,secondNum)));
                        break;
                }
            }
        });
    }
    
    public static double Add(double first, double second)//functions to do calculation
    {
        return first + second;
    }
    public double Multiply(double first, double second)
    {
        return first * second;
    }
    public double Divide(double first, double second)
    {
        return first / second;
    }
    public double Subtract(double first, double second)
    {
        return first - second;
    }
}
