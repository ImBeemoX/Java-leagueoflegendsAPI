import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

public class GUISummonorDetail extends JFrame{

    private int screenWidth;
    private int screenHeight;

    JLabel lblSummonorName;

    private void getScreenSize(){
        screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    }
    public GUISummonorDetail(JSONObject object) {
        super("League of legends");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getScreenSize();
        setBounds((screenWidth / 2) / 4, (screenHeight / 2) / 4, screenWidth / 4, screenHeight /4);
        setPreferredSize(new Dimension(screenWidth / 2, screenHeight / 2));
        setMinimumSize(new Dimension(screenWidth / 2, screenHeight / 2));
        setLayout(new BorderLayout());
        setVisible(true);

        JPanel pnlName = new JPanel();
        JLabel lblName = new JLabel("Summonor name: ");
        lblSummonorName = new JLabel(object.getString("name"));

        pnlName.add(lblName);
        pnlName.add(lblSummonorName);
        pnlName.add(new JLabel(Long.toString((object.getLong("summonerLevel")))));

        System.out.println(object);

        add(pnlName);

    }

}
