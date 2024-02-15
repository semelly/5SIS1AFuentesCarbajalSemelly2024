package Tarea1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PersonaGUI extends JFrame {

    private List<Persona> personas;

    private JTextField idField;
    private JTextField nombreField;
    private JTextField edadField;
    private JButton registrarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JTable personasTable;

    public PersonaGUI() {
     
        personas = new ArrayList<>();
        personas.add(new Persona(123, "Angel", 30));
        personas.add(new Persona(456, "Rosa", 25));
        personas.add(new Persona(789, "Andres", 40));
        personas.add(new Persona(135, "Ana", 35));
        personas.add(new Persona(246, "Luis", 28));

        
        setTitle("CRUD de Personas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        
        JPanel controlPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        idField = new JTextField();
        idField.setEditable(false);
        nombreField = new JTextField();
        edadField = new JTextField();

        registrarButton = new JButton("Registrar");
        editarButton = new JButton("Editar");
        eliminarButton = new JButton("Eliminar");

        
        personasTable = new JTable();
        actualizarTabla();

        
        controlPanel.add(new JLabel("ID:"));
        controlPanel.add(idField);
        controlPanel.add(new JLabel("Nombre:"));
        controlPanel.add(nombreField);
        controlPanel.add(new JLabel("Edad:"));
        controlPanel.add(edadField);
        controlPanel.add(registrarButton);
        controlPanel.add(editarButton);
        controlPanel.add(eliminarButton);

        
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPersona();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarPersona();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPersona();
            }
        });

    
        setLayout(new BorderLayout());
        add(controlPanel, BorderLayout.WEST);
        add(new JScrollPane(personasTable), BorderLayout.CENTER);
    }

    private void actualizarTabla() {
        String[] columnas = {"ID", "Nombre", "Edad"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        for (Persona persona : personas) {
            Object[] fila = {persona.getId(), persona.getNombre(), persona.getEdad()};
            modelo.addRow(fila);
        }
        personasTable.setModel(modelo);
    }

    private void registrarPersona() {
        String nombre = nombreField.getText();
        int edad = Integer.parseInt(edadField.getText());
        int id = personas.isEmpty() ? 1 : personas.get(personas.size() - 1).getId() + 1;
        Persona persona = new Persona(id, nombre, edad);
        personas.add(persona);
        actualizarTabla();
        limpiarCampos();
    }

    private void editarPersona() {
        int filaSeleccionada = personasTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = Integer.parseInt(idField.getText());
            String nombre = nombreField.getText();
            int edad = Integer.parseInt(edadField.getText());
            Persona persona = new Persona(id, nombre, edad);
            personas.set(filaSeleccionada, persona);
            actualizarTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una persona para editar.");
        }
    }

    private void eliminarPersona() {
        int filaSeleccionada = personasTable.getSelectedRow();
        if (filaSeleccionada != -1) {
            personas.remove(filaSeleccionada);
            actualizarTabla();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una persona para eliminar.");
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        edadField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PersonaGUI().setVisible(true);
            }
        });
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public void setNombreField(JTextField nombreField) {
        this.nombreField = nombreField;
    }

    public void setEdadField(JTextField edadField) {
        this.edadField = edadField;
    }

    public void setRegistrarButton(JButton registrarButton) {
        this.registrarButton = registrarButton;
    }

    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }

    public void setPersonasTable(JTable personasTable) {
        this.personasTable = personasTable;
    }
}

class Persona {
    private int id;
    private String nombre;
    private int edad;

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}