import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Fenetre extends JFrame implements ActionListener {
    //static final int NB_BOUTTON = 3;
    static final String REPO = "J:\\ESIG_II\\APO\\Exo Questionnaire-TuuTau Thu";
    JButton btnChoisir, btnAfficher, btnQuitter;
    //JButton[] mesBouttons;
    //String[] titreBouttons:
    JFileChooser chooser;
    JTextArea textArea;
    ListeItem questionnaire;
    JScrollPane scrollPane;

    public Fenetre (String titre){
        setTitle(titre);
        JPanel bouttonPanel = new JPanel();

        btnChoisir = new JButton("Choisir un fichier");
        btnAfficher = new JButton("Afficher");
        btnQuitter = new JButton("Quitter");
        //mesBouttons = new JButton[NB_BOUTTON];
        //titreBouttons= new String[]{"Choisir un fichier", "Afficher", "Quitter"};
        textArea = new JTextArea(25,50);
        textArea.setEditable(false);

        bouttonPanel.add(btnChoisir);
        bouttonPanel.add(btnAfficher);
        bouttonPanel.add(btnQuitter);

        btnChoisir.addActionListener(this);
        btnAfficher.addActionListener(this);
        btnQuitter.addActionListener(this);

       /* for (int i = 0; i < NB_BOUTTON ; i++) {
            mesBouttons[i] = new JButton(titreBouttons[i]);
            bouttonPanel.add(mesBouttons[i]);
            mesBouttons[i].addActionListener(this);
            System.out.println(mesBouttons);
        }
        mesBouttons[1].setEnabled(false);*/

        btnAfficher.setEnabled(false);
        scrollPane = new JScrollPane(textArea);
        add(bouttonPanel,"North");
        add(scrollPane, "South");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(btnChoisir)){
            chooser = new JFileChooser(new File(REPO));
            int retour = chooser.showOpenDialog(null);
            File fichier = chooser.getSelectedFile();
            questionnaire = new ListeItem(fichier);
            btnAfficher.setEnabled(true);
        }
        else if (ae.getSource().equals(btnAfficher)){
            for (Item item : questionnaire.questionnaire) {
                textArea.append(item.toString());
            }
        }
        else{System.exit(0);}
    }
}