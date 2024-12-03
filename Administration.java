/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.administration;

/**
 *
 * @author Usuario
 */
public class Administration {
    public static void main(String[] args) {
        System.out.println("Iniciando pruebas de conexión a las bases de datos...");

        // Verificar conexión a PostgreSQL
        System.out.println("\nVerificando conexión y datos de PostgreSQL:");
        PostgresConnection.fetchData(); // Llamar al método para consultar PostgreSQL

        
        // Verificar conexión a MongoDB
        System.out.println("\nVerificando conexión y datos de MongoDB:");
        MongoConnection.fetchData(); // Llamar al método para consultar MongoDB

       
        
        // Verificar conexión y datos de la tabla users
        System.out.println("\nVerificando conexión y datos de la tabla users:");
        UsersConnection.fetchUsers(); // Llamar al método para consultar la tabla users

        // Mostrar el JFrame de inicio de sesión
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new log_in().setVisible(true);
            }
        });

        // Comentar el JFrame con el JTable para pruebas
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
        */
    }
}





