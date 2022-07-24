import java.awt.*;
import java.awt.event.*;



public class VatCalculation extends Frame implements ActionListener {
    int n1 = 0,
        n2 = 0;
    TextField priceTxt = new TextField(n1 + "");
    TextField payTxt = new TextField(n2 +"");
    Choice vatChoice = new Choice();
    Button calButton = new Button("Calculate");
    Button clearButton = new Button("Clear");
    Button aboutButton = new Button("About");
    String strVat[] = { "--", "1", "3", "7", "10" };

    public VatCalculation() {
        super("ราคาสินค้ารวม VAT");
        Panel ePanel = new Panel();
        Panel cPanel = new Panel();
        Panel sPanel = new Panel();
        ePanel.setLayout(new GridLayout(3, 2));
        cPanel.setLayout(new GridLayout(3, 1));
        add(ePanel, BorderLayout.WEST);
        add(cPanel, BorderLayout.CENTER);
        add(sPanel, BorderLayout.SOUTH);
        ePanel.add(new Label("Price"));
        cPanel.add(priceTxt);
        ePanel.add(new Label("VAT (%)"));
        for (int i = 0; i < strVat.length; i++) {
            vatChoice.addItem(strVat[i]);
        }
        cPanel.add(vatChoice);
        ePanel.add(new Label("All Price VAT"));
        cPanel.add(payTxt);
        payTxt.setEditable(false);
        sPanel.add(calButton);
        sPanel.add(clearButton);
        sPanel.add(aboutButton);
        setSize(400, 350 );
        setVisible(true);
        aboutButton.addActionListener(this);
        clearButton.addActionListener(this);
        calButton.addActionListener(this);
        CodeToHandleWinClose m = new CodeToHandleWinClose();
        addWindowListener(m);
    }

    

    public static void main(String[] args) {
        new VatCalculation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == aboutButton) {
            new About();
        }

        if(e.getSource() == clearButton) {
            n1 = 0;
            n2 = 0;
            payTxt.setText(n2 + "");
            priceTxt.setText(n1 +"");
            vatChoice.removeAll();
            for (int i = 0; i < strVat.length; i++) {
                vatChoice.addItem(strVat[i]);
            }
        }

        if(e.getSource() == calButton) {
            try {
                n1 = Integer.parseInt(priceTxt.getText());
                int vat = Integer.parseInt(vatChoice.getSelectedItem());
                n2 = n1 + (n1 * vat/100);
                // n2 = vat;
                priceTxt.setText(n1 + "");
                payTxt.setText(n2 + "");
            } catch (NumberFormatException err) {
                new ErrorNum();
                System.out.println(err);
            }
        }

    }

}

class ErrorNum extends Frame  {
    Label label = new Label("Please insert number");
    public ErrorNum() {
        super("Error");
        CodeToHandleWinClose m = new CodeToHandleWinClose();
        Dialog d = new Dialog(this, "Error");
        d.addWindowListener(m);
        d.setBackground(Color.green); 
        d.setVisible(true);
        d.setSize(100,100);
        d.add(label);
    }

}

class About extends Frame implements ActionListener {
        Button about_btn = new Button("OK");
        Panel tPanel = new Panel();
        Panel bPanel = new Panel();
        public About() {
            Dialog d = new Dialog(this, "About Java");
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
           if(e.getSource() == about_btn) {
                setVisible(false);
           } 
        }
            
};

class CodeToHandleWinClose implements WindowListener {

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
}