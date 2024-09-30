/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sqlux;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author simon
 */
public class SqluxMenu extends javax.swing.JFrame
{
    private static final long serialVersionUID=1L;
    private static File iniDirectory=System.getenv("SQLUXINI")==null
                        ? new File(System.getProperty("user.home")+File.separator+".sqlux")
                        : new File(System.getenv("SQLUXINI"));

    //private static File sqluxHome=new File(System.getenv("SQLUXHOME")==null?"sQLux":System.getenv("SQLUX"));
    private static File sqluxBinary=System.getenv("SQLUX")==null?new File("sqlux")
                                                    :new File(System.getenv("SQLUX"));

    private transient final Ini ini=new Ini();

    /**
     * Creates new form SqluxMenu
     */
    public SqluxMenu()
    {
        initComponents();

        romDirectoryTextField.setText(new File(sqluxBinary.getParentFile(), "roms").getPath());

        deviceTable.getModel().addTableModelListener(new TableModelListener()
        {
            boolean changing=false;

            @Override public void tableChanged(TableModelEvent tme)
            {
                if(changing) return;

                changing=true;

                final int column=tme.getColumn();

                if(column>=3)
                {

                    for(int r=0;r<deviceTable.getRowCount();r++)
                    {
                        if((column==3)&&(deviceTable.getValueAt(r,3)!=null)&&(Boolean)deviceTable.getValueAt(r,3))
                        {
                            deviceTable.setValueAt(false,r,4);
                            deviceTable.setValueAt(false,r,5);
                        }
                        else if((column==4)&&(deviceTable.getValueAt(r,4)!=null)&&(Boolean)deviceTable.getValueAt(r,4))
                        {
                            deviceTable.setValueAt(false,r,3);
                            deviceTable.setValueAt(false,r,5);
                        }
                        else if((column==5)&&(deviceTable.getValueAt(r,5)!=null)&&(Boolean)deviceTable.getValueAt(r,5))
                        {
                            deviceTable.setValueAt(false,r,3);
                            deviceTable.setValueAt(false,r,4);
                        }
                    }
                }

                changing=false;
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        boolean help=false;

        for(int i=0; i<args.length; i++)
        {
            if((args[i].equals("-d")||(args[i].equals("--dir")))&&(i+1<args.length))
            {
                iniDirectory=new File(args[++i]);
            }
            else if((args[i].equals("-s")||(args[i].equals("--sqlux")))&&(i+1<args.length))
            {
                sqluxBinary=new File(args[++i]);
            }
            else if((args[i].equals("-h")||(args[i].equals("--help"))))
                help=true;
            else
            {
                System.err.println("Unknown command line argument: "+args[i]);
                help=true;
                break;
            }
        }

        if(help)
        {
            System.out.println("sQLuxmenu [-d|--dir config_directory] [-s|--sqlux sqlux_binary_path] [-h|--help]");
            System.exit(0);
        }

        if(!sqluxBinary.exists())
        {
            System.err.println("sQLux executable not found: "+sqluxBinary);
            System.exit(1);
        }

        if(!iniDirectory.exists()) iniDirectory.mkdirs();

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(SqluxMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SqluxMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SqluxMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch(javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SqluxMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new SqluxMenu().setVisible(true);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        windowSizeButtonGroup = new javax.swing.ButtonGroup();
        aspectButtonGroup = new javax.swing.ButtonGroup();
        keyboardButtonGroup = new javax.swing.ButtonGroup();
        paletteButtonGroup = new javax.swing.ButtonGroup();
        shaderButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        hardwarePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ramTopTextField = new javax.swing.JTextField();
        CPUHogCheckBox = new javax.swing.JCheckBox();
        fastStartupCheckBox = new javax.swing.JCheckBox();
        skipBootCheckBox = new javax.swing.JCheckBox();
        noPatchCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        windowSize1RadioButton = new javax.swing.JRadioButton();
        windowSize2RadioButton = new javax.swing.JRadioButton();
        windowSize3RadioButton = new javax.swing.JRadioButton();
        windowSizeMaxRadioButton = new javax.swing.JRadioButton();
        windowSizeFullRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        xTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        yTextField = new javax.swing.JTextField();
        filterCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        aspect4x3RadioButton = new javax.swing.JRadioButton();
        aspectQLRadioButton = new javax.swing.JRadioButton();
        aspect1to1RadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        keyboardGBRadioButton = new javax.swing.JRadioButton();
        keyboardDERadioButton = new javax.swing.JRadioButton();
        keyboardUSRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        speedTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        soundTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        paletteBrightRadioButton = new javax.swing.JRadioButton();
        paletteMutedjRadioButton = new javax.swing.JRadioButton();
        paletteGreyscaleRadioButton = new javax.swing.JRadioButton();
        shaderDisabledRadioButton = new javax.swing.JRadioButton();
        shaderFlatjRadioButton = new javax.swing.JRadioButton();
        shaderBarrelRadioButton = new javax.swing.JRadioButton();
        shaderFileTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        strictLockCheckBox = new javax.swing.JCheckBox();
        romPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        romDirectoryTextField = new javax.swing.JTextField();
        selectRomDirectoryButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        portRomTextField = new javax.swing.JTextField();
        selectPortRomButton = new javax.swing.JButton();
        IORomTextField = new javax.swing.JTextField();
        selectIORom2Button = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        selectIOROMButton = new javax.swing.JButton();
        IORom2TextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        sysRomTextField = new javax.swing.JTextField();
        sysRomDirectoryButton = new javax.swing.JButton();
        devicesPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        serial1TextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        serial2TextField = new javax.swing.JTextField();
        serial3TextField = new javax.swing.JTextField();
        serial4TextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        printCommandTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        deviceTable = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        ser2SelectButton = new javax.swing.JButton();
        ser1SelectButton = new javax.swing.JButton();
        ser3SelectButton = new javax.swing.JButton();
        ser4SelectButton = new javax.swing.JButton();
        bootDeviceTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        bdiTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        joy2TextField = new javax.swing.JTextField();
        joy1TextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        bootCommandTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        iniList = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        quitMenuItem = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        runButton.setText("Run!");
        runButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                runButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(runButton)))
        );

        jLabel1.setText("Ramtop:");

        ramTopTextField.setText("1024");
        ramTopTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ramTopTextFieldActionPerformed(evt);
            }
        });

