package se.lexicon.jpaworkshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.*;


@Entity
public class AppUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appUserId;

    @Column(length = 250, nullable = false)
    private String userName;
    @Column(length = 150, nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDate regDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "details_Id")
    private Details userDetails;

    @OneToMany(
               cascade = {CascadeType.DETACH, REFRESH,MERGE,PERSIST},
               fetch = FetchType.LAZY,
               mappedBy = "borrower")
   private List<BookLoan> bookLoanList;

    public AppUser() {
    }

    public AppUser(int appUserId, String userName, String password,
                   LocalDate regDate, Details userDetails, List<BookLoan> bookLoanList ) {
        this.appUserId = appUserId;
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
        this.bookLoanList = bookLoanList;
    }

    public AppUser(String userName, String password, LocalDate regDate, Details userDetails) {
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
        setBookLoanList(new ArrayList<>());

    }


    public void addBookLoan(BookLoan bookLoan) {
        if (bookLoan == null) throw new IllegalArgumentException("parameter bookLoan was null");
        if (bookLoanList == null) bookLoanList = new ArrayList<>();


        if (!bookLoanList.contains(bookLoan)){
            bookLoan.setBorrower(this);
            bookLoanList.add(bookLoan);
        }


    }

    public List<BookLoan> getBookLoanList() {
        return bookLoanList;
    }

    public void setBookLoanList(List<BookLoan> bookLoanList) {
        this.bookLoanList = bookLoanList;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser user = (AppUser) o;
        return appUserId == user.appUserId && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(regDate, user.regDate) && Objects.equals(userDetails, user.userDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appUserId, userName, password, regDate, userDetails);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "appUserId=" + appUserId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                ", userDetails=" + userDetails +
                '}';
    }
}
