package com.demo.bean;

import com.demo.dao.UserDAO;
import com.demo.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean implements Serializable {
    UserDAO dao = new UserDAO();

    public List<User> getUsers() {
        List<User> listUser = dao.getUser();
        return listUser;
    }

    public String addUser(User user)
    {
        dao.insertUser(user);
        return "list?faces-redirect=true";
    }
}
