package farmproject;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

public class homepage extends javax.swing.JFrame {

    ImageIcon manIcon = new ImageIcon(getClass().getResource("/img/man-icon.png"));
    ImageIcon femaleIcon = new ImageIcon(getClass().getResource("/img/woman-icon.png"));
    ImageIcon logoIcon = new ImageIcon(getClass().getResource("/img/logo.png"));
    String userName, pass, email, phone, gender, changeName;

    ArrayList<Plants> possible = new ArrayList<Plants>();
    Plants[] array = new Plants[5];
    Engineer engineer = new Engineer();
    String job = "";

    public homepage(String logUsername) {//to process user information that logs in from login jframe
        initComponents();
        this.userName = logUsername;

        Connection dbconn = dbConnection.connectDB();

        if (dbconn != null) {
            try { //purpose to show user's information in profile section

                Farmer farmer = new Farmer();
                if (farmer.searchFarmer(logUsername) == true) {
                    job = "Farmer";
                    PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM farmer");
                    ResultSet res = st.executeQuery();
//to search by user name from login jframe and find other information of the farmer from database
                    while (res.next()) {
                        if (res.getString("username").equals(userName)) {
                            email = res.getString("email");
                            pass = res.getString("password");
                            phone = res.getString("phone");
                            gender = res.getString("gender");
                        }

                    }
                    //to set up a profile icon based on user gender
                    if (gender.equals("man")) {
                        profileIcon.setIcon(manIcon);
                    } else {
                        profileIcon.setIcon(femaleIcon);
                    }
                } else {
                    job = "Engineer";
                    PreparedStatement st = (PreparedStatement) dbconn.prepareStatement("Select * FROM engineer");
                    ResultSet res = st.executeQuery();
//to search by user name from login jframe and find other information of the farmer from database
                    while (res.next()) {
                        if (res.getString("username").equals(userName)) {
                            email = res.getString("email");
                            pass = res.getString("password");
                            phone = res.getString("phone");
                            gender = res.getString("gender");
                        }

                    }
                    //to set up a profile icon based on user gender
                    if (gender.equals("man")) {
                        profileIcon.setIcon(manIcon);
                    } else {
                        profileIcon.setIcon(femaleIcon);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("The connection not available");
        }

        this.setIconImage(logoIcon.getImage());
        //to change the visibility of panels based on the user's business
        if (job.equals("Engineer")) {
            homePagePanel.setVisible(false);
            plantListBtn.setVisible(false);
            engineerHomepagePanel.setVisible(true);
            messagePanel.setVisible(true);
            engineerInfoPanel.setVisible(false);
            JTableHeader Theader = plantTable1.getTableHeader();
            Theader.setBackground(Color.black);
            Theader.setForeground(new Color(47, 102, 114));
            Theader.setFont(new Font("Tahome", Font.BOLD, 17));
            ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

            try { //To show information from a plant arraylist in a table
                addRowToeng();
            } catch (IOException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            homePagePanel.setVisible(true);
            plantListBtn.setVisible(true);
            engineerHomepagePanel.setVisible(false);
            messagePanel.setVisible(false);
            engineerInfoPanel.setVisible(true);
            plantListBtn.setBackground(new Color(35, 58, 89));
            plantListBtn.setForeground(new Color(209, 217, 193));

        }
        //common panels for all users
        displayFarmerPanel.setVisible(false);
        yearlyPanel.setVisible(false);
        calculatePanel.setVisible(false);
        aboutUsPanel.setVisible(false);
        profilePanel.setVisible(false);
        plantPanel.setVisible(false);
        slidePanel.setVisible(false);
        homePageBtn.setBackground(new Color(191, 179, 155));
        homePageBtn.setForeground(Color.white);
        aboutBtn.setBackground(new Color(35, 58, 89));
        aboutBtn.setForeground(new Color(209, 217, 193));
        profileBtn.setBackground(new Color(35, 58, 89));
        profileBtn.setForeground(new Color(209, 217, 193));

    }

    private homepage() {
        initComponents();
        notice.showMessageDialog(this, "Please start the project with login jframe", "Error", notice.ERROR_MESSAGE);
        System.exit(0);  //login jframe to make entry mandatory

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeGroup = new javax.swing.ButtonGroup();
        lifeGroup = new javax.swing.ButtonGroup();
        yearsGroup = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        homePagePanel = new javax.swing.JPanel();
        questionOneLabel = new javax.swing.JLabel();
        questionOneText = new javax.swing.JTextField();
        questionTwoLabel = new javax.swing.JLabel();
        seasonalBtn = new javax.swing.JRadioButton();
        yearlyBtn = new javax.swing.JRadioButton();
        yearlyPanel = new javax.swing.JPanel();
        yearlyBtn1 = new javax.swing.JRadioButton();
        yearlyBtn2 = new javax.swing.JRadioButton();
        yearlyBtn3 = new javax.swing.JRadioButton();
        questionThreeLabel = new javax.swing.JLabel();
        herbBtn = new javax.swing.JRadioButton();
        bushBtn = new javax.swing.JRadioButton();
        treeBtn = new javax.swing.JRadioButton();
        questionFourLabel = new javax.swing.JLabel();
        questionFourText = new javax.swing.JTextField();
        areaInfoLabel = new javax.swing.JLabel();
        calculateBtn = new javax.swing.JButton();
        calculateLabe = new javax.swing.JLabel();
        calculatePanel = new javax.swing.JPanel();
        calculateScrollPane = new javax.swing.JScrollPane();
        calculateTable = new javax.swing.JTable();
        calculateLabel = new javax.swing.JLabel();
        engineerHomepagePanel = new javax.swing.JPanel();
        search2field = new javax.swing.JTextField();
        farmerDisplayPanel = new javax.swing.JTabbedPane();
        plantScrollPanel1 = new javax.swing.JScrollPane();
        plantTable1 = new javax.swing.JTable();
        displayFarmerPanel = new javax.swing.JPanel();
        farmerScrollPane = new javax.swing.JScrollPane();
        farmerTable = new javax.swing.JTable();
        leftGif1 = new javax.swing.JLabel();
        rightGif1 = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        userArea = new javax.swing.JTextField();
        email1 = new javax.swing.JLabel();
        emailArea = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordArea = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneArea = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        saveLabel = new javax.swing.JLabel();
        messagePanel = new javax.swing.JPanel();
        messageTittle = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        farmerEmailLabel = new javax.swing.JLabel();
        farmerEmailTextField = new javax.swing.JTextField();
        opinionLabel = new javax.swing.JLabel();
        opinionTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        sendLabel = new javax.swing.JLabel();
        engineerInfoBackground1 = new javax.swing.JLabel();
        engineerInfoPanel = new javax.swing.JPanel();
        engineerLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneEngLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        engineerInfoBackground = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        deleteLabel = new javax.swing.JLabel();
        updateBtn1 = new javax.swing.JButton();
        plantPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        plantScrollPane = new javax.swing.JScrollPane();
        plantTable = new javax.swing.JTable();
        leftGif = new javax.swing.JLabel();
        rightGif = new javax.swing.JLabel();
        aboutUsPanel = new javax.swing.JPanel();
        slidePanel = new javax.swing.JPanel();
        slideShowLabel = new javax.swing.JLabel();
        aboutTitle = new javax.swing.JLabel();
        aboutInfoScrollPanel = new javax.swing.JScrollPane();
        aboutInfoArea = new javax.swing.JTextArea();
        contactUsTitle = new javax.swing.JLabel();
        instaIcon = new javax.swing.JLabel();
        mailIcon = new javax.swing.JLabel();
        intaInfo = new javax.swing.JLabel();
        mailInfo = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        iconPanel = new javax.swing.JPanel();
        profileIcon = new javax.swing.JLabel();
        gifLabel = new javax.swing.JLabel();
        menuLineOne = new javax.swing.JSeparator();
        menuLineTwo = new javax.swing.JSeparator();
        profileBtn = new javax.swing.JLabel();
        homePageBtn = new javax.swing.JLabel();
        plantListBtn = new javax.swing.JLabel();
        aboutBtn = new javax.swing.JLabel();
        exitBtn = new javax.swing.JButton();
        exitIcon = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FarmLab");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePagePanel.setBackground(new java.awt.Color(191, 179, 155));
        homePagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        questionOneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionOneLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionOneLabel.setText("The last product you planted in your field ");
        homePagePanel.add(questionOneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        questionOneText.setBackground(new java.awt.Color(191, 179, 155));
        questionOneText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        questionOneText.setForeground(new java.awt.Color(58, 125, 140));
        questionOneText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(58, 125, 140)));
        questionOneText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                questionOneTextFocusGained(evt);
            }
        });
        questionOneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionOneTextActionPerformed(evt);
            }
        });
        homePagePanel.add(questionOneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 235, 30));

        questionTwoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionTwoLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionTwoLabel.setText("Type of product you want to grow ");
        homePagePanel.add(questionTwoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        seasonalBtn.setBackground(new java.awt.Color(255, 255, 255));
        lifeGroup.add(seasonalBtn);
        seasonalBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        seasonalBtn.setForeground(new java.awt.Color(58, 125, 140));
        seasonalBtn.setText("Seasonal");
        seasonalBtn.setBorder(null);
        seasonalBtn.setContentAreaFilled(false);
        seasonalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        seasonalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonalBtnActionPerformed(evt);
            }
        });
        homePagePanel.add(seasonalBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        yearlyBtn.setBackground(new java.awt.Color(255, 255, 255));
        lifeGroup.add(yearlyBtn);
        yearlyBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        yearlyBtn.setForeground(new java.awt.Color(58, 125, 140));
        yearlyBtn.setText("Yearly");
        yearlyBtn.setBorder(null);
        yearlyBtn.setContentAreaFilled(false);
        yearlyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearlyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearlyBtnMouseClicked(evt);
            }
        });
        yearlyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyBtnActionPerformed(evt);
            }
        });
        homePagePanel.add(yearlyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        yearlyPanel.setBackground(new java.awt.Color(191, 179, 155));

        yearlyBtn1.setBackground(new java.awt.Color(255, 255, 255));
        lifeGroup.add(yearlyBtn1);
        yearlyBtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yearlyBtn1.setForeground(new java.awt.Color(58, 125, 140));
        yearlyBtn1.setText("1-5 Years");
        yearlyBtn1.setBorder(null);
        yearlyBtn1.setContentAreaFilled(false);
        yearlyBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearlyBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyBtn1ActionPerformed(evt);
            }
        });

        yearlyBtn2.setBackground(new java.awt.Color(255, 255, 255));
        lifeGroup.add(yearlyBtn2);
        yearlyBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yearlyBtn2.setForeground(new java.awt.Color(58, 125, 140));
        yearlyBtn2.setText("5-10 Years");
        yearlyBtn2.setBorder(null);
        yearlyBtn2.setContentAreaFilled(false);
        yearlyBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearlyBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyBtn2ActionPerformed(evt);
            }
        });

        yearlyBtn3.setBackground(new java.awt.Color(255, 255, 255));
        lifeGroup.add(yearlyBtn3);
        yearlyBtn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yearlyBtn3.setForeground(new java.awt.Color(58, 125, 140));
        yearlyBtn3.setText("10+ Years");
        yearlyBtn3.setBorder(null);
        yearlyBtn3.setContentAreaFilled(false);
        yearlyBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        yearlyBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout yearlyPanelLayout = new javax.swing.GroupLayout(yearlyPanel);
        yearlyPanel.setLayout(yearlyPanelLayout);
        yearlyPanelLayout.setHorizontalGroup(
            yearlyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yearlyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(yearlyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearlyBtn1)
                    .addComponent(yearlyBtn2)
                    .addComponent(yearlyBtn3))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        yearlyPanelLayout.setVerticalGroup(
            yearlyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yearlyPanelLayout.createSequentialGroup()
                .addComponent(yearlyBtn1)
                .addGap(5, 5, 5)
                .addComponent(yearlyBtn2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearlyBtn3)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        homePagePanel.add(yearlyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 80, 150, 100));

        questionThreeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionThreeLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionThreeLabel.setText("Type selection");
        homePagePanel.add(questionThreeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        herbBtn.setBackground(new java.awt.Color(255, 255, 255));
        typeGroup.add(herbBtn);
        herbBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        herbBtn.setForeground(new java.awt.Color(58, 125, 140));
        herbBtn.setText("Herb");
        herbBtn.setBorder(null);
        herbBtn.setContentAreaFilled(false);
        herbBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        herbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herbBtnActionPerformed(evt);
            }
        });
        homePagePanel.add(herbBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 150, -1, -1));

        bushBtn.setBackground(new java.awt.Color(255, 255, 255));
        typeGroup.add(bushBtn);
        bushBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bushBtn.setForeground(new java.awt.Color(58, 125, 140));
        bushBtn.setText("Bush");
        bushBtn.setBorder(null);
        bushBtn.setContentAreaFilled(false);
        bushBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bushBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bushBtnActionPerformed(evt);
            }
        });
        homePagePanel.add(bushBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 150, -1, -1));

        treeBtn.setBackground(new java.awt.Color(255, 255, 255));
        typeGroup.add(treeBtn);
        treeBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        treeBtn.setForeground(new java.awt.Color(58, 125, 140));
        treeBtn.setText("Tree");
        treeBtn.setBorder(null);
        treeBtn.setContentAreaFilled(false);
        treeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        treeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeBtnActionPerformed(evt);
            }
        });
        homePagePanel.add(treeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 150, -1, -1));

        questionFourLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        questionFourLabel.setForeground(new java.awt.Color(255, 255, 255));
        questionFourLabel.setText("Field size");
        homePagePanel.add(questionFourLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        questionFourText.setBackground(new java.awt.Color(191, 179, 155));
        questionFourText.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        questionFourText.setForeground(new java.awt.Color(58, 125, 140));
        questionFourText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(58, 125, 140)));
        questionFourText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                questionFourTextFocusGained(evt);
            }
        });
        questionFourText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                questionFourTextKeyTyped(evt);
            }
        });
        homePagePanel.add(questionFourText, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 201, 150, 36));

        areaInfoLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        areaInfoLabel.setForeground(new java.awt.Color(255, 255, 255));
        areaInfoLabel.setText("acres");
        homePagePanel.add(areaInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 217, -1, 30));

        calculateBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        calculateBtn.setForeground(new java.awt.Color(58, 125, 140));
        calculateBtn.setText("Calculate");
        calculateBtn.setBorder(null);
        calculateBtn.setContentAreaFilled(false);
        calculateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calculateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateBtnMouseClicked(evt);
            }
        });
        calculateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateBtnActionPerformed(evt);
            }
        });
        homePagePanel.add(calculateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 140, 40));

        calculateLabe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calculateLabe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn/whiteBtn.png"))); // NOI18N
        homePagePanel.add(calculateLabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 140, 40));

        getContentPane().add(homePagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 85, 770, 340));

        calculatePanel.setBackground(new java.awt.Color(191, 179, 155));
        calculatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calculateTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        calculateTable.setForeground(new java.awt.Color(35, 58, 89));
        calculateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plants Name", "Kg Price (TL)", "Estimated Earnings (TL)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        calculateTable.setToolTipText("");
        calculateTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calculateTable.setSelectionBackground(new java.awt.Color(209, 217, 193));
        calculateScrollPane.setViewportView(calculateTable);

        calculatePanel.add(calculateScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 47, 600, 240));

        calculateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        calculateLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calculatePanel.png"))); // NOI18N
        calculatePanel.add(calculateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 744, -1));

        getContentPane().add(calculatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 760, 310));

        engineerHomepagePanel.setBackground(new java.awt.Color(191, 179, 155));
        engineerHomepagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search2field.setBackground(new java.awt.Color(191, 179, 155));
        search2field.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        search2field.setForeground(new java.awt.Color(35, 58, 89));
        search2field.setText("Search");
        search2field.setToolTipText("");
        search2field.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(35, 58, 89)));
        search2field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search2fieldFocusGained(evt);
            }
        });
        search2field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search2fieldActionPerformed(evt);
            }
        });
        search2field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search2fieldKeyReleased(evt);
            }
        });
        engineerHomepagePanel.add(search2field, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 120, 32));

        farmerDisplayPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                farmerDisplayPanelMouseClicked(evt);
            }
        });

        plantScrollPanel1.setForeground(new java.awt.Color(204, 102, 255));
        plantScrollPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plantScrollPanel1MouseClicked(evt);
            }
        });

        plantTable1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        plantTable1.setForeground(new java.awt.Color(35, 58, 89));
        plantTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of Plants", "Price", "Kg Over Dekar", "Type of Plants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        plantTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plantTable1.setRowHeight(22);
        plantTable1.setSelectionBackground(new java.awt.Color(209, 217, 193));
        plantScrollPanel1.setViewportView(plantTable1);

        farmerDisplayPanel.addTab("Plants", plantScrollPanel1);

        displayFarmerPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayFarmerPanelMouseClicked(evt);
            }
        });

        farmerTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        farmerTable.setForeground(new java.awt.Color(35, 58, 89));
        farmerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name-Last Name", "Email", "Phone", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        farmerTable.setToolTipText("");
        farmerTable.setSelectionBackground(new java.awt.Color(209, 217, 193));
        farmerScrollPane.setViewportView(farmerTable);

        javax.swing.GroupLayout displayFarmerPanelLayout = new javax.swing.GroupLayout(displayFarmerPanel);
        displayFarmerPanel.setLayout(displayFarmerPanelLayout);
        displayFarmerPanelLayout.setHorizontalGroup(
            displayFarmerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(farmerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        displayFarmerPanelLayout.setVerticalGroup(
            displayFarmerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(farmerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
        );

        farmerDisplayPanel.addTab("Farmers", displayFarmerPanel);

        engineerHomepagePanel.add(farmerDisplayPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 770, 560));
        farmerDisplayPanel.getAccessibleContext().setAccessibleName("Plants");

        leftGif1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftGif1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leftcorner.gif"))); // NOI18N
        engineerHomepagePanel.add(leftGif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 190, 180));

        rightGif1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightGif1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rightcorner.gif"))); // NOI18N
        engineerHomepagePanel.add(rightGif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 190, 180));

        getContentPane().add(engineerHomepagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1010, 760));

        profilePanel.setBackground(new java.awt.Color(191, 179, 155));
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setText("Username");
        profilePanel.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        userArea.setBackground(new java.awt.Color(191, 179, 155));
        userArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userArea.setForeground(new java.awt.Color(58, 125, 140));
        userArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        userArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userAreaFocusGained(evt);
            }
        });
        profilePanel.add(userArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 270, 40));

        email1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        email1.setForeground(new java.awt.Color(255, 255, 255));
        email1.setText("Email");
        profilePanel.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        emailArea.setBackground(new java.awt.Color(191, 179, 155));
        emailArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailArea.setForeground(new java.awt.Color(58, 125, 140));
        emailArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        emailArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailAreaFocusGained(evt);
            }
        });
        profilePanel.add(emailArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 270, 40));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");
        profilePanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        passwordArea.setBackground(new java.awt.Color(191, 179, 155));
        passwordArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordArea.setForeground(new java.awt.Color(58, 125, 140));
        passwordArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        passwordArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordAreaFocusGained(evt);
            }
        });
        passwordArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordAreaActionPerformed(evt);
            }
        });
        profilePanel.add(passwordArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 270, 40));

        phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneLabel.setText("Phone");
        profilePanel.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        phoneArea.setBackground(new java.awt.Color(191, 179, 155));
        phoneArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneArea.setForeground(new java.awt.Color(58, 125, 140));
        phoneArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        phoneArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneAreaFocusGained(evt);
            }
        });
        phoneArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneAreaKeyTyped(evt);
            }
        });
        profilePanel.add(phoneArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 200, 40));

        updateBtn.setBackground(new java.awt.Color(58, 125, 140));
        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(58, 125, 140));
        updateBtn.setText("Update");
        updateBtn.setBorder(null);
        updateBtn.setContentAreaFilled(false);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        profilePanel.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 140, 40));

        saveLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saveLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn/whiteBtn.png"))); // NOI18N
        profilePanel.add(saveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 140, 40));

        messagePanel.setBackground(new java.awt.Color(191, 179, 155));
        messagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        messageTittle.setBackground(new java.awt.Color(140, 131, 104));
        messageTittle.setBorder(null);
        messageTittle.setForeground(new java.awt.Color(191, 179, 155));
        messageTittle.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        messageTittle.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        messageTittle.setEnabled(false);
        messageTittle.setFocusable(false);
        messageTittle.setInheritsPopupMenu(true);
        messageTittle.setOpaque(false);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(140, 131, 104));
        jTextArea3.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(242, 227, 213));
        jTextArea3.setLineWrap(true);
        jTextArea3.setTabSize(0);
        jTextArea3.setText("    State your opinion for the farmers you are responsible for");
        jTextArea3.setToolTipText("");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 227, 213)));
        jTextArea3.setFocusable(false);
        jTextArea3.setKeymap(null);
        jTextArea3.setSelectionColor(new java.awt.Color(191, 179, 155));
        jTextArea3.setVerifyInputWhenFocusTarget(false);
        messageTittle.setViewportView(jTextArea3);

        messagePanel.add(messageTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 300, 50));

        farmerEmailLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        farmerEmailLabel.setForeground(new java.awt.Color(242, 227, 213));
        farmerEmailLabel.setText("Farmer's email adress:");
        messagePanel.add(farmerEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, 20));

        farmerEmailTextField.setBackground(new java.awt.Color(140, 131, 104));
        farmerEmailTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        farmerEmailTextField.setForeground(new java.awt.Color(255, 255, 255));
        farmerEmailTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 227, 213)));
        messagePanel.add(farmerEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 140, 30));

        opinionLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        opinionLabel.setForeground(new java.awt.Color(242, 227, 213));
        opinionLabel.setText("Your opinion:");
        messagePanel.add(opinionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 90, -1));

        opinionTextField.setBackground(new java.awt.Color(140, 131, 104));
        opinionTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        opinionTextField.setForeground(new java.awt.Color(255, 255, 255));
        opinionTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 227, 213)));
        messagePanel.add(opinionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 280, 30));

        sendButton.setBackground(new java.awt.Color(58, 125, 140));
        sendButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        sendButton.setForeground(new java.awt.Color(58, 125, 140));
        sendButton.setText("Send");
        sendButton.setBorder(null);
        sendButton.setContentAreaFilled(false);
        sendButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendButtonMouseClicked(evt);
            }
        });
        messagePanel.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, 50));

        sendLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn/whiteBtn.png"))); // NOI18N
        sendLabel.setText("Send");
        messagePanel.add(sendLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 140, 50));

        engineerInfoBackground1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        engineerInfoBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profilPanel.png.png"))); // NOI18N
        messagePanel.add(engineerInfoBackground1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        profilePanel.add(messagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 349, 289));

        engineerInfoPanel.setBackground(new java.awt.Color(191, 179, 155));
        engineerInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        engineerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        engineerInfoPanel.add(engineerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 110, 110));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(242, 227, 213));
        nameLabel.setToolTipText("");
        engineerInfoPanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 135, 170, -1));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(242, 227, 213));
        emailLabel.setToolTipText("");
        engineerInfoPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 170, -1));

        phoneEngLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        phoneEngLabel.setForeground(new java.awt.Color(242, 227, 213));
        engineerInfoPanel.add(phoneEngLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 181, -1, -1));

        jScrollPane2.setBackground(new java.awt.Color(140, 131, 104));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(191, 179, 155));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setEnabled(false);
        jScrollPane2.setFocusable(false);
        jScrollPane2.setInheritsPopupMenu(true);
        jScrollPane2.setOpaque(false);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(140, 131, 104));
        jTextArea2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(242, 227, 213));
        jTextArea2.setLineWrap(true);
        jTextArea2.setTabSize(0);
        jTextArea2.setText("       Agricultural engineer in\n               charge of you");
        jTextArea2.setToolTipText("");
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 227, 213)));
        jTextArea2.setFocusable(false);
        jTextArea2.setKeymap(null);
        jTextArea2.setSelectionColor(new java.awt.Color(191, 179, 155));
        jTextArea2.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextArea2);

        engineerInfoPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 50));

        engineerInfoBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        engineerInfoBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profilPanel.png.png"))); // NOI18N
        engineerInfoPanel.add(engineerInfoBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        profilePanel.add(engineerInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 349, 289));

        deleteBtn.setBackground(new java.awt.Color(58, 125, 140));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete Account");
        deleteBtn.setBorder(null);
        deleteBtn.setContentAreaFilled(false);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        profilePanel.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 615, 140, 40));

        deleteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn/redBtn.png"))); // NOI18N
        profilePanel.add(deleteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 615, 140, 40));

        updateBtn1.setBackground(new java.awt.Color(58, 125, 140));
        updateBtn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updateBtn1.setForeground(new java.awt.Color(58, 125, 140));
        updateBtn1.setText("Update");
        updateBtn1.setBorder(null);
        updateBtn1.setContentAreaFilled(false);
        updateBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });
        profilePanel.add(updateBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 140, 40));

        getContentPane().add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 850, 680));

        plantPanel.setBackground(new java.awt.Color(191, 179, 155));
        plantPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setBackground(new java.awt.Color(191, 179, 155));
        searchField.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        searchField.setForeground(new java.awt.Color(35, 58, 89));
        searchField.setText("Search");
        searchField.setToolTipText("");
        searchField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(35, 58, 89)));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        plantPanel.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 120, 32));

        plantTable.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        plantTable.setForeground(new java.awt.Color(35, 58, 89));
        plantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name of Plants", "Price", "Kg Over Dekar", "Type of Plants"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        plantTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plantTable.setRowHeight(22);
        plantTable.setSelectionBackground(new java.awt.Color(209, 217, 193));
        plantScrollPane.setViewportView(plantTable);

        plantPanel.add(plantScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 770, 560));

        leftGif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/leftcorner.gif"))); // NOI18N
        plantPanel.add(leftGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 190, 180));

        rightGif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rightcorner.gif"))); // NOI18N
        plantPanel.add(rightGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 580, 190, 180));

        getContentPane().add(plantPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1010, 760));

        aboutUsPanel.setBackground(new java.awt.Color(191, 179, 155));
        aboutUsPanel.setToolTipText("");
        aboutUsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slidePanel.setBackground(new java.awt.Color(191, 179, 155));

        slideShowLabel.setBackground(new java.awt.Color(191, 179, 155));
        slideShowLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        slideShowLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/slideShowImg/1.jpg"))); // NOI18N

        javax.swing.GroupLayout slidePanelLayout = new javax.swing.GroupLayout(slidePanel);
        slidePanel.setLayout(slidePanelLayout);
        slidePanelLayout.setHorizontalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slideShowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        slidePanelLayout.setVerticalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slidePanelLayout.createSequentialGroup()
                .addComponent(slideShowLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );

        aboutUsPanel.add(slidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 560, 490));

        aboutTitle.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        aboutTitle.setForeground(new java.awt.Color(47, 102, 114));
        aboutTitle.setText("About Us :");
        aboutUsPanel.add(aboutTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, -1, 30));

        aboutInfoScrollPanel.setBackground(new java.awt.Color(191, 179, 155));
        aboutInfoScrollPanel.setBorder(null);
        aboutInfoScrollPanel.setForeground(new java.awt.Color(191, 179, 155));
        aboutInfoScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        aboutInfoScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        aboutInfoScrollPanel.setEnabled(false);
        aboutInfoScrollPanel.setFocusable(false);
        aboutInfoScrollPanel.setInheritsPopupMenu(true);
        aboutInfoScrollPanel.setOpaque(false);

        aboutInfoArea.setEditable(false);
        aboutInfoArea.setBackground(new java.awt.Color(191, 179, 155));
        aboutInfoArea.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        aboutInfoArea.setForeground(new java.awt.Color(40, 62, 81));
        aboutInfoArea.setLineWrap(true);
        aboutInfoArea.setTabSize(0);
        aboutInfoArea.setText("     Farmlab is a program codded by four friends that main purpose is helping the farmers.In our country agriculture is very common.But  there is not enough working knowledge about agriculture.In turkey we have a place between farming 2.0 and the farming 3.0. but europe is at farming 3.0. The future of the farming is farming 4.0.FarmLab speeds up the transition from farming 2.0 to farming 4.0  When planting plants, minerals must be taken into account. Thats where  FarmLab helps its users.FarmLab gets the conditions about the planting area and then lets the user choose between various options about the type  of the plant and the lifespan of the plant.");
        aboutInfoArea.setToolTipText("");
        aboutInfoArea.setWrapStyleWord(true);
        aboutInfoArea.setBorder(null);
        aboutInfoArea.setFocusable(false);
        aboutInfoArea.setKeymap(null);
        aboutInfoArea.setSelectionColor(new java.awt.Color(191, 179, 155));
        aboutInfoArea.setVerifyInputWhenFocusTarget(false);
        aboutInfoScrollPanel.setViewportView(aboutInfoArea);

        aboutUsPanel.add(aboutInfoScrollPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 360, 290));

        contactUsTitle.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        contactUsTitle.setForeground(new java.awt.Color(47, 102, 114));
        contactUsTitle.setText("Contact Us :");
        aboutUsPanel.add(contactUsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, -1, -1));

        instaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/instagram.png"))); // NOI18N
        aboutUsPanel.add(instaIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 30, 40));

        mailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/email.png"))); // NOI18N
        mailIcon.setText("jLabel4");
        aboutUsPanel.add(mailIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, 30, 40));

        intaInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        intaInfo.setForeground(new java.awt.Color(40, 62, 81));
        intaInfo.setText("@Farm.Lab06  (Click Me)");
        intaInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        intaInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                intaInfoMouseClicked(evt);
            }
        });
        aboutUsPanel.add(intaInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 500, 150, 20));

        mailInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailInfo.setForeground(new java.awt.Color(40, 62, 81));
        mailInfo.setText("18050111024@ybu.edu.tr");
        aboutUsPanel.add(mailInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 542, -1, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        aboutUsPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 550, 110, 110));

        getContentPane().add(aboutUsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 42, 1000, 696));

        iconPanel.setBackground(new java.awt.Color(35, 58, 89));

        profileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/woman-icon.png"))); // NOI18N

        javax.swing.GroupLayout iconPanelLayout = new javax.swing.GroupLayout(iconPanel);
        iconPanel.setLayout(iconPanelLayout);
        iconPanelLayout.setHorizontalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanelLayout.createSequentialGroup()
                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        iconPanelLayout.setVerticalGroup(
            iconPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iconPanelLayout.createSequentialGroup()
                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        getContentPane().add(iconPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, 120));

        gifLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gifLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plant.gif"))); // NOI18N
        getContentPane().add(gifLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 600, 120, 120));

        menuLineOne.setBackground(new java.awt.Color(191, 179, 155));
        getContentPane().add(menuLineOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 156, 5));

        menuLineTwo.setBackground(new java.awt.Color(191, 179, 155));
        getContentPane().add(menuLineTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 156, 20));

        profileBtn.setBackground(new java.awt.Color(35, 58, 89));
        profileBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        profileBtn.setForeground(new java.awt.Color(209, 217, 193));
        profileBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profileBtn.setText("      Profile");
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileBtn.setName(""); // NOI18N
        profileBtn.setOpaque(true);
        profileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileBtnMouseClicked(evt);
            }
        });
        getContentPane().add(profileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 156, 50));

        homePageBtn.setBackground(new java.awt.Color(35, 58, 89));
        homePageBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        homePageBtn.setForeground(new java.awt.Color(209, 217, 193));
        homePageBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homePageBtn.setText("      Homepage");
        homePageBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homePageBtn.setName(""); // NOI18N
        homePageBtn.setOpaque(true);
        homePageBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePageBtnMouseClicked(evt);
            }
        });
        getContentPane().add(homePageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 156, 50));

        plantListBtn.setBackground(new java.awt.Color(35, 58, 89));
        plantListBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        plantListBtn.setForeground(new java.awt.Color(209, 217, 193));
        plantListBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        plantListBtn.setText("      Plants List");
        plantListBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        plantListBtn.setName(""); // NOI18N
        plantListBtn.setOpaque(true);
        plantListBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plantListBtnMouseClicked(evt);
            }
        });
        getContentPane().add(plantListBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 156, 50));

        aboutBtn.setBackground(new java.awt.Color(35, 58, 89));
        aboutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        aboutBtn.setForeground(new java.awt.Color(209, 217, 193));
        aboutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aboutBtn.setText("      About Us");
        aboutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutBtn.setName(""); // NOI18N
        aboutBtn.setOpaque(true);
        aboutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutBtnMouseClicked(evt);
            }
        });
        getContentPane().add(aboutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 156, 50));

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        exitBtn.setForeground(new java.awt.Color(209, 217, 193));
        exitBtn.setText("Exit");
        exitBtn.setBorder(null);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 518, -1, 30));

        exitIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        exitIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitIconMouseClicked(evt);
            }
        });
        getContentPane().add(exitIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/app-background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 750));

        setSize(new java.awt.Dimension(1216, 789));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bushBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bushBtnActionPerformed


    }//GEN-LAST:event_bushBtnActionPerformed

    private void treeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treeBtnActionPerformed


    }//GEN-LAST:event_treeBtnActionPerformed

    private void questionFourTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionFourTextFocusGained
        questionFourText.setText(""); //to clear the text when pressed in the text area
    }//GEN-LAST:event_questionFourTextFocusGained

    private void questionOneTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_questionOneTextFocusGained
        questionOneText.setText("");
    }//GEN-LAST:event_questionOneTextFocusGained

    private void calculateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateBtnActionPerformed


    }//GEN-LAST:event_calculateBtnActionPerformed

    private void userAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userAreaFocusGained
        userArea.setText("");
    }//GEN-LAST:event_userAreaFocusGained

    private void emailAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailAreaFocusGained
        emailArea.setText("");
    }//GEN-LAST:event_emailAreaFocusGained

    private void phoneAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneAreaFocusGained
        phoneArea.setText("");
    }//GEN-LAST:event_phoneAreaFocusGained

    private void passwordAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordAreaActionPerformed
        passwordArea.setText("");
    }//GEN-LAST:event_passwordAreaActionPerformed

    private void passwordAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordAreaFocusGained
        passwordArea.setText("");
    }//GEN-LAST:event_passwordAreaFocusGained

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
//to return to login jframe when clicking exitBtn
        login frame = new login();
        frame.setVisible(true);
        this.hide();
    }//GEN-LAST:event_exitBtnActionPerformed
    int clicked = 0;
    private void profileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileBtnMouseClicked
        homePagePanel.setVisible(false);
        yearlyPanel.setVisible(false);
        calculatePanel.setVisible(false);
        aboutUsPanel.setVisible(false);
        profilePanel.setVisible(true);
        plantPanel.setVisible(false);
        engineerHomepagePanel.setVisible(false);
        slidePanel.setVisible(false);
        profileBtn.setBackground(new Color(191, 179, 155));
        profileBtn.setForeground(Color.white);
        homePageBtn.setBackground(new Color(35, 58, 89));
        homePageBtn.setForeground(new Color(209, 217, 193));
        aboutBtn.setBackground(new Color(35, 58, 89));
        aboutBtn.setForeground(new Color(209, 217, 193));
        plantListBtn.setBackground(new Color(35, 58, 89));
        plantListBtn.setForeground(new Color(209, 217, 193));

        userArea.setText(userName);
        emailArea.setText(email);
        phoneArea.setText(phone);
        passwordArea.setText(pass);

