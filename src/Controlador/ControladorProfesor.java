package Controlador;
import Modelo.Administracion.ContenedorProfesor;
import Modelo.Administracion.IProfesor;
import Modelo.Entidades.*;
import Vista.Administracion.Asignaturas;
import Vista.Profesor.*;
import Vista.Interfaz;
import antlr.actions.cpp.ActionLexer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class ControladorProfesor {
    
    private final IProfesor iProfesor;
    private final InterfazProfesor interfazProf;
    private ListaAsignaturas interfazListaAsig;
    private ListaProfesores interfazListaProf;
    private ListaEstudiantes interfazListaEst;
    private NotaEstudiante interfazNotas;
    private AusenciasEstudiante interfazAusc;
    private Ausencia interfazAgrAusc;
    
    private List lista;    
    
    
    public ControladorProfesor(Interfaz interfazPrin, String _idProf){        
        iProfesor = new ContenedorProfesor();
        interfazProf = new InterfazProfesor();
        interfazListaEst = new ListaEstudiantes();
        interfazListaProf = new  ListaProfesores();        
        interfazListaAsig = new ListaAsignaturas();
        interfazNotas = new NotaEstudiante();
        interfazAusc = new AusenciasEstudiante();
        interfazAgrAusc = new Ausencia();
                        
        interfazPrin.panelContenedor.add(interfazProf).repaint();       
        
        cargarTablaAsignaturas(_idProf);       
        interfazProf.panel_Contenido.add(interfazListaAsig);
        
        interfazPrin.panelContenedor.add(interfazProf);
        interfazPrin.panelContenedor.revalidate();
        
        listarProfesoresClick();
        listarAsginaturasClick(_idProf);
        listarEstudiantesClick();
    }
    
    private void cargarTablaAsignaturas(String _idProf){
        lista = iProfesor.listarAsignaturas(_idProf);        
        
        interfazListaAsig.tbl_ListaAsig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazListaAsig.tbl_ListaAsig.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"CODIGO","NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, etiquetas){
                boolean[] canEdit = new boolean[2];
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex ){
                    return canEdit[columnIndex];
                }
        };
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("IdAsignatura");
            fila[1] = tupla.get("Nombre");            
            model.addRow(fila);
        }
        interfazListaAsig.tbl_ListaAsig.setModel(model); 
    }
    
    private void cargarTablaProfesores(){
        lista = iProfesor.listarProfesores();
        
        interfazListaProf.tbl_ListaProf.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazListaProf.tbl_ListaProf.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"NOMBRE","APELLIDOS"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, etiquetas){
                boolean[] canEdit = new boolean[2];
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex ){
                    return canEdit[columnIndex];
                }
        };
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[2];
            fila[0] = tupla.get("nombre");
            fila[1] = tupla.get("ape1"); 
            model.addRow(fila);
        }
        interfazListaProf.tbl_ListaProf.setModel(model); 
    }
    
    private void cargarTablaEstudiantes(String _idAsig, String _nom){   
        ArrayList<EntidadEstudiante> listEst = iProfesor.listarEstudiantes(_idAsig);
        
        interfazListaEst.tbl_listaEst.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazListaEst.tbl_listaEst.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"CEDULA","NOMBRE","APELLIDOS"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, etiquetas){
                boolean[] canEdit = new boolean[3];
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex ){
                    return canEdit[columnIndex];
                }
        };
        Object[] fila ;
        for(int i=0;i<listEst.size();i++){
            fila= new Object[3];
            fila[0]=listEst.get(i).getId();
            fila[1]=listEst.get(i).getNombre();
            fila[2]=listEst.get(i).getApe1();
            model.addRow(fila);
        }
        interfazListaEst.tbl_listaEst.setModel(model); 
        interfazListaEst.lbl_tituloListEst.setText(_idAsig+"-"+_nom);
    }
    
    private void cargarTablaAusencias(String _cedEst, String _idAsig){
        lista = iProfesor.listarAusencias(_cedEst, _idAsig);
        
        interfazAusc.tbl_Ausc.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        interfazAusc.tbl_Ausc.getTableHeader().setReorderingAllowed(false);
        Object[] etiquetas = {"ASIGNATURA","ESTUDIANTE","FECHA","ESTADO"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, etiquetas){
                boolean[] canEdit = new boolean[4];
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex ){
                    return canEdit[columnIndex];
                }
        };
        Object[] fila ;
        for(Object lib:lista){
            Map tupla = (Map)lib;
            fila = new Object[4];
            fila[2] = tupla.get("Fecha");
            fila[1] = tupla.get("IdEstudiante"); 
            fila[0] = tupla.get("IdAsignatura"); 
            fila[3] = tupla.get("Justificacion"); 
            model.addRow(fila);
        }
        interfazAusc.tbl_Ausc.setModel(model); 
    }
    
    private void editarNota(String _ced, String _nom, String _asig, String _idAsig){
        interfazNotas.txt_ced.setText(_ced);
        interfazNotas.txt_nomAp.setText(_nom);
        interfazNotas.txt_asig.setText(_asig);
        interfazNotas.txt_notaActual.setText(String.valueOf(iProfesor.obtenerNota(_ced,_idAsig)));
    }
    
    private void listarProfesoresClick(){//        
        interfazProf.btn_listarProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                cargarTablaProfesores();
                interfazProf.panel_Contenido.removeAll();
                interfazProf.panel_Contenido.add(interfazListaProf).repaint();
                interfazProf.panel_Contenido.updateUI();
            }
        });
    }
    
    private void listarAsginaturasClick(String _idProf){
        interfazProf.btn_listarAsig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarTablaAsignaturas(_idProf);
                interfazProf.panel_Contenido.removeAll();
                interfazProf.panel_Contenido.add(interfazListaAsig).repaint();
                interfazProf.panel_Contenido.updateUI();
            }
        });
    }
    
    private void listarEstudiantesClick(){
        interfazListaAsig.btn_verEstudiantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(interfazListaAsig.tbl_ListaAsig.getSelectedRow() > -1){                    
                    String idAsig = (String) interfazListaAsig.tbl_ListaAsig.getValueAt(interfazListaAsig.tbl_ListaAsig.getSelectedRow(),0);
                    String nomAsig = (String) interfazListaAsig.tbl_ListaAsig.getValueAt(interfazListaAsig.tbl_ListaAsig.getSelectedRow(),1);
                    cargarTablaEstudiantes(idAsig, nomAsig);                    
                    interfazProf.panel_Contenido.removeAll();
                    interfazProf.panel_Contenido.add(interfazListaEst).repaint();
                    interfazProf.panel_Contenido.updateUI();
                    agregarNotaClick(idAsig, nomAsig);
                    irAusenciasClick(idAsig, nomAsig);
                }
            }
        });
    }
    
    private void agregarNotaClick(String _idAsig, String _nombreAsig){
        interfazListaEst.btn_nota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                if(interfazListaEst.tbl_listaEst.getSelectedRow() > -1){
                    String asig = _idAsig+"-"+_nombreAsig; 
                    String  _idEst = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),0);
                    String _nomEst = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),1);
                    String _apeEst = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),2);
                    interfazProf.panel_Contenido.removeAll();
                    interfazProf.panel_Contenido.add(interfazNotas).repaint();
                    interfazProf.panel_Contenido.updateUI();
                    editarNota(_idEst, _nomEst, asig,_idAsig);
                    guardarNotaClick(_idEst, _idAsig, _nomEst+" "+_apeEst,asig);
                }
            }
        });
    }
    
    private void guardarNotaClick(String _ced, String _idAsig, String _nom, String _asig){
        interfazNotas.btn_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double nota;
                if(!interfazNotas.txt_notaNueva.getText().isEmpty()){
                    nota = Double.parseDouble(interfazNotas.txt_notaNueva.getText());
                    iProfesor.ponerNota(nota, _ced, _idAsig);
                    editarNota(_ced, _nom, _asig, _idAsig);
                    JOptionPane.showMessageDialog(null, "Se modifico la nota exitosamente!", "Modificacion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    interfazNotas.txt_notaNueva.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "No se ingreso una nueva nota \nNo se modifico la nota!", "No se modifico", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void irAusenciasClick(String _idAsig, String _nomAsig){
        interfazListaEst.btn_faltas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(interfazListaEst.tbl_listaEst.getSelectedRow() > -1){                    
                    String _idEst = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),0);
                    String _nomEst = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),1);
                    String _apeEst = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),2);
                    cargarTablaAusencias(_idEst, _idAsig);
                    interfazProf.panel_Contenido.removeAll();
                    interfazProf.panel_Contenido.add(interfazAusc).repaint();
                    interfazProf.panel_Contenido.updateUI();    
                    agregarAusenciaClick(_idEst,_nomEst+" "+_apeEst, _idAsig,_nomAsig);
                    modificarAusencia();
                }               
            }
        });
    }
    
    private void agregarAusenciaClick(String _idEst, String _nomEst, String _idAsig, String _nomAsig){
        interfazAusc.btn_agregarAusc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazAgrAusc.txt_Est.setText(_idEst+" "+_nomEst);
                interfazAgrAusc.txt_asig.setText(_idAsig+"-"+_nomAsig);   
                interfazProf.panel_Contenido.removeAll();
                interfazProf.panel_Contenido.add(interfazAgrAusc).repaint();
                interfazProf.panel_Contenido.updateUI(); 
                guardarAusenciaClick(_idAsig, _idEst);
            }
        });
    }
    
    private void guardarAusenciaClick(String _idAsig, String _idEst){
        interfazAgrAusc.btn_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!interfazAgrAusc.txt_fecha.getText().isEmpty()){
                    if(interfazAgrAusc.rbtn_just.isSelected()){
                        iProfesor.ponerFalta(interfazAgrAusc.txt_fecha.getText(), _idAsig, _idEst, interfazAgrAusc.rbtn_just.getText());
                    }
                    if(interfazAgrAusc.rbtn_sinJust.isSelected()){
                        iProfesor.ponerFalta(interfazAgrAusc.txt_fecha.getText(), _idAsig, _idEst, interfazAgrAusc.rbtn_sinJust.getText());
                    }
                    JOptionPane.showMessageDialog(null, "Se agrego la ausencia!", "Ausencia Agregada", JOptionPane.INFORMATION_MESSAGE);
                    interfazAgrAusc.txt_fecha.setText("");
                    interfazAgrAusc.rbtn_just.setSelected(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Campo de Fecha no puede estar vacio \nNo se agrego la ausencia", "Error al agregar", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void modificarAusencia(){
        interfazAusc.btn_modAusc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(interfazAusc.tbl_Ausc.getSelectedRow() > -1 ){ 
                    if(JOptionPane.showConfirmDialog(null, "Desea modificar el estado de la ausencia: ", "Modificar estado ausencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        String _idAsig = (String) interfazAusc.tbl_Ausc.getValueAt(interfazAusc.tbl_Ausc.getSelectedRow(),0);
                        String _idEst = (String) interfazAusc.tbl_Ausc.getValueAt(interfazAusc.tbl_Ausc.getSelectedRow(),1);
                        String _fecha = (String) interfazAusc.tbl_Ausc.getValueAt(interfazAusc.tbl_Ausc.getSelectedRow(),2);
                        String _estado = (String) interfazAusc.tbl_Ausc.getValueAt(interfazAusc.tbl_Ausc.getSelectedRow(),3);
                        if("Justificada".equals(_estado)){
                            iProfesor.modificarFalta(_idEst, _idAsig, _fecha, "Sin justificar");
                        }
                        if("Sin justificar".equals(_estado)){
                            iProfesor.modificarFalta(_idEst, _idAsig, _fecha, "Justificada");
                        }
                        cargarTablaAusencias(_idEst, _idAsig);
                    }
                } 
            }
        });
    }
}
