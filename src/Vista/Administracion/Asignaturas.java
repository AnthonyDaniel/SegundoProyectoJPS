
package Vista.Administracion;

import java.awt.event.KeyEvent;

public class Asignaturas extends javax.swing.JPanel {

    public Asignaturas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonAsignatura = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldProfesor = new javax.swing.JTextField();
        jButtonModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonEstudiantes = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Profesor");

        jButtonAsignatura.setBackground(new java.awt.Color(51, 51, 51));
        jButtonAsignatura.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAsignatura.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsignatura.setText("Ver Asignaturas");

        jButtonEliminar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar");

        jTextFieldId.setEnabled(false);

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyPressed(evt);
            }
        });

        jTextFieldProfesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldProfesorKeyPressed(evt);
            }
        });

        jButtonModificar.setBackground(new java.awt.Color(51, 51, 51));
        jButtonModificar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar");
        jButtonModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonModificarKeyPressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/persona.png"))); // NOI18N

        jButtonEstudiantes.setBackground(new java.awt.Color(51, 51, 51));
        jButtonEstudiantes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonEstudiantes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEstudiantes.setText("Ver Estudiantes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldId)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEstudiantes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAsignatura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                  jTextFieldProfesor.requestFocus(); //Este metodo da foco 
           }
    }//GEN-LAST:event_jTextFieldNombreKeyPressed

    private void jTextFieldProfesorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldProfesorKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                   jButtonModificar.requestFocus(); //Este metodo da foco 
           }
    }//GEN-LAST:event_jTextFieldProfesorKeyPressed

    private void jButtonModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonModificarKeyPressed
           if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                   //Modificarrrrr.............. no implementado aún
           }
    }//GEN-LAST:event_jButtonModificarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAsignatura;
    public javax.swing.JButton jButtonEliminar;
    public javax.swing.JButton jButtonEstudiantes;
    public javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField jTextFieldId;
    public javax.swing.JTextField jTextFieldNombre;
    public javax.swing.JTextField jTextFieldProfesor;
    // End of variables declaration//GEN-END:variables
}
