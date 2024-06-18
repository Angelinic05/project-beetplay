package com.campuslands;

import java.util.List;
import java.util.Scanner;

import com.campuslands.pais.adapter.in.PaisConsoleAdapter;
import com.campuslands.pais.adapter.out.PaisMySQLRepository;
import com.campuslands.pais.application.PaisService;
import com.campuslands.pais.domain.Pais;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/beetplay";
        String username = "root";
        String password = "root";

        PaisMySQLRepository paisRepository = new PaisMySQLRepository(url, username, password);

        System.out.println("--------------- MENU PRINCIPAL ---------------");
        while (true) {
            System.out.println("1. Ciudad");
            System.out.println("2. Pais");
            System.out.println("3. Region");
            System.out.println("4. Cuerpo Tecnico");
            System.out.println("5. Equipo");
            System.out.println("5. Jugador");
            System.out.println("5. Persona");
            System.out.println("5. Plantel");
            System.out.println("5. Posicion");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                

                case 2:
                    System.out.println("--------------- MENU PAIS ---------------");
                    PaisService paisService = new PaisService(paisRepository);
                    PaisConsoleAdapter paisConsoleAdapter = new PaisConsoleAdapter(paisService);
                    paisConsoleAdapter.start();
                    break;

                case 3:
                    

                case 4:
                    

                case 5:
                    
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");

        
                }
            }
    }
}
