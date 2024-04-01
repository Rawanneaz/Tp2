package ma.emsic.studentsapp2.service;


import ma.emsic.studentsapp2.entities.Role;
import ma.emsic.studentsapp2.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authentificate(String userName,String password);
}
