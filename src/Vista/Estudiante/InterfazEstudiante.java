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

        setBackground(new java.awt.Color(51, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Menu Estudiante");

        btnListarEstudiantes.setText("Listar Estudiante");

        btnListarProfesores.setText("Listar Profesores");

        javax.swing.GroupLayout panelEstudiantesLayout = new javax.swing.GroupLayout(panelEstudiantes);
        panelEstudiantes.setLayout(panelEstudiantesLayout);
        panelEstudiantesLayout.setHorizontalGroup(
            panelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        panelEstudiantesLayout.setVerticalGroup(
            panelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        btnListarNotasEstu.setText("Listar Notas");

        btnAsistencia.setText("Listar Asistencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnListarEstudiantes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnListarProfesores)
                        .addGap(18, 18, 18)
                        .addComponent(btnListarNotasEstu)
                        .addGap(18, 18, 18)
                        .addComponent(btnAsistencia))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(panelEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
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
                    .addComponent(btnAsistencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelEstudiantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsistencia;
    public javax.swing.JButton btnListarEstudiantes;
    public javax.swing.JButton btnListarNotasEstu;
    public javax.swing.JButton btnListarProfesores;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JPanel panelEstudiantes;
    // End of variables declaration//GEN-END:variables

}
