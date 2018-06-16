package ro.utm.java.service;

import ro.utm.java.domain.Domain;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="domainService", eager = true)
@ApplicationScoped
public class DomainService {

    private List<String> domainList;

    @PostConstruct
    public void init() {
        domainList = new ArrayList<String>();
        domainList.add("Thriller");
        domainList.add("Comedie");
        domainList.add("Sci-fi");
        domainList.add("Fizica");
        domainList.add("Educatie");
        domainList.add("Tragedie");
    }

    public List<String> getDomainList() {
        return domainList;
    }

}