//I checked the number of clicks with checked so that no new engineers were assigned to the user each time the profile panel was opened 
        clicked++;
        if (clicked == 1) {
            engineer.randEng();
        }

//to set up a profile icon based on user gender
        if (engineer.userGender.equals("man")) {
            engineerLabel.setIcon(manIcon);
        } else {
            engineerLabel.setIcon(femaleIcon);
        }
//to show engineer information
        nameLabel.setText(engineer.userNameLastName);
        emailLabel.setText(engineer.userEmailAdress);
        phoneEngLabel.setText(engineer.userPhoneNumber);
    }//GEN-LAST:event_profileBtnMouseClicked

    private void aboutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutBtnMouseClicked
        homePagePanel.setVisible(false);
        yearlyPanel.setVisible(false);
        calculatePanel.setVisible(false);
        aboutUsPanel.setVisible(true);
        profilePanel.setVisible(false);
        plantPanel.setVisible(false);
        engineerHomepagePanel.setVisible(false);
        slidePanel.setVisible(true);
        aboutBtn.setBackground(new Color(191, 179, 155));
        aboutBtn.setForeground(Color.white);
        homePageBtn.setBackground(new Color(35, 58, 89));
        homePageBtn.setForeground(new Color(209, 217, 193));
        profileBtn.setBackground(new Color(35, 58, 89));
        profileBtn.setForeground(new Color(209, 217, 193));
        plantListBtn.setBackground(new Color(35, 58, 89));
        plantListBtn.setForeground(new Color(209, 217, 193));
        SlideShow();


    }//GEN-LAST:event_aboutBtnMouseClicked

    private void homePageBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePageBtnMouseClicked

