package org.example.controlador;

import org.example.modelo.ModeloTablaMoto;
import org.example.modelo.Motocicleta;
import org.example.vista.VentanaMoto;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorMoto extends MouseAdapter {
    private VentanaMoto view;
    private ModeloTablaMoto modelo;

    public ControladorMoto(VentanaMoto view) {
        this.view = view;
        modelo = new ModeloTablaMoto();
        modelo.cargarDatos();
        this.view.getTblMoto().setModel(modelo);
        this.view.getTblMoto().updateUI();

        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblMoto().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        //Evento del boton cargar:
        if(e.getSource() == this.view.getBtnCargar()){
            modelo.cargarDatos();
            this.view.getTblMoto().setModel(modelo);
            this.view.getTblMoto().updateUI();
        }

        //Eventos del boton agregar:
        if(e.getSource() == this.view.getBtnAgregar()){
            Motocicleta moto = new Motocicleta();
            moto.setId(0);
            moto.setMarca(this.view.getTxtMarca().getText());
            moto.setModelo(this.view.getTxtModelo().getText());
            moto.setVelocidad(Double.parseDouble(this.view.getTxtVelocidad().getText()));
            moto.setPais(this.view.getTxtPais().getText());
            moto.setUrl(this.view.getTxtUrl().getText());

            if(modelo.agregarMoto(moto)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblMoto().updateUI();
            }else{
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de Datos." +
                        "Porfavor revise su conexion", "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();
        }

        //Eventos sobre la tabla:
        if(e.getSource() == view.getTblMoto()){
            System.out.println("Evento sobre tabla");
            int index = this.view.getTblMoto().getSelectedRow();
            Motocicleta tmp = modelo.getMotoAtIndex(index);
            try{
                this.view.getImagenMoto().setIcon(tmp.getImagen());
                this.view.getImagenMoto().setText("");
            }catch(MalformedURLException mfue){
                System.out.println("Imagen no encontrada");
            }
        }

        //Evento del boton Delete:
        if(e.getSource() == view.getBtnDelete()){
            int index = this.view.getTblMoto().getSelectedRow();
            int id = modelo.getMotoAtIndex(index).getId();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Seguro que quieres borrar el elemento con indice: "
                    + id + "?", "Atencion", JOptionPane.YES_NO_OPTION);
            if(respuesta == 0){
                if(modelo.borrarMoto(id)){
                    JOptionPane.showMessageDialog(view, "Se borro ese renglon");

                    modelo.cargarDatos();
                    this.view.getTblMoto().setModel(modelo);
                    this.view.getTblMoto().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No has cargado la tabla");
                }
            }
        }

        //Evento del boton Actualizar:
        if(e.getSource() == view.getBtnActualizar()){

            //Para actualizar cualquier casilla con dato de tipo String:
            try{
                Object o = this.view.getTxtActualizar().getText();
            int index = this.view.getTblMoto().getSelectedRow();
            int id = modelo.getMotoAtIndex(index).getId();
            int columna = this.view.getTblMoto().getSelectedColumn();

            if(modelo.actualizarUnElemento(o, id, columna)){
                JOptionPane.showMessageDialog(view, "Se actualizo ese elemento");
                this.view.limpiar();
                modelo.cargarDatos();
                this.view.getTblMoto().setModel(modelo);
                this.view.getTblMoto().updateUI();
            } else{
                JOptionPane.showMessageDialog(view, "No has cargado la tabla");
            }
            //Para actualizar las casillas que poseen datos Double:
            }catch (ClassCastException cce){
                Object o = Double.parseDouble(this.view.getTxtActualizar().getText());
                int index = this.view.getTblMoto().getSelectedRow();
                int id = modelo.getMotoAtIndex(index).getId();
                int columna = this.view.getTblMoto().getSelectedColumn();

                if(modelo.actualizarUnElemento(o, id, columna)){
                    JOptionPane.showMessageDialog(view, "Se actualizo ese elemento");
                    modelo.cargarDatos();
                    this.view.getTblMoto().setModel(modelo);
                    this.view.getTblMoto().updateUI();
                } else{
                    JOptionPane.showMessageDialog(view, "No se puede modificar el id");
                }

            }

        }
    }
}
