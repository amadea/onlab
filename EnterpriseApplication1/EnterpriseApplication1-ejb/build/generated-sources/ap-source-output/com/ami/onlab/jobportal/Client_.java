package com.ami.onlab.jobportal;

import com.ami.onlab.jobportal.Client.Gender;
import com.ami.onlab.jobportal.Client.Nationality;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-02T22:21:00")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Long> id;
    public static volatile SingularAttribute<Client, byte[]> picture;
    public static volatile SingularAttribute<Client, String> lastName;
    public static volatile SingularAttribute<Client, String> phone;
    public static volatile SingularAttribute<Client, Nationality> nationality;
    public static volatile SingularAttribute<Client, String> address;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, byte[]> CVFile;
    public static volatile SingularAttribute<Client, Gender> gender;
    public static volatile SingularAttribute<Client, String> userName;
    public static volatile SingularAttribute<Client, Date> birthDate;
    public static volatile SingularAttribute<Client, String> firstName;
    public static volatile SingularAttribute<Client, String> password;
    public static volatile SingularAttribute<Client, String> skype;

}