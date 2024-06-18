package com.campuslands.ciudad.adapter.in;

import java.util.Optional;
import java.util.Scanner;

import com.campuslands.ciudad.application.CiudadService;
import com.campuslands.ciudad.domain.Ciudad;

public class CiudadConsoleAdapter {
    private final CiudadService ciudadService;

    public CiudadConsoleAdapter(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Pais");
            System.out.println("2. Actualizar Pais");
            System.out.println("3. Buscar Pais por ID");
            System.out.println("4. Eliminar Pais");
            System.out.println("5. Listar todos Paises");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Ingrese la opcion: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nobre del pais: ");
                    String createName = scanner.nextLine();

                    System.out.print("Ingrese el nobre del pais: ");
                    String createId_region = scanner.nextLine();

                    Ciudad newCiudad = new Ciudad(createName);
                    ciudadService.createCiudad(newCiudad);

                    Ciudad newId_region = new Ciudad(createId_region);
                    ciudadService.createCiudad(newId_region);
                    break;

                case 2:
                    System.out.print("Ingrese  ID a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Ingrese la nueva Id region: ");
                    int updateId_region = scanner.nextInt();


                    Ciudad updatedCiudad = new Ciudad(updateId, updateName, updateId_region);
                    ciudadService.updateCiudad(updatedCiudad);
                    break;

                case 3:
                    System.out.print("Ingrese el Id del pais a buscar: ");
                    int findId = scanner.nextInt();
                    scanner.nextLine();

                    Optional<Ciudad> pais = ciudadService.getCiudadById(findId);
                    pais.ifPresentOrElse(
                        p -> System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre()),
                        () -> System.out.println("Pais no encontrado")
                    );
                    break;

                case 4:
                    System.out.print("Ingrese el Id del pais a borrar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    ciudadService.deleteCiudad(deleteId);
                    break;

                case 5:
                    ciudadService.getAllCiudades().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre());
                    });
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
