import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GodButton
{
    static JFrame frame;
    static int toggle = 1;
    public static void main(String[] args)
    {
        // schedule this for the event dispatch thread (edt)
        SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    displayJFrame();
                }
            });
    }

    static void displayJFrame()
    {
        frame = new JFrame("Microsoft Word");

        // create our jbutton
        JButton showDialogButton = new JButton("( ͡° ͜ʖ ͡°)");

        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    // display/center the jdialog when the button is pressed
                    if(toggle == 1){
                        Process p;
                        Process o;
                        try{
                            p = Runtime.getRuntime().exec("mv DyKnow.app DyKnow1.app");
                            o = Runtime.getRuntime().exec("pkill -9 DyKnow >/dev/null/2>&1");
                        }
                        catch(java.io.IOException ex){
                            System.out.println("COMMAND NOT RECOGNIZED");   
                        }
                        toggle = toggle*-1;
                        showDialogButton.setText("CURRENTLY: OFF");
                    }
                    else if(toggle == -1){
                        Process p;
                        
                        //Process o;
                        try{
                            p = Runtime.getRuntime().exec("mv DyKnow1.app DyKnow.app");
                            
                            //o = Runtime.getRuntime().exec("open DyKnow.app");
                        }
                        catch(java.io.IOException ex){
                            System.out.println("COMMAND NOT RECOGNIZED");   
                        }
                        toggle = toggle*-1;
                        showDialogButton.setText("CURRENTLY: ON");
                    }
                }
            });

        // put the button on the frame
        frame.getContentPane().setLayout(new FlowLayout());
        frame.add(showDialogButton);

        // set up the jframe, then display it
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(175, 65));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}