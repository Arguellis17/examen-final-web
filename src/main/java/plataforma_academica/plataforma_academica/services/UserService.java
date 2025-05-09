package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.User;

public interface UserService extends CrudService<User,Long>{
    User registerUser(String name, String email, String role) throws Exception;
}
