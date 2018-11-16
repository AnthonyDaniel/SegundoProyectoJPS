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
    
    private List lista;
    
    public ControladorProfesor(Interfaz interfazPrin, String _idProf){        
        iProfesor = new ContenedorProfesor();
        interfazProf = new InterfazProfesor();
        interfazListaEst = new ListaEstudiantes();
        interfazListaProf = new  ListaProfesores();        
        interfazListaAsig = new ListaAsignaturas();
        interfazNotas = new NotaEstudiante();
                        
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
    
    private void cargarTablaEstudiantes(int _idAsig, String _nom){   
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
    
    private void editarNota(String _ced, String _nom, String _asig, int _idAsig){
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
                if(interfazListaAsig.tbl_ListaAsig.getValueAt(interfazListaAsig.tbl_ListaAsig.getSelectedRow(), 0) != null){
                    
                    int id = (int) interfazListaAsig.tbl_ListaAsig.getValueAt(interfazListaAsig.tbl_ListaAsig.getSelectedRow(),0);
                    String nom = (String) interfazListaAsig.tbl_ListaAsig.getValueAt(interfazListaAsig.tbl_ListaAsig.getSelectedRow(),1);
                    cargarTablaEstudiantes(id, nom);                    
                    interfazProf.panel_Contenido.removeAll();
                    interfazProf.panel_Contenido.add(interfazListaEst).repaint();
                    interfazProf.panel_Contenido.updateUI();
                    agregarNotaClick(id, nom);
                }
            }
        });
    }
    
    private void agregarNotaClick(int _idAsig, String _nombreAsig){
        interfazListaEst.btn_nota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                if(interfazListaEst.tbl_listaEst.getValueAt(interfazListaAsig.tbl_ListaAsig.getSelectedRow(), 0) != null){
                    String asig = _idAsig+"-"+_nombreAsig; 
                    String ced = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),0);
                    String nom = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),1);
                    String ape = (String) interfazListaEst.tbl_listaEst.getValueAt(interfazListaEst.tbl_listaEst.getSelectedRow(),2);
                    interfazProf.panel_Contenido.removeAll();
                    interfazProf.panel_Contenido.add(interfazNotas).repaint();
                    interfazProf.panel_Contenido.updateUI();
                    editarNota(ced, nom+" "+ape, asig,_idAsig);
                    guardarNotaClick(ced, _idAsig, nom+" "+ape,asig);
                }
            }
        });
    }
    
    private void guardarNotaClick(String _ced, int _idAsig, String _nom, String _asig){
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
}
