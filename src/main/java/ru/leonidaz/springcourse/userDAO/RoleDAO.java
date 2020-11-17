package ru.leonidaz.springcourse.userDAO;

import ru.leonidaz.springcourse.models.Role;

public interface RoleDAO {
    Role findByID(int id);
}
