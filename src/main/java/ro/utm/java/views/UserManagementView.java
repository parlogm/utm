package ro.utm.java.views;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import ro.utm.java.entities.User;
import ro.utm.java.service.UserService;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="userManagementView")
@ViewScoped
public class UserManagementView implements Serializable {

    private List<User> userList;

    @ManagedProperty("#{userService}")
    @Autowired
    private UserService userService;

    private String name;
    private String lastName;
    private String email;
    private String password;

    private User selectedUser;

    @PostConstruct
    public void init() {
        userList = userService.getAllUsers();
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void onAddNew() {
        // Add one new user to the db & table
        User newUser = new User(name, lastName, password, email);
        userService.saveUser(newUser);
        User newlyAddedUser = userService.findUserByEmail(email);
        userList.add(newlyAddedUser);
        FacesMessage msg = new FacesMessage("New user added", newlyAddedUser.getEmail());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().execute("PF('dlg2').hide();PF('cellUsers').addRow();");
    }

    // TODO - check why it doesn't work
    public void deleteUser() {
        userList.remove(selectedUser);
        userService.removeUser(selectedUser);
        selectedUser = null;
    }

    public void deleteUser(User user) {
        userList.remove(user);
        userService.removeUser(user);
        selectedUser = null;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }
}
