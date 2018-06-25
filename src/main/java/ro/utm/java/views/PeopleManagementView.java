package ro.utm.java.views;

import org.hibernate.validator.constraints.Email;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import ro.utm.java.entities.Books;
import ro.utm.java.entities.People;
import ro.utm.java.service.BookService;
import ro.utm.java.service.PeopleService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="peopleManagementView")
@ViewScoped
public class PeopleManagementView implements Serializable {

    private List<People> people;
    private List<People> filteredPeople;

    @ManagedProperty("#{peopleService}")
    @Autowired
    private PeopleService peopleService;

    private String name;
    private String lastName;
    @Email(message = "must be a valid email")
    private String email;
    @Size(min=13,max=13)
    private String cnp;
    private int active;

    private People selectedPerson;

    public PeopleManagementView() {
    }

    @PostConstruct
    public void init() {
        people = peopleService.getAllPeople();
        selectedPerson = new People();
    }

    public void onAddNew() {
        // Add one new user to the db & table
        active = 1; // when adding people - they are always active
        People person= new People(name, lastName, email, cnp, active);
        peopleService.savePerson(person);
        People newlyAddedPerson = peopleService.findPersonByCNP(cnp);
        people.add(newlyAddedPerson);
        FacesMessage msg = new FacesMessage("New reader added", newlyAddedPerson.getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().execute("PF('dlgp2').hide();PF('cellPeople').addRow();");
    }

    public void updateSelected() {
        peopleService.updatePerson(selectedPerson);
        selectedPerson = null;
    }

    public void deletePerson(People person) {
        people.remove(person);
        peopleService.removePerson(person);
        selectedPerson = null;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public List<People> getFilteredPeople() {
        return filteredPeople;
    }

    public void setFilteredPeople(List<People> filteredPeople) {
        this.filteredPeople = filteredPeople;
    }

    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public People getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(People selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
}
