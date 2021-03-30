package farmproject;


import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class login extends javax.swing.JFrame {

   ImageIcon logoIcon = new ImageIcon(getClass().getResource("/img/logo.png"));
   

    public login() {
        initComponents();
     this.setIconImage(logoIcon.getImage());
//When login Jframe is opened, only the loginPanel panel is visible.
        signUpPanel.setVisible(false);
        loginPanel.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        LoginTitle = new javax.swing.JLabel();
        loginInfo = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        userArea = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        passArea = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        loginLabel = new javax.swing.JLabel();
        signUpInfo = new javax.swing.JLabel();
        signUpBtn = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        signUpPanel = new javax.swing.JPanel();
        signUpTitle = new javax.swing.JLabel();
        registerInfo = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        nameArea = new javax.swing.JTextField();
        user2 = new javax.swing.JLabel();
        userNameArea = new javax.swing.JTextField();
        email1 = new javax.swing.JLabel();
        emailArea = new javax.swing.JTextField();
        pass1 = new javax.swing.JLabel();
        passArea1 = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneArea = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        signUpBtn1 = new javax.swing.JButton();
        signUpLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        stateBtn = new javax.swing.JButton();
        genderLabel1 = new javax.swing.JLabel();
        jobComboBox = new javax.swing.JComboBox<>();
        background = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FarmLab");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPanel.setBackground(new java.awt.Color(20, 47, 64));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LoginTitle.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        LoginTitle.setForeground(new java.awt.Color(209, 217, 183));
        LoginTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LoginTitle.setText("Login");
        loginPanel.add(LoginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 80));

        loginInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginInfo.setForeground(new java.awt.Color(209, 217, 193));
        loginInfo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginInfo.setText("Enter your details below to continue");
        loginPanel.add(loginInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 240, 40));

        user.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("Username");
        loginPanel.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        userArea.setBackground(new java.awt.Color(20, 47, 64));
        userArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userArea.setForeground(new java.awt.Color(255, 255, 255));
        userArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        userArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userAreaFocusGained(evt);
            }
        });
        userArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAreaActionPerformed(evt);
            }
        });
        loginPanel.add(userArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 270, 40));

        pass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pass.setText("Password");
        loginPanel.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 20));

        passArea.setBackground(new java.awt.Color(20, 47, 64));
        passArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passArea.setForeground(new java.awt.Color(255, 255, 255));
        passArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        passArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passAreaFocusGained(evt);
            }
        });
        passArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passAreaActionPerformed(evt);
            }
        });
        passArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passAreaKeyPressed(evt);
            }
        });
        loginPanel.add(passArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 270, 40));

        loginBtn.setBackground(new java.awt.Color(209, 217, 183));
        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.setBorder(null);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtnKeyPressed(evt);
            }
        });
        loginPanel.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 140, 40));

        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn/greenBtn.png"))); // NOI18N
        loginPanel.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 140, 40));

        signUpInfo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        signUpInfo.setForeground(new java.awt.Color(132, 143, 108));
        signUpInfo.setText("Don't have an account?");
        loginPanel.add(signUpInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        signUpBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signUpBtn.setForeground(new java.awt.Color(132, 143, 108));
        signUpBtn.setText("Sign up here");
        signUpBtn.setBorder(null);
        signUpBtn.setContentAreaFilled(false);
        signUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        loginPanel.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 461, 100, 30));

        check.setBackground(new java.awt.Color(20, 47, 64));
        check.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        check.setForeground(new java.awt.Color(255, 255, 255));
        check.setText("Show password");
        check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        loginPanel.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        getContentPane().add(loginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 370, 550));

        signUpPanel.setBackground(new java.awt.Color(20, 47, 64));
        signUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signUpTitle.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        signUpTitle.setForeground(new java.awt.Color(209, 217, 183));
        signUpTitle.setText("Sign Up");
        signUpPanel.add(signUpTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        registerInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        registerInfo.setForeground(new java.awt.Color(209, 217, 183));
        registerInfo.setText("Enter your details below to register");
        signUpPanel.add(registerInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 112, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Full Name");
        signUpPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 155, -1, -1));

        nameArea.setBackground(new java.awt.Color(20, 47, 64));
        nameArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameArea.setForeground(new java.awt.Color(255, 255, 255));
        nameArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        nameArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameAreaFocusGained(evt);
            }
        });
        nameArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameAreaActionPerformed(evt);
            }
        });
        signUpPanel.add(nameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 270, 40));

        user2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        user2.setForeground(new java.awt.Color(255, 255, 255));
        user2.setText("Username");
        signUpPanel.add(user2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 245, -1, -1));

        userNameArea.setBackground(new java.awt.Color(20, 47, 64));
        userNameArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userNameArea.setForeground(new java.awt.Color(255, 255, 255));
        userNameArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        userNameArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameAreaFocusGained(evt);
            }
        });
        userNameArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameAreaActionPerformed(evt);
            }
        });
        signUpPanel.add(userNameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 270, 40));

        email1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        email1.setForeground(new java.awt.Color(255, 255, 255));
        email1.setText("Email");
        signUpPanel.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 335, -1, -1));

        emailArea.setBackground(new java.awt.Color(20, 47, 64));
        emailArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailArea.setForeground(new java.awt.Color(255, 255, 255));
        emailArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        emailArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailAreaFocusGained(evt);
            }
        });
        emailArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAreaActionPerformed(evt);
            }
        });
        signUpPanel.add(emailArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 355, 270, 40));

        pass1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pass1.setForeground(new java.awt.Color(255, 255, 255));
        pass1.setText("Password");
        signUpPanel.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 425, -1, -1));

        passArea1.setBackground(new java.awt.Color(20, 47, 64));
        passArea1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passArea1.setForeground(new java.awt.Color(255, 255, 255));
        passArea1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        passArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passArea1FocusGained(evt);
            }
        });
        signUpPanel.add(passArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 445, 160, 40));

        phoneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(255, 255, 255));
        phoneLabel.setText("Phone");
        signUpPanel.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 515, -1, -1));

        phoneArea.setBackground(new java.awt.Color(20, 47, 64));
        phoneArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneArea.setForeground(new java.awt.Color(255, 255, 255));
        phoneArea.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        phoneArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneAreaFocusGained(evt);
            }
        });
        phoneArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneAreaActionPerformed(evt);
            }
        });
        phoneArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneAreaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneAreaKeyTyped(evt);
            }
        });
        signUpPanel.add(phoneArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 535, 160, 40));

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setText("Your Job");
        signUpPanel.add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 425, -1, -1));

        genderComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genderComboBox.setForeground(new java.awt.Color(209, 217, 183));
        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Man", "Female" }));
        genderComboBox.setToolTipText("");
        genderComboBox.setBorder(null);
        genderComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });
        genderComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                genderComboBoxKeyPressed(evt);
            }
        });
        signUpPanel.add(genderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 542, 90, 30));

        signUpBtn1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        signUpBtn1.setForeground(new java.awt.Color(255, 255, 255));
        signUpBtn1.setText("Sign Up");
        signUpBtn1.setBorder(null);
        signUpBtn1.setContentAreaFilled(false);
        signUpBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpBtn1MouseClicked(evt);
            }
        });
        signUpBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtn1ActionPerformed(evt);
            }
        });
        signUpPanel.add(signUpBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 613, 150, 50));

        signUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Btn/greenBtn.png"))); // NOI18N
        signUpPanel.add(signUpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, -1, -1));

        stateLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        stateLabel.setForeground(new java.awt.Color(132, 143, 108));
        stateLabel.setText("I already have an account");
        signUpPanel.add(stateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 663, -1, -1));

        stateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stateBtn.setForeground(new java.awt.Color(132, 143, 108));
        stateBtn.setText("Sign in here");
        stateBtn.setBorder(null);
        stateBtn.setContentAreaFilled(false);
        stateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stateBtnMouseClicked(evt);
            }
        });
        stateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateBtnActionPerformed(evt);
            }
        });
        signUpPanel.add(stateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 655, 100, 30));

        genderLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        genderLabel1.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel1.setText("Gender");
        signUpPanel.add(genderLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 515, -1, -1));

        jobComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jobComboBox.setForeground(new java.awt.Color(209, 217, 183));
        jobComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Farmer", "Engineer" }));
        jobComboBox.setBorder(null);
        jobComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jobComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobComboBoxActionPerformed(evt);
            }
        });
        jobComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jobComboBoxKeyPressed(evt);
            }
        });
        signUpPanel.add(jobComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 450, 90, 30));

        getContentPane().add(signUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 410, 720));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 760));

        setSize(new java.awt.Dimension(1216, 799));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userAreaActionPerformed

    private void userAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userAreaFocusGained
        userArea.setText(""); //to clear the text when pressed in the text area
    }//GEN-LAST:event_userAreaFocusGained

    private void passAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passAreaFocusGained
        passArea.setText("");
    }//GEN-LAST:event_passAreaFocusGained

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed


    }//GEN-LAST:event_loginBtnActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        signUpPanel.setVisible(true);
        loginPanel.setVisible(false);
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void passAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passAreaActionPerformed

    private void nameAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameAreaFocusGained
        nameArea.setText("");
    }//GEN-LAST:event_nameAreaFocusGained

    private void nameAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameAreaActionPerformed

    private void emailAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailAreaFocusGained
        emailArea.setText("");
    }//GEN-LAST:event_emailAreaFocusGained

    private void emailAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAreaActionPerformed

    private void passArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passArea1FocusGained
        passArea1.setText("");
    }//GEN-LAST:event_passArea1FocusGained

    private void phoneAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneAreaFocusGained
        phoneArea.setText("");
    }//GEN-LAST:event_phoneAreaFocusGained

    private void signUpBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtn1ActionPerformed


    }//GEN-LAST:event_signUpBtn1ActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed


    private void stateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateBtnActionPerformed
