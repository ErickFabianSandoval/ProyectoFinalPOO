package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaMoto extends JFrame {
    private JLabel lblId;
    private JLabel lblMarca;
    private JLabel lblModelo;
    private JLabel lblVelocidad;
    private JLabel lblPais;
    private JLabel lblUrl;

    private JTextField txtId;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtVelocidad;
    private JTextField txtPais;
    private JTextField txtUrl;

    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblMoto;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1; //formulario para capturar libros
    private JPanel panel2; //Tabla para mostrar los libros
    private JPanel panel3; //Mostrar imagen seleccionada
    private JPanel panel4; //Eliminacion y actualizacion de campos
    private JLabel imagenMoto;
    private JLabel lblDelete;
    private JButton btnDelete;
    private JTextArea txaActualizar;
    private JButton btnActualizar;
    private JTextField txtActualizar;
    public VentanaMoto(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(227, 169, 169));
        lblId = new JLabel("Id:");
        lblMarca = new JLabel("Marca:");
        lblModelo = new JLabel("Modelo:");
        lblVelocidad = new JLabel("Velocidad Max(km/hr):");
        lblPais = new JLabel("Pais de Origen:");
        lblUrl = new JLabel("URL:");
        txtId = new JTextField(2);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtMarca = new JTextField(10);
        txtModelo = new JTextField(10);
        txtVelocidad = new JTextField(6);
        txtPais = new JTextField(7);
        txtUrl = new JTextField(23);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblMarca);
        panel1.add(txtMarca);
        panel1.add(lblModelo);
        panel1.add(txtModelo);
        panel1.add(lblVelocidad);
        panel1.add(txtVelocidad);
        panel1.add(lblPais);
        panel1.add(txtPais);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);



        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(199, 232, 188));
        btnCargar = new JButton("Cargar");
        panel2.add(btnCargar);
        tblMoto = new JTable();
        scrollPane = new JScrollPane(tblMoto);
        panel2.add(scrollPane);

        //panel 3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(168, 193, 227));
        imagenMoto = new JLabel("...");
        panel3.add(imagenMoto);


        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(157, 149, 182));
        lblDelete = new JLabel("Seleccione la fila que desee borrar y oprima el boton");
        btnDelete = new JButton("Delete");
        txaActualizar = new JTextArea("Actualizar:"+ "\n1.Escriba el nuevo valor." +
                "\n 2.Seleccione la casilla que desea sustituir" + " \n 3.Oprima el boton actualizar");
        txaActualizar.setBackground(null);
        txtActualizar = new JTextField(14);
        btnActualizar = new JButton("Actualizar");
        panel4.add(lblDelete);
        panel4.add(btnDelete);
        panel4.add(txaActualizar);
        panel4.add(txtActualizar);
        panel4.add(btnActualizar);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JLabel getLblModelo() {
        return lblModelo;
    }

    public void setLblModelo(JLabel lblModelo) {
        this.lblModelo = lblModelo;
    }

    public JLabel getLblVelocidad() {
        return lblVelocidad;
    }

    public void setLblVelocidad(JLabel lblVelocidad) {
        this.lblVelocidad = lblVelocidad;
    }

    public JLabel getLblPais() {
        return lblPais;
    }

    public void setLblPais(JLabel lblPais) {
        this.lblPais = lblPais;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    public JTextField getTxtVelocidad() {
        return txtVelocidad;
    }

    public void setTxtVelocidad(JTextField txtVelocidad) {
        this.txtVelocidad = txtVelocidad;
    }

    public JTextField getTxtPais() {
        return txtPais;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblMoto() {
        return tblMoto;
    }

    public void setTblMoto(JTable tblMoto) {
        this.tblMoto = tblMoto;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagenMoto() {
        return imagenMoto;
    }

    public void setImagenMoto(JLabel imagenMoto) {
        this.imagenMoto = imagenMoto;
    }

    public JLabel getLblDelete() {
        return lblDelete;
    }

    public void setLblDelete(JLabel lblDelete) {
        this.lblDelete = lblDelete;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JTextArea getTxaActualizar() {
        return txaActualizar;
    }

    public void setTxaActualizar(JTextArea txaActualizar) {
        this.txaActualizar = txaActualizar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JTextField getTxtActualizar() {
        return txtActualizar;
    }

    public void setTxtActualizar(JTextField txtActualizar) {
        this.txtActualizar = txtActualizar;
    }

    public void limpiar(){
        txtMarca.setText("");
        txtModelo.setText("");
        txtVelocidad.setText("");
        txtPais.setText("");
        txtUrl.setText("");
        txtActualizar.setText("");

    }
}