//if the user is an engineer, he will see the plant table on his homepage 
        if (job.equals("Engineer")) {
            homePagePanel.setVisible(false);
            plantListBtn.setVisible(false);
            engineerHomepagePanel.setVisible(true);

//to edit the title part of the plantTable where we printed the results
            JTableHeader Theader = plantTable1.getTableHeader();
            Theader.setBackground(Color.black);
            Theader.setForeground(new Color(47, 102, 114));
            Theader.setFont(new Font("Tahome", Font.BOLD, 17));
            ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

            try {
                addRowToeng();
            } catch (IOException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
//if the user is a farmer, he will see the panel on the homepage where the plant is proposed
        } else {
            homePagePanel.setVisible(true);
            plantListBtn.setVisible(true);
            engineerHomepagePanel.setVisible(false);
            plantListBtn.setBackground(new Color(35, 58, 89));
            plantListBtn.setForeground(new Color(209, 217, 193));

        }

        yearlyPanel.setVisible(false);
        calculatePanel.setVisible(false);
        aboutUsPanel.setVisible(false);
        profilePanel.setVisible(false);
        plantPanel.setVisible(false);
        slidePanel.setVisible(false);
        homePageBtn.setBackground(new Color(191, 179, 155));
        homePageBtn.setForeground(Color.white);
        aboutBtn.setBackground(new Color(35, 58, 89));
        aboutBtn.setForeground(new Color(209, 217, 193));
        profileBtn.setBackground(new Color(35, 58, 89));
        profileBtn.setForeground(new Color(209, 217, 193));


    }//GEN-LAST:event_homePageBtnMouseClicked

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        changeName = userArea.getText();
        email = emailArea.getText();
        pass = passwordArea.getText();
        phone = phoneArea.getText();