//just to show the signUpPanel panel
        loginPanel.setVisible(true);
        signUpPanel.setVisible(false);

//to clear pre-entered information each time the signUpPanel panel is opened
        nameArea.setText("");
        userNameArea.setText("");
        emailArea.setText("");
        passArea1.setText("");
        phoneArea.setText("");
        genderComboBox.setSelectedIndex(0);
        jobComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_stateBtnActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
//to show the password
        if (check.isSelected()) {
            passArea.setEchoChar((char) 0);
        } else {
            passArea.setEchoChar('*');
        }
    }//GEN-LAST:event_checkActionPerformed

    private void phoneAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneAreaActionPerformed

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
//to log in
        String logUsername = userArea.getText();
        String logPassword = String.valueOf(passArea.getPassword());

        boolean result = false;
//I checked to see if the user has entered missing information
        if (logUsername.isEmpty() || logPassword.isEmpty()) {
            notice.showMessageDialog(this, "Username / Password should not be empty.", "Warning", notice.WARNING_MESSAGE);
        } else {
//to use the login method entity created 
            LoginClass login = new LoginClass();
            Farmer farmer = new Farmer();
            /*We have 2 different user types these are farmer and engineer.That's why I first search username and password information entered 
by the user among farmers.if this search result is correct, I loged in as a farmer, but if it is false, I entered as an engineer.  */
            if (farmer.searchFarmer(logUsername) == true) {
                result = login.farmerLogin(logUsername, logPassword);
            } else {
                result = login.engineerLogin(logUsername, logPassword);
            }

//If the result of any of the 2 searches was correct, the user was able to log in 
            if (result == true) {
                homepage frame = new homepage(userArea.getText());  //I sent username information to use user information in homepage jframe
                this.setVisible(false);
                frame.setVisible(true);
            } else {
                notice.showMessageDialog(this, "Username or Pasword is wrong", "Warning", notice.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_loginBtnMouseClicked

    private void signUpBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpBtn1MouseClicked
//to register
        String name = nameArea.getText();
        String username = userNameArea.getText();
        String email = emailArea.getText();
        String password = passArea1.getText();
        String phone = phoneArea.getText();
        String gender = "";
        String job = "";
        int check = 0;
        boolean result = false;

        //to checked to have at least 8 characters of the entered password     
        if (password.length() < 8) {
            notice.showMessageDialog(this, "Your password must consist of at least 8 characters", "Warning", notice.WARNING_MESSAGE);
        } else {

            if (genderComboBox.getSelectedIndex() == 1) {
                gender = "man";
            } else if (genderComboBox.getSelectedIndex() == 2) {
                gender = "female";
            }
            if (jobComboBox.getSelectedIndex() == 1) {
                job = "Farmer";
                Farmer farmer = new Farmer();
// to check if there is another user with values entered by the user
                check = farmer.searchUser(name, username, email, password, phone, gender, job);

                if (check == 1) {
                    notice.showMessageDialog(this, "This username has already been taken ", "Warning", notice.WARNING_MESSAGE);
                } else if (check == 2) {
                    notice.showMessageDialog(this, "This email has already been taken ", "Warning", notice.WARNING_MESSAGE);
                } else if (check == 3) {
                    notice.showMessageDialog(this, "This phone number has already been taken ", "Warning", notice.WARNING_MESSAGE);
                } else {
                    //to add a farmer with the information entered
                    result = farmer.addUser(name, username, email, password, phone, gender, job);

//to back to the log in panel after the user successfully registers
                    if (result == true) {
                        notice.showMessageDialog(this, "Welcome to the FarmLab", "Sucsess", notice.INFORMATION_MESSAGE, logoIcon);
                        signUpPanel.setVisible(false);
                        loginPanel.setVisible(true);
                    }
                }
            } else if (jobComboBox.getSelectedIndex() == 2) {
                job = "Engineer";
                Engineer engineer = new Engineer();
// to check if there is another user with values entered by the user
                check = engineer.searchUser(name, username, email, password, phone, gender, job);

                if (check == 1) {
                    notice.showMessageDialog(this, "This username has already been taken ", "Warning", notice.WARNING_MESSAGE);
                } else if (check == 2) {
                    notice.showMessageDialog(this, "This email has already been taken ", "Warning", notice.WARNING_MESSAGE);
                } else if (check == 3) {
                    notice.showMessageDialog(this, "This phone number has already been taken ", "Warning", notice.WARNING_MESSAGE);
                } else {//to add a engineer with the information entered
                    result = engineer.addUser(name, username, email, password, phone, gender, job);

//to back to the log in panel after the user successfully registers
                    if (result == true) {
                      notice.showMessageDialog(this, "Welcome to the FarmLab", "Sucsess", notice.INFORMATION_MESSAGE, logoIcon);
                        signUpPanel.setVisible(false);
                        loginPanel.setVisible(true);
                    }
                }
            }
//I checked to see if the user has entered missing information
            if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty() || job.isEmpty()) {
                notice.showMessageDialog(this, "Areas should not be empty.", "Warning", notice.WARNING_MESSAGE);

            } else {

            }
        }
    }//GEN-LAST:event_signUpBtn1MouseClicked

    private void loginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtnKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnKeyPressed

    private void passAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passAreaKeyPressed
//to run the login method when the user presses enter when entering their password

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//the working logic of the code is the same as signUpBtn1MouseClicked()

        String logUsername = userArea.getText();
        String logPassword = String.valueOf(passArea.getPassword());

        boolean result = false;

        if (logUsername.isEmpty() || logPassword.isEmpty()) {
            notice.showMessageDialog(this, "Username / Password should not be empty.", "Warning", notice.WARNING_MESSAGE);
        } else {

            LoginClass login = new LoginClass();
            Farmer farmer = new Farmer();
  
            if (farmer.searchFarmer(logUsername) == true) {
                result = login.farmerLogin(logUsername, logPassword);
            } else {
                result = login.engineerLogin(logUsername, logPassword);
            }

            if (result == true) {
                homepage frame = new homepage(userArea.getText());  
                this.setVisible(false);
                frame.setVisible(true);
            } else {
                notice.showMessageDialog(this, "Username or Pasword is wrong", "Warning", notice.WARNING_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_passAreaKeyPressed

    private void phoneAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneAreaKeyPressed

    }//GEN-LAST:event_phoneAreaKeyPressed

    private void genderComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_genderComboBoxKeyPressed
        /*to run the login method when the user presses enter when selecting their gender
    the working logic of the code is the same as loginBtnMouseClicked()*/
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String name = nameArea.getText();
            String username = userNameArea.getText();
            String email = emailArea.getText();
            String password = passArea1.getText();
            String phone = phoneArea.getText();
            String gender = "";
            String job = "";
            int check = 0;
            boolean result = false;
            if (password.length() < 8) {
                notice.showMessageDialog(this, "Your password must consist of at least 8 characters", "Warning", notice.WARNING_MESSAGE);
            } else {

                if (genderComboBox.getSelectedIndex() == 1) {
                    gender = "man";
                } else {
                    gender = "female";
                }
                if (jobComboBox.getSelectedIndex() == 1) {
                    job = "Farmer";
                    Farmer farmer = new Farmer();
                    check = farmer.searchUser(name, username, email, password, phone, gender, job);
                    result = farmer.addUser(name, username, email, password, phone, gender, job);
                } else {
                    job = "Engineer";
                    Engineer engineer = new Engineer();
                    check = engineer.searchUser(name, username, email, password, phone, gender, job);
                    result = engineer.addUser(name, username, email, password, phone, gender, job);
                }

                if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty()) {
                    notice.showMessageDialog(this, "Areas should not be empty.", "Warning", notice.WARNING_MESSAGE);
                } else {

                    if (check == 1) {
                        notice.showMessageDialog(this, "This username has already been taken ", "Warning", notice.WARNING_MESSAGE);
                    } else if (check == 2) {
                        notice.showMessageDialog(this, "This email has already been taken ", "Warning", notice.WARNING_MESSAGE);
                    } else if (check == 3) {
                        notice.showMessageDialog(this, "This phone number has already been taken ", "Warning", notice.WARNING_MESSAGE);
                    } else {

                        if (result == true) {
                           notice.showMessageDialog(this, "Welcome to the FarmLab", "Sucsess", notice.INFORMATION_MESSAGE, logoIcon);
                            signUpPanel.setVisible(false);
                            loginPanel.setVisible(true);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_genderComboBoxKeyPressed

    private void userNameAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameAreaFocusGained
        userNameArea.setText("");
    }//GEN-LAST:event_userNameAreaFocusGained

    private void userNameAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameAreaActionPerformed

    private void jobComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobComboBoxActionPerformed

    private void jobComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jobComboBoxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobComboBoxKeyPressed

    private void phoneAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneAreaKeyTyped
//so that the user cannot enter anything other than the number in the phone information
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_phoneAreaKeyTyped

    private void stateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stateBtnMouseClicked
       //just to show the signUpPanel panel
        loginPanel.setVisible(true);
        signUpPanel.setVisible(false);

//to clear pre-entered information each time the signUpPanel panel is opened
        nameArea.setText("");
        userNameArea.setText("");
        emailArea.setText("");
        passArea1.setText("");
        phoneArea.setText("");
        genderComboBox.setSelectedIndex(0);
        jobComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_stateBtnMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LoginTitle;
    private javax.swing.JLabel background;
    private javax.swing.JCheckBox check;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField emailArea;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jobComboBox;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginInfo;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameArea;
    private javax.swing.JLabel pass;
    private javax.swing.JLabel pass1;
    private javax.swing.JPasswordField passArea;
    private javax.swing.JTextField passArea1;
    private javax.swing.JTextField phoneArea;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel registerInfo;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JButton signUpBtn1;
    private javax.swing.JLabel signUpInfo;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JPanel signUpPanel;
    private javax.swing.JLabel signUpTitle;
    private javax.swing.JButton stateBtn;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel user;
    private javax.swing.JLabel user2;
    private javax.swing.JTextField userArea;
    private javax.swing.JTextField userNameArea;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JOptionPane notice;

}
