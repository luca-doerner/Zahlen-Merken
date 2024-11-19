import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class QuestionWindow extends JPanel {
    JTextField[] textFields;
    JButton abschicken;
    ArrayList<String> numsAnswer;
    ArrayList<String> nums;
    int rightOrder, rightNums;
    final Timer timer = new Timer(1000, null);
    ActionListener listener;
    int secs;

    public QuestionWindow(ArrayList<String> nums){
        this.nums = nums;
        this.rightOrder = 0;
        this.rightNums = 0;

        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secs++;
            }
        };
        timer.addActionListener(listener);

        initWindow();
    }

    public void startTimer(){
        timer.start();
    }

    private void initWindow() {
        this.setSize(600, 500);
        this.setLayout(new GridLayout(2,1));
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(1,9));

        this.textFields = new JTextField[9];

        for(JTextField textField: textFields){
            textField = new JTextField();
            textFieldPanel.add(textField);
        }
        this.add(textFieldPanel);

        this.abschicken = new JButton("Abschicken");
        this.abschicken.addActionListener((ActionEvent e) -> {
            numsAnswer = new ArrayList<String>();

            for (int i = 0; i < 9; i++){
                JTextField textField = (JTextField) textFieldPanel.getComponent(i);
                numsAnswer.add(textField.getText());
            }

            for(int i = 0; i < 9; i++){
                if(Objects.equals(numsAnswer.get(i), nums.get(i))){
                    JTextField textField = (JTextField) textFieldPanel.getComponent(i);
                    rightOrder++;
                    textField.setBackground(new Color(0,255,0));
                    textFieldPanel.revalidate();
                }
                if(numsAnswer.contains(nums.get(i))){
                    rightNums++;
                }
            }

            this.abschicken.setEnabled(false);
            timer.stop();
            JOptionPane.showMessageDialog(this, "richtige Reihenfolge: " + rightOrder + "\nrichtige Zahlen: " + rightNums + "\nZeit in Sekunden: " + secs, "Ergebnisse", JOptionPane.PLAIN_MESSAGE);
        });
        this.add(abschicken);
    }
}
