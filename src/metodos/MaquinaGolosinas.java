package metodos;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jesus
 */
public class MaquinaGolosinas {

    private String nombresGolosinas[][];
    private double precio[][];
    private double cantidad[][];
    private double ventas[][];

    public MaquinaGolosinas() {
        this.nombresGolosinas = new String[][]{
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}

        };

        this.precio = new double[][]{
            {1000, 200, 500, 950},
            {1800, 100, 120, 100},
            {1750, 130, 120, 800},
            {1500, 110, 720, 350}

        };
        this.cantidad = new double[][]{
            {5, 5, 5, 5},
            {5, 5, 5, 5},
            {5, 5, 5, 5},
            {5, 5, 5, 5}

        };
        this.ventas = new double[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
    }

    public String[][] getNombresGolosinas() {
        return nombresGolosinas;
    }

    public void setNombresGolosinas(String[][] nombresGolosinas) {
        this.nombresGolosinas = nombresGolosinas;
    }

    public double[][] getPrecio() {
        return precio;
    }

    public void setPrecio(double[][] precio) {
        this.precio = precio;
    }

    public double[][] getCantidad() {
        return cantidad;
    }

    public void setCantidad(double[][] cantidad) {
        this.cantidad = cantidad;
    }

    public double[][] getVentas() {
        return ventas;
    }

    public void setVentas(double[][] ventas) {
        this.ventas = ventas;
    }

    public void pedirGolosina(JTextField jtfFila, JTextField jtfColumna) {

        int fila = Integer.parseInt(jtfFila.getText());
        int columna = Integer.parseInt(jtfColumna.getText());
        String info;

        if (fila >= 0 && fila < 4 && columna >= 0 && columna < 4) {
            if (cantidad[fila][columna] > 0) {
                cantidad[fila][columna]--;
                ventas[fila][columna]++;
                info = "Has comprado: " + nombresGolosinas[fila][columna] + " por " + precio[fila][columna] + " pesitos.";

                JOptionPane.showMessageDialog(null, info);
            } else {
                info = "Lo siento, no quedan más " + nombresGolosinas[fila][columna];
                JOptionPane.showMessageDialog(null, info);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Codigo invalido");
        }

    }

    public void mostrarGolosinas() {
        String mensaje = "Golosinas disponibles: \n";
        for (int i = 0; i < nombresGolosinas.length; i++) {
            for (int j = 0; j < nombresGolosinas[i].length; j++) {
                mensaje += "Código: " + i + j + " - Nombre: " + nombresGolosinas[i][j] + " - Precio: $" + precio[i][j] + " - Cantidad: " + cantidad[i][j] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void rellenarGolosinas() {
        String contrasena = JOptionPane.showInputDialog(
                "Entre la contraseña");

        if (contrasena.equals("Maquina2020")) {

            String codigo = JOptionPane.showInputDialog(
                    "Ingrese el código de la golosina (fila y columna, ej: 20): ");
            int fila = Character.getNumericValue(codigo.charAt(0));
            int columna = Character.getNumericValue(codigo.charAt(1));

            if (fila >= 0 && fila < 4 && columna >= 0 && columna < 4) {
                int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese la nueva cantidad de " + nombresGolosinas[fila][columna] + ": "));
                cantidad[fila][columna] = nuevaCantidad;
                String info = "La cantidad de " + nombresGolosinas[fila][columna] + " ha sido actualizada a " + nuevaCantidad;
                JOptionPane.showMessageDialog(null, info);
            } else {
                JOptionPane.showMessageDialog(null, "Código inválido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
        }
    }

    public void ventasporGolo() {
        String ventasT = "Las ventas por golosinas son: \n";
        for (int i = 0; i < nombresGolosinas.length; i++) {
            for (int j = 0; j < nombresGolosinas[i].length; j++) {
                ventasT += " - Nombre: " + nombresGolosinas[i][j] + " - Vendidas " + ventas[i][j] + " - Ventas por golosina $" + ventas[i][j] * precio[i][j] + "\n";

            }
        }
        JOptionPane.showMessageDialog(null, ventasT);
    }

    public void ventasEstadisticas() {
        String estadistica;
        double ventasTotales = 0;
        double golovendi = 0;
        for (int i = 0; i < nombresGolosinas.length; i++) {
            for (int j = 0; j < nombresGolosinas[i].length; j++) {
                ventasTotales += ventas[i][j] * precio[i][j];
                golovendi += ventas[i][j];

            }

        }
        estadistica = "Las ventas son: \n$" + ventasTotales + "\nLa cantidad vendida de golosinas es: \n" + golovendi;
        JOptionPane.showMessageDialog(null, estadistica);

    }

    public void setLlenarJTable(JTable tabla) {
        String[][] nombreyprecio = new String[4][4];
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                nombreyprecio[i][j] = nombresGolosinas[i][j] + "\n $" + precio[i][j];
            }
        }
        String[] columnas = {"Columna 0", "Columna 1", "Columna 2", "Columna 3"};
        DefaultTableModel miModelo = new DefaultTableModel(nombreyprecio, columnas);
        tabla.setModel(miModelo);

    }

}
