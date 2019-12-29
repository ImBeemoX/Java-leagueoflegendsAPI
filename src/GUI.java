import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private int screenWidth;
    private int screenHeight;
    private JLabel label;
    private JButton btnSearch;
    private JTextField textField;

    public GUI(){
        super("League of legends");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getScreenSize();
        setBounds((screenWidth - screenWidth / 2) / 2, (screenHeight - screenHeight / 2) / 2, screenWidth / 2, screenHeight /2);
        setPreferredSize(new Dimension(screenWidth / 2, screenHeight / 2));
        setMinimumSize(new Dimension(screenWidth / 2, screenHeight / 2));
        setLayout(new BorderLayout());
        setVisible(true);

    }

    private void getScreenSize(){
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    }

    private void addComponents(){
       JPanel panel = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 10));
       btnSearch = new JButton("Search");
       btnSearch.setMinimumSize(new Dimension(screenWidth / 4, screenHeight / 4));
       btnSearch.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               SummonorGetter getter = new SummonorGetter();
               GUISummonorDetail g = new GUISummonorDetail(getter.getSummonorByName(textField.getText()));
           }
       });
       label = new JLabel("Name:");
       textField = new JTextField(8);
       Font font = textField.getFont().deriveFont(50f);

        textField.setFont(font);
        label.setFont(font);
        panel.add(label);
        panel.add(textField);
        panel.add(btnSearch);
        add(panel);
        pack();
    }



    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.addComponents();
    }
}
