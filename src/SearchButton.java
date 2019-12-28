import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton extends JButton {
    public SearchButton(String str) {
        super(str);
        setListener();
    }

    private void setListener(){
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 GUI a = new GUI();
            }
        });
    }

}
