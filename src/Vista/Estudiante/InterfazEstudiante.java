/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista.Estudiante;

/**
 *
 * @author Thony
 */
public class InterfazEstudiante extends javax.swing.JPanel {

    /** Creates new form InterfazEstudiante */
    public InterfazEstudiante() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnListarEstudiantes = new javax.swing.JButton();
        btnListarProfesores = new javax.swing.JButton();
        panelEstudiantes = new javax.swing.JPanel();
        btnListarNotasEstu = new javax.swing.JButton();
        btnAsistencia = new javax.swing.JButton();
        btnListarAsignatura = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Menu Estudiante");

        btnListarEstudiantes.setText("Listar Estudiante");

        btnListarProfesores.setText("Listar Profesores");

        panelEstudiantes.setLayout(new java.awt.GridLayout(0, 1));

        btnListarNotasEstu.setText("Listar Notas");

        btnAsistencia.setText("Listar Asistencia");

        btnListarAsignatura.setText("Listar Asignatura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnListarEstudiantes)
                                .addGap(27, 27, 27)
                                .addComponent(btnListarProfesores)
                                .addGap(18, 18, 18)
                                .addComponent(btnListarNotasEstu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAsistencia)
                                .addGap(18, 18, 18)
                                .addComponent(btnListarAsignatura)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarEstudiantes)
                    .addComponent(btnListarNotasEstu)
                    .addComponent(btnListarProfesores)
                    .addComponent(btnAsistencia)
                    .addComponent(btnListarAsignatura))
                .addGap(18, 18, 18)
                .addComponent(panelEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsistencia;
    public javax.swing.JButton btnListarAsignatura;
    public javax.swing.JButton btnListarEstudiantes;
    public javax.swing.JButton btnListarNotasEstu;
    public javax.swing.JButton btnListarProfesores;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel panelEstudiantes;
    // End of variables declaration//GEN-END:variables

}
