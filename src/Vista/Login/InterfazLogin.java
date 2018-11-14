package Vista.Login;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;

public class InterfazLogin extends javax.swing.JFrame {

    public InterfazLogin() {
        setLayout(null);
        setUndecorated(true);
        initComponents();
        esquinasCurvasFrame();
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    public void esquinasCurvasFrame(){ //Curvar las esquinas del Frame principal
        Shape forma = new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,27,27);
        AWTUtilities.setWindowShape(this, forma);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldContrasena = new javax.swing.JPasswordField();
        jTextFieldCedula = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelMensaje = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Contraseña:");

        jLabel3.setText("Cedula:");

        jPasswordFieldContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldContrasenaKeyPressed(evt);
            }
        });

        jTextFieldCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldCedulaKeyReleased(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");

        salir.setBackground(new java.awt.Color(204, 204, 204));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/X2.png"))); // NOI18N
        salir.setBorder(null);
        salir.setBorderPainted(false);
        salir.setOpaque(false);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Login");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 96, Short.MAX_VALUE)
                .addComponent(jLabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(jButtonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(salir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCedula)
                            .addComponent(jPasswordFieldContrasena))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(156, 156, 156))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(salir)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(41, 41, 41)
                .addComponent(jButtonAceptar)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void jTextFieldCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCedulaKeyReleased
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                   jPasswordFieldContrasena.requestFocus(); //Este metodo da foco 
           }
    }//GEN-LAST:event_jTextFieldCedulaKeyReleased

    private void jPasswordFieldContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldContrasenaKeyPressed
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                   jButtonAceptar.requestFocus(); //Este metodo da foco 
           }
    }//GEN-LAST:event_jPasswordFieldContrasenaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabelMensaje;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField jPasswordFieldContrasena;
    public javax.swing.JTextField jTextFieldCedula;
    public javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