        CPUHogCheckBox.setText("CPU hog");

        fastStartupCheckBox.setSelected(true);
        fastStartupCheckBox.setText("Fast startup");

        skipBootCheckBox.setText("Skip boot");

        noPatchCheckBox.setText("No patch");

        jLabel2.setText("Window size:");

        windowSizeButtonGroup.add(windowSize1RadioButton);
        windowSize1RadioButton.setSelected(true);
        windowSize1RadioButton.setText("x1");

        windowSizeButtonGroup.add(windowSize2RadioButton);
        windowSize2RadioButton.setText("x2");

        windowSizeButtonGroup.add(windowSize3RadioButton);
        windowSize3RadioButton.setText("x3");

        windowSizeButtonGroup.add(windowSizeMaxRadioButton);
        windowSizeMaxRadioButton.setText("Max");

        windowSizeButtonGroup.add(windowSizeFullRadioButton);
        windowSizeFullRadioButton.setText("Full");

        jLabel3.setText("Resolution:");

        jLabel4.setText("x");

        filterCheckBox.setText("Filter");

        jLabel5.setText("Fix aspect:");

        aspectButtonGroup.add(aspect4x3RadioButton);
        aspect4x3RadioButton.setText("4:3");

        aspectButtonGroup.add(aspectQLRadioButton);
        aspectQLRadioButton.setText("QL");

        aspectButtonGroup.add(aspect1to1RadioButton);
        aspect1to1RadioButton.setSelected(true);
        aspect1to1RadioButton.setText("1:1");

        jLabel6.setText("Keyboard:");

        keyboardButtonGroup.add(keyboardGBRadioButton);
        keyboardGBRadioButton.setSelected(true);
        keyboardGBRadioButton.setText("GB");

        keyboardButtonGroup.add(keyboardDERadioButton);
        keyboardDERadioButton.setText("DE");

        keyboardButtonGroup.add(keyboardUSRadioButton);
        keyboardUSRadioButton.setText("US");

        jLabel7.setText("Speed:  x");

        speedTextField.setText("1");

        jLabel8.setText("Sound:");

        soundTextField.setText("4");

        jLabel9.setText("Palette:");

        jLabel10.setText("Shader:");

        paletteButtonGroup.add(paletteBrightRadioButton);
        paletteBrightRadioButton.setSelected(true);
        paletteBrightRadioButton.setText("Bright");

        paletteButtonGroup.add(paletteMutedjRadioButton);
        paletteMutedjRadioButton.setText("Muted");

        paletteButtonGroup.add(paletteGreyscaleRadioButton);
        paletteGreyscaleRadioButton.setText("Greyscale");

        shaderButtonGroup.add(shaderDisabledRadioButton);
        shaderDisabledRadioButton.setSelected(true);
        shaderDisabledRadioButton.setText("Disabled");

        shaderButtonGroup.add(shaderFlatjRadioButton);
        shaderFlatjRadioButton.setText("Flat");

        shaderButtonGroup.add(shaderBarrelRadioButton);
        shaderBarrelRadioButton.setText("Barrel distortion");

        jLabel23.setText("Shader file:");

