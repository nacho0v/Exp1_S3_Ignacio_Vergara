package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> users = new ArrayList<>();
    private List<Rol> roles = new ArrayList<>();
    private List<ShippingAddress> addresses = new ArrayList<>();

    public UserController() {
        // Crear instancias de Rol
        Rol rol1 = new Rol(1, "Admin");
        Rol rol2 = new Rol(2, "Cliente");
        Rol rol3 = new Rol(3, "Delivery");
        roles.add(rol1);
        roles.add(rol2);
        roles.add(rol3);

        // Crear instancias de ShippingAddress
        ShippingAddress address1 = new ShippingAddress("1", "Región Metropolitana", "La Florida", "Calle Falsa", "123");
        ShippingAddress address2 = new ShippingAddress("2", "Región Maule", "Talca", "Calle existente", "100");
        ShippingAddress address3 = new ShippingAddress("3", "Región Valparaiso", "El Quisco", "Calle Bonita", "200");
        ShippingAddress address4 = new ShippingAddress("4", "Región Atacama", "San Pedro de Atacama", "Calle fea", "130");
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
        addresses.add(address4);

        // Crear instancias de User con roles y direcciones
        List<Rol> rolesUser1 = new ArrayList<>();
        rolesUser1.add(rol1);
        List<ShippingAddress> addressesUser1 = new ArrayList<>();
        addressesUser1.add(address1);
        users.add(new User(1, "Juanito", "Juanito@gmail.com", "juan1234", rolesUser1, addressesUser1));

        List<Rol> rolesUser2 = new ArrayList<>();
        rolesUser2.add(rol2);
        List<ShippingAddress> addressesUser2 = new ArrayList<>();
        addressesUser2.add(address2);
        users.add(new User(2, "Andres", "Andres@gmail.com", "Andres1234", rolesUser2, addressesUser2));

        List<Rol> rolesUser3 = new ArrayList<>();
        rolesUser3.add(rol1);
        List<ShippingAddress> addressesUser3 = new ArrayList<>();
        addressesUser3.add(address3);
        users.add(new User(3, "Pepita", "Pepita@gmail.com", "Pepita1234", rolesUser3, addressesUser3));

        List<Rol> rolesUser4 = new ArrayList<>();
        rolesUser4.add(rol3);
        List<ShippingAddress> addressesUser4 = new ArrayList<>();
        addressesUser4.add(address4);
        users.add(new User(4, "Catalina", "Catalina@gmail.com", "Catalina1234", rolesUser4, addressesUser4));
    }

    @GetMapping("/user")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Método para buscar usuarios por tipo de rol
    @GetMapping("/user/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        List<User> usersWithRole = new ArrayList<>();
        for (User user : users) {
            for (Rol rol : user.getRoles()) {
                if (rol.getNombre().equalsIgnoreCase(role)) {
                    usersWithRole.add(user);
                    break;
                }
            }
        }
        return usersWithRole;
    }

    // Método para mostrar las direcciones de despacho de cada usuario
    @GetMapping("/user/{id}/shipping-address")
    public List<ShippingAddress> getShippingAddressesByUserId(@PathVariable int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user.getShippingAddress();
            }
        }
        return null;
    }
}
