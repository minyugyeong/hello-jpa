package hellojpa_section5;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "member")
public class Member_2 {

    //매핑 어노테이션
    //- @Column : 컬럼 매핑
    //- @Temporal : 날짜 타입 매핑
    //- @Enumerated : enum 타입 매핑
    //- @Lob : BLOB, CLOB 매핑
    //- @Transient 특정 필드를 컬럼에 매핑하지 않음(매핑 무시)

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roletype;

    private Date createDate;

    private Date lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int temp;

    public Member_2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoletype() {
        return roletype;
    }

    public void setRoletype(RoleType roletype) {
        this.roletype = roletype;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
