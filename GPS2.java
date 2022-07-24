import java.awt.*;
import java.awt.event.*;

class GPS2 extends Frame implements ActionListener {
    String edu = "1/2548";
    int Credits;
    double GPS;
    Button calButton = new Button("Calculate");
    Button aboutButton = new Button("About");
    Panel tPanel = new Panel();
    Panel lPanel = new Panel();
    Panel rPanel = new Panel();
    Panel bPanel = new Panel();
    String subject[] = { "Modern Programming", "Computer Graphics", "Project II", "Subject", "Subject", "Subject",
            "Subject", "Subject", "Subject", "Subject" };
    String grad[] = { "A", "B+", "B", "C+", "C", "D+", "D", "F" };
    Choice gradChoice = new Choice();
    TextField Semister = new TextField(edu + "");
    TextField Semister_cal = new TextField(edu + "");
    TextField Credits_cal = new TextField(Credits + "");
    TextField GPS_cal = new TextField(GPS + "");

    public GPS2() {
        super("JAVA Grade Point Semister");
        tPanel.setLayout(new GridLayout(1, 4));
        add(tPanel, BorderLayout.NORTH);
        add(lPanel, BorderLayout.WEST);
        // tPanel
        tPanel.add(new Label("Semister"));
        tPanel.add(Semister);
        tPanel.add(new Label(""));
        tPanel.add(new Label(""));
        // lPanel
        lPanel.setLayout(new GridLayout(13, 3));
        lPanel.add(new Label("Subject"));
        lPanel.add(new Label("Credit"));
        lPanel.add(new Label("Grade"));
        for (int i = 0; i < subject.length; i++) {
            lPanel.add(new TextField(subject[i]));
            lPanel.add(new TextField("0"));
            lPanel.add(gradChoice = new Choice());
            for (int j = 0; j < grad.length; j++) {
                gradChoice.addItem(grad[j]);
            }
        }
        // rPanel
        add(rPanel, BorderLayout.EAST);
        rPanel.setLayout(new GridLayout(4, 4));
        rPanel.add(new Label("GPS Semister"));
        rPanel.add(Semister_cal);
        rPanel.add(new Label("Sum of Credits"));
        rPanel.add(Credits_cal);
        rPanel.add(new Label("GPS"));
        rPanel.add(GPS_cal);
        Semister_cal.setEditable(false);
        Credits_cal.setEditable(false);
        GPS_cal.setEditable(false);
        // bPanel
        add(bPanel, BorderLayout.SOUTH);
        bPanel.setLayout(new GridLayout(1, 4));
        bPanel.add(new Label(" "));
        bPanel.add(new Label(" "));
        bPanel.add(calButton);
        bPanel.add(aboutButton);
        // program
        setVisible(true);
        setSize(400, 400);
        pack();
        CodeToHandleWinClose m = new CodeToHandleWinClose();
        addWindowListener(m);
        calButton.addActionListener(this);
        aboutButton.addActionListener(this);
    }

    public static void main(String[] args) {
        new GPS2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == aboutButton) {
            new About();
        }
    }
}

class About extends Frame implements ActionListener {
    Button about_btn = new Button("OK");
    Panel tPanel = new Panel();
    Panel bPanel = new Panel();

    public About() {
        Dialog d = new Dialog(this, "About JAVA GPS");
        d.setSize(200, 200);
        d.setVisible(true);
        d.add(tPanel, BorderLayout.CENTER);
        d.add(bPanel, BorderLayout.SOUTH);
        tPanel.add(new Label("My first GUI program"));
        tPanel.add(new Label("java 1.4.2"));
        bPanel.add(about_btn);
        about_btn.addActionListener(this);
        CodeToHandleWinClose m = new CodeToHandleWinClose();
        d.addWindowListener(m);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == about_btn) {
            setVisible(false);
        }
    }

};
