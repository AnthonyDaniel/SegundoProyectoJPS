
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
        jPanel5 = new javax.swing.JPanel();
        contenedorEstudiantes = new javax.swing.JPanel();
        panelAgregarEstudiantes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        contenedorProfesores = new javax.swing.JPanel();
        panelAgregarProfesores = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelAsignaturas = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("Tabla de Datos");

        jLabel2.setText("Buscar");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa-de-busqueda (1).png"))); // NOI18N

        buttonGroup1.add(jRadioButtonEstudiantes);
        jRadioButtonEstudiantes.setSelected(true);
        jRadioButtonEstudiantes.setText("Estudiantes");

        buttonGroup1.add(jRadioButtonProfesor);
        jRadioButtonProfesor.setText("Profesores");

        buttonGroup1.add(jRadioButonAsignaturas);
        jRadioButonAsignaturas.setText("Asignaturas");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonEstudiantes, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButonAsignaturas)
                                .addComponent(jRadioButtonProfesor)))))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jRadioButtonEstudiantes)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonProfesor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(28, 28, 28)))
                .addComponent(jRadioButonAsignaturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Inicio", jPanel4);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorEstudiantes.setBackground(new java.awt.Color(204, 255, 204));
        contenedorEstudiantes.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(contenedorEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 15, 946, 250));

        panelAgregarEstudiantes.setBackground(new java.awt.Color(204, 255, 204));
        panelAgregarEstudiantes.setLayout(new java.awt.GridLayout(1, 0));
        jPanel5.add(panelAgregarEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 789, 120));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 960, 520));

        jTabbedPane2.addTab("Estudiantes", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 255, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorProfesores.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(contenedorProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 800, 196));

        panelAgregarProfesores.setLayout(new java.awt.GridLayout(1, 0));
        jPanel6.add(panelAgregarProfesores, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 800, 130));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 520));

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
            .addComponent(panelAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable jTableDatos;
    public javax.swing.JPanel panelAgregar;
    public javax.swing.JPanel panelAgregarEstudiantes;
    public javax.swing.JPanel panelAgregarProfesores;
    public javax.swing.JPanel panelAsignaturas;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