        strictLockCheckBox.setText("Stick lock");
        strictLockCheckBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                strictLockCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hardwarePanelLayout = new javax.swing.GroupLayout(hardwarePanel);
        hardwarePanel.setLayout(hardwarePanelLayout);
        hardwarePanelLayout.setHorizontalGroup(
            hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardwarePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                        .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hardwarePanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aspect4x3RadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aspectQLRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aspect1to1RadioButton))
                            .addGroup(hardwarePanelLayout.createSequentialGroup()
                                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(paletteBrightRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paletteMutedjRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paletteGreyscaleRadioButton))
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(keyboardGBRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(keyboardDERadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(keyboardUSRadioButton))
                                    .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(soundTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(speedTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(shaderDisabledRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(shaderFlatjRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(shaderBarrelRadioButton)
                                        .addGap(55, 55, 55)
                                        .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(strictLockCheckBox)
                                            .addGroup(hardwarePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(2, 2, 2)
                                                .addComponent(shaderFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                        .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(hardwarePanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(skipBootCheckBox)
                                    .addComponent(ramTopTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(CPUHogCheckBox)
                                        .addGap(124, 124, 124)
                                        .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(noPatchCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fastStartupCheckBox)))))
                            .addGroup(hardwarePanelLayout.createSequentialGroup()
                                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(windowSize1RadioButton))
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(xTextField)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(windowSize2RadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(windowSize3RadioButton))
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yTextField)))
                                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(windowSizeMaxRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(windowSizeFullRadioButton))
                                    .addGroup(hardwarePanelLayout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(filterCheckBox)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        hardwarePanelLayout.setVerticalGroup(
            hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardwarePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ramTopTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPUHogCheckBox)
                    .addComponent(fastStartupCheckBox)
                    .addComponent(strictLockCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skipBootCheckBox)
                    .addComponent(noPatchCheckBox))
                .addGap(18, 18, 18)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(windowSize1RadioButton)
                    .addComponent(windowSize2RadioButton)
                    .addComponent(windowSize3RadioButton)
                    .addComponent(windowSizeMaxRadioButton)
                    .addComponent(windowSizeFullRadioButton))
                .addGap(18, 18, 18)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(aspect4x3RadioButton)
                    .addComponent(aspectQLRadioButton)
                    .addComponent(aspect1to1RadioButton))
                .addGap(18, 18, 18)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(keyboardGBRadioButton)
                    .addComponent(keyboardDERadioButton)
                    .addComponent(keyboardUSRadioButton))
                .addGap(18, 18, 18)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(speedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(soundTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(paletteBrightRadioButton)
                    .addComponent(paletteMutedjRadioButton)
                    .addComponent(paletteGreyscaleRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hardwarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(shaderDisabledRadioButton)
                    .addComponent(shaderFlatjRadioButton)
                    .addComponent(shaderBarrelRadioButton)
                    .addComponent(shaderFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(377, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hardware", hardwarePanel);

        jLabel11.setText("System rom:");

        jLabel12.setText("Rom directory:");

        selectRomDirectoryButton1.setText("Select");
        selectRomDirectoryButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectRomDirectoryButton1ActionPerformed(evt);
            }
        });

        jLabel18.setText("Port rom:");

        selectPortRomButton.setText("Select");
        selectPortRomButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectPortRomButtonActionPerformed(evt);
            }
        });

        selectIORom2Button.setText("Select");
        selectIORom2Button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectIORom2ButtonActionPerformed(evt);
            }
        });

        jLabel19.setText("IO Rom:");

        selectIOROMButton.setText("Select");
        selectIOROMButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectIOROMButtonActionPerformed(evt);
            }
        });

        jLabel20.setText("IO Rom2:");

        sysRomDirectoryButton.setText("Select");
        sysRomDirectoryButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sysRomDirectoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout romPanelLayout = new javax.swing.GroupLayout(romPanel);
        romPanel.setLayout(romPanelLayout);
        romPanelLayout.setHorizontalGroup(
            romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(romPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(romPanelLayout.createSequentialGroup()
                        .addComponent(IORom2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectIORom2Button))
                    .addGroup(romPanelLayout.createSequentialGroup()
                        .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sysRomTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(romDirectoryTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(portRomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IORomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectRomDirectoryButton1)
                            .addComponent(sysRomDirectoryButton)
                            .addComponent(selectPortRomButton)
                            .addComponent(selectIOROMButton))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        romPanelLayout.setVerticalGroup(
            romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(romPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(romDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(selectRomDirectoryButton1))
                .addGap(23, 23, 23)
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sysRomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(sysRomDirectoryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectPortRomButton)
                    .addComponent(portRomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectIOROMButton)
                    .addComponent(IORomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(romPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectIORom2Button)
                    .addComponent(IORom2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addContainerGap(546, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ROMs", romPanel);

        jLabel13.setText("Serial 1:");

        jLabel14.setText("Serial 2:");

        jLabel15.setText("Serial 3:");

        jLabel16.setText("Serial 4:");

        jLabel17.setText("Print command:");

        printCommandTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                printCommandTextFieldActionPerformed(evt);
            }
        });

        deviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String []
            {
                "Qdos name", "Unix path", "Clean?", "Qdos fs?", "Native?", "Qdos-like?"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(deviceTable);

        jLabel21.setText("Devices:");

        jLabel22.setText("Boot device:");

        ser2SelectButton.setText("Select");
        ser2SelectButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ser2SelectButtonActionPerformed(evt);
            }
        });

        ser1SelectButton.setText("Select");
        ser1SelectButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ser1SelectButtonActionPerformed(evt);
            }
        });

        ser3SelectButton.setText("Select");
        ser3SelectButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ser3SelectButtonActionPerformed(evt);
            }
        });

        ser4SelectButton.setText("Select");
        ser4SelectButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ser4SelectButtonActionPerformed(evt);
            }
        });

        jLabel24.setText("BDI file:");

        jLabel25.setText("Joy 1:");

        jLabel26.setText("Joy 2:");

        jLabel27.setText("Boot command:");

        javax.swing.GroupLayout devicesPanelLayout = new javax.swing.GroupLayout(devicesPanel);
        devicesPanel.setLayout(devicesPanelLayout);
        devicesPanelLayout.setHorizontalGroup(
            devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devicesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(devicesPanelLayout.createSequentialGroup()
                        .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(devicesPanelLayout.createSequentialGroup()
                                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel15))
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(serial1TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                    .addComponent(serial4TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                    .addComponent(serial3TextField)
                                    .addComponent(serial2TextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ser1SelectButton)
                                    .addComponent(ser2SelectButton)
                                    .addComponent(ser3SelectButton)
                                    .addComponent(ser4SelectButton)))
                            .addComponent(jLabel24))
                        .addGap(170, 170, 170))
                    .addGroup(devicesPanelLayout.createSequentialGroup()
                        .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(printCommandTextField)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                            .addComponent(bdiTextField)
                            .addGroup(devicesPanelLayout.createSequentialGroup()
                                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(joy2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(joy1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(devicesPanelLayout.createSequentialGroup()
                                .addComponent(bootDeviceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(bootCommandTextField)))))
                .addContainerGap())
        );
        devicesPanelLayout.setVerticalGroup(
            devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(devicesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(serial1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ser1SelectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serial2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(ser2SelectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serial3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(ser3SelectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serial4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(ser4SelectButton))
                .addGap(9, 9, 9)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(printCommandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(bootDeviceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(bootCommandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(bdiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(devicesPanelLayout.createSequentialGroup()
                        .addComponent(joy1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(devicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joy2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addContainerGap(269, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Devices", devicesPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iniList.setModel(new IniListModel());
        iniList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        iniList.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                iniListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(iniList);

        jMenu1.setText("File");

        quitMenuItem.setText("Quit");
        quitMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(quitMenuItem);

        openMenuItem.setText("Open ini...");
        openMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(openMenuItem);

        saveAsMenuItem.setText("Save as...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printCommandTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_printCommandTextFieldActionPerformed
    {//GEN-HEADEREND:event_printCommandTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printCommandTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButtonActionPerformed
    {//GEN-HEADEREND:event_saveButtonActionPerformed
        toIni(ini);

        if(ini.getFile()==null)
        {
            ini.setFile(openFile(JFileChooser.FILES_ONLY,iniDirectory));
        }

        try
        {
            ini.save();
        }
        catch(final Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void quitMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitMenuItemActionPerformed
    {//GEN-HEADEREND:event_quitMenuItemActionPerformed
        if((ini!=null)&&ini.wasModified())
        {
            switch(JOptionPane.showConfirmDialog(this, "Save ini file?", "Quit", JOptionPane.YES_NO_CANCEL_OPTION))
            {
                case JOptionPane.CANCEL_OPTION:
                    return;
                case JOptionPane.YES_OPTION:
                    try
                    {
                        ini.save();
                    }
                    catch(final Exception e)
                    {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                    }
            }
        }

        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_quitMenuItemActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_runButtonActionPerformed
    {//GEN-HEADEREND:event_runButtonActionPerformed
        try
        {
            final boolean noFile=ini.getFile()==null;

            if(noFile) ini.setFile(File.createTempFile("sqluxmunu", ".ini"));

            toIni(ini);
            ini.save();

            // Run
            final Process p=Runtime.getRuntime().exec(new String[]
            {
                sqluxBinary.getAbsolutePath(), "--CONFIG", ini.getFile().getAbsolutePath()
            });

            while(p.isAlive())
            {
                try
                {
                    p.waitFor();
                }
                catch(final InterruptedException e)
                {
                }
            }

            if(p.exitValue()!=0)
            {
                final StringBuilder error=new StringBuilder();

                int c=0;

                for(final InputStream stream : new InputStream[]
                {
                    p.getInputStream(), p.getErrorStream()
                })
                {
                    try(final BufferedReader in=new BufferedReader(new InputStreamReader(stream)))
                    {
                        for(String buffer=in.readLine(); buffer!=null; buffer=in.readLine())
                        {
                            if(++c>2)
                            {
                                if(!error.isEmpty()) error.append(buffer);
                                error.append("\n").append(buffer);
                            }

                            System.out.println(buffer);
                        }
                    }
                }

                if(!error.isEmpty()) JOptionPane.showMessageDialog(this, error.toString());
            }

            // Tidy up
            if(noFile)
            {
                ini.getFile().deleteOnExit();
                ini.setFile(null);
            }

        }
        catch(final Exception e)
        {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_runButtonActionPerformed

    private void selectRomDirectoryButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectRomDirectoryButton1ActionPerformed
    {//GEN-HEADEREND:event_selectRomDirectoryButton1ActionPerformed
        final File romdir=openFile(JFileChooser.DIRECTORIES_ONLY,new File(romDirectoryTextField.getText()));

        if((romdir!=null)&&romdir.isDirectory()) romDirectoryTextField.setText(romdir.getPath());
    }//GEN-LAST:event_selectRomDirectoryButton1ActionPerformed

    private void selectPortRomButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectPortRomButtonActionPerformed
    {//GEN-HEADEREND:event_selectPortRomButtonActionPerformed
        final File portRom=openFile(JFileChooser.FILES_ONLY,new File(romDirectoryTextField.getText()));

        if(portRom==null)
            romDirectoryTextField.setText("");
        else
        {
            String rom=portRom.getPath();
            final String romDir=romDirectoryTextField.getText();

            if(!rom.isBlank())
            {
                if(portRom.length()!=16384)
                {
                    JOptionPane.showMessageDialog(this, "Rom '"+portRom+"' is not 16k!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else // if(rom.startsWith(romDir))
                {
                    portRomTextField.setText(portRom.getAbsolutePath());
                }
            }
        }
    }//GEN-LAST:event_selectPortRomButtonActionPerformed

    private void sysRomDirectoryButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sysRomDirectoryButtonActionPerformed
    {//GEN-HEADEREND:event_sysRomDirectoryButtonActionPerformed
        final File sysRom=openFile(JFileChooser.FILES_ONLY,new File(romDirectoryTextField.getText()));

        if(sysRom==null)
            sysRomTextField.setText("");
        else
        {
            String rom=sysRom.getPath();
            final String romDir=romDirectoryTextField.getText();

            if(!rom.isBlank())
            {
                if(sysRom.length()!=49152)
                {
                    JOptionPane.showMessageDialog(this, "Rom '"+sysRom+"' is not 48k! (It's "+sysRom.length()+")", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else //if(rom.startsWith(romDir))
                {
                    sysRomTextField.setText(sysRom.getAbsolutePath());
                }
            }
        }
    }//GEN-LAST:event_sysRomDirectoryButtonActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openMenuItemActionPerformed
    {//GEN-HEADEREND:event_openMenuItemActionPerformed
        final File iniFile=openFile(JFileChooser.FILES_ONLY,iniDirectory);

        if(iniFile!=null)
        {
            try
            {
                ini.setFile(iniFile);
                ini.load();

                fromIni(ini);

                SqluxMenu.this.setTitle(iniFile.getName());
            }
            catch(final Exception e)
            {
                e.printStackTrace(System.out);
                JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void iniListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_iniListValueChanged
    {//GEN-HEADEREND:event_iniListValueChanged
        final File newFile=new File(iniDirectory, iniList.getSelectedValue());

        if((ini.getFile()==null)||!ini.getFile().equals(newFile))
        {
            try
            {
                toIni(ini);

                if(ini.wasModified())
                {
                    // Prompt for save
                }

                ini.setFile(newFile);
                ini.load();
                fromIni(ini);
                SqluxMenu.this.setTitle(newFile.getName());
            }
            catch(final Exception e)
            {
                e.printStackTrace(System.out);
                JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_iniListValueChanged

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveAsMenuItemActionPerformed
    {//GEN-HEADEREND:event_saveAsMenuItemActionPerformed
        final File newFile=openFile(JFileChooser.FILES_ONLY,iniDirectory);

        if(newFile!=null)
        {
            try
            {
                toIni(ini);

                ini.setFile(newFile);
                ini.save();
                fromIni(ini);
                setTitle(newFile.getName());

                ((IniListModel) iniList.getModel()).refresh();
                iniList.repaint();
            }
            catch(final Exception e)
            {
                e.printStackTrace(System.out);
                JOptionPane.showMessageDialog(this, "Error: "+e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void ser4SelectButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ser4SelectButtonActionPerformed
    {//GEN-HEADEREND:event_ser4SelectButtonActionPerformed
        final File newFile=openFile(JFileChooser.FILES_ONLY,new File("/dev"));

        serial4TextField.setText(newFile.getPath());
    }//GEN-LAST:event_ser4SelectButtonActionPerformed

    private void ser1SelectButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ser1SelectButtonActionPerformed
    {//GEN-HEADEREND:event_ser1SelectButtonActionPerformed
        final File newFile=openFile(JFileChooser.FILES_ONLY,new File("/dev"));

        serial1TextField.setText(newFile.getPath());
    }//GEN-LAST:event_ser1SelectButtonActionPerformed

    private void ser2SelectButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ser2SelectButtonActionPerformed
    {//GEN-HEADEREND:event_ser2SelectButtonActionPerformed
        final File newFile=openFile(JFileChooser.FILES_ONLY,new File("/dev"));

        serial2TextField.setText(newFile.getPath());        // TODO add your handling code here:
    }//GEN-LAST:event_ser2SelectButtonActionPerformed

    private void ser3SelectButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ser3SelectButtonActionPerformed
    {//GEN-HEADEREND:event_ser3SelectButtonActionPerformed
        final File newFile=openFile(JFileChooser.FILES_ONLY,new File("/dev"));

        serial3TextField.setText(newFile.getPath());    }//GEN-LAST:event_ser3SelectButtonActionPerformed

    private void selectIOROMButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectIOROMButtonActionPerformed
    {//GEN-HEADEREND:event_selectIOROMButtonActionPerformed
        final File ioROM=openFile(JFileChooser.FILES_ONLY,new File(romDirectoryTextField.getText()));

        if(ioROM==null)
            sysRomTextField.setText("");
        else
        {
            String rom=ioROM.getPath();

            if(!rom.isBlank())
            {
                if(ioROM.length()!=49152)
                {
                    JOptionPane.showMessageDialog(this, "Rom '"+ioROM+"' is not 48k!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    IORomTextField.setText(ioROM.getPath());
                }
            }
        }
    }//GEN-LAST:event_selectIOROMButtonActionPerformed

    private void selectIORom2ButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectIORom2ButtonActionPerformed
    {//GEN-HEADEREND:event_selectIORom2ButtonActionPerformed
        final File ioROM=openFile(JFileChooser.FILES_ONLY,new File(romDirectoryTextField.getText()));

        if(ioROM==null)
            sysRomTextField.setText("");
        else
        {
            String rom=ioROM.getPath();

            if(!rom.isBlank())
            {
                if(ioROM.length()!=49152)
                {
                    JOptionPane.showMessageDialog(this, "Rom '"+ioROM+"' is not 48k!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    IORom2TextField.setText(ioROM.getPath());
                }
            }
        }
    }//GEN-LAST:event_selectIORom2ButtonActionPerformed

    private void ramTopTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ramTopTextFieldActionPerformed
    {//GEN-HEADEREND:event_ramTopTextFieldActionPerformed
        try
        {
            int z=Integer.parseInt(ramTopTextField.getText());

            if(z<=0) ramTopTextField.setText("256");
        }
        catch(final NumberFormatException e)
        {
            ramTopTextField.setText("256");
        }
    }//GEN-LAST:event_ramTopTextFieldActionPerformed

    private void strictLockCheckBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_strictLockCheckBoxActionPerformed
    {//GEN-HEADEREND:event_strictLockCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strictLockCheckBoxActionPerformed

    private void put(final Ini ini, final String key, final String value)
    {
        if(value.isBlank()) ini.remove(key);
        else ini.put(key, value);
    }

    public void fromIni(final Ini ini)
    {
        sysRomTextField.setText(ini.get("SYSROM").stream().findAny().orElse(""));
        romDirectoryTextField.setText(ini.get("ROMDIR").stream().findAny().orElse(""));
        ramTopTextField.setText(ini.get("RAMTOP").stream().findAny().orElse(""));
        serial1TextField.setText(ini.get("SER1").stream().findAny().orElse(""));
        serial2TextField.setText(ini.get("SER2").stream().findAny().orElse(""));
        serial3TextField.setText(ini.get("SER3").stream().findAny().orElse(""));
        serial4TextField.setText(ini.get("SER4").stream().findAny().orElse(""));
        printCommandTextField.setText(ini.get("PRINT").stream().findAny().orElse(""));
        CPUHogCheckBox.setSelected(ini.has("CPU_HOG")&&ini.get("CPU_HOG").stream().findAny().orElse("").equals("1"));
        fastStartupCheckBox.setSelected(ini.get("FAST_STARTUP").stream().findAny().orElse("").equals("1"));
        skipBootCheckBox.setSelected(ini.has("SKIP_BOOT")&&!ini.get("SKIP_BOOT").stream().findAny().orElse("").equals("0"));
        portRomTextField.setText(ini.get("ROMPORT").stream().findAny().orElse(""));
        IORomTextField.setText(ini.get("IOROM1").stream().findAny().orElse(""));
        IORom2TextField.setText(ini.get("IOROM2").stream().findAny().orElse(""));
        noPatchCheckBox.setSelected(ini.has("NO_PATCH")&&ini.get("NO_PATCH").stream().findAny().orElse("").equals("1"));
        strictLockCheckBox.setSelected(ini.has("STRICT_LOCK")&&ini.get("STRICT_LOCK").stream().findAny().orElse("").equals("1"));

        for(int rc=0;rc<deviceTable.getRowCount();rc++)
        {
            deviceTable.setValueAt("",rc,0);
            deviceTable.setValueAt("",rc,1);
            for(int i=2;i<6;i++) deviceTable.setValueAt(false, rc,i);
        }

        int rc=0;

        for(String device:ini.get("DEVICE"))
        {
            for(int i=0;i<2;i++)
            {
                int p=device.indexOf(',');

                if(p==-1)
                {
                    // WARNING!
                }

                deviceTable.setValueAt(device.substring(0,p),rc,i);
                device=device.substring(p+1).trim();
            }

            while(!device.isEmpty())
            {
                int p=device.indexOf(",");

                final String z=p==-1?device:device.substring(0,p).trim();
                if(p!=-1) device=device.substring(p+1).trim();
                else device="";

                switch(z)
                {
                    case "clean" -> deviceTable.setValueAt(true, rc,2);
                    case "qdos-fs" -> deviceTable.setValueAt(true, rc,3);
                    case "native" -> deviceTable.setValueAt(true, rc,4);
                    case "qdos-like" -> deviceTable.setValueAt(true, rc,5);
                }
            }

            rc++;
        }

        bdiTextField.setText(ini.get("BDI1").stream().findAny().orElse(""));

        bootDeviceTextField.setText(ini.get("BOOT_DEVICE").stream().findAny().orElse(""));

        if(ini.has("WIN_SIZE")) switch(ini.get("WIN_SIZE").stream().findAny().orElse(""))
            {
                case "1x" ->
                    windowSize1RadioButton.setSelected(true);
                case "2x" ->
                    windowSize2RadioButton.setSelected(true);
                case "3x" ->
                    windowSize3RadioButton.setSelected(true);
                case "max" ->
                    windowSizeMaxRadioButton.setSelected(true);
                case "full" ->
                    windowSizeFullRadioButton.setSelected(true);
                default ->
                    windowSize1RadioButton.setSelected(true);
        }
        else windowSize1RadioButton.setSelected(true);

        if(ini.has("RESOLUTION"))
        {
            final String res=ini.get("RESOLUTION").stream().findAny().orElse("");
            final int p=res.indexOf("x");

            xTextField.setText(p==-1?"":res.substring(0, p).trim());
            yTextField.setText(p==-1?"":res.substring(p+1).trim());
        }

        filterCheckBox.setSelected(ini.has("FILTER")&&ini.get("FILTER").stream().findAny().get().equals("1"));

        if(ini.has("FIXASPECT")) switch(ini.get("FIXASPECT").stream().findAny().orElse(""))
            {
                case "1" ->
                    aspect4x3RadioButton.setSelected(true);
                case "2" ->
                    aspectQLRadioButton.setSelected(rootPaneCheckingEnabled);
                default ->
                    aspect1to1RadioButton.setSelected(true);
        }
        else aspect1to1RadioButton.setSelected(true);

        if(ini.has("KBD")) switch(ini.get("KBD").stream().findAny().orElse(""))
            {
                case "GB" ->
                    keyboardGBRadioButton.setSelected(true);
                case "DE" ->
                    keyboardDERadioButton.setSelected(true);
                default ->
                    keyboardUSRadioButton.setSelected(true);
        }
        else keyboardUSRadioButton.setSelected(true);

        speedTextField.setText(ini.get("SPEED").stream().findAny().orElse(""));
        soundTextField.setText(ini.get("SOUND").stream().findAny().orElse(""));
        // put(ini,"JOY1",...);
        // put(ini,"JOY2",...);

        if(ini.has("PALETTE")) switch(ini.get("PALETTE").stream().findAny().orElse(""))
            {
                case "1" ->
                    paletteMutedjRadioButton.setSelected(true);
                case "2" ->
                    paletteGreyscaleRadioButton.setSelected(true);
                default ->
                    paletteBrightRadioButton.setSelected(true);
        }
        else paletteBrightRadioButton.setSelected(true);

        if(ini.has("BOOT_CMD")) bootCommandTextField.setText(ini.get("BOOT_CMD").stream().findAny().get());
        if(ini.has("JOY1")) joy1TextField.setText(ini.get("JOY1").stream().findAny().get());
        if(ini.has("JOY2")) joy2TextField.setText(ini.get("JOY2").stream().findAny().get());

        if(ini.has("SHADER")) switch(ini.get("SHADER").stream().findAny().orElse(""))
            {
                case "1" ->
                    shaderFlatjRadioButton.setSelected(true);
                case "2" ->
                    shaderBarrelRadioButton.setSelected(true);
                default ->
                    shaderDisabledRadioButton.setSelected(true);
        }
        else shaderDisabledRadioButton.setSelected(true);

        shaderFileTextField.setText(ini.get("SHADER_FILE").stream().findAny().orElse(""));
    }

    public void toIni(final Ini ini)
    {
        ini.clear();

        put(ini, "SYSROM", sysRomTextField.getText());

        put(ini, "ROMDIR", this.romDirectoryTextField.getText());
        put(ini, "RAMTOP", this.ramTopTextField.getText());
        put(ini, "SER1", this.serial1TextField.getText());
        put(ini, "SER2", this.serial2TextField.getText());
        put(ini, "SER3", this.serial3TextField.getText());
        put(ini, "SER4", this.serial4TextField.getText());
        put(ini, "PRINT", this.printCommandTextField.getText());

        if(this.bootDeviceTextField.getText().isBlank())
            ini.remove("BOOT_CMD");
        else put(ini,"BOOT_CMD",this.bootDeviceTextField.getText());

        if(this.joy1TextField.getText().isBlank())
            ini.remove("JOY1");
        else try
        {
            int j=Integer.parseInt(this.joy1TextField.getText());

            if((j>=1)&&(j<=8)) put(ini,"JOY1",Integer.toString(j));
        }
        catch(final NumberFormatException e)
        {
            ini.remove("JOY1");
            joy1TextField.setText("");
        }


        if(this.joy2TextField.getText().isBlank())
            ini.remove("JOY2");
        else try
        {
            int j=Integer.parseInt(this.joy2TextField.getText());

            if((j>=1)&&(j<=8)) put(ini,"JOY2",Integer.toString(j));
        }
        catch(final NumberFormatException e)
        {
            ini.remove("JOY2");
            joy2TextField.setText("");
        }

        if(this.strictLockCheckBox.isSelected())
            put(ini, "STRICT_LOCK","1");
        else ini.remove("STRICT_LOCK");

        if(this.CPUHogCheckBox.isSelected())
            put(ini,"CPU_HOG","1");
        else put(ini, "CPU_HOG","0");


        put(ini, "FAST_STARTUP", this.fastStartupCheckBox.isSelected()?"1":"0");

        if(!this.skipBootCheckBox.isSelected())
            put(ini, "SKIP_BOOT","0");
        else ini.remove("SKIP_BOOT");

        put(ini, "ROMPORT", this.portRomTextField.getText());
        put(ini, "IOROM1", this.IORomTextField.getText());
        put(ini, "IOROM2", this.IORom2TextField.getText());

        if(this.noPatchCheckBox.isSelected())
            put(ini, "NO_PATCH","1");
        else ini.remove("NO_PATCH");

        put(ini, "BDI1",this.bdiTextField.getText());
        put(ini, "BOOT_DEVICE", bootDeviceTextField.getText());

        if(windowSize1RadioButton.isSelected())
            ini.remove("WIN_SIZE");
        else if(windowSize2RadioButton.isSelected())
            put(ini, "WIN_SIZE", "2x");
        else if(windowSize3RadioButton.isSelected())
            put(ini, "WIN_SIZE", "3x");
        else if(windowSizeMaxRadioButton.isSelected())
            put(ini, "WIN_SIZE", "max");
        else if(windowSizeFullRadioButton.isSelected())
            put(ini, "WIN_SIZE", "full");

        if(!this.xTextField.getText().isBlank()&&!this.yTextField.getText().isBlank())
            put(ini, "RESOLUTION", this.xTextField.getText()+"x"+this.yTextField.getText());

        if(filterCheckBox.isSelected())
            put(ini, "FILTER","1");
        else ini.remove("FILTER");

        if(aspect1to1RadioButton.isSelected())
            ini.remove("FIXASPECT");
        else if(aspect4x3RadioButton.isSelected())
            put(ini, "FIXASPECT", "1");
        else if(aspectQLRadioButton.isSelected())
            put(ini, "FIXASPECT", "2");

        if(keyboardGBRadioButton.isSelected()) put(ini, "KBD", "GB");
        else if(keyboardDERadioButton.isSelected()) put(ini, "KBD", "DE");
        else if(keyboardUSRadioButton.isSelected()) put(ini, "KBD", "");

        put(ini, "SOUND", soundTextField.getText());
        if(speedTextField.getText().equals("0")
        ||speedTextField.getText().equals("0.0")
        ||speedTextField.getText().isBlank())
            ini.remove("SPEED");
        else put(ini, "SPEED", speedTextField.getText());

        // put(ini,"JOY1",...);
        // put(ini,"JOY2",...);
        if(paletteBrightRadioButton.isSelected()) ini.remove("PALETTE");
        else if(paletteMutedjRadioButton.isSelected()) put(ini, "PALETTE", "1");
        else if(paletteGreyscaleRadioButton.isSelected()) put(ini, "PALETTE", "2");

        if(shaderDisabledRadioButton.isSelected()) put(ini, "SHADER", "");
        else if(shaderFlatjRadioButton.isSelected()) put(ini, "SHADER", "1");
        else if(shaderBarrelRadioButton.isSelected()) put(ini, "SHADER", "2");

        put(ini, "SHADER_FILE", shaderFileTextField.getText());

        for(int r=0;r<deviceTable.getRowCount();r++)
        {
            final StringBuilder d=new StringBuilder();

            d.append(deviceTable.getValueAt(r,0));
            if(d.toString().equals("null")||d.isEmpty()) continue;
            d.append(",").append(deviceTable.getValueAt(r,1));

            if((deviceTable.getValueAt(r,2)!=null)&&(Boolean)deviceTable.getValueAt(r,2)) d.append(",clean");
            if((deviceTable.getValueAt(r,3)!=null)&&(Boolean)deviceTable.getValueAt(r,3)) d.append(",qdos-fs");
            if((deviceTable.getValueAt(r,4)!=null)&&(Boolean)deviceTable.getValueAt(r,4)) d.append(",native");
            if((deviceTable.getValueAt(r,5)!=null)&&(Boolean)deviceTable.getValueAt(r,5)) d.append(",qdos-like");

            System.out.println("DEVICE='"+d.toString()+"'");

            put(ini,"DEVICE",d.toString());
        }
    }

    public void openFile(final Ini ini)
    {
        ini.setFile(openFile());
    }

    public File openFile()
    {
        return openFile(JFileChooser.FILES_ONLY,iniDirectory);
    }

    public File openFile(final int mode,final File dir)
    {
        final JFileChooser fileChooser=new JFileChooser(dir);

        fileChooser.setFileSelectionMode(mode);
        fileChooser.setFileHidingEnabled(false);

        final int result=fileChooser.showOpenDialog(this);

        if(result==JFileChooser.APPROVE_OPTION)
        {
            return fileChooser.getSelectedFile();
        }
        else return null;
    }

    public class IniListModel extends DefaultListModel<String>
    {

        private static final long serialVersionUID=1L;

        public IniListModel()
        {
            refresh();
        }

        public final void refresh()
        {
            this.clear();

            for(File file : iniDirectory.listFiles((File file, String string) -> string.endsWith(".ini")))
            {
                this.add(this.size(), file.getName());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CPUHogCheckBox;
    private javax.swing.JTextField IORom2TextField;
    private javax.swing.JTextField IORomTextField;
    private javax.swing.JRadioButton aspect1to1RadioButton;
    private javax.swing.JRadioButton aspect4x3RadioButton;
    private javax.swing.ButtonGroup aspectButtonGroup;
    private javax.swing.JRadioButton aspectQLRadioButton;
    private javax.swing.JTextField bdiTextField;
    private javax.swing.JTextField bootCommandTextField;
    private javax.swing.JTextField bootDeviceTextField;
    private javax.swing.JTable deviceTable;
    private javax.swing.JPanel devicesPanel;
    private javax.swing.JCheckBox fastStartupCheckBox;
    private javax.swing.JCheckBox filterCheckBox;
    private javax.swing.JPanel hardwarePanel;
    private javax.swing.JList<String> iniList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField joy1TextField;
    private javax.swing.JTextField joy2TextField;
    private javax.swing.ButtonGroup keyboardButtonGroup;
    private javax.swing.JRadioButton keyboardDERadioButton;
    private javax.swing.JRadioButton keyboardGBRadioButton;
    private javax.swing.JRadioButton keyboardUSRadioButton;
    private javax.swing.JCheckBox noPatchCheckBox;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JRadioButton paletteBrightRadioButton;
    private javax.swing.ButtonGroup paletteButtonGroup;
    private javax.swing.JRadioButton paletteGreyscaleRadioButton;
    private javax.swing.JRadioButton paletteMutedjRadioButton;
    private javax.swing.JTextField portRomTextField;
    private javax.swing.JTextField printCommandTextField;
    private javax.swing.JMenuItem quitMenuItem;
    private javax.swing.JTextField ramTopTextField;
    private javax.swing.JTextField romDirectoryTextField;
    private javax.swing.JPanel romPanel;
    private javax.swing.JButton runButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton selectIOROMButton;
    private javax.swing.JButton selectIORom2Button;
    private javax.swing.JButton selectPortRomButton;
    private javax.swing.JButton selectRomDirectoryButton1;
    private javax.swing.JButton ser1SelectButton;
    private javax.swing.JButton ser2SelectButton;
    private javax.swing.JButton ser3SelectButton;
    private javax.swing.JButton ser4SelectButton;
    private javax.swing.JTextField serial1TextField;
    private javax.swing.JTextField serial2TextField;
    private javax.swing.JTextField serial3TextField;
    private javax.swing.JTextField serial4TextField;
    private javax.swing.JRadioButton shaderBarrelRadioButton;
    private javax.swing.ButtonGroup shaderButtonGroup;
    private javax.swing.JRadioButton shaderDisabledRadioButton;
    private javax.swing.JTextField shaderFileTextField;
    private javax.swing.JRadioButton shaderFlatjRadioButton;
    private javax.swing.JCheckBox skipBootCheckBox;
    private javax.swing.JTextField soundTextField;
    private javax.swing.JTextField speedTextField;
    private javax.swing.JCheckBox strictLockCheckBox;
    private javax.swing.JButton sysRomDirectoryButton;
    private javax.swing.JTextField sysRomTextField;
    private javax.swing.JRadioButton windowSize1RadioButton;
    private javax.swing.JRadioButton windowSize2RadioButton;
    private javax.swing.JRadioButton windowSize3RadioButton;
    private javax.swing.ButtonGroup windowSizeButtonGroup;
    private javax.swing.JRadioButton windowSizeFullRadioButton;
    private javax.swing.JRadioButton windowSizeMaxRadioButton;
    private javax.swing.JTextField xTextField;
    private javax.swing.JTextField yTextField;
    // End of variables declaration//GEN-END:variables
}
