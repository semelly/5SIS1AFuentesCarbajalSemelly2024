package Examen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz extends JFrame {
    private JTextField modeloField;
    private JTextField numeroReporteField;
    private JTextField fechaInspeccionField;
    private JButton generarTablaButton;

    public Interfaz() {
        setTitle("Inspección de Medidas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel modeloLabel = new JLabel("MODELO:");
        modeloField = new JTextField(10);
        JLabel numeroReporteLabel = new JLabel("NÚMERO DE REPORTE:");
        numeroReporteField = new JTextField(10);
        JLabel fechaInspeccionLabel = new JLabel("FECHA DE INSPECCIÓN:");
        fechaInspeccionField = new JTextField(10);

        topPanel.add(modeloLabel);
        topPanel.add(modeloField);
        topPanel.add(numeroReporteLabel);
        topPanel.add(numeroReporteField);
        topPanel.add(fechaInspeccionLabel);
        topPanel.add(fechaInspeccionField);

        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 4));

        JLabel puntosAMedirLabel = new JLabel("PUNTOS A MEDIR");
        JLabel fichaTecnicaLabel = new JLabel("FICHA TÉCNICA");
        JLabel numeroPrendaColoresLabel = new JLabel("No. PRENDA / COLORES");
        JLabel totalPrendasLabel = new JLabel("TOTAL DE PRENDAS");

        centerPanel.add(puntosAMedirLabel);
        centerPanel.add(fichaTecnicaLabel);
        centerPanel.add(numeroPrendaColoresLabel);
        centerPanel.add(totalPrendasLabel);

        add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JLabel aqlLabel = new JLabel("AQL");
        JLabel acLabel = new JLabel("AC");
        JLabel reLabel = new JLabel("RE");
        JLabel mayorAceptadoLabel = new JLabel("MAYOR ACEPTADO:");
        JTextField mayorAceptadoField = new JTextField(5);
        JLabel rechazoLabel = new JLabel("RECHAZO:");
        JTextField rechazoField = new JTextField(5);

        bottomPanel.add(aqlLabel);
        bottomPanel.add(acLabel);
        bottomPanel.add(reLabel);
        bottomPanel.add(mayorAceptadoLabel);
        bottomPanel.add(mayorAceptadoField);
        bottomPanel.add(rechazoLabel);
        bottomPanel.add(rechazoField);

        JLabel firmaProveedorLabel = new JLabel("FIRMA DEL PROVEEDOR:");
        JTextField firmaProveedorField = new JTextField(10);
        JLabel firmaInspectorLabel = new JLabel("FIRMA DEL INSPECTOR:");
        JTextField firmaInspectorField = new JTextField(10);

        bottomPanel.add(firmaProveedorLabel);
        bottomPanel.add(firmaProveedorField);
        bottomPanel.add(firmaInspectorLabel);
        bottomPanel.add(firmaInspectorField);

        generarTablaButton = new JButton("Generar Tabla");
        generarTablaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarTabla();
            }
        });
        bottomPanel.add(generarTablaButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void generarTabla() {
        String modelo = modeloField.getText();
        String numeroReporte = numeroReporteField.getText();
        String fechaInspeccion = fechaInspeccionField.getText();
        String muestreoPrendas = "Aquí iría el muestreo de prendas generado";

        JFrame tablaFrame = new JFrame("Tabla Generada");
        tablaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tablaFrame.setSize(600, 200);
        tablaFrame.setLayout(new BorderLayout());

        JPanel tablaPanel = new JPanel();
        tablaPanel.setLayout(new GridLayout(1, 1));

        JTextArea tablaTextArea = new JTextArea();
        tablaTextArea.setEditable(false);
        tablaTextArea.append("PUNTOS A MEDIR\tFICHA TÉCNICA\tNo. PRENDA / COLORES\tTOTAL DE PRENDAS\n");
        tablaTextArea.append("\tSTD\tTOL\n");
        tablaTextArea.append(muestreoPrendas);

        tablaPanel.add(new JScrollPane(tablaTextArea));
        tablaFrame.add(tablaPanel, BorderLayout.CENTER);

        tablaFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());
    }
}
