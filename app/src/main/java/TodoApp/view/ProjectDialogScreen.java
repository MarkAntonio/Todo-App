/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package TodoApp.view;

import TodoApp.controller.ProjectController;
import TodoApp.model.Project;
import java.time.LocalDateTime;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class ProjectDialogScreen extends javax.swing.JDialog {

    ProjectController projectController;
    
    public ProjectDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        projectController = new ProjectController();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectHeaderJPanel = new javax.swing.JPanel();
        projectHeaderTitle = new javax.swing.JLabel();
        projectHeaderIcon = new javax.swing.JLabel();
        ProjectContentJPanel = new javax.swing.JPanel();
        projectNameJLabel = new javax.swing.JLabel();
        projectNameJTextField = new javax.swing.JTextField();
        projectDescriptionJLabel = new javax.swing.JLabel();
        projectContentjScrollPane = new javax.swing.JScrollPane();
        projectDescriptionJTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(229, 229, 229));

        projectHeaderJPanel.setBackground(new java.awt.Color(139, 45, 186));

        projectHeaderTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        projectHeaderTitle.setForeground(java.awt.Color.white);
        projectHeaderTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        projectHeaderTitle.setText("Project");

        projectHeaderIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        projectHeaderIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectHeaderIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout projectHeaderJPanelLayout = new javax.swing.GroupLayout(projectHeaderJPanel);
        projectHeaderJPanel.setLayout(projectHeaderJPanelLayout);
        projectHeaderJPanelLayout.setHorizontalGroup(
            projectHeaderJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectHeaderJPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(projectHeaderTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(projectHeaderIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        projectHeaderJPanelLayout.setVerticalGroup(
            projectHeaderJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projectHeaderJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectHeaderJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectHeaderTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectHeaderIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        ProjectContentJPanel.setBackground(java.awt.Color.white);

        projectNameJLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectNameJLabel.setText("Name");

        projectNameJTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNameJTextFieldActionPerformed(evt);
            }
        });

        projectDescriptionJLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        projectDescriptionJLabel.setText("Description");

        projectDescriptionJTextArea.setColumns(20);
        projectDescriptionJTextArea.setRows(5);
        projectContentjScrollPane.setViewportView(projectDescriptionJTextArea);

        javax.swing.GroupLayout ProjectContentJPanelLayout = new javax.swing.GroupLayout(ProjectContentJPanel);
        ProjectContentJPanel.setLayout(ProjectContentJPanelLayout);
        ProjectContentJPanelLayout.setHorizontalGroup(
            ProjectContentJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProjectContentJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProjectContentJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectContentjScrollPane)
                    .addComponent(projectNameJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectNameJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectDescriptionJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap())
        );
        ProjectContentJPanelLayout.setVerticalGroup(
            ProjectContentJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProjectContentJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectNameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectDescriptionJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectContentjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ProjectContentJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectHeaderJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectHeaderJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProjectContentJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void projectNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectNameJTextFieldActionPerformed

    private void projectHeaderIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectHeaderIconMouseClicked
        try{    
            Project project = new Project();
            String text = projectNameJTextField.getText();
            project.setName(!text.equals("")?text:null);
            text = projectDescriptionJTextArea.getText();
            project.setDescription(!text.equals("")?text:null);
            projectController.save(project);
           
            JOptionPane.showMessageDialog(rootPane, "The projet was successfully saved");
            this.dispose();
        }
        catch (NullPointerException e) {
             JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_projectHeaderIconMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProjectDialogScreen dialog = new ProjectDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProjectContentJPanel;
    private javax.swing.JScrollPane projectContentjScrollPane;
    private javax.swing.JLabel projectDescriptionJLabel;
    private javax.swing.JTextArea projectDescriptionJTextArea;
    private javax.swing.JLabel projectHeaderIcon;
    private javax.swing.JPanel projectHeaderJPanel;
    private javax.swing.JLabel projectHeaderTitle;
    private javax.swing.JLabel projectNameJLabel;
    private javax.swing.JTextField projectNameJTextField;
    // End of variables declaration//GEN-END:variables
}
