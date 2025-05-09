package plataforma_academica.plataforma_academica.services;

import plataforma_academica.plataforma_academica.model.User;

public interface UserService extends CrudService<User,Long>{
    User registerUser(String name, String email, String role) throws Exception;

    User authenticateUser(String email, String password) throws Exception;

    User getUserProfile(Long userId) throws Exception;

    User updateUserProfile(Long userId, String name, String password) throws Exception;

    void softDeleteUser(Long userId) throws Exception;
}
