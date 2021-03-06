
package Vista.Administracion;

public class InterfazAdministracion extends javax.swing.JPanel {

    public InterfazAdministracion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jRadioButtonEstudiantes = new javax.swing.JRadioButton();
        jRadioButtonProfesor = new javax.swing.JRadioButton();
        jRadioButonAsignaturas = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        contenedorEstudiantes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelAgregarEstudiantes = new javax.swing.JPanel();
        panelAgregarMaterias = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        panelAgregarProfesores = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        contenedorProfesores = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelAsignaturas = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Tabla de Datos");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setText("Buscar");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 37, -1, -1));
        jPanel4.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 61, 156, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-de-busqueda (1).png"))); // NOI18N
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 49, 68, -1));

        jRadioButtonEstudiantes.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButtonEstudiantes);
        jRadioButtonEstudiantes.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jRadioButtonEstudiantes.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButtonEstudiantes.setSelected(true);
        jRadioButtonEstudiantes.setText("Estudiantes");
        jPanel4.add(jRadioButtonEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 27, 110, -1));

        jRadioButtonProfesor.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButtonProfesor);
        jRadioButtonProfesor.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jRadioButtonProfesor.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButtonProfesor.setText("Profesores");
        jPanel4.add(jRadioButtonProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 110, -1));

        jRadioButonAsignaturas.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup1.add(jRadioButonAsignaturas);
        jRadioButonAsignaturas.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jRadioButonAsignaturas.setForeground(new java.awt.Color(204, 204, 204));
        jRadioButonAsignaturas.setText("Asignaturas");
        jPanel4.add(jRadioButonAsignaturas, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 95, 110, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableDatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 135, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 540));

        jTabbedPane2.addTab("Inicio", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorEstudiantes.setBackground(new java.awt.Color(204, 255, 204));
        contenedorEstudiantes.setLayout(new java.awt.GridLayout(0, 1));
        jPanel5.add(contenedorEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1060, 190));

        panelAgregarEstudiantes.setBackground(new java.awt.Color(204, 255, 204));
        panelAgregarEstudiantes.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane3.setViewportView(panelAgregarEstudiantes);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 280));

        panelAgregarMaterias.setLayout(new java.awt.GridLayout());
        jPanel5.add(panelAgregarMaterias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 1060, 140));

        jTabbedPane2.addTab("Estudiantes", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 255, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAgregarProfesores.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(panelAgregarProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 1060, 210));

        contenedorProfesores.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(contenedorProfesores);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 420));

        jTabbedPane2.addTab("Profesores o administrativos", jPanel6);

        panelAgregar.setBackground(new java.awt.Color(204, 204, 255));
        panelAgregar.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panelAsignaturas.setBackground(new java.awt.Color(204, 204, 204));
        panelAsignaturas.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(panelAsignaturas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Asignaturas", jPanel1);

        add(jTabbedPane2);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JPanel contenedorEstudiantes;
    public javax.swing.JPanel contenedorProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JRadioButton jRadioButonAsignaturas;
    public javax.swing.JRadioButton jRadioButtonEstudiantes;
    public javax.swing.JRadioButton jRadioButtonProfesor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable jTableDatos;
    public javax.swing.JPanel panelAgregar;
    public javax.swing.JPanel panelAgregarEstudiantes;
    public javax.swing.JPanel panelAgregarMaterias;
    public javax.swing.JPanel panelAgregarProfesores;
    public javax.swing.JPanel panelAsignaturas;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
