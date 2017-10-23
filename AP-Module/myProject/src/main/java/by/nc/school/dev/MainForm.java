package main.java.by.nc.school.dev;

import main.java.by.nc.school.dev.entities.users.AppUser;
import main.java.by.nc.school.dev.exceptions.MyException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by User on 15.10.2017.
 */
public class MainForm extends JFrame {
    private JPanel panel1;
    private JList list1;
    private DefaultListModel list1Model = new DefaultListModel();
    private ArrayList<AppUser> appUsers;

    public MainForm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        getContentPane().add(panel1);
        pack();
        initMenuBar();
    }

    private void initMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.add(initMenuOpenSave());
        menuBar.add(initMenuOpenSaveBinaryFile());
        setMenuBar(menuBar);
    }

    private Menu initMenuOpenSave() {
        Menu menuOpenSave = new Menu("File");
        MenuItem openFileItem = new MenuItem("Open");
        MenuItem saveFileItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        menuOpenSave.add(openFileItem);
        menuOpenSave.add(saveFileItem);
        menuOpenSave.add(exitItem);
        openFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(rootPane) == JFileChooser.APPROVE_OPTION) {
                    appUsers = loadAppUsersFromFile(fileChooser.getSelectedFile());
                    updateList1();
                }
            }
        });
        saveFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(rootPane) == JFileChooser.APPROVE_OPTION) {
                    saveArrayOfAppUsers(fileChooser.getSelectedFile());
                }
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return menuOpenSave;
    }

    private ArrayList<AppUser> loadAppUsersFromFile(File file) {
        try {
            ArrayList<AppUser> array = new ArrayList<>();
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                long id = Long.parseLong(st.nextToken());
                String username = st.nextToken();
                String password = st.nextToken();
                String role = st.nextToken();
                AppUser appUser = new AppUser(id, username, password, role);
                array.add(appUser);
            }
            return array;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, "File not found!");
        } catch (MyException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        return null;
    }

    private void saveArrayOfAppUsers(File file) {
        try {
            if (appUsers != null) {
                PrintStream ps = new PrintStream(file);
                for (AppUser appUser : appUsers) {
                    ps.println(appUser);
                }
                ps.close();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    private void updateList1() {
        list1Model.clear();
        list1.setModel(list1Model);
        if (appUsers != null) {
            for (AppUser appUser : appUsers) {
                list1Model.addElement(appUser);
            }
        }
    }

    private Menu initMenuOpenSaveBinaryFile(){
        Menu menuOpenSaveBinary = new Menu("Binary file");
        MenuItem openFileBinaryItem = new  MenuItem("Open binary file");
        MenuItem saveFileBinaryItem = new MenuItem("Save binary file");
        menuOpenSaveBinary.add(openFileBinaryItem);
        menuOpenSaveBinary.add(saveFileBinaryItem);
        openFileBinaryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if(fileChooser.showOpenDialog(rootPane) == JFileChooser.APPROVE_OPTION){
                    try{
                        FileInputStream inputStream = new FileInputStream(fileChooser.getSelectedFile());
                        ObjectInputStream objectInputFile = new ObjectInputStream(inputStream);
                        appUsers = (ArrayList<AppUser>)objectInputFile.readObject();
                        updateList1();
                    }
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Problem with file!");
                    }
                    catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Class problem!");
                    }
                }

            }
        });
        saveFileBinaryItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if(fileChooser.showSaveDialog(rootPane) == JFileChooser.APPROVE_OPTION){
                    try{
                        FileOutputStream outputStream = new FileOutputStream(fileChooser.getSelectedFile());
                        ObjectOutputStream objectOutputFile = new ObjectOutputStream(outputStream);
                        objectOutputFile.writeObject(appUsers);
                    }
                    catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Problem with file!");
                    }
                }

            }
        });
        return menuOpenSaveBinary;
    }

//    private Menu initMenuOpenSaveBinaryFile() {
//
//    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

}
