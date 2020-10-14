import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SequencerInputPanel extends JPanel {

    private JPanel mainPane;
    private JTextField digits;
    private JPanel listPane;
    private String[] permutationArray;
    private DefaultListModel listModel;
    private Container pane;

    public SequencerInputPanel(Container pane) {
        this.pane = pane;
        pane.setLayout(new BorderLayout());
        unlimitedInputPanel();
        listOfPermutations();
        pane.add(mainPane, BorderLayout.PAGE_START);
        pane.add(listPane, BorderLayout.CENTER);
    }




    public void unlimitedInputPanel() {
        mainPane = new JPanel();
        mainPane.setLayout(new BorderLayout());
        mainPane.setBorder(new EmptyBorder(15,15,15,15));
        JPanel northPane = new JPanel(new BorderLayout(5, 5)); //add this panel right above your text area
        JPanel centerPane = new JPanel(new BorderLayout(5, 5));
        JPanel southPane = new JPanel(new BorderLayout(5,5));
        JLabel welcomeMessage = new JLabel("Enter any number of digits to get all possible sequences");
        digits = new JTextField(); //will take all the available space, so you don't need arguments
        JButton enter = new JButton("Enter input");
        setFont(enter);
        enter.addActionListener(new EnterButton());
        setFont(digits);
        setFont(welcomeMessage);
        northPane.add(welcomeMessage);
        centerPane.add(digits);
        southPane.add(enter);
        mainPane.add(centerPane, BorderLayout.CENTER);
        mainPane.add(northPane, BorderLayout.NORTH);
        mainPane.add(southPane, BorderLayout.SOUTH);
    }

    void listOfPermutations(){
        listPane = new JPanel();
        listPane.setLayout(new BorderLayout());
        listPane.setBorder(new EmptyBorder(15,15,15,15));
        listModel = new DefaultListModel();
        JList permutationList = new JList(listModel);
        setFont(permutationList);
        JScrollPane scrollPane = new JScrollPane(permutationList);
        listPane.add(scrollPane,BorderLayout.CENTER);


    }

    private void permutationAddition() {
        for(int i = 0; i< permutationArray.length; i++){
            listModel.addElement(permutationArray[i]);
        }
    }

    private void setFont(JButton jButton) {
        Font font = jButton.getFont();
        jButton.setFont(font.deriveFont(30.0F));
    }

    private void setFont(JList jList) {
        Font font = jList.getFont();
        jList.setFont(font.deriveFont(25.0F));
    }

    private void setFont(JLabel jLabel) {
        Font font = jLabel.getFont();
        jLabel.setFont(font.deriveFont(40.0F));
    }

    private void setFont(JTextField jTextField) {
        Font font = jTextField.getFont();
        jTextField.setFont(font.deriveFont(40.0F));
    }

    class EnterButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = digits.getText();
            listModel.clear();
            Sequencer sequencer = new Sequencer(input);
            permutationArray = sequencer.getArray();
            permutationAddition();
        }
    }


}