//I checked to see if the user has entered missing information
        if (userName.isEmpty() || pass.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty()) {
            notice.showMessageDialog(this, "Areas should not be empty.", "Warning", notice.WARNING_MESSAGE);

        } else {
            try {
                boolean result;
                //I changed the user's changes based on their work in the relevant table
                if (job.equals("Farmer")) {
                    Farmer farmer = new Farmer();
                    result = farmer.updateUser(userName, changeName, email, pass, phone);

                } else {
                    Engineer engineer = new Engineer();
                    result = engineer.updateUser(userName, changeName, email, pass, phone);
                }

//I informed the user if the update was made or not
                if (result == true) {
                    notice.showMessageDialog(this, "Your information was successfully updated", "Sucsess", notice.INFORMATION_MESSAGE, logoIcon);
                } else {
                    notice.showMessageDialog(this, "Your information could not be updated.Please try again", "Error", notice.ERROR_MESSAGE);

                }
            } catch (SQLException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void exitIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitIconMouseClicked
        //to return to login jframe 
        login frame = new login();
        frame.setVisible(true);
        this.hide();

    }//GEN-LAST:event_exitIconMouseClicked
    Plants plants = new Plants();
    int year, dekar, plantType;
    String mineral;

    private void yearlyBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearlyBtnMouseClicked
        yearlyPanel.setVisible(true);
    }//GEN-LAST:event_yearlyBtnMouseClicked

    private void yearlyBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyBtn1ActionPerformed
        year = 3; //the purpose of this variable is to search from the arraylist according to the life expectancy of the plant
    }//GEN-LAST:event_yearlyBtn1ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        boolean result;
        //I deleted the user based on their work in the relevant table
        if (job.equals("Farmer")) {

            Farmer farmer = new Farmer();
            result = farmer.deleteUser(userName);

        } else {

            Engineer engineer = new Engineer();
            result = engineer.deleteUser(userName);
        }

        //I informed the user if the delete was made or not
        if (result == true) {
            notice.showMessageDialog(this, "This account was successfully deleted", "Sucsess", notice.INFORMATION_MESSAGE, logoIcon);

            //to return to login jframe after user is deleted
            login frame = new login();
            this.setVisible(false);
            frame.setVisible(true);
        } else {
            notice.showMessageDialog(this, "Your information could not be updated.Please try again", "Error", notice.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_deleteBtnActionPerformed

    private void yearlyBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyBtn2ActionPerformed
        year = 7; //the purpose of this variable is to search from the arraylist according to the life expectancy of the plant
    }//GEN-LAST:event_yearlyBtn2ActionPerformed

    private void yearlyBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyBtn3ActionPerformed
        year = 10; //the purpose of this variable is to search from the arraylist according to the life expectancy of the plant
    }//GEN-LAST:event_yearlyBtn3ActionPerformed

    private void questionOneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionOneTextActionPerformed

    }//GEN-LAST:event_questionOneTextActionPerformed

    private void intaInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_intaInfoMouseClicked
        //to open our instagram page
        String url = "https://www.instagram.com/farm.lab06/";
        Desktop desktop = Desktop.getDesktop();

        try {//To open a web browser with url given
            desktop.browse(new URI(url));

        } catch (URISyntaxException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_intaInfoMouseClicked

    private void calculateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculateBtnMouseClicked

        String lastProduct = questionOneText.getText();
        lastProduct.toUpperCase();
        String dek = questionFourText.getText();

//I checked to see if the user has entered missing information
        if (lastProduct.isEmpty() || dek.isEmpty()) {
            notice.showMessageDialog(this, "Areas should not be empty.", "Warning", notice.WARNING_MESSAGE);
        } else if (seasonalBtn.isSelected() == false && (yearlyBtn.isSelected() == false && (yearlyBtn1.isSelected() == false && yearlyBtn2.isSelected() == false && yearlyBtn3.isSelected() == false))) {
            notice.showMessageDialog(this, "The life time of the plants is empty", "Warning", notice.WARNING_MESSAGE);
        } else if (herbBtn.isSelected() == false && bushBtn.isSelected() == false && treeBtn.isSelected() == false) {
            notice.showMessageDialog(this, "The type Sof the plants is empty", "Warning", notice.WARNING_MESSAGE);
        } else {
            dekar = Integer.parseInt(dek);
            calculatePanel.setVisible(true);

            try {  //we search the arraylist after learning about the plant that the user planted last year
                mineral = plants.searchPlant(lastProduct);
                calculate();

            } catch (IOException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }

//to edit the title part of the calculateTable where we printed the results
            JTableHeader Theader = calculateTable.getTableHeader();
            Theader.setBackground(Color.black);
            Theader.setForeground(new Color(47, 102, 114));
            Theader.setFont(new Font("Tahome", Font.BOLD, 16));
            ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        }


    }//GEN-LAST:event_calculateBtnMouseClicked

    public void calculate() {
//we search the arraylist according to the radio button selected by the user
        if (herbBtn.isSelected() == true) {
            Herbs herb = new Herbs();
            herb.selection(mineral, year, array);
        }
        if (bushBtn.isSelected() == true) {
            Bushes bush = new Bushes();
            bush.selection(mineral, year, array);
        }
        if (treeBtn.isSelected() == true) {
            Trees trees = new Trees();
            trees.selection(mineral, year, array);
        }

//we have identified array for our calculation value      
        double[] totalprice = new double[5];

        DefaultTableModel model = (DefaultTableModel) calculateTable.getModel();
        Object rowData[] = new Object[6];
        double dene;

        //we have placed the information obtained in the calculateTable
        for (int i = 0; i < 5; i++) {

            totalprice[i] = array[i].price * dekar * array[i].kgOverDekar;
            totalprice[i] = Double.parseDouble(new DecimalFormat("##.##").format(totalprice[i]));

            rowData[0] = array[i].nameOfPlant;
            rowData[1] = array[i].price;
            rowData[2] = totalprice[i];

            model.addRow(rowData);
        }

    }
    private void seasonalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonalBtnActionPerformed
        year = 1; //the purpose of this variable is to search from the arraylist according to the life expectancy of the plant
    }//GEN-LAST:event_seasonalBtnActionPerformed

    private void yearlyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyBtnActionPerformed
        yearlyPanel.setVisible(true);
    }//GEN-LAST:event_yearlyBtnActionPerformed

    private void herbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_herbBtnActionPerformed


    }//GEN-LAST:event_herbBtnActionPerformed

    private void plantListBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plantListBtnMouseClicked
        homePagePanel.setVisible(false);
        yearlyPanel.setVisible(false);
        calculatePanel.setVisible(false);
        aboutUsPanel.setVisible(false);
        profilePanel.setVisible(false);
        plantPanel.setVisible(true);
        slidePanel.setVisible(false);
        plantListBtn.setBackground(new Color(191, 179, 155));
        plantListBtn.setForeground(Color.white);
        homePageBtn.setBackground(new Color(35, 58, 89));
        homePageBtn.setForeground(new Color(209, 217, 193));
        aboutBtn.setBackground(new Color(35, 58, 89));
        aboutBtn.setForeground(new Color(209, 217, 193));
        profileBtn.setBackground(new Color(35, 58, 89));
        profileBtn.setForeground(new Color(209, 217, 193));

        //to edit the title part of the plantTable where we printed the results
        JTableHeader Theader = plantTable.getTableHeader();
        Theader.setBackground(Color.black);
        Theader.disable();
        Theader.setForeground(new Color(47, 102, 114));
        Theader.setFont(new Font("Tahome", Font.BOLD, 17));
        ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        try {
            addRowToJTable();
        } catch (IOException ex) {
            Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_plantListBtnMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed

    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        String search = searchField.getText();
        dinamicSearch(search.toUpperCase()); //to search at Jtable
    }//GEN-LAST:event_searchFieldKeyReleased

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        searchField.setText("");
    }//GEN-LAST:event_searchFieldFocusGained

    private void search2fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search2fieldFocusGained
        search2field.setText("");
    }//GEN-LAST:event_search2fieldFocusGained

    private void search2fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search2fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search2fieldActionPerformed

    private void search2fieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2fieldKeyReleased
        String search = search2field.getText();
        dinamicSearch(search.toUpperCase()); //to search at Jtable

    }//GEN-LAST:event_search2fieldKeyReleased
    int click = 0;
    private void farmerDisplayPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_farmerDisplayPanelMouseClicked
        //to edit the title part of the farmerTable where we printed the results
        JTableHeader Theader = farmerTable.getTableHeader();
        Theader.setBackground(Color.black);
        Theader.setForeground(new Color(47, 102, 114));
        Theader.setFont(new Font("Tahome", Font.BOLD, 17));
        ((DefaultTableCellRenderer) Theader.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        click++;
        //each time the panel was clicked, I had to add it to the table only once to make sure that the farmers would not add it back to the table.
        if (click == 1) {
            try {
                addRowToEngineer();
            } catch (IOException ex) {
                Logger.getLogger(homepage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        plantScrollPanel1.setVisible(false);


    }//GEN-LAST:event_farmerDisplayPanelMouseClicked

    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBtn1ActionPerformed

    private void phoneAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneAreaKeyTyped
        //so that the user cannot enter anything other than the number in the phone information      
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_phoneAreaKeyTyped

    private void questionFourTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_questionFourTextKeyTyped
        //so that the user cannot enter anything other than the number in the size information
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_questionFourTextKeyTyped

    private void displayFarmerPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayFarmerPanelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_displayFarmerPanelMouseClicked

    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseClicked
        String farmerEmail = farmerEmailTextField.getText();
        String engOpinion = opinionTextField.getText();
//we printed the information the engineer wrote for the farmer in the opinion file      
        writeToFile(farmerEmail, engOpinion);


    }//GEN-LAST:event_sendButtonMouseClicked

    private void plantScrollPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plantScrollPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_plantScrollPanel1MouseClicked
    public static void writeToFile(String farmerEmail, String engOpinion) {
        try {
            //if we don't do true to the end, append mode doesn't happen, oldies are deleted
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\FarmProject\\src\\farmproject\\opinion.txt", true));
            writer.write(farmerEmail);
            writer.write(" " + engOpinion + " \n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutBtn;
    private javax.swing.JTextArea aboutInfoArea;
    private javax.swing.JScrollPane aboutInfoScrollPanel;
    private javax.swing.JLabel aboutTitle;
    private javax.swing.JPanel aboutUsPanel;
    private javax.swing.JLabel areaInfoLabel;
    private javax.swing.JLabel background;
    private javax.swing.JRadioButton bushBtn;
    private javax.swing.JButton calculateBtn;
    private javax.swing.JLabel calculateLabe;
    private javax.swing.JLabel calculateLabel;
    private javax.swing.JPanel calculatePanel;
    private javax.swing.JScrollPane calculateScrollPane;
    private javax.swing.JTable calculateTable;
    private javax.swing.JLabel contactUsTitle;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JPanel displayFarmerPanel;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField emailArea;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel engineerHomepagePanel;
    private javax.swing.JLabel engineerInfoBackground;
    private javax.swing.JLabel engineerInfoBackground1;
    private javax.swing.JPanel engineerInfoPanel;
    private javax.swing.JLabel engineerLabel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel exitIcon;
    private javax.swing.JTabbedPane farmerDisplayPanel;
    private javax.swing.JLabel farmerEmailLabel;
    private javax.swing.JTextField farmerEmailTextField;
    private javax.swing.JScrollPane farmerScrollPane;
    private javax.swing.JTable farmerTable;
    private javax.swing.JLabel gifLabel;
    private javax.swing.JRadioButton herbBtn;
    private javax.swing.JLabel homePageBtn;
    private javax.swing.JPanel homePagePanel;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JLabel instaIcon;
    private javax.swing.JLabel intaInfo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel leftGif;
    private javax.swing.JLabel leftGif1;
    private javax.swing.ButtonGroup lifeGroup;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel mailIcon;
    private javax.swing.JLabel mailInfo;
    private javax.swing.JSeparator menuLineOne;
    private javax.swing.JSeparator menuLineTwo;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JScrollPane messageTittle;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel opinionLabel;
    private javax.swing.JTextField opinionTextField;
    private javax.swing.JTextField passwordArea;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneArea;
    private javax.swing.JLabel phoneEngLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel plantListBtn;
    private javax.swing.JPanel plantPanel;
    private javax.swing.JScrollPane plantScrollPane;
    private javax.swing.JScrollPane plantScrollPanel1;
    private javax.swing.JTable plantTable;
    private javax.swing.JTable plantTable1;
    private javax.swing.JLabel profileBtn;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel questionFourLabel;
    private javax.swing.JTextField questionFourText;
    private javax.swing.JLabel questionOneLabel;
    private javax.swing.JTextField questionOneText;
    private javax.swing.JLabel questionThreeLabel;
    private javax.swing.JLabel questionTwoLabel;
    private javax.swing.JLabel rightGif;
    private javax.swing.JLabel rightGif1;
    private javax.swing.JLabel saveLabel;
    private javax.swing.JTextField search2field;
    private javax.swing.JTextField searchField;
    private javax.swing.JRadioButton seasonalBtn;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel sendLabel;
    private javax.swing.JPanel slidePanel;
    private javax.swing.JLabel slideShowLabel;
    private javax.swing.JRadioButton treeBtn;
    private javax.swing.ButtonGroup typeGroup;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    private javax.swing.JLabel user;
    private javax.swing.JTextField userArea;
    private javax.swing.JRadioButton yearlyBtn;
    private javax.swing.JRadioButton yearlyBtn1;
    private javax.swing.JRadioButton yearlyBtn2;
    private javax.swing.JRadioButton yearlyBtn3;
    private javax.swing.JPanel yearlyPanel;
    private javax.swing.ButtonGroup yearsGroup;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JOptionPane notice;

    DefaultTableModel model;

    public void addRowToJTable() throws IOException {
        model = (DefaultTableModel) plantTable.getModel();
//adds the data from the arraylist to the plantTable
        Object rowData[] = new Object[4];
        ArrayList<Plants> list = plants.readFromFile();
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).nameOfPlant;
            rowData[1] = list.get(i).price;
            rowData[2] = list.get(i).kgOverDekar;
            rowData[3] = list.get(i).plantType;

            model.addRow(rowData);
        }
    }

    public void addRowToeng() throws IOException {
        model = (DefaultTableModel) plantTable1.getModel();
//adds the data from the arraylist to plantTable for engineers at homepage
        Object rowData[] = new Object[4];
        ArrayList<Plants> list = plants.readFromFile();
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).nameOfPlant;
            rowData[1] = list.get(i).price;
            rowData[2] = list.get(i).kgOverDekar;
            rowData[3] = list.get(i).plantType;

            model.addRow(rowData);

        }
    }

    public void addRowToEngineer() throws IOException {
        model = (DefaultTableModel) farmerTable.getModel();
//adds the farmers data from the arraylist to farmerTable for engineers at homepage
        Farmer farmer = new Farmer();
        Object rowData[] = new Object[4];
        ArrayList<Person> list = farmer.displayUser();
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).userNameLastName;
            rowData[1] = list.get(i).userEmailAdress;
            rowData[2] = list.get(i).userPhoneNumber;
            rowData[3] = list.get(i).userGender;

            model.addRow(rowData);

        }
    }

    //to search at Jtable
    private void dinamicSearch(String search) {

        TableRowSorter<DefaultTableModel> table = new TableRowSorter<>(model);
        plantTable.setRowSorter(table);
        plantTable1.setRowSorter(table);
        table.setRowFilter(RowFilter.regexFilter(search));

    }

    Timer time;
    int count = 0, position = 0;

    public void SlideShow() {

        time = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                //for switching photos, respectively
                position = position + 1;
                System.out.println(position);
                if (count < 6) {
                    if (position < 0) {
                        position = 0;
                    }
                    show(position);

                } else if (count == 6) { //to go back to the beginning when the last photo came
                    count = 0;
                    position = -1;
                }

            }
        });
        //to place the photo on the label
        int p = this.slideShowLabel.getX();

        time.start();

    }

    public String[] takeimage() {
        File f = new File(getClass().getResource("/slideShowImg").getFile());
        String[] Images = f.list();
        return Images;
    }

    public void show(int index) {
        String[] Images = takeimage();
        String img = Images[index];
        ImageIcon icon = new ImageIcon(getClass().getResource("/slideShowImg/" + img));
        Image image = icon.getImage().getScaledInstance(slideShowLabel.getWidth(), slideShowLabel.getHeight(), Image.SCALE_SMOOTH);
        slideShowLabel.setIcon(new ImageIcon(image));
    }

}
