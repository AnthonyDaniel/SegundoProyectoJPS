/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Profesor;

/**
 *
 * @author Mauricio
 */
public class ListaEstudiantes extends javax.swing.JPanel {

    /**
     * Creates new form ListaEstudiantes
     */
    public ListaEstudiantes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listaEst = new javax.swing.JTable();
        btn_nota = new javax.swing.JButton();
        lbl_tituloListEst = new javax.swing.JLabel();

        lbl_1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_1.setText("Estudiantes Asignatura:");

        tbl_listaEst.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_listaEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_listaEst.setColumnSelectionAllowed(true);
        tbl_listaEst.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_listaEst);
        tbl_listaEst.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_listaEst.getColumnModel().getColumnCount() > 0) {
            tbl_listaEst.getColumnModel().getColumn(0).setResizable(false);
            tbl_listaEst.getColumnModel().getColumn(1).setResizable(false);
            tbl_listaEst.getColumnModel().getColumn(2).setResizable(false);
        }

        btn_nota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_nota.setText("Agregar/Modificar Nota");

        lbl_tituloListEst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nota)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_tituloListEst, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_1)
                    .addComponent(lbl_tituloListEst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_nota)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_nota;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbl_1;
    public javax.swing.JLabel lbl_tituloListEst;
    public javax.swing.JTable tbl_listaEst;
    // End of variables declaration//GEN-END:variables
}
